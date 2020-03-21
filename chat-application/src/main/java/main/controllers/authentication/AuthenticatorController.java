package main.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticatorController {
	public final String NAME_PARAM = "name";
	public final String CHAT_PATH = "chat";
	
	@RequestMapping("/login")
	public String login(@RequestParam(name=NAME_PARAM,required=true) String name,
			Model model) {
		model.addAttribute(NAME_PARAM, name);
		return CHAT_PATH;
	}
	
}
