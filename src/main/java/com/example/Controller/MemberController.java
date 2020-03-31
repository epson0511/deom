package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Dao.MemberRepository;
import com.example.Model.MemberAccount;
import com.example.Model.MemberAccountJPA;
import com.example.Service.MemberService;

@Controller
public class MemberController {
	// 透過 @RequestMapping 指定從/會被對應到此addMemberPage()方法
	@Autowired
	MemberAccount memberAccount;
	
	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	DataSource dataSource;

	@GetMapping("/addMemberPage")
	public String addMemberPage() {
//    	memberAccount = new MemberAccount();
//    	memberService.addMember(memberAccount);

		List<MemberAccountJPA> memberAccountJPA = new ArrayList<MemberAccountJPA>();
		memberAccountJPA = memberRepository.findAll();

		for (int i = 0; i < memberAccountJPA.size(); i++) {
			System.out.println(memberAccountJPA.get(i).getId());
		}

		return "addMemberPage";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute MemberAccountJPA memberAccountJPA) {

		return "login";

	}

	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute MemberAccountJPA memberAccountJPA, HttpSession session) {
		String email = memberAccountJPA.getEmail();
		String password = memberAccountJPA.getPassword();
		List<MemberAccountJPA> MemberAccountJPAList = new ArrayList<MemberAccountJPA>();
		MemberAccountJPAList = memberRepository.findCheckMemberAccount(email, password);
		MemberAccount memberAccount = new  MemberAccount();
		memberAccount.setPassword(password);
		memberAccount.setEmail(email);;

		if(MemberAccountJPAList.size()==0){
			return "login";
		}
		else{
			session.setAttribute("uid", memberAccount);
			return "welcome";
		}
		
	}
	
	@GetMapping("/memberList")
    public String memberListPage(Model model){
		List<MemberAccountJPA> memberAccountList;
		memberAccountList = memberRepository.findAll();
		model.addAttribute("memberAccountList", memberAccountList);
        return "member/memberListPage";
    }  
}
