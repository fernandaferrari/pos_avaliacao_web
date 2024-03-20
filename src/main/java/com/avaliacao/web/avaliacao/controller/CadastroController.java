package com.avaliacao.web.avaliacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {
	@GetMapping("/signup")
    public String signup() {
        return "cadastro";
    }
}
