package com.infy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infy.model.Data;



@Repository
public class DaoImpl implements Dao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String Store(Data data) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
