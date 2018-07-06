package com.akshay.springData;

import static java.lang.System.exit;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;


@SpringBootApplication
public class SpringDataDemo implements CommandLineRunner {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	DataSource dataSource;

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDataDemo.class, args);
	}

	@Transactional(readOnly = true)
	@Override
	public void run(String... args) throws Exception {

		System.out.println("DATASOURCE = " + dataSource);

		System.out.println("\n1.findAll()...");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}

		System.out.println("\n2.findByEmail(String email)...");
		for (Customer customer : customerRepository.findByEmail("222@yahoo.com")) {
			System.out.println(customer);
		}

		System.out.println("\n3.findByDate(Date date)...");
		for (Customer customer : customerRepository.findByDate(sdf.parse("2017-02-12"))) {
			System.out.println(customer);
		}

		// For Stream, need @Transactional
		System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
		try (Stream<Customer> stream = customerRepository.findByEmailReturnStream("333@yahoo.com")) {
			stream.forEach(x -> System.out.println(x));
		}

		System.out.println("Done!");

		exit(0);
	}
}

@Entity(name = "Customer_SPRING_DATA")
@Table(name = "Customer_SPRING_DATA")
@Data
class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	Long id;

	String name;

	String email;

	@Column(name = "CREATED_DATE")
	Date date;

}

interface CustomerRepository extends CrudRepository<Customer, Integer> {

	List<Customer> findByEmail(String email);

	List<Customer> findByDate(Date date);

	// custom query example and return a stream
	@Query("select c from Customer_SPRING_DATA c where c.email = :email")
	Stream<Customer> findByEmailReturnStream(@Param("email") String email);

}