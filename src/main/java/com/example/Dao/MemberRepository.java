package com.example.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Model.MemberAccountJPA;

public interface MemberRepository extends JpaRepository<MemberAccountJPA, Long>{
	
	List<MemberAccountJPA> findAll();
	
	List<MemberAccountJPA> findByEmail(String email);

	@Query(value="select id,email,password,address,cellphone from epsondb.memberaccountjpa where EMAIL = ?1 and PASSWORD = ?2 " ,nativeQuery = true)
	List<MemberAccountJPA> findCheckMemberAccount(String email,String password);
	
}
