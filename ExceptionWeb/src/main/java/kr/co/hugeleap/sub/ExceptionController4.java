package kr.co.hugeleap.sub;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController4 {
	
	@RequestMapping("/ex5")
	public void ezen(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController2.ezen()");
		throw new Exception("예외 발생!!!!!");
	}
	
	@RequestMapping("/ex6")
	public String ezen2(Model m) throws Exception {
		throw new Exception("예외 발생!!!!!");
	}
	
	@RequestMapping("/ex7")
	public String ezen3(Model m) throws Exception {		
		throw new NullPointerException("Null Pointer 예외 발생!!!!!");
	}
	
	@RequestMapping("/ex8")
	public void ezen4(Model m) throws FileNotFoundException {
		throw new FileNotFoundException("파일이 존재하지 않는 예외 발생!!!!!");
	}
	
}
