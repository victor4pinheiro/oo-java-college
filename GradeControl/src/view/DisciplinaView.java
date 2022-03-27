package view;

import java.util.List;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;
import model.Disciplina;

/**
 * Verifica se a disciplina existe, e o adiciona.
 */
public class DisciplinaView {
  public void adicionarDisciplina(Scanner entrada, SistemaController sistema) {
    Disciplina novaDisciplina = new Disciplina();

    System.out.println("Digite o nome do curso:");
    entrada.nextLine();
    String nomeCurso = entrada.nextLine();

    if (sistema.verificarCurso(nomeCurso) == null) {
      System.out.println("Curso não encontrado");
      return;
    }

    System.out.println("Nome da disciplina:");
    novaDisciplina.setNome(entrada.nextLine());

    System.out.println("Código da disciplina:");
    novaDisciplina.setCodigo(entrada.next());

    System.out.println("Descrição da disciplina:");
    entrada.nextLine();
    novaDisciplina.setDescricao(entrada.nextLine());

    System.out.println("Modalidade da disciplina:");
    novaDisciplina.setModalidade(entrada.next());

    System.out.println("Carga horária da disciplina:");
    novaDisciplina.setCargaHoraria(entrada.nextFloat());

    System.out.println("Período da disciplina:");
    novaDisciplina.setPeriodo(entrada.nextInt());

    System.out.println("Docente da disciplina:");
    entrada.nextLine();
    novaDisciplina.setDocente(entrada.nextLine());

    System.out.println("Turno da disciplina:");
    novaDisciplina.setTurno(entrada.next());

    if (!sistema.adicionarDisciplina(nomeCurso, novaDisciplina)) {
      novaDisciplina = null;
      System.out.println("Disciplina já existente.");
    }
  }
  /**
 * Lista todas as disciplinas ofertadas.
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
 * Lista as disciplinas de acordo com o curso pertencente.
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
/**
 * Mostra os dados da disciplina.
 */
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