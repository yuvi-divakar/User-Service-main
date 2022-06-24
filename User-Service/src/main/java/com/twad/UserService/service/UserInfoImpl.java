package com.twad.UserService.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.twad.UserService.dto.UserDetails;
//import com.twad.UserService.model.User;

@Service
public class UserInfoImpl implements Serializable{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	
	public List<UserDetails> getAllUserDetails() {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(" Select u.userid as id,(u.firstname|| ' ' || u.middlename|| ' ' ||u.lastname) as username,u.email,u.mobile1 as mobile1,u.mobile2 as mobile2 ,ARRAY_AGG (r.title) as roles  ,ARRAY_AGG(d.title) as departments ");
		sqlQuery.append(" from tbl_user u ");
		sqlQuery.append(" join tbl_roleassignments ra on u.userid = ra.userid ");
		sqlQuery.append(" join tbl_roles r on ra.roleid=r.roleid ");
		sqlQuery.append(" join tbl_departmentassignments da on u.departmentid= da.departmentid ");
		sqlQuery.append(" join tbl_department d on da.departmentid = d.departmentid  ");
		sqlQuery.append(" where u.is_active is true ");
		sqlQuery.append(" group by u.userid,(u.firstname|| ' ' || u.middlename|| ' ' ||u.lastname),u.email,u.mobile1,u.mobile2 ");
		sqlQuery.append(" order by u.userid ");
		
		Query query= entityManager.createNativeQuery(sqlQuery.toString(), "map_userDetails");
		System.out.println(sqlQuery.toString());
		System.out.println(query.getResultList().get(1));
		
		
		List<UserDetails> users= (List<UserDetails>) query.getResultList();
	
		
		return users;
		
	}


}
