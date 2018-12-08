package cn.contentcl.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hibernate的工具类
 * @author leer
 *
 */
public class HibernateUtils {
	
	public static final Configuration cfg;
	public static final SessionFactory sf;
	
	static {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sf.openSession();
	}

}
