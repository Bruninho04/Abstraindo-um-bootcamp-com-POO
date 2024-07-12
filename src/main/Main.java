package main;

import java.time.LocalDate;

import br.com.dominio.classes.*;

public class Main {

    public static void main(String[] args) {
        // Criando um novo curso
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);
        
        // Criando uma nova mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria java");
        mentoria.setDescricao("Java com POO");
        mentoria.setData(LocalDate.now());
        
        // Criando um novo bootcamp e adicionando curso e mentoria ao bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição bootcamp Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria);
        
        // Criando um novo desenvolvedor, inscrevendo-o no bootcamp e mostrando seus conteúdos inscritos e concluídos
        Dev devBruno = new Dev();
        devBruno.setNome("Bruno");
        devBruno.inscreverBootcamp(bootcamp);
        System.out.println("---------------------------");
        System.out.println("Conteúdos Inscritos do Bruno:" + devBruno.getConteudosInscritos());
        
        // Progredindo nos conteúdos do bootcamp
        devBruno.progredir();
        devBruno.progredir();
        
        // Mostrando os conteúdos inscritos e concluídos após a progressão
        System.out.println("Conteúdos Inscritos do Bruno:" + devBruno.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos do Bruno:" + devBruno.getConteudosConcluidos());
        
        // Calculando e mostrando o XP ganho
        System.out.println("XP: " + devBruno.calcularXP());
        System.out.println("---------------------------");
        System.out.println();
        
        // Repetindo o processo para um segundo desenvolvedor
        System.out.println("---------------------------");
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos do João:" + devJoao.getConteudosInscritos());
        System.out.println();
        
        // Progredindo nos conteúdos do bootcamp
        devJoao.progredir();
        
        // Mostrando os conteúdos inscritos e concluídos após a progressão
        System.out.println("Conteúdos Inscritos do João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos do João:" + devJoao.getConteudosConcluidos());
        
        // Calculando e mostrando o XP ganho
        System.out.println("XP: " + devJoao.calcularXP());
        System.out.println("---------------------------");
    }
}

