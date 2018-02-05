
public class Circle extends Shape{
	private String names;

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	public void draw()
	{
		System.out.print(this.names + " Shape");
	}
}
