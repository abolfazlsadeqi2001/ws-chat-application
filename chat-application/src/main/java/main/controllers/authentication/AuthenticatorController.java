package main.controllers.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticatorController {
	// TODO using session instead of cookies
	private final int COOKIES_LIFE_TIME = 3 * 24 * 60 * 60;
	public final String NAME_PARAM = "name";
	
	@RequestMapping("/login")
	public void login(@RequestParam(name=NAME_PARAM,required=true) String name,
			HttpServletResponse res) {
		Cookie nameCookie = new Cookie(NAME_PARAM,name);
		nameCookie.setMaxAge(COOKIES_LIFE_TIME);
		res.addCookie(nameCookie);
	}
	
}
