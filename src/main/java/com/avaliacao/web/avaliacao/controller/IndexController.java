package com.avaliacao.web.avaliacao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.avaliacao.web.avaliacao.model.Tarefa;
import com.avaliacao.web.avaliacao.repository.TarefaRepository;
import com.avaliacao.web.avaliacao.vo.TarefaVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

	@Autowired TarefaRepository tarefaRepository;
	
	@GetMapping("/")
    public String index(Model model) { 
        List<Tarefa> tarefas = this.tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("novaTarefa", new TarefaVO());
        return "index";
    }
	
	@PostMapping("/salvarTarefa")
	public String saveTarefa(@ModelAttribute("novaTarefa") TarefaVO vo) {
		try {
			Tarefa novaTarefa = new Tarefa(vo);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date dataInicio = dateFormat.parse(vo.getDataInicio());
	        novaTarefa.setDataInicio(dataInicio);
			this.tarefaRepository.save(novaTarefa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/";
	}
	
	@GetMapping("/buscarTarefa/{id}")
	@ResponseBody
	public TarefaVO buscarTarefaPorId(@PathVariable Long id) {
		Tarefa tarefa = this.tarefaRepository.findById(id).get();
		TarefaVO vo = new TarefaVO(tarefa);
	    return vo;
	}
	
	@GetMapping("/excluirTarefa/{id}")
    public String excluirTarefa(@PathVariable Long id) {
		this.tarefaRepository.deleteById(id);
        return "redirect:/";
    }
	
}
