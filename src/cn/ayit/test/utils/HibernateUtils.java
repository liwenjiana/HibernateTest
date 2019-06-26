package cn.ayit.test.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	public static SessionFactory sf;

	// 保证类加载时就执行一次（保证SessionFactory只存在一个）
	static {
		Configuration cf = new Configuration();
		cf.configure();
		sf = cf.buildSessionFactory();
	}

	public static Session getCurrentSession() {
		return sf.getCurrentSession();

	}

	public static Session getOpenSession() {
		return sf.openSession();
	}
}
