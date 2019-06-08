package br.com.ceub.campeonato.controller;

import br.com.ceub.campeonato.model.Time;
import br.com.ceub.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClassificacaoController {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping("/classificacao")
    public ModelAndView classificacao() {
        ModelAndView modelAndView = new ModelAndView("classificacao");
        modelAndView.addObject("times",
                timeRepository.findAll(Sort.by(Sort.Direction.DESC, "pontos", "saldoDeGols")));
        return modelAndView;
    }

    @GetMapping("/limparDados")
    public String limparDados() {
        List<Time> times = timeRepository.findAll();
        times.forEach(x -> {
            x.setGolsPro(0);
            x.setPontos(0);
            x.setEmpates(0);
            x.setGolsContra(0);
            x.setSaldoDeGols(0);
            x.setPartidasJogadas(0);
            x.setDerrotas(0);
            x.setVitorias(0);
            timeRepository.save(x);
        });

        return "limpar";
    }
}
