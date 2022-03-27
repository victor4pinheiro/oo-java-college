package controller;

import java.util.LinkedList;
import java.util.List;
import model.Curso;
import model.Disciplina;
import model.Estudante;

 /**
 * Classe que permite o gerenciamento do sistema, permitindo adição de cursos, disciplinas, estudantes e seus dados.
 */
public class SistemaController {
  List<Curso> cursos = new LinkedList<Curso>();

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
 * Verifica se o curso existe, e retorna nulo caso não exista.
 */
  public Curso verificarCurso(String nomeCurso) {
    for (Curso curso : cursos) {
      if (curso.getNome().equals(nomeCurso))
        return curso;
    }
    return null;
  }

  public List<Curso> listarCurso() {
    return cursos;
  }
  /**
 * Adiciona disciplina ao curso
 */
  public boolean adicionarDisciplina(String nomeCurso, Disciplina disciplina) {
    for (Curso cursoAdicao : cursos) {
      if (cursoAdicao.getNome().equals(nomeCurso)) {
        return cursoAdicao.adicionarDisciplina(disciplina);
      }
    }
    return false;
  }
/**
 * Checa a disciplina na lista e verifica se ela existe.
 */
  public Disciplina buscarDisciplina(Curso tmpCurso, String nomeDisciplina) {
    for (Curso curso : cursos) {
      if (curso.equals(tmpCurso)) {
        for (Disciplina disciplina : curso.disciplinas) {
          if (disciplina.getNome().equals(nomeDisciplina)) {
            return disciplina;
          }
        }
      }
    }
    return null;
  }
/**
 * Apresenta todas as disciplinas do curso presentes na lista.
 */
  public List<Disciplina> listarTodasDisciplinas(Curso cursoVerificacao) {
    for (Curso curso : cursos) {
      if (curso.equals(cursoVerificacao)) {
        return curso.disciplinas;
      }
    }
    return null;
  }
/**
 * Apresenta as disciplinas da lista de acordo com o período.
 */
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
 * Verifica se o curso existe e adiciona o estudante.
 */
  public boolean adicionarEstudante(Curso tmpCurso, Estudante estudante) {
    for (Curso curso : cursos) {
      if (curso.equals(tmpCurso)) {
        return curso.estudantes.add(estudante);
      }
    }

    return false;
  }
  /**
 * Procura o estudante de acordo com o curso.
 */
  public Estudante buscarEstudante(Curso tmpCurso, String nome) {
    for (Curso curso : cursos) {
      if (curso.equals(tmpCurso)) {
        for (Estudante estudante : curso.estudantes) {
          if (estudante.getNome().equals(nome))
            return estudante;
        }
      }
    }
    return null;
  }
  /**
 * Permite adição de nota na disciplina.
 */

  public boolean definirNotaDisciplina(Curso tmpCurso, Estudante tmpEstudante, Disciplina tmpDisciplina,
      Float notaBimestral, int index) {
    for (Curso curso : cursos) {
      if (curso.equals(tmpCurso)) {
        for (Estudante estudante : curso.estudantes) {
          if (estudante.equals(tmpEstudante))
            return estudante.definirNotaDisciplina(tmpDisciplina, notaBimestral, index);
        }
      }
    }
    return false;
  }
/**
 * Mostra a nota semestral do estudante.
 */
  public float obterNotaSemestral(Curso tmpCurso, Estudante tmpEstudante, Disciplina tmpDisciplina) {
    for (Curso curso : cursos) {
      if (curso.equals(tmpCurso)) {
        for (Estudante estudante : curso.estudantes) {
          if (estudante.equals(tmpEstudante)) {
            for (Disciplina disciplina : estudante.getDisciplinas()) {
              if (disciplina.equals(tmpDisciplina)) {
                return disciplina.retornaMediaSemestral();
              }
            }
          }
        }
      }
    }
    return 0;
  }
}