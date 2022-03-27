package view;

import java.util.List;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;

/**
 * Confere a existência do curso, e o adiciona.
 */
public class CursoView {
  public void adicionarCurso(Scanner entrada, SistemaController sistema) {
    Curso novoCurso = new Curso();

    System.out.println("Código do curso:");
    novoCurso.setCodigo(entrada.next());

    System.out.println("Nome do curso:");
    entrada.nextLine();
    novoCurso.setNome(entrada.nextLine());

    System.out.println("Duração (em semestres/periodos):");
    novoCurso.setDuracao(entrada.nextInt());

    System.out.println("Turno do curso:");
    novoCurso.setTurno(entrada.next());

    System.out.println("Modalidade do curso:");
    novoCurso.setModalidade(entrada.next());

    System.out.println("Tipo de graduação do curso:");
    System.out.println("Ex.: Bacharelado, Licenciatura, Pós, Especialização, Mestrado, Doutorado, Pós-doc");
    novoCurso.setGraduacao(entrada.next());

    if (!sistema.adicionarCurso(novoCurso)) {
      novoCurso = null;
      System.out.println("Não foi possível adicionar o novo curso ao sistema.");
      System.out.println("Motivo: Curso já existente.");
      return;
    }

    System.out.println("Curso adicionado com sucesso");
  }
  /**
 * Lista os cursos adicionados
 */
  public void listarCurso(SistemaController sistema) {
    List<Curso> tmpCursos = sistema.listarCurso();
    for (Curso curso : tmpCursos) {
      System.out.println("----------------------------");
      System.out.println("Nome: " + curso.getNome());
      System.out.println("Código do curso: " + curso.getCodigo());
      System.out.println("Tipo de graduação: " + curso.getGraduacao());
      System.out.println("Turno: " + curso.getTurno());
      System.out.println("----------------------------");
    }
  }
}
