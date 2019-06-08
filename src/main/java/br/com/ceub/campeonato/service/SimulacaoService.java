package br.com.ceub.campeonato.service;

import br.com.ceub.campeonato.model.Simulacao;
import br.com.ceub.campeonato.model.Time;
import br.com.ceub.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulacaoService {

    @Autowired
    private TimeRepository timeRepository;

    public void realizarSimulacao(Simulacao simulacao) {
        Time time1 = timeRepository.getOne(simulacao.getTime1().getId());
        Time time2 = timeRepository.getOne(simulacao.getTime2().getId());

        time1.setPartidasJogadas(time1.getPartidasJogadas() + 1);
        time2.setPartidasJogadas(time2.getPartidasJogadas() + 1);

        time1.setSaldoDeGols(
                time1.getSaldoDeGols() + (simulacao.getGolsTime1() - simulacao.getGolsTime2())
        );
        time2.setSaldoDeGols(
                time2.getSaldoDeGols() + (simulacao.getGolsTime2() - simulacao.getGolsTime1())
        );

        time1.setGolsContra(time1.getGolsContra() + simulacao.getGolsTime2());
        time2.setGolsContra(time2.getGolsContra() + simulacao.getGolsTime1());
        time1.setGolsPro(time1.getGolsPro() + simulacao.getGolsTime1());
        time2.setGolsPro(time2.getGolsPro() + simulacao.getGolsTime2());

        if(simulacao.getGolsTime1() > simulacao.getGolsTime2()) {
            vitoriaTime1(time1, time2);
        } else if(simulacao.getGolsTime2() > simulacao.getGolsTime1()) {
            vitoriaTime2(time1, time2);
        } else {
            empate(time1, time2);
        }
    }

    private void vitoriaTime1(Time time1, Time time2) {
        time1.setVitorias(time1.getVitorias() + 1);
        time2.setDerrotas(time2.getDerrotas() + 1);
        time1.setPontos(time1.getPontos() + 3);

        persistirTimes(time1, time2);
    }

    private void vitoriaTime2(Time time1, Time time2) {
        time2.setVitorias(time2.getVitorias() + 1);
        time1.setDerrotas(time1.getDerrotas() + 1);
        time2.setPontos(time1.getPontos() + 3);

        persistirTimes(time1, time2);
    }

    private void empate(Time time1, Time time2) {
        time1.setEmpates(time1.getEmpates() + 1);
        time2.setEmpates(time2.getEmpates() + 1);
        time1.setPontos(time1.getPontos() + 1);
        time2.setPontos(time2.getPontos() + 1);

        persistirTimes(time1, time2);
    }

    private void persistirTimes(Time time1, Time time2) {
        timeRepository.save(time1);
        timeRepository.save(time2);
    }
}
