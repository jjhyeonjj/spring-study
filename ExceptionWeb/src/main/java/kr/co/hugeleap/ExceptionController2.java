package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {
	
	@RequestMapping("/ex__")
	public void ezen(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController2.ezen()");
		throw new Exception("예외 발생!!!!!");
	}
	
	@RequestMapping("/ex2__")
	public String ezen2(Model m) throws Exception {
		throw new Exception("예외 발생!!!!!");
	}
	
	@RequestMapping("/ex3__")
	public String ezen3(Model m) throws Exception {		
		throw new NullPointerException("Null Pointer 예외 발생!!!!!");
	}
	
	@RequestMapping("/ex4__")
	public void ezen4(Model m) throws FileNotFoundException {
		throw new FileNotFoundException("파일이 존재하지 않는 예외 발생!!!!!");
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {	
		System.out.println("catcher() in ExceptionController2");
		System.out.println("m = "+m.getAttribute("msg")); // 다른 모델을 사용 중.
		
		m.addAttribute("ex", ex);	// 예외정보가 모델에 담겨서 뷰에 전달된 것.	
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	
	
}