package jpdr.apps.bankdemo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankErrorController implements ErrorController{
	
	@RequestMapping(method = RequestMethod.GET, value="/error")
	public ModelAndView login(HttpServletRequest request) {		
		return new ModelAndView("error/error");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/error/error")
	public String loginBegin(HttpServletRequest request) {		
		return "error";
	}

}
