package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.MemberDao;
import com.example.Model.MemberAccount;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	public void addMember(MemberAccount memberAccount){
		memberDao.addMember(memberAccount);
	}
}
