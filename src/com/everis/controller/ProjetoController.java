package com.everis.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.dal.JdbcClienteDao;
import com.everis.dal.JdbcProjetoDao;
import com.everis.entidades.Projeto;

@RequestMapping("/projeto")
@Controller
public class ProjetoController {

	private ApplicationContext context;
	private JdbcClienteDao clienteDao;
	private JdbcProjetoDao projetoDao;

	public ProjetoController() {
		/* Realiza a instanciação de um bean descrito no XML */
		this.context = new ClassPathXmlApplicationContext("beanJDBC.xml");
		this.clienteDao = (JdbcClienteDao) context.getBean("jdbcClienteDao");
		this.projetoDao = (JdbcProjetoDao) context.getBean("jdbcProjetoDao");
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView incluirProjetoForm() {
		ModelAndView mv = new ModelAndView("projeto/cadastro");
		try {
			mv.addObject("lista_clientes", clienteDao.findAll());
		} catch (Exception e) {
			mv.addObject("mensagem_erro", "Não foi possível carregar a lista de clientes.");
		}
		return mv;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView incluirProjeto(@RequestParam("idCliente") int idCliente, Projeto projeto, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/projeto/cadastro");
		try {
			projeto.setCliente(clienteDao.findById(idCliente));
			projetoDao.save(projeto);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mvErro = new ModelAndView("projeto/cadastro-erro");
			mvErro.addObject("erro", "Erro ao cadastrar projeto: " + e.getMessage());
			return mvErro;
		}
		redirect.addFlashAttribute("mensagem_status_cadastro", "Projeto " + projeto.getDocumento() + " cadastrado com sucesso!");
		return mv;
	}

}
