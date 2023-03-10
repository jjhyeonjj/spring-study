package kr.co.ezensignup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/register/add")		// 신규회원 가입화면
	public String register() {
		return "registerForm";			// /WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value="/register/save")
	public String save(User user) {
		return "registerInfo";
	}
}
