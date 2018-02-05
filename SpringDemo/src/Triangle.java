import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @author akshay243601
 *
 */

public class Triangle extends Shape implements ApplicationContextAware, BeanNameAware, InitializingBean,DisposableBean
{
	private Shape shapeObj1;
	private Shape shapeObj2;
	private Shape shapeObj3;
	private ApplicationContext context;
	
	public Shape getShapeObj1() {
		return shapeObj1;
	}

	public void setShapeObj1(Shape shapeObj1) {
		this.shapeObj1 = shapeObj1;
	}

	public Shape getShapeObj2() {
		return shapeObj2;
	}

	public void setShapeObj2(Shape shapeObj2) {
		this.shapeObj2 = shapeObj2;
	}

	public Shape getShapeObj3() {
		return shapeObj3;
	}

	public void setShapeObj3(Shape shapeObj3) {
		this.shapeObj3 = shapeObj3;
	}
	
	public void draw()
	{
			System.out.println(getShapeObj1().getType() + "  ,  " + getShapeObj1().getHeight());
			System.out.println(getShapeObj2().getType() + "  ,  " + getShapeObj2().getHeight());
			System.out.println(getShapeObj3().getType() + "  ,  " + getShapeObj3().getHeight());
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("Bean Name is :- "+ beanName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" Initializing bean method is called");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(" Destroy bean method is called");
		
	}
	
	public void customAfterPropertiesSet() throws Exception {
		System.out.println("My Initializing bean method is called");
		
	}

	
	public void customDestroy() throws Exception {
		System.out.println("My Destroy bean method is called");
		
	}
	
}
