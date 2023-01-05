package kr.co.ezenweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDice {
	
	int id1 = (int)(Math.random()*6)+1;
	int id2 = (int)(Math.random()*6)+1;
	
	@RequestMapping("/rollDice")
	public void ezen(HttpServletResponse response) {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		
	try {
		out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice"+id1+".jpg'>");
		out.println("<img src='resources/img/dice"+id2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
		
	} catch(IOException e) {e.printStackTrace();}
	}
}
