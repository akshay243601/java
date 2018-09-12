package com.akshay.lambda;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {
	private int id;
	private Set<Book> books;

	public Student(int id, Set<Book> books) {
		this.id = id;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Book> getBooks() {
		if (this.books == null) {
			this.books = new HashSet<Book>();
		}
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}

class Book {
	private Integer bookId;
	private String bookName;

	public Book(int bookId, String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}

public class LambdaStream {

	public static void main(String[] args) {

		streamOperationLikeFilterSortedMapFileReadingPrepareMap();

		flatMapOperation();

		lambdaWithSynchronized();

		sortLambda();

	}

	private static void flatMapOperation() {

		/*
		 * Diff Between map and Flat map:- In Java 8, Stream can hold different
		 * data types, for examples:
		 */
		/* Stream<String[]>, */
		/* Stream<Set<String>>, */
		/* Stream<List<String>>, */
		/* Stream<List<Object>> */

		/*
		 * But, the Stream operations (filter, sum, distinct…) and collectors do
		 * not support it, So, we need flatMap() to do the following conversion
		 * :
		 */
		/*
		 * Stream<String[]> -> flatMap -> Stream<String>, Stream<Set<String>> ->
		 * flatMap -> Stream<String>, Stream<List<String>> -> flatMap ->
		 * Stream<String>, Stream<List<Object>> -> flatMap -> Stream<Object>
		 */
		/*
		 * FlatMap will convert your Stream of list, set or array into normal
		 * stream : Stream<String[]> -> FlatMap -> Stream<String>
		 */

		String[][] array = { { "a", "b" }, { "c", "b" }, { "a", "e" } };
		Stream<String[]> arrayStream = Arrays.stream(array);

		System.out.println("Print using normal filter : NO FLAT MAP");

		// Nothing will return because here data will be compare for 'String[]'
		// with 'a' which always return false. So for this we will use flatMap
		arrayStream.filter(x -> x.equals("a")).forEach(System.out::println);
		arrayStream.close();

		System.out.println("Print using FLAT MAP");
		Stream<String[]> arrayStreamUsingFlatMap = Arrays.stream(array);
		arrayStreamUsingFlatMap.flatMap(x -> Arrays.stream(x)).filter(x -> x.equals("a")).forEach(System.out::println);
		arrayStreamUsingFlatMap.close();

		// Use of FlatMap
		System.out.println("Print using FLAT MAP with Custome List and Set");
		System.out.println("Fetch All distict Books name from all students");
		List<Student> studentList = prepareStudentList();
		studentList.stream() // Stream<Student>
				.map(x -> x.getBooks()) // Steam<Set<Book>>
				.flatMap(x -> x.stream()) // Stream<Book>
				.map(x -> x.getBookName()) // Stream<String>
				.distinct().forEach(x -> System.out.println(x));

		// Way 1
		// Use of FlatMapToInt
		System.out.println("Print using FLAT MAP TO INT");
		int[] intArray = { 1, 2, 3, 4, 5 };
		Stream.of(intArray).flatMapToInt(x -> Arrays.stream(x)).forEach(x -> System.out.println(x));

		// Way 2
		int[] intArray1 = { 1, 2, 3, 4, 5, 6 };
		// 1. Stream<int[]>
		Stream<int[]> streamArray = Stream.of(intArray1); // int stream return
															// Stream<int[]>
		// 2. Stream<int[]> -> flatMap -> IntStream
		IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x)); // flatMapIntoInt
																				// return
																				// IntStream
		intStream.forEach(x -> System.out.println(x));

		// Way 1
		System.out.println("Map Example :->  Way 1 of map filter ");
		Map<Student, Set<Book>> studentbookMap = prepareStudentBooksMap();
		studentbookMap.entrySet().stream().map(x -> x.getKey().getBooks()). // Stream<Set<Book>>
																			// Stream<Set<Book>>
				flatMap(x -> x.stream()) // Stream<Book>
				.map(x -> x.getBookName()) // Stream<String>
				.filter(x -> x.contains("ook")) // Stream<String>
				.distinct() // Stream<String>
				.collect(Collectors.toList()) // List<String>
				.forEach(x -> System.out.println(x));

		// OR

		// Way 2
		System.out.println("Map Example :->  Way 2 of map filter ");
		Map<Student, Set<Book>> studentbookMap1 = prepareStudentBooksMap();
		studentbookMap1.entrySet().stream().flatMap(x -> x.getKey().getBooks().stream()) // Stream<Book>
																							// Converting
																							// Stream<Set<Book>>
																							// ->
																							// Stream<Book>
				.map(x -> x.getBookName()) // Stream<String>
				.filter(x -> x.contains("ook")) // Stream<String>
				.distinct() // Stream<String>
				.collect(Collectors.toList()) // List<String>
				.forEach(x -> System.out.println(x));

	}

	private static void sortLambda() {
		List<Student> studentList = prepareStudentList();
		List<Book> books = studentList.stream().flatMap(x -> x.getBooks().stream()).sorted(new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getBookName().compareTo(o2.getBookName());
			}
		}).collect(Collectors.toList());

		books.stream().forEach(x -> System.out.println(x.getBookName()));
	}

	private static List<Student> prepareStudentList() {
		List<Student> list = new ArrayList<Student>();

		Student s1 = new Student(1, new HashSet<Book>());
		s1.getBooks().add(new Book(1, "Book1"));
		s1.getBooks().add(new Book(2, "Book2"));
		s1.getBooks().add(new Book(4, "Book4"));

		Student s2 = new Student(2, new HashSet<Book>());
		s2.getBooks().add(new Book(1, "Book1"));
		s2.getBooks().add(new Book(2, "Book2"));
		s2.getBooks().add(new Book(4, "Book4"));

		Student s3 = new Student(3, new HashSet<Book>());
		s3.getBooks().add(new Book(2, "Book2"));
		s3.getBooks().add(new Book(4, "Book4"));
		s3.getBooks().add(new Book(6, "Book6"));

		list.add(s1);
		list.add(s2);
		list.add(s3);

		return list;
	}

	private static Map<Student, Set<Book>> prepareStudentBooksMap() {
		Map<Student, Set<Book>> studentBooksMap = new HashMap<Student, Set<Book>>();

		Student s1 = new Student(1, new HashSet<Book>());
		s1.getBooks().add(new Book(1, "Book1"));
		s1.getBooks().add(new Book(2, "Book2"));
		s1.getBooks().add(new Book(4, "Book4"));
		studentBooksMap.put(s1, s1.getBooks());

		Student s2 = new Student(2, new HashSet<Book>());
		s2.getBooks().add(new Book(1, "Book1"));
		s2.getBooks().add(new Book(2, "Book2"));
		s2.getBooks().add(new Book(4, "Book4"));
		studentBooksMap.put(s2, s2.getBooks());

		Student s3 = new Student(3, new HashSet<Book>());
		s3.getBooks().add(new Book(2, "Book2"));
		s3.getBooks().add(new Book(4, "Book4"));
		s3.getBooks().add(new Book(6, "Book6"));
		studentBooksMap.put(s3, s3.getBooks());

		return studentBooksMap;
	}

	// Here i will diff. diff. output as its sync. because no idea in which
	// order parallel stream will pick the list. So to avaoid this we can use
	// parallel stream
	private static void lambdaWithSynchronized() {
		List<Integer> ss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		List<Integer> result = new ArrayList<Integer>();

		ss.parallelStream().map(s -> {
			synchronized (result) {
				if (result.size() < 10) {
					result.add(s);
				}
			}
			return s;
		}).forEach(e -> {
			System.out.print(e + " ,");
		});

		System.out.println();
		System.out.println(result);
	}
	

	private static void streamOperationLikeFilterSortedMapFileReadingPrepareMap() {
	
		
		System.out.println("Stream Example 1 :-> ");
		IntStream.range(1, 10).forEach(System.out::println);

		System.out.println("Stream Example 2 :-> ");
		IntStream.range(1, 10).skip(5).forEach(System.out::println);

		System.out.println("Stream Example 3 :-> ");
		System.out.println(IntStream.range(1, 10).skip(5).sum());

		System.out.println("Stream Example 4 :-> ");
		IntStream.range(1, 10).filter(x -> x % 2 == 0).forEach(System.out::println);

		System.out.println("Stream Example 5 :-> ");
		IntStream.range(1, 10).map(x -> x + 10).forEach(System.out::println);

		System.out.println("Stream Example 6 :-> ");
		String[] listOfName = { "Akshay", "Akash", "Sunil", "Sudhir", "Akash" };
		Arrays.stream(listOfName).filter(x -> x.contains("a")).sorted().forEach(System.out::println);

		System.out.println("Stream Example 7 :->  Find average of even elements starting from 1 to 10 ");
		IntStream.range(1, 5).filter(x -> x % 2 == 0).map(x -> x * x).average().ifPresent(System.out::println);

		System.out.println(
				"Stream Example 8 :->  Get data from file and print rows whose brand name contains 'a' character");
		Stream<String> bands = null;
		try {
			bands = Files.lines(
					Paths.get("D:/Personnel/Git-Repository/Git-Java/java/JavaCore/src/com/akshay/lambda/Bands.txt"));
			List<String> listOfBands = bands.filter(x -> x.contains("A")).collect(Collectors.toList());
			listOfBands.forEach(x -> System.out.print(x + "  ,"));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			bands.close();
		}

		// Good Question
		System.out.println(
				"Stream Example 9 :->  Get data from file and get only those rows who are in good csv format and map into array and print those whose age is greater then 15 ");
		Stream<String> rows = null;
		try {
			rows = Files.lines(Paths
					.get("D:/Personnel/Git-Repository/Git-Java/java/JavaCore/src/com/akshay/lambda/voterList.csv"));
			rows.skip(1).map(x -> x.split(",")).filter(x -> x.length == 5).filter(x -> Integer.parseInt(x[2]) > 15)
					.forEach(x -> System.out.println("Id : " + x[0] + " Name : " + x[1] + " Age " + x[2]));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			rows.close();
		}

		// Good Question
		System.out.println(
				"Stream Example 10 :->  Get data from file and get only those rows who are in good csv format and map into array and print those whose age is greater then 15 and store into a Map");
		try {
			rows = Files.lines(Paths
					.get("D:/Personnel/Git-Repository/Git-Java/java/JavaCore/src/com/akshay/lambda/voterList.csv"));
			Map<Integer, String[]> map = rows.skip(1).map(x -> x.split(",")).filter(x -> x.length == 5)
					.filter(x -> Integer.parseInt(x[2]) > 15)
					.collect(Collectors.toMap(x -> Integer.parseInt(x[0]), x -> x));

			for (Entry<Integer, String[]> string : map.entrySet()) {
				System.out.println(
						"Id : " + string.getKey() + " Values : " + Arrays.asList(string.getValue()).toString());
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			rows.close();
		}

		// Good Question
		System.out.println("Stream Example 11 :->  Print occurence of int using lambda");
		Map<Integer, Integer> intOccurenceMap = new HashMap<>();
		Arrays.stream(new int[] { 2, 4, 6, 7, 8, 1, 2, 2, 2, 2, 5, 6, 2 }).forEach(x -> {
			if (!intOccurenceMap.containsKey(x)) {
				intOccurenceMap.put(x, 0);
			}
			intOccurenceMap.put(x, intOccurenceMap.get(x) + 1);
		});

		for (Entry<Integer, Integer> intOcc : intOccurenceMap.entrySet()) {
			System.out.println("key : " + intOcc.getKey() + " Count : " + intOcc.getValue());
		}

		System.out.println("Stream Example 11 : PART 2 :->  Print occurence of int using lambda");
		Arrays.stream(new String[] { "a", "b", "c", "a", "b" })
				.collect(Collectors.groupingBy(name -> name, Collectors.counting()))
				.forEach((x, y) -> System.out.println(x + " " + y));

		// PEEK :-> Returns a stream consisting of the elements of this stream,
		// additionally performing the provided action on each element as
		// elements are consumed from the resulting stream.

		// Peek is used to perform additional action on the stream and if we
		// want to print the current state of element or change the element
		// state etc etc
		System.out.println("Stream Example 12 : Use of PEEK ");

		// It will not print anything as Peek is used to perform addition task
		// and it used for debugging purpose and it works when it return
		// something or we have put some extra function calling on this.
		System.out.println("With Peek Not Printing anything ");
		IntStream.of(new int[] { 3, 2, 5, 6, 7, 8, 2, 1, 2 }).peek(x -> System.out.println(x));

		System.out.println("With Peek Returning sum");
		System.out
				.println(IntStream.of(new int[] { 3, 2, 5, 6, 7, 8, 2, 1, 2 }).peek(x -> System.out.println(x)).sum());

		System.out.println("With Peek Add 10 into each elemnt and print");
		IntStream.of(new int[] { 3, 2, 5, 6, 7, 8, 2, 1, 2 }).peek(x -> System.out.println("Peek before map " + x))
				.map(x -> x + 10).peek(x -> {
					System.out.println("After map " + x);
				}).forEach(x -> System.out.println("Element Value " + x));

		System.out.println(
				"Stream Example 13 : Use of PEEK Changes in FOO element. Using peek change replacing a old object Foo with new Foo Object and it doesn't have any impact ");
		IntStream.range(1, 4) // IntStream<Integer>
				.mapToObj(i -> new Foo("Foo" + i)) // Stream<Foo>
				.peek(i -> new Foo("Foo Change value is " + i)) // this line
																// doesn't
																// implact data.
																// and doesn't
																// change any
																// value.
																// because we
																// are creating
																// new object or
																// we can say we
																// are not
																// modifing
																// existing foo
																// object.
				.forEach(i -> System.out.println(i.name)); // will print foo1,
															// foo2, foo3

		System.out.println(
				"Stream Example 13 : Use of PEEK Changes in FOO element. Using peek : change foo object name and print");
		IntStream.range(1, 4) // IntStream<Integer>
				.mapToObj(i -> new Foo("Foo" + i)) // Stream<Foo>
				.peek(i -> i.name = "Change Value of FOO is " + i.name) // change
																		// value
																		// as it
																		// is
																		// same
																		// object.
				.forEach(i -> System.out.println(i.name)); // will print Change
															// Value of FOO is
															// foo1, Change
															// Value of FOO is
															// foo2, Change
															// Value of FOO is
															// foo3

		System.out.println(
				"Stream Example 13 : Use of PEEK Changes in FOO element. Using peek change foo object and add bar into foo element and print bar per foo");
		IntStream.range(1, 4) // IntStream<Integer>
				.mapToObj(i -> new Foo("Foo" + i)) // Stream<Foo>
				.peek(f -> IntStream.range(1, 4) // changes in Stream<Foo> and
													// adding bar into fee
						.mapToObj(i -> new Bar("Bar" + i + " -> " + f.name)) // Stream<Bar>
						.forEach(f.bars::add)) // print bars and add into foo
												// list
				.flatMap(f -> f.bars.stream()) // creating Stream<Bar>
				.forEach(b -> System.out.println(b.name)); // printing bar
		
		
		
		
		//Use of Reduce
		List<BigInteger> ints = new ArrayList<BigInteger>();
		ints.add(new BigInteger("1"));
		ints.add(new BigInteger("2"));
		ints.add(new BigInteger("3"));
		ints.add(new BigInteger("4"));
		ints.add(new BigInteger("5"));
		ints.add(new BigInteger("6"));
		ints.add(new BigInteger("7"));
		ints.add(new BigInteger("8"));
		ints.add(new BigInteger("9"));
		ints.add(new BigInteger("10"));
		System.out.println(ints.stream().reduce(BigInteger.ZERO, BigInteger::add).intValue());

	}
}

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}