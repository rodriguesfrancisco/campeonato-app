package br.com.ceub.campeonato.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIME")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PONTOS")
    private Integer pontos;

    @Column(name = "PARTIDAS_JOGADAS")
    private Integer partidasJogadas;

    @Column(name = "VITORIAS")
    private Integer vitorias;

    @Column(name = "EMPATES")
    private Integer empates;

    @Column(name = "DERROTAS")
    private Integer derrotas;

    @Column(name = "GOLS_PRO")
    private Integer golsPro;

    @Column(name = "GOLS_CONTRA")
    private Integer golsContra;

    @Column(name = "SALDO_GOLS")
    private Integer saldoDeGols;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setPartidasJogadas(Integer partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(Integer golsPro) {
        this.golsPro = golsPro;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public Integer getSaldoDeGols() {
        return saldoDeGols;
    }

    public void setSaldoDeGols(Integer saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }
}
