package view;

import java.util.Random;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;
import model.Estudante;

/**
 * EstudanteView
 */
public class EstudanteView {
  public void adicionarEstudante() {
    Estudante estudante = new Estudante();
    SistemaController sistema = new SistemaController();
    Scanner entrada = new Scanner(System.in);

    System.out.println("Nome do curso:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);
    if (tmpCurso == null) {
      System.out.println("Curso não existente");
      return;
    }

    System.out.println("Nome do estudante:");
    estudante.setNome(entrada.nextLine());
    Random random = new Random();
    estudante.setMatricula(random.nextInt());
    estudante.setPeriodo(1);
    estudante.setCurso(tmpCurso);
    estudante.setDisciplinas(sistema.listarTodasDisciplinas(tmpCurso));

    if (!sistema.adicionarEstudante(tmpCurso, estudante)) {
      estudante = null;
      System.out.println("Cadastro não realizado.");
      return;
    }

    System.out.println("Cadastro realizado com sucesso.");
  }

  public void listarDadosEstudante() {
    SistemaController sistema = new SistemaController();
    Scanner entrada = new Scanner(System.in);

    System.out.println("Digite o nome do curso do estudante:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);

    if (tmpCurso == null) {
      System.out.println("Curso não existente");
      entrada.close();
      return;
    }

    System.out.println("Digite o nome do estudante:");
    String nomeEstudante = entrada.nextLine();
    entrada.close();

    Estudante tmpEstudante = sistema.listarDadosEstudante(tmpCurso, nomeEstudante);

    if (tmpEstudante == null) {
      System.out.println("Estudante não existente.");
      return;
    }

    System.out.println("Nome: " + tmpEstudante.getNome());
    System.out.println("Matrícula: " + tmpEstudante.getMatricula());
    System.out.println("Período: " + tmpEstudante.getPeriodo());
    System.out.println("Nome do curso: " + tmpEstudante.getCurso().getNome());
  }

  public void definirNotaDisciplina() {
    SistemaController sistema = new SistemaController();
    Scanner entrada = new Scanner(System.in);

    System.out.println("Matrícula do estudante:");
    int matricula = entrada.nextInt();

    // if (1 == 2) {
    // System.out.println("Estudante não existe: ");
    // return;
    // }
    // System.out.println("Digite a disciplina do estudante: ");
    // for (Curso curso : cursos) {
    // if (curso.equals(cursoVerificacao)) {
    // return curso.disciplinas;
    // }
    // return null;
    // }
    // System.out.println("Defina a nota do 1 semestre:");
    // estudante.setNota1();
    // System.out.println("Defina a nota do 2 semestre: ");
    // estudante.setNota2();
    // System.out.println("Media: ");
    // estudante.getMedia();

    // System.out.println("Nome: " + getNome());
    // System.out.println("Matrícula: " + getMatricula());
    // System.out.println("Disciplina: " + getDisciplina());
    // System.out.println("Notas semestrais " + getNota1(), +getNota2());
    // System.out.println("Disciplina: " + getMedia());

    // System.out.println("Nome do estudante");
  }
}