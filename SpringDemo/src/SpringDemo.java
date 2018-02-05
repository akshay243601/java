import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class SpringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			//context.registerShutdownHook();
			//BeanFactory context = new XmlBeanFactory(new FileSystemResource("springContext.xml"));
			Triangle obj = (Triangle)context.getBean("objC");
//			Circle crObj = (Circle)context.getBean("crObj");
			obj.draw();
			
		
	}

}
