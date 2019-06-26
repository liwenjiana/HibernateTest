package cn.ayit.test.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.ayit.test.domain.Stuinfo;
import cn.ayit.test.utils.HibernateUtils;

/**
 * 原生的sql查询
 * 
 * @author LX
 */
public class ProtosomaticSQLTest {

	/**
	 * 基础查询
	 */
	@Test
	public void fun1() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction();

		String sql = "select * from stuinfo";
		SQLQuery query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();

		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
		tran.commit();
		session.close();
	}

	/**
	 * 基础查询 (将结果封装到对象中)
	 */
	@Test
	public void fun2() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction();
		String sql = "select * from stuinfo";
		// 创建查询对象
		SQLQuery query = session.createSQLQuery(sql);
		// 将结果集封装到对象中
		query.addEntity(Stuinfo.class);
		List<Stuinfo> list = query.list();
		System.out.println(list.toString());
		tran.commit();
		session.close();
	}
	
	/**
	 * 条件查询
	 */
	@Test
	public void fun3() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction();
		String sql = "select * from stuinfo where id = ?";
		// 创建查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//传参 参一:下标  参二：值
		query.setParameter(0, 1); 
		// 将结果集封装到对象中
		query.addEntity(Stuinfo.class);
		List<Stuinfo> list = query.list();
		System.out.println(list.toString());
		tran.commit();
		session.close();
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void fun4() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction();
		String sql = "select * from stuinfo limit ? , ?";
		// 创建查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//传参 参一:下标  参二：值
		query.setParameter(0, 0); 
		query.setParameter(1, 1); 
		// 将结果集封装到对象中
		query.addEntity(Stuinfo.class);
		List<Stuinfo> list = query.list();
		System.out.println(list.toString());
		tran.commit();
		session.close();
	}
}
