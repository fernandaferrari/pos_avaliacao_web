package com.avaliacao.web.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avaliacao.web.avaliacao.service.UsuarioService;

@Controller
public class LoginController {
	@Autowired UsuarioService usuarioService;
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@PostMapping("/auth")
    public String login(@RequestParam("username") String username, 
                        @RequestParam("password") String password) {
        // Chama o método autenticarUsuario da classe de serviço de autenticação
        if (usuarioService.autenticarUsuario(username, password)) {
            // Se a autenticação for bem-sucedida, redireciona para a página principal
            return "redirect:/index";
        } else {
            // Se a autenticação falhar, redireciona de volta para a página de login com uma mensagem de erro
            return "redirect:/login?error=true";
        }
    }
}
