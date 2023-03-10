package kr.co.ezen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 해당 요일을 알려주는 프로그램
@Controller					// 1. 원격호출 가능한 프로그램으로 등록
public class DayOfTheWeek3 {
	
	@RequestMapping("/getDayOfTheWeek3")		// 2. URL과 메서드를 연결
	public static void main(HttpServletRequest request, HttpServletResponse response) {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		// 2. 문자를 숫자로 바꿈
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);					// 날짜 setting
		
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);				// 요일 리턴(sunday = 1,...)
		
		/*
		 * " 일월화수목금토".charAt(1); => "일"
		 * " 일월화수목금토".charAt(2); => "월"
		 */
		char dayofTheWeek=" 일월화수목금토".charAt(dayofWeek);
		
		// 3. 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");	// 한글 정상 출력
		PrintWriter out;
		
		try {
			out = response.getWriter();			// response 객체에서 브라우저로의 출력 스트링 획득
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			
			out.println(year+"년 "+month+"월 "+day+"일은 ");
			out.println(dayofTheWeek+"요일 입니다.");
			
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {e.printStackTrace();}
		
	}

}
