package view;

import java.util.List;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;
import model.Disciplina;

/**
 * Classe que adicionar uma nova disciplina, e listar
 * as disciplinas presentes em um curso, e também por período.
 * 
 * 
 * DisciplinaView
 * 
 * @param entrada Leitura de dados
 * @param sistema objeto referenciando a classe SistemaController
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class DisciplinaView {
  public void adicionarDisciplina(Scanner entrada, SistemaController sistema) {
    Disciplina novaDisciplina = new Disciplina();

    System.out.println("Digite o nome do curso:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);

    if (tmpCurso == null) {
      System.out.println("Curso não encontrado");
      return;
    }

    do {
      System.out.println("Nome da disciplina:");
      novaDisciplina.setNome(entrada.nextLine());
    } while (novaDisciplina.getNome().isBlank() || sistema.isNumeric(novaDisciplina.getNome()));

    do {
      System.out.println("Código da disciplina:");
      novaDisciplina.setCodigo(entrada.next());
    } while (novaDisciplina.getCodigo().isBlank());

    do {
      System.out.println("Descrição da disciplina:");
      entrada.nextLine();
      novaDisciplina.setDescricao(entrada.nextLine());
    } while (novaDisciplina.getDescricao().isBlank() || sistema.isNumeric(novaDisciplina.getDescricao()));

    do {
      System.out.println("Modalidade da disciplina (presencial/EAD):");
      novaDisciplina.setModalidade(entrada.next());
    } while (novaDisciplina.getModalidade().isBlank() || sistema.isNumeric(novaDisciplina.getModalidade()));

    do {
      System.out.println("Carga horária da disciplina (em horas):");
      novaDisciplina.setCargaHoraria(entrada.nextFloat());
    } while (novaDisciplina.getCargaHoraria() <= 0);

    do {
      System.out.println("Período da disciplina:");
      novaDisciplina.setPeriodo(entrada.nextInt());
    } while (novaDisciplina.getPeriodo() <= 0 || novaDisciplina.getPeriodo() > tmpCurso.getDuracao());

    do {
      System.out.println("Docente da disciplina:");
      entrada.nextLine();
      novaDisciplina.setDocente(entrada.nextLine());
    } while (novaDisciplina.getDocente().isBlank() || sistema.isNumeric(novaDisciplina.getDocente()));

    do {
      System.out.println("Turno da disciplina (matutino, vespertino e noturno):");
      novaDisciplina.setTurno(entrada.next());
    } while (novaDisciplina.getTurno().isBlank() || sistema.isNumeric(novaDisciplina.getTurno()));

    if (!sistema.adicionarDisciplina(nomeCurso, novaDisciplina)) {
      novaDisciplina = null;
      System.out.println("Disciplina já existente.");
    }
    return;
  }

  /**
   * Método que verifica se o curso existe, se está vazio e
   * lista todas as disciplinas do curso.
   * 
   * @param entrada Leitura de dados
   * @param sistema Objeto referenciando a classe SistemaController
   * 
   * @return caso não exista curso, retorna "Curso não existente".
   *         caso não exista disciplina,retorna "Curso sem disciplina".
   */
  public void listarTodasDisciplinas(Scanner entrada, SistemaController sistema) {
    System.out.println("Nome do curso:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);

    if (tmpCurso == null) {
      System.out.println("Curso não existente");
      return;
    }

    List<Disciplina> disciplinas = sistema.listarTodasDisciplinas(tmpCurso);

    if (disciplinas == null) {
      System.out.println("Curso sem disciplinas.");
      return;
    }

    System.out.println("Disciplinas do curso " + nomeCurso + ":");
    for (Disciplina disciplina : disciplinas) {
      System.out.println("----------------------------");
      System.out.println("Código:" + disciplina.getCodigo());
      System.out.println("Nome: " + disciplina.getNome());
      System.out.println("Descrição: " + disciplina.getDescricao());
      System.out.println("Carga Horária: " + disciplina.getCargaHoraria());
      System.out.println("Turno: " + disciplina.getTurno());
      System.out.println("Período: " + disciplina.getPeriodo());
      System.out.println("Modalidade: " + disciplina.getModalidade());
      System.out.println("Docente: " + disciplina.getDocente());
      System.out.println("----------------------------");
    }
  }

  /**
   * Método que verifica se o curso existe, se possui disciplinas no período
   * especificado e lista as disciplinas por período.
   *
   * @param entrada Leitura de dados
   * @param sistema Objeto referenciando a classe SistemaController
   * 
   * @return caso não exista curso, retorna "Curso não existente".
   *         caso não exista disciplina,retorna "Curso sem disciplinas no
   *         respecitivo período."
   */
  public void listarDisciplinasPorPeriodo(Scanner entrada, SistemaController sistema) {
    System.out.println("Nome do curso:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    Curso tmpCurso = sistema.verificarCurso(nomeCurso);
    if (tmpCurso == null) {
      System.out.println("Curso não existente");
      return;
    }

    int periodo = 0;
    do {
      System.out.println("Período do estudante:");
      periodo = entrada.nextInt();
    } while (periodo == 0 || periodo > tmpCurso.getDuracao());

    List<Disciplina> disciplinasPeriodo = sistema.listarDisciplinasPorPeriodo(periodo, tmpCurso);

    if (disciplinasPeriodo == null) {
      System.out.println("Curso sem disciplinas no respectivo período.");
      return;
    }
    for (Disciplina disciplina : disciplinasPeriodo) {
      System.out.println("----------------------------");
      System.out.println("Código:" + disciplina.getCodigo());
      System.out.println("Nome: " + disciplina.getNome());
      System.out.println("Descrição: " + disciplina.getDescricao());
      System.out.println("Carga Horária: " + disciplina.getCargaHoraria());
      System.out.println("Turno: " + disciplina.getTurno());
      System.out.println("Período: " + disciplina.getPeriodo());
      System.out.println("Modalidade: " + disciplina.getModalidade());
      System.out.println("Docente: " + disciplina.getDocente());
      System.out.println("----------------------------");
    }
  }
}