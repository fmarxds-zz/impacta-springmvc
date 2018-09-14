package com.everis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("mensagem_boasVindas", "Olá convidado. Seja bem vindo!");
		return mv;
	}
	
}
