package view;

import java.util.Random;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;
import model.Disciplina;
import model.Estudante;

/**
 * Classe que permite a adição de um novo estudante, e
 * o insere na lista de disciplinas do cursos, além de listar os dados.
 * 
 * 
 * CursoView
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 */
public class EstudanteView {
  /**
   * Adiciona o estudante a lista de estudantes caso exista o curso com matrícula
   * e período pré-definidos
   * 
   * @param entrada Leitura de daddos
   * @param sistema Objeto referenciando a classe SistemaController
   */
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

    do {
      System.out.println("Nome do estudante:");
      estudante.setNome(entrada.nextLine());
    } while (estudante.getNome().isBlank() || sistema.isNumeric(estudante.getNome()));

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

  /**
   * Método que verifica a existência de um curso ,e caso exista
   * insere um estudante, caso ele exista.
   * Permite também, a listagem dos estudantes por disciplina, e a quantas
   * o aluno pertence.
   * 
   * @param entrada Leitura de dados
   * @param sistema Objeto referenciando a classe SistemaController
   */
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
    System.out.println("Quantidade de disciplinas: " + tmpEstudante.getDisciplinas().size());

    if (tmpEstudante.getDisciplinas().isEmpty())
      return;

    System.out.println("Deseja listar as disciplinas do estudante? (S/n)");
    String resposta = entrada.nextLine();

    if (resposta == "n" || resposta == "N") {
      System.out.println("Listagem finalizada.");
      return;
    }

    System.out.println("Lista de disciplinas:");
    for (Disciplina disciplina : tmpEstudante.getDisciplinas()) {
      System.out.println("----------------------------");
      System.out.println("Nome: " + disciplina.getNome());
      System.out.println("Código: " + disciplina.getCodigo());
      System.out.println("Turno: " + disciplina.getTurno());
      System.out.println("Docente: " + disciplina.getDocente());

      for (int i = 0; i < 2; i++) {
        if (disciplina.getNotas()[i] != -1) {
          System.out.println("Nota bimestral " + i + ": " + disciplina.getNotas()[i]);
          continue;
        }
        System.out.println("Nota bimestral " + i + ": não existente");
      }
      System.out.println("----------------------------");
    }

  }

  /**
   * Método que verifica a existência do curso e do estudante, e caso
   * existam, permite a adição de notas.
   * 
   * @param entrada Leitura de dados
   * @param sistema Objeto referenciando a classe SistemaController
   */
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

    float nota = 0;

    if (quantidadeNotas == 1) {
      int semestre = 0;
      do {
        System.out.println("Em qual bimestre deseja definir nota? (1 ou 2)");
        semestre = entrada.nextInt();
      } while (semestre <= 0 || semestre > 2);

      System.out.println("Digite a nota:");
      nota = entrada.nextFloat();

      if (!sistema.definirNotaDisciplina(tmpCurso, tmpEstudante, disciplina, nota, semestre)) {
        System.out.println("Inserção não finalizada. Realizar novamente.");
        return;
      }
      System.out.println("Nota definida!");
      return;
    }

    for (int i = 0; i < quantidadeNotas; i++) {
      System.out.println("Digite a nota " + (i + 1) + ":");
      nota = entrada.nextFloat();
      if (!sistema.definirNotaDisciplina(tmpCurso, tmpEstudante, disciplina, nota, i)) {
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
      System.out.println("Média semestral: " + sistema.obterNotaSemestral(tmpCurso, tmpEstudante, disciplina));
    }
  }
}