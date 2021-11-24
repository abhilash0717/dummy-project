package com.infy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.Dao;
import com.infy.model.Data;


@Service
@Transactional
public class ServiceImpl implements ProjectService {
	
	@Autowired
	private Dao dao;

	@Override
	public String Store(Data data) {
		return dao.Store(data);
	}
	

}
