package com.hnb.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberServiceImpl service;
	@Autowired
	MemberVO member;
	int result;

	@RequestMapping("/admin_home")
	public String adminHome(Model model){
		logger.info("어드민홈 입장!!!!");
		return "member/admin_home";
	}
	@RequestMapping("/provision")
	public String provision(MemberVO member){
		return "member/provision";
	}
	@RequestMapping("/join_member")
	public String joinMember(String id,String password,String name, String birth, String addr,
			String gender,String email,String phone, Model model
			){
		logger.info("가입 아이디 : {}", id);
		logger.info("가입 패스워드 : {}", password);
		logger.info("가입 이름 : {}", name);
		logger.info("가입 생년 : {}", birth);
		logger.info("가입 성별 : {}", addr);
		logger.info("가입 주소 : {}", gender);
		logger.info("가입 이메일 : {}", email);
		logger.info("가입 전화 번호 : {}", phone);
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setAddr(addr);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		
	    result = service.join(member);
		if (result == 1) {
			logger.info("회원가입 성공");
			model.addAttribute("result", "success");
			model.addAttribute("name", member.getName());
			logger.info("결과 {}", model);
		} else {
			logger.info("회원가입 실패");
			model.addAttribute("result", "fail");
		}
		return "member/join_member";
	}
	@RequestMapping("/join_Result")
	public String joinResult(){
		return "member/join_Result";
	}
	@RequestMapping("/logout")
	public String logout(Model model){
		logger.info("Member : 로그아웃 진입");
		model.addAttribute("result", "success");
		return "member/logout";
	}
	@RequestMapping("/login")
	public String login(String id,String password, Model model
			){
		logger.info("Member : 로그인 진입");
		logger.info("유저아이디 : " + id);
		logger.info("유저패스워드 : " + password);
		member = service.login(id, password);
		if (member == null) {
			model.addAttribute("result", "fail");
		} else {
			model.addAttribute("result", "success");
			model.addAttribute("id", id);
			model.addAttribute("pw", password);
			if (id.equals("choa")) {
				model.addAttribute("admin", "yes");
			} else {
				model.addAttribute("admin", "no");
			}
		}
		return "member/login";
	}
	@RequestMapping("/check_Overlap")
	public String checkOverlap(String id, Model model
			){
		logger.info("컨트롤러 / 중복체크로 진입");
		if (service.searchById(id).getId() == null) {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
		} else {
			model.addAttribute("result", "unusable");
			model.addAttribute("id", id);
		}
		return "member/check_Overlap";
	}
	@RequestMapping("/mypage")
	public String mypage(MemberVO member){
		return "member/mypage";
	}
	@RequestMapping("/detail")
	public String detail(MemberVO member){
		return "member/detail";
	}
}
