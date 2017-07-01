package com.wowwebapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wowwebapp.config.HibernateConfig;
import com.wowwebapp.entities.UserEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private HibernateConfig hbConfig;
	
	private final static Logger Logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Override
	public boolean validate(String username, String password) {
		
		//UserEntity userentity = new UserEntity(username,password);		
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.eq("username", username));
		criterion.add(Restrictions.eq("password", password));
		
		List<UserEntity> userEntity = hbConfig.getListByCriteria(UserEntity.class,criterion);
		
		System.out.println("size : " + userEntity.size());
		return userEntity.size() >= 1;
	}

}
