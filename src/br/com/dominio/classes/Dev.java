package br.com.dominio.classes;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/*
 * Utilizar o LinkedHashSet pois o dev não pode se inscrever no mesmo curso ou mentoria
 * mais de uma vez
 * */

public class Dev {
    private String nome; // Nome do desenvolvedor
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>(); // Conjunto de conteúdos inscritos pelo desenvolvedor
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>(); // Conjunto de conteúdos concluídos pelo desenvolvedor

    // Método para inscrever o desenvolvedor em um bootcamp
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos()); // Adiciona todos os conteúdos do bootcamp aos conteúdos inscritos do desenvolvedor
        bootcamp.getDevsInscritos().add(this); // Adiciona o desenvolvedor à lista de desenvolvedores inscritos no bootcamp
    }

    // Método para progredir nos conteúdos inscritos
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst(); // Encontra o primeiro conteúdo inscrito

        if (conteudo.isPresent()) { // Se o conteúdo estiver presente
            this.conteudosConcluidos.add(conteudo.get()); // Adiciona o conteúdo aos conteúdos concluídos
            this.conteudosInscritos.remove(conteudo.get()); // Remove o conteúdo dos conteúdos inscritos
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!"); // Exibe uma mensagem de erro se não houver conteúdos inscritos
        }
    }

    // Método para calcular a XP (experiência) do desenvolvedor com base nos conteúdos concluídos
    public double calcularXP() {
        return this.conteudosConcluidos
                .stream() // Cria um stream dos conteúdos concluídos
                .mapToDouble(conteudo -> conteudo.calcularXp()) // Mapeia cada conteúdo para seu valor de XP
                .sum(); // Soma todos os valores de XP
    }

    // Getter para o nome do desenvolvedor
    public String getNome() {
        return nome;
    }

    // Setter para o nome do desenvolvedor
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para os conteúdos inscritos do desenvolvedor
    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    // Setter para os conteúdos inscritos do desenvolvedor
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    // Getter para os conteúdos concluídos do desenvolvedor
    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    // Setter para os conteúdos concluídos do desenvolvedor
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    // Método hashCode para gerar um código hash para o objeto Dev
    @Override
    public int hashCode() {
        return Objects.hash(conteudosConcluidos, conteudosInscritos, nome); // Gera o código hash baseado nos atributos
    }

    // Método equals para comparar objetos Dev
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se são o mesmo objeto
        if (obj == null) return false; // Verifica se o objeto é nulo
        if (getClass() != obj.getClass()) return false; // Verifica se o objeto é de uma classe diferente
        Dev other = (Dev) obj; // Faz um cast para Dev
        return Objects.equals(conteudosConcluidos, other.conteudosConcluidos) && 
               Objects.equals(conteudosInscritos, other.conteudosInscritos) && 
               Objects.equals(nome, other.nome); // Compara todos os atributos
    }
}
