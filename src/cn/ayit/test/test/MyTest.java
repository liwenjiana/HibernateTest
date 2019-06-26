package cn.ayit.test.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.ayit.test.domain.Stuinfo;
import cn.ayit.test.utils.HibernateUtils;

public class MyTest {
	@Test
  public void fun() {
		//获取session
	  Session session=HibernateUtils.getOpenSession();
	  //开启
	  Transaction transaction=session.beginTransaction();
	  //指定sql
	  String sql="from Stuinfo";
	  //根据hql查询
	  Query query=session.createQuery(sql);
	  //获取查询结果（自动封装成Stuinfo对象）
	  List<Stuinfo> list=query.list();
	  
	  System.out.println(list.toString());
	  
	  transaction.commit();
	  
	  session.close();
	  
  }
}
