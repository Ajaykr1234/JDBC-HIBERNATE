package hibernate_demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testcfg {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("demo.xml.cfg");
		
		SessionFactory factory= cfg.buildSessionFactory();
		System.out.println(factory);
	}

}
