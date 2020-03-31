package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.MemAccount;

public interface MemberApiRepository extends JpaRepository<MemAccount, Long> {
	
}
