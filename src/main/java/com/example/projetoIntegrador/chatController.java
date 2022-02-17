package com.example.projetoIntegrador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class chatController {
	private String historico;
	List<String> listaHistorico = new ArrayList<String>();

	@RequestMapping(value="/chat",method=RequestMethod.GET)
	public ModelAndView getChat() {
		ModelAndView mv = new ModelAndView("chat");
		return mv;
	}
	
	@RequestMapping(value="/chat",method=RequestMethod.POST)
	public ModelAndView postChat(@RequestParam("msg") String mensagem) {
		this.historico = this.historico + "\n" + mensagem;
		listaHistorico.add(mensagem);
		ModelAndView mv = new ModelAndView("chat");
		mv.addObject("chat",listaHistorico);
		return mv;
	}
	
	
}
