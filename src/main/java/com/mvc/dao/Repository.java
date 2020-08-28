package com.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mvc.model.Blog;
import com.mvc.model.User;

public class Repository {
	
	// USER
	
	public static User findByUsername(String username) {
		Session session = openSession();
		Query q = session.createQuery("from User where username = " + "'" + username + "'");
		User user = (User) q.uniqueResult();
		session.close();
		
		return user;
	}
	
	public static void saveUser(User user) {
		Session session = openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static int getUserIDbyUsername(String username) {
		Session session = openSession();
		Query q = session.createQuery("Select id from User where username = " + "'" + username + "'");
		int id = (Integer) q.uniqueResult();
		session.close();
		
		return id;
	}
	
	// BLOG
	
	public static void deleteBlog(Blog blog) {
		Session session = openSession();
		session.getTransaction().begin();
		session.delete(blog);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateBlog(Blog blog) {
		Session session = openSession();
		session.beginTransaction();
		session.update(blog);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void saveBlog(Blog blog) {
		Session session = openSession();
		session.beginTransaction();
		session.persist(blog);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Blog getBlog(int id) {
		Session session = openSession();
		Blog blog = (Blog) session.get(Blog.class, id);
		session.close();
		
		return blog;
	}

	public static Blog getBlogByTitle(String title) {
		Session session = openSession();
		Query q = session.createQuery("from Blog where title = " + "'" + title + "'" + " order by date");
		Blog blog = (Blog) q.uniqueResult();
		session.close();
		
		return blog;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Blog> getBlogs(){
		Session session = openSession();
		Criteria cr = session.createCriteria(Blog.class);
		List<Blog> blogs = cr.list();
		session.close();
		
		return blogs;
	}

	@SuppressWarnings("unchecked")
	public static List<Blog> getBlogsForCurrentUser(int id){
		Session session = openSession();
		Query q = session.createQuery("from Blog where link = " + id);
		List<Blog> blogs = q.list();
		session.close();
		
		return blogs;
	}
	
	public static Session openSession()	{
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Blog.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		
		return factory.openSession();
	}
	
}
