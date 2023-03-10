package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	@RequestMapping("/ex_")
	public void ezen(Model m) throws Exception {
			throw new Exception("예외 발생!!!!!");
	}
	
	@RequestMapping("/ex2_")
	public String ezen2(Model m) throws Exception {
			throw new Exception("예외 발생!!!!!");
	}
	
	@RequestMapping("/ex3_")
	public String ezen3(Model m) throws Exception {		
			throw new NullPointerException("Null Pointer 예외 발생!!!!!");
	}
	
	@RequestMapping("/ex4_")
	public void ezen4(Model m) throws FileNotFoundException {
		throw new FileNotFoundException("파일이 존재하지 않는 예외 발생!!!!!");
	}
	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, Model m) {	
//		m.addAttribute("ex", ex);	// 예외정보가 모델에 담겨서 뷰에 전달된 것.				
//		return "error";
//	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	
	
}
