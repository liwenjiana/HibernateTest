package cn.ayit.test.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.ayit.test.domain.Stuinfo;
import cn.ayit.test.utils.HibernateUtils;

/**
 * 面向对象的无语句SQl查询
 * 
 * @author LX
 */
public class CriteriaTest {

	/**
	 * Criteria基础查询
	 */
	@Test
	public void fun1() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction();

		// 查询所有的Stuinfo对象
		Criteria criteria = session.createCriteria(Stuinfo.class);
		List<Stuinfo> list = criteria.list();
		System.out.println(list.toString());
		tran.commit();
		session.close();
	}

	// Criteria条件查询
	// sql常用操作符 Restrictions的方法
	// > gt
	// >= ge
	// < lt
	// <= le
	// == eq
	// != ne
	// in in
	// between and between
	// like like
	// is not null isNotNull
	// is null isNull
	// or or
	// and and
	@Test
	public void fun2() {
		Session session = HibernateUtils.getOpenSession();
		Transaction tran = session.beginTransaction();

		// 查询所有的Stuinfo对象
		Criteria criteria = session.createCriteria(Stuinfo.class);
		// 添加查询参数
		criteria.add(Restrictions.eq("id", 1));
		// 执行查询获得结果
		Stuinfo info = (Stuinfo) criteria.uniqueResult();
		System.out.println(info.toString());
		tran.commit();
		session.close();
	}

	/**
	 * 分页查询
	 */
	@Test
	public void fun3() {
		// 1 获得session
		Session session = HibernateUtils.getOpenSession();
		// 2 控制事务
		Transaction tx = session.beginTransaction();
		// 3执行操作
		// -------------------------------------------
		// 创建criteria查询对象
		Criteria criteria = session.createCriteria(Stuinfo.class);
		// 设置分页信息 limit ?,?
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		// 执行查询
		List<Stuinfo> list = criteria.list();
		System.out.println(list);
		// -------------------------------------------
		// 4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联

	}

	@Test
	// 查询总记录数
	public void fun4() {
		// 1 获得session
		Session session = HibernateUtils.getOpenSession();
		// 2 控制事务
		Transaction tx = session.beginTransaction();
		// 3执行操作
		// -------------------------------------------
		// 创建criteria查询对象
		Criteria criteria = session.createCriteria(Stuinfo.class);
		// 设置查询的聚合函数 => 总行数
		criteria.setProjection(Projections.rowCount());
		// 执行查询
		Integer count = (Integer) criteria.uniqueResult();
		System.out.println(count);
		// -------------------------------------------
		// 4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联

	}
}
