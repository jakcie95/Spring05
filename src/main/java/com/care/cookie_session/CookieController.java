package com.care.cookie_session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookieController {
	@GetMapping("cookie")
	public String myCookie( 
			HttpServletResponse res,
			HttpServletRequest req,
			@CookieValue(value="myCookie", required = false) Cookie cookie) {
			//required : 해당객체가 없으면 null 값을 넣음, 있으면 해당 객체 저장
		System.out.println("cookie : "+cookie);
		Cookie[] cooks = req.getCookies();//웹에서 요청받은 정보 쿠키에 저장
		for(Cookie c : cooks) {
			System.out.println(c.getName());
		}
		 
		Cookie cook = new Cookie("myCookie", "test");
		cook.setMaxAge( 5 );
		cook.setPath("/"); //최고 상위폴더에서 쿠키 사용 가능, 범위 설정
		res.addCookie(cook);//웹으로 응답
		return "cookie";
	}
	@GetMapping("cookie_quiz")
	public String cookieQuiz(
							HttpServletResponse response,
							Model model,
							@CookieValue(value="myCookie", required = false)Cookie cook) {
			if( cook == null ) {
						
					}else {
						model.addAttribute("cook", cook.getValue());
					}
		return "cookie_quiz";
	}
	@GetMapping("popup")
	public String popup() {
		return "popup";
	}
	@GetMapping("chk")
	public String chk(HttpServletResponse rep) {
		Cookie cook = new Cookie("myCookie", "test");
		cook = new Cookie("myCookie", "testCookie");
		cook.setMaxAge(5);
		rep.addCookie(cook);
		return "close";
	}
}










