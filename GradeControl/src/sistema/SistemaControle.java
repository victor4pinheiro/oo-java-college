package sistema;

import java.util.LinkedList;
import java.util.List;

public class SistemaControle {
  List<Curso> cursos = new LinkedList<Curso>();
  List<Estudante> estudantes = new LinkedList<Estudante>();

  /**
   * Verificará se existe o curso na univerdade. Caso verdadeiro,
   * retorna falso, caso contrário, permite a inserção de mais um curso na
   * universidade em uma lista de cursos.
   *
   * @param curso curso a ser adicionado ao sistema.
   * @return verdadeiro se a adição do curso ao sistema foi bem sucedida, caso
   *         contrário, retorna falso.
   */
  public boolean adicionarCurso(Curso curso) {
    return this.cursos.add(curso);
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
  public boolean adicionarDisciplina(Curso curso, Disciplina disciplina) {
    return curso.adicionarDisciplina(disciplina);
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
}
