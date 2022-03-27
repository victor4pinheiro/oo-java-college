package view;

import java.util.List;
import java.util.Scanner;

import controller.SistemaController;
import model.Curso;

/**
 * Classe que permite a adição de um novo curso, desde que ainda não exista
 * e lista os cursos já adicionados.
 * 
 * CursoView
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 */
public class CursoView {
  /**
   * Adiciona o curso a lista de curso caso não exista o curso
   * 
   * @param entrada Leitura de daddos
   * @param sistema Objeto referenciando a classe SistemaController
   */
  public void adicionarCurso(Scanner entrada, SistemaController sistema) {
    Curso novoCurso = new Curso();

    do {
      System.out.println("Código do curso:");
      novoCurso.setCodigo(entrada.next());
    } while (novoCurso.getCodigo().isBlank());

    do {
      System.out.println("Nome do curso:");
      entrada.nextLine();
      novoCurso.setNome(entrada.nextLine());
    } while (novoCurso.getNome().isBlank() || sistema.isNumeric(novoCurso.getNome()));

    do {
      System.out.println("Duração (em semestres/periodos):");
      novoCurso.setDuracao(entrada.nextInt());
    } while (novoCurso.getDuracao() <= 0 || novoCurso.getDuracao() > 20);

    do {
      System.out.println("Turno do curso (matutino, vespertino, noturno):");
      novoCurso.setTurno(entrada.next());
    } while (novoCurso.getTurno().isBlank() || sistema.isNumeric(novoCurso.getTurno()));

    do {
      System.out.println("Modalidade do curso (presencial/EAD):");
      novoCurso.setModalidade(entrada.next());
    } while (novoCurso.getModalidade().isBlank() || sistema.isNumeric(novoCurso.getModalidade()));

    do {
      System.out.println("Tipo de graduação do curso:");
      System.out.println("Ex.: Graduação, Pós, Especialização, Mestrado, Doutorado, Pós-doc");
      novoCurso.setGraduacao(entrada.next());
    } while (novoCurso.getGraduacao().isBlank() || sistema.isNumeric(novoCurso.getGraduacao()));

    if (!sistema.adicionarCurso(novoCurso)) {
      novoCurso = null;
      System.out.println("Não foi possível adicionar o novo curso ao sistema.");
      System.out.println("Motivo: Curso já existente.");
      return;
    }

    System.out.println("Curso adicionado com sucesso");
  }

  /**
   * Método que apresenta os cursos listados ao usuário.
   * 
   * @param sistema Objeto referenciando a classe SistemaController.
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
