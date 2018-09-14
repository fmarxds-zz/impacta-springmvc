package com.everis.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.dal.JdbcCronogramaDao;
import com.everis.dal.JdbcProjetoDao;
import com.everis.entidades.Cronograma;
import com.everis.enumeracoes.Concluido;

@RequestMapping("/cronograma")
@Controller
public class CronogramaController {

	private ApplicationContext context;
	private JdbcCronogramaDao cronogramaDao;
	private JdbcProjetoDao projetoDao;

	public CronogramaController() {
		/* Realiza a instanciação de um bean descrito no XML */
		this.context = new ClassPathXmlApplicationContext("beanJDBC.xml");
		this.cronogramaDao = (JdbcCronogramaDao) context.getBean("jdbcCronogramaDao");
		this.projetoDao = (JdbcProjetoDao) context.getBean("jdbcProjetoDao");
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView incluirCronogramaForm() {
		ModelAndView mv = new ModelAndView("cronograma/cadastro");
		try {
			mv.addObject("lista_projetos", projetoDao.findAll());
		} catch (Exception e) {
			mv.addObject("mensagem_erro", "Não foi possível carregar a lista de projetos.");
		}
		return mv;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView incluirCronograma(@RequestParam("idProjeto") int idProjeto, Cronograma cronograma, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/cronograma/cadastro");
		try {
			cronograma.setProjeto(projetoDao.findById(idProjeto));
			cronograma.setConcluido(Concluido.N);
			cronogramaDao.save(cronograma);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mvErro = new ModelAndView("cronograma/cadastro-erro");
			mvErro.addObject("erro", "Erro ao cadastrar cronograma: " + e.getMessage());
			return mvErro;
		}
		redirect.addFlashAttribute("mensagem_status_cadastro", "Cadastrado cronograma para o projeto " + cronograma.getIdProjeto() + " com sucesso!");
		return mv;
	}

}
