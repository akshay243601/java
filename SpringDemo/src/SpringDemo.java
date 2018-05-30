import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.registerShutdownHook();
		Triangle obj = (Triangle) context.getBean("objC");
		obj.draw();
		
		
		Circle obj1 = (Circle) context.getBean("objCircle");
		obj1.draw();
	}

}
