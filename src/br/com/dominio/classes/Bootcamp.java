package br.com.dominio.classes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome; // Nome do bootcamp
    private String descricao; // Descrição do bootcamp
    private final LocalDate dataInicial = LocalDate.now(); // Data de início do bootcamp, definida como a data atual, não pode ser alterada
    private LocalDate dataFinal = dataInicial.plusDays(45); // Data de término do bootcamp, definida como 45 dias após a data inicial
    private Set<Dev> devsInscritos = new HashSet<>(); // Conjunto de desenvolvedores inscritos no bootcamp
    private Set<Conteudo> conteudos = new LinkedHashSet<>(); // Conjunto de conteúdos do bootcamp (usando LinkedHashSet para manter a ordem de inserção)

    // Getter para o nome do bootcamp
    public String getNome() {
        return nome;
    }

    // Setter para o nome do bootcamp
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para a descrição do bootcamp
    public String getDescricao() {
        return descricao;
    }

    // Setter para a descrição do bootcamp
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter para a data final do bootcamp
    public LocalDate getDataFinal() {
        return dataFinal;
    }

    // Setter para a data final do bootcamp
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    // Getter para os desenvolvedores inscritos no bootcamp
    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    // Setter para os desenvolvedores inscritos no bootcamp
    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    // Getter para os conteúdos do bootcamp
    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    // Setter para os conteúdos do bootcamp
    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    // Getter para a data inicial do bootcamp
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    // Método equals para comparar objetos Bootcamp
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Verifica se são o mesmo objeto
        if (o == null || getClass() != o.getClass()) return false; // Verifica se o objeto é nulo ou de uma classe diferente
        Bootcamp bootcamp = (Bootcamp) o; // Faz um cast para Bootcamp
        return Objects.equals(nome, bootcamp.nome) && 
               Objects.equals(descricao, bootcamp.descricao) && 
               Objects.equals(dataInicial, bootcamp.dataInicial) && 
               Objects.equals(dataFinal, bootcamp.dataFinal) && 
               Objects.equals(devsInscritos, bootcamp.devsInscritos) && 
               Objects.equals(conteudos, bootcamp.conteudos); // Compara todos os atributos
    }

    // Método hashCode para gerar um código hash para o objeto Bootcamp
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos); // Gera o código hash baseado nos atributos
    }
}
