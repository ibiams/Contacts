package br.com.contatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.contatos.dao.Contato;
import br.com.contatos.dao.ContatosDAO;
import br.com.contatos.dao.Telefone;

@Controller
public class ContatosController {
	
	static ContatosDAO dao;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String listarContatos(ModelMap model) {
		singletonDao(); 
		System.out.println("hahaha");
		model.addAttribute("contatos", dao.listarContatos());
		return "home";
	}
	
	@RequestMapping(value = {"/detalhar-contato"}, method = RequestMethod.GET)
	public String detalharContato(ModelMap model, @RequestParam("id") int id) {
		singletonDao(); 
		
		model.addAttribute("contato", dao.selecionarContatoPorId(id));
		return "contato";
	}
	
	@RequestMapping(value = {"/deletar-contato"}, method = RequestMethod.GET)
	public String deletarContato(ModelMap model, @RequestParam("id") int id) {
		singletonDao(); 
		
		dao.removerContato(dao.selecionarContatoPorId(id));
		
		return "redirect:/";
	}
	
	@RequestMapping(value = {"/adicionar"}, method = RequestMethod.GET)
	public ModelAndView adicionar() {

		Contato contato = new Contato();
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		telefones.add(new Telefone());
		telefones.add(new Telefone());
		telefones.add(new Telefone());
		System.out.println(telefones.size());
		contato.setTelefones(telefones);
		
		return new ModelAndView("adicionar","command", contato);
	}
	
	@RequestMapping(value = {"/adicionarContato"}, method = RequestMethod.POST)
	public String adicionarContato(@ModelAttribute("SpringWeb")Contato contato, 
			   ModelMap model) {
		
		singletonDao();
		
		for(int i = 0; i < contato.getTelefones().size(); i++) {
			if (contato.getTelefones().get(i).getNumero() == null || contato.getTelefones().get(i).getNumero().trim().equals("")){
				contato.getTelefones().remove(i);
				i--;
			}else{
				contato.getTelefones().get(i).setContatos(contato);
			}
		}
		
		dao.inserirContato(contato);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = {"/atualizar"}, method = RequestMethod.GET)
	public ModelAndView atualizar(ModelMap model, @RequestParam("id") int id) {
		
		singletonDao();
		
		Contato contato = dao.selecionarContatoPorId(id);
		
		return new ModelAndView("atualizar","command", contato);
	}
	
	@RequestMapping(value = {"/atualizarContato"}, method = RequestMethod.POST)
	public String atualizarContato(@ModelAttribute("SpringWeb")Contato contato, 
			   ModelMap model) {
		
		singletonDao();
		
		for (int i = 0; i < contato.getTelefones().size(); i++){
			System.out.println("Entrou");
			//System.out.println(contato.getTelefones().size());
			if (contato.getTelefones().get(i) == null || contato.getTelefones().get(i).getNumero() == null || contato.getTelefones().get(i).getNumero().trim().equals("")) {
				
				if(contato.getTelefones().get(i) == null || contato.getTelefones().get(i).getNumero() == null){
					contato.getTelefones().remove(i);
				}else{
					removerTelefone(contato, i);
				}
				
				System.out.println(contato.getTelefones().size());
				i--;
			}else{
				contato.getTelefones().get(i).setContatos(contato);
				dao.atualizarTelefone(contato.getTelefones().get(i));
			}
		}
		
		System.out.println(contato.getTelefones().size());
		dao.atualizarContato(contato);
		
		return "redirect:/";
	}

	public void removerTelefone(Contato contato, int i){
		if (contato.getTelefones().get(i) != null && contato.getTelefones().size() > i){
			contato.getTelefones().get(i).setContatos(contato);
			dao.removerTelefone(contato.getTelefones().get(i));
			contato.getTelefones().remove(i);
		}
	}
	
 	public void singletonDao(){
		if (dao == null)
			dao = new ContatosDAO();
	}
 	
 	//teste git
}
