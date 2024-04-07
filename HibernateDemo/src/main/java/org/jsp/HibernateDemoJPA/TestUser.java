package org.jsp.HibernateDemoJPA;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUser {
	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure();
		SessionFactory factory= cfg.buildSessionFactory();
	}
}

