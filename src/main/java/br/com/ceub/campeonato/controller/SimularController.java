package br.com.ceub.campeonato.controller;

import br.com.ceub.campeonato.model.Simulacao;
import br.com.ceub.campeonato.repository.TimeRepository;
import br.com.ceub.campeonato.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimularController {

    @Autowired
    private SimulacaoService simulacaoService;

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping("/simular")
    public ModelAndView simular(Model model) {
        ModelAndView modelAndView = new ModelAndView("simular");
        model.addAttribute("simulacao", new Simulacao());
        modelAndView.addObject("times", timeRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/simularJogo")
    public String simularForm(@ModelAttribute Simulacao simulacao) {
        System.out.println("Gols 1 " + simulacao.getTime1().getGolsPro());
        System.out.println("Gols 1 " + simulacao.getTime1().getNome());
        simulacaoService.realizarSimulacao(simulacao);
        return "result";
    }
}
