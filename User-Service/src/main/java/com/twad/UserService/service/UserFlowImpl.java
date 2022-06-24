package com.twad.UserService.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class UserFlowImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	
}
