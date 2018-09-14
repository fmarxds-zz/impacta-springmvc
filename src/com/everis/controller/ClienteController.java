package com.everis.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.everis.dal.JdbcClienteDao;
import com.everis.dal.JdbcClienteProjetoViewModelDao;
import com.everis.dal.JdbcTotalProjetosViewModelDao;

@RequestMapping("/cliente")
@Controller
public class ClienteController {

	private ApplicationContext context;
	private JdbcClienteDao clienteDao;
	private JdbcClienteProjetoViewModelDao clienteProjetoViewModelDao;
	private JdbcTotalProjetosViewModelDao totalProjetosViewModelDao;

	public ClienteController() {
		/* Realiza a instanciação de um bean descrito no XML */
		this.context = new ClassPathXmlApplicationContext("beanJDBC.xml");
		this.clienteDao = (JdbcClienteDao) context.getBean("jdbcClienteDao");
		this.clienteProjetoViewModelDao = (JdbcClienteProjetoViewModelDao) context.getBean("jdbcClienteProjetoViewModelDao");
		this.totalProjetosViewModelDao = (JdbcTotalProjetosViewModelDao) context.getBean("jdbcTotalProjetosViewModelDao");
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView exibirTodosClientesEProjetos() {
		ModelAndView mv = new ModelAndView("cliente/lista");
		try {
			mv.addObject("lista_clientes_projetos", totalProjetosViewModelDao.findProjetosByCliente());
			totalProjetosViewModelDao.findProjetosByCliente().forEach(System.out::println);
		} catch (Exception e) {
			mv.addObject("mensagem_erro", "Não foi possível carregar a lista de projetos por cliente");
		}
		totalProjetosViewModelDao.findProjetosByCliente().forEach(System.out::println);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView exibirProjetosPorClientesForm() {
		ModelAndView mv = new ModelAndView("cliente/detalhe");
		try {
			mv.addObject("lista_cliente", clienteDao.findAll());
		} catch (Exception e) {
			mv.addObject("mensagem_erro", "Não foi possível carregar a lista de clientes.");
		}
		return mv;
	}

	@RequestMapping(value = "/detalhes", method = RequestMethod.GET)
	public ModelAndView exibirProjetosPorCliente(@RequestParam("idCliente") int idCliente) {
		ModelAndView mv = new ModelAndView("cliente/detalhe");
		try {
			mv.addObject("lista_cliente", clienteDao.findAll());
			mv.addObject("lista_clienteProjeto", clienteProjetoViewModelDao.findProjetosByClienteId(idCliente));
		} catch (Exception e) {
			mv.addObject("mensagem_erro", "Não foi possível carregar a lista de clientes.");
		}
		return mv;
	}

}
