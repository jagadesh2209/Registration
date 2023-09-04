package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Register;

public class RegisterDao {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jaga");
	
	public static boolean saveReg(Register e)
	{
		try {
		EntityManager cm = emf.createEntityManager();
		EntityTransaction ct = cm.getTransaction();
		ct.begin();
		cm.persist(e);
		ct.commit();
		return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static boolean updateReg(Register e)
	{
		try{
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(e);
			et.commit();
			return true;
		}
		catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	public static List<Register> getAllReg()
	{
		EntityManager em = emf.createEntityManager();
		Query qt = em.createQuery("select e from Register e");
		return qt.getResultList();
	}
	public static boolean deleteReg(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Register e = em.find(Register.class, id);
		if(e==null) return false;
		else {
			et.begin();
			em.remove(e);
			et.commit();
			return true;
		}
	}
	public static Register findId(int id)
	{
		EntityManager em = emf.createEntityManager();
		return em.find(Register.class, id);
	}
}
