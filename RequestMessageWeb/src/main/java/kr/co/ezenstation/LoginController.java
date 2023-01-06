package kr.co.ezenstation;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {

	@RequestMapping(value = {"/req/loginForm.do", "/req/loginForm2.do"}, 
					method = {RequestMethod.GET})
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/requestMessage/loginFrom");
		return mav;
	}
	
	@RequestMapping(value ="/req/login.do", 
					method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		String requestLine = request.getMethod();
		requestLine += " " + request.getRequestURI();
		
		String queryString = request.getQueryString();
		requestLine += queryString == null ? "" : "?" + queryString;
		requestLine += " " + request.getProtocol();
		System.out.println(requestLine);
		
		Enumeration<String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name+" : "+request.getHeader(name));
		}
		
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("content length" + CONTENT_LENGTH);
		
		if(CONTENT_LENGTH > 0) {
			try{
				request.setCharacterEncoding("utf-8");
				mav.setViewName("/requestMessage/result");
				
				String userId=request.getParameter("userID");
				String userName=request.getParameter("userName");
				
				mav.addObject("userId", userId);
				mav.addObject("userName", userName);
			} catch(UnsupportedEncodingException e1) {e1.printStackTrace();}
		}	
		return mav;
	}
}
