package com.avaliacao.web.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.avaliacao.web.avaliacao.UsuarioService;
import com.avaliacao.web.avaliacao.model.Usuario;
import com.avaliacao.web.avaliacao.vo.CadastroVO;

@Controller
public class CadastroController {
	
	@Autowired UsuarioService usuarioService;
	
	@GetMapping("/signup")
    public String signup(Model model) {
		model.addAttribute("novaTarefa", new CadastroVO());
        return "cadastro";
    }
	
	@PostMapping("/salvar")
	public String salvarNovoCadastro(@ModelAttribute("novoCadastro") CadastroVO novoCadastro) {
		try {
			Usuario user = new Usuario(novoCadastro);
			this.usuarioService.save(user);
		} catch (Exception e) {
			
		}
		return "redirect:/";
	}
}
