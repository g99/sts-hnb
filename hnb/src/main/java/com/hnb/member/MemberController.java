package com.hnb.member;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberServiceImpl service;
	@Autowired
	MemberVO member;
	
	@RequestMapping("/admin_home")
	public String adminHome(){
		logger.info("멤버컨트롤러 adminHome() - 진입");
		return "member/admin_home";
	}
	@RequestMapping("/provision")
	public String provision(){
		logger.info("멤버컨트롤러 provision() - 진입");
		return "member/provision";
	}
	@RequestMapping("/join_member")
	public Model joinMember(
			String id,
			String password,
			String name,
			String birth,
			String addr,
			String gender,
			String email,
			String phone,
			Model model
			){
		logger.info("가입 아이디 : {}",id);
		logger.info("가입 패스워드 : {}",password);
		logger.info("가입 이름 : {}",name);
		logger.info("가입 생년 : {}",birth);
		logger.info("가입 주소 : {}",addr);
		logger.info("가입 성별 : {}",gender);
		logger.info("가입 이메일 : {}",email);
		logger.info("가입 전화번호 : {}",phone);
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setAddr(addr);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		
		int result = service.join(member);
		if (result == 1) {
			logger.info("회원가입 성공");
			model.addAttribute("result","success");
			model.addAttribute("name",member.getName());
		} else {
			logger.info("회원가입 실패");
			model.addAttribute("result", "fail");
		}
		return model;
	}
	@RequestMapping("/join_Result")
	public String joinResult(){
		logger.info("멤버컨트롤러 joinResult() - 진입");
		
		return "member/join_Result";
	}
	@RequestMapping("/logout")
	public String logout(Model model, SessionStatus status){
		logger.info("멤버컨트롤러 logout() - 진입");
		status.setComplete();
		model.addAttribute("result", "success");
		return "global/default.tiles";
	}
	@RequestMapping("/login")
	public @ResponseBody MemberVO login(
			String id,
			@RequestParam("pw")String password,
		    Model model){
		logger.info("멤버컨트롤러 login() - 진입");
		logger.info("유저아이디 : {}",id);
		logger.info("유저 비밀번호: {}",password);
		member = service.login(id, password);
		model.addAttribute("user", member);
		if (member.getId().equals(id)) {
		logger.info("로그인 성공!!!!!!!!!!!!!");
		} else {
			logger.info("로그인 실패!!!!!!!!");
		}
			if (id.equals("choa")) {
				model.addAttribute("admin", "yes");
			} else {
				model.addAttribute("admin", "no");
			}
		return member;
	}
	@RequestMapping("/check_Overlap")
	public Model checkOverlap(
			String id,
			Model model
			){
		logger.info("멤버컨트롤러 checkOverlap() - 진입");
		if (service.selectById(id).getId() == null) {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
		} else {
			model.addAttribute("result", "unusable");
			model.addAttribute("id", id);
		}
		return model;
	}
	@RequestMapping("/mypage")
	public String mypage(){
		logger.info("멤버컨트롤러 mypage() - 진입");
		return "member/mypage.tiles";
	}
	@RequestMapping("/detail/{id}")
	public @ResponseBody MemberVO detail(
		@PathVariable("id")String id){
		logger.info("멤버컨트롤러 detail() - 진입");
		member = service.selectById(id);
		return member;
	}
	
}
