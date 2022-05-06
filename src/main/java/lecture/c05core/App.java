package lecture.c05core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
public class App {
	public static void main(String[] args) {
		String path = "lecture/c05core/context.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		
		Servlet s = context.getBean(Servlet.class);
		Dao d = context.getBean(Dao.class);
		Dao d1 = (Dao)context.getBean("myDao");
		
		log.warn(s);
		log.warn(d);
		log.warn(d1);
	}
}
