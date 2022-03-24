package view;

import java.util.Random;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;
import model.Disciplina;
import model.Estudante;

/**
 * EstudanteView
 */
public class EstudanteView {
  public void adicionarEstudante(Scanner entrada, SistemaController sistema) {
    Estudante estudante = new Estudante();
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

  public void listarDadosEstudante(Scanner entrada, SistemaController sistema) {
    System.out.println("Digite o nome do curso do estudante:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);

    if (tmpCurso == null) {
      System.out.println("Curso não existente");
      return;
    }

    System.out.println("Digite o nome do estudante:");
    String nomeEstudante = entrada.nextLine();

    Estudante tmpEstudante = sistema.buscarEstudante(tmpCurso, nomeEstudante);

    if (tmpEstudante == null) {
      System.out.println("Estudante não existente.");
      return;
    }

    System.out.println("Nome: " + tmpEstudante.getNome());
    System.out.println("Matrícula: " + tmpEstudante.getMatricula());
    System.out.println("Período: " + tmpEstudante.getPeriodo());
    System.out.println("Nome do curso: " + tmpEstudante.getCurso().getNome());
  }

  public void definirNotaDisciplina(Scanner entrada, SistemaController sistema) {
    System.out.println("Digite o nome do curso do estudante:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);

    if (tmpCurso == null) {
      System.out.println("Curso não existente");
      return;
    }

    System.out.println("Digite o nome do estudante:");
    String nomeEstudante = entrada.nextLine();

    Estudante tmpEstudante = sistema.buscarEstudante(tmpCurso, nomeEstudante);

    if (tmpEstudante == null) {
      System.out.println("Estudante não existente.");
      return;
    }

    System.out.println("Digite a disciplina do estudante:");
    String nomeDisciplina = entrada.nextLine();

    Disciplina disciplina = sistema.buscarDisciplina(tmpCurso, nomeDisciplina);

    if (disciplina == null) {
      System.out.println("Disciplina não existente.");
      return;
    }

    int quantidadeNotas = 0;
    do {
      System.out.println("Quantas notas serão digitadas?");
      quantidadeNotas = entrada.nextInt();

    } while (quantidadeNotas < 0 || quantidadeNotas > 2);

    if (quantidadeNotas == 0) {
      System.out.println("Nenhuma alteração realizada;");
      return;
    }

    for (int i = 0; i < quantidadeNotas; i++) {
      System.out.println("Digite a nota " + i + ":");
      if (!sistema.definirNotaDisciplina(tmpCurso, tmpEstudante, disciplina, entrada.nextFloat(), i)) {
        System.out.println("Inserção não finalizada. Realizar novamente.");
        return;
      }
    }

    if (quantidadeNotas == 2) {
      System.out.println("Deseja ver a média semestral? (S/n)");
      String resposta = entrada.next();

      if (resposta == "n") {
        System.out.println("Inserção de notas finalizada com sucesso.");
      }
    }

    System.out.println("Média semestral: " + sistema.obterNotaSemestral(tmpCurso, tmpEstudante, disciplina));
  }
}