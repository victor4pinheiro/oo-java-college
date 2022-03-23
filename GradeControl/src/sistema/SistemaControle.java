package sistema;

import java.util.LinkedList;
import java.util.List;

public class SistemaControle {
  List<Curso> cursos = new LinkedList<Curso>();
  List<Estudante> estudantes = new LinkedList<Estudante>();

  /**
   * Verificará se existe o curso na universidade. Caso verdadeiro,
   * retorna falso, caso contrário, permite a inserção de mais um curso na
   * universidade em uma lista de cursos.
   *
   * @param curso curso a ser adicionado ao sistema.
   * @return verdadeiro se a adição do curso ao sistema foi bem sucedida, caso
   *         contrário, retorna falso.
   */
  public boolean adicionarCurso(Curso novoCurso) {
    for (Curso curso : cursos) {
      if (curso.getCodigo().equals(novoCurso.getCodigo()))
        return false;
      if (curso.getNome().equals(novoCurso.getNome()))
        return false;
    }
    return this.cursos.add(novoCurso);
  }

  /**
   * Verifica se o curso passado via parâmetro existe e retorna ele caso exista.
   * 
   * @param nomeCurso nome do curso a ser buscado na lista de cursos.
   * @return Curso caso verdadeiro, caso falso, retorna nulo indicando que o curso
   *         não existe.
   */
  public Curso verificarCurso(String nomeCurso) {
    for (Curso curso : cursos) {
      if (curso.getNome().equals(nomeCurso))
        return curso;
    }
    return null;
  }

  /**
   * Mostrará ao usuário os cursos listados no sistema, e suas informações.
   */
  public List<Curso> listarCurso() {
    return cursos;
  }

  /**
   * Verificará se existe a disciplina no curso. Caso verdadeiro, retorna falso,
   * caso contrário, adicionará a disciplina de acordo com o período/semestre
   * dela.
   * 
   * @param curso      curso para adicionar a disciplina.
   * @param disciplina disciplina a ser adicionado ao curso.
   * @return verdadeiro se a adição da disciplina ao curso foi bem sucedida, caso
   *         contrário, retorna falso.
   */
  public boolean adicionarDisciplina(String nomeCurso, Disciplina disciplina) {
    for (Curso cursoAdicao : cursos) {
      if (cursoAdicao.getNome().equals(nomeCurso)) {
        return cursoAdicao.adicionarDisciplina(disciplina);
      }
    }
    return false;
  }

  public List<Disciplina> listarTodasDisciplinas(Curso cursoVerificacao) {
    for (Curso curso : cursos) {
      if (curso.equals(cursoVerificacao)) {
        return curso.disciplinas;
      }
    }
    return null;
  }

  public List<Disciplina> listarDisciplinasPorPeriodo(int periodo, Curso curso) {
    List<Disciplina> tmpDisciplinas = new LinkedList<Disciplina>();
    for (Curso tmpCurso : cursos) {
      if (tmpCurso.equals(curso)) {
        for (Disciplina disciplina : curso.disciplinas) {
          if (disciplina.getPeriodo() == periodo)
            tmpDisciplinas.add(disciplina);
        }
      }
    }
    return tmpDisciplinas;
  }

  /**
   * Adicionará um estudante à universidade com um curso já definido.
   * 
   * @param estudante estudante a ser inserido no sistema.
   * @return verdadeiro se a adição do estudante ao sistema foi bem sucedida, caso
   *         contrário, retorna falso.
   */
  public boolean adicionarEstudante(Estudante estudante) {
    if (this.estudantes.contains(estudante))
      return false;

    return this.estudantes.add(estudante);
  }

  public Estudante listarDadosEstudante(String nome) {
    for (Estudante estudante : estudantes) {
      if (estudante.getNome().equals(nome))
        return estudante;
    }
    return null;
  }
}
