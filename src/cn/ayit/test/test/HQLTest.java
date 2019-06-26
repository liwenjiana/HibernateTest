package cn.ayit.test.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.ayit.test.domain.Stuinfo;
import cn.ayit.test.utils.HibernateUtils;

public class HQLTest {

	/**
	 * 基础查询
	 */
	@Test
	public void fun() {
		Session session = HibernateUtils.getOpenSession();
		// 获取事务
		Transaction tran = session.beginTransaction();

		// Stuinfo不是数据库表名，而是实例化数据库的类的名称，
		// 可以写类的全类名，或者直接写类名（一个项目中只存在一个此类名）
		String hql = "from Stuinfo";
		// 根据hql查询
		Query query = session.createQuery(hql);
		// 获取结果的集合（自动封装成Stuinfo对象）
		List<Stuinfo> list = query.list();
		// Stuinfo stuinfo = (Stuinfo) query.uniqueResult(); 查询单个对象
		System.out.println(list.toString());

		// 提交事务
		tran.commit();
		// 关闭session(养成良好的习惯)
		session.close();
	}

	/**
	 * (条件查询)问号占位符
	 */
	@Test
	public void fun2() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction(); // 获取事务

		/*
		 * 此语句中的id不是数据库表中的列名，而是表所对应的类的属性名
		 */
		String hql = "from Stuinfo where id = ?";
		Query query = session.createQuery(hql); // 根据hql查询
		// query.setInteger(0, 1); // 设置参数，参一：问号占位符的下标（从0开始），参二：问号的值
		query.setParameter(0, 1); // 与上一行代码意义相同，（通用写法不用担心类型不匹配）
		List<Stuinfo> list = query.list(); // 获取结果的集合（自动封装成Stuinfo对象）
		System.out.println(list.toString());

		tran.commit(); // 提交事务
		session.close(); // 关闭session(养成良好的习惯)
	}

	/**
	 * 命名占位符
	 */
	@Test
	public void fun3() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction(); // 获取事务
		/*
		 * 此语句中的id不是数据库表中的列名，而是表所对应的类的属性名
		 */
		String hql = "from Stuinfo where id= :id";
		Query query = session.createQuery(hql); // 根据hql查询
		query.setParameter("id", 1); // 设置参数，参一：问号占位符的下标（从0开始），参二：问号的值
		List<Stuinfo> list = query.list(); // 获取结果的集合（自动封装成Stuinfo对象）
		System.out.println(list.toString());

		tran.commit(); // 提交事务
		session.close(); // 关闭session(养成良好的习惯)
	}

	@Test
	public void fun4() {
		// 1 获得session
		Session session = HibernateUtils.getOpenSession();
		// 2 控制事务
		Transaction tx = session.beginTransaction();
		// 3执行操作
		// -------------------------------------------
		// 1> 书写HQL语句
		String hql = " from Stuinfo"; // 查询所有Customer对象
		// 2> 根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		// 设置分页信息 limit ?,?
		query.setFirstResult(0);
		query.setMaxResults(1);
		// 3> 根据查询对象获得查询结果
		List<Stuinfo> list = query.list();
		System.out.println(list);
		// -------------------------------------------
		// 4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联

	}
}
