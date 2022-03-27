package controller;

import java.util.LinkedList;
import java.util.List;
import model.Curso;
import model.Disciplina;
import model.Estudante;

/**
 * Classe que permite o gerenciamento do sistema acadêmico.
 * 
 * 
 * SistemaController
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
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
     * Verifica se o curso existe na lista, e retorna seu nome
     * caso não existe o curso, retorna nulo.
     * 
     * @param nomeCurso  nome do curso
     * 
     * @return se for nulo, retorna nulo, caso contrário, retorna o curso 
     *         cujo o nome foi inserido.    
     *      
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
     * Verifica se o curso existe na lista, e adiciona uma disciplina
     * caso não existe o curso, retorna nulo.
     * 
     * @param nomeCurso nome do curso
     * @param disciplina disciplina do curso
     * 
     * @return se for nulo, retorna nulo, caso contrário, 
     *         insere a disciplina no curso especificado.         
     *      
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
     * Verifica se o curso existe na lista, e adiciona uma disciplina
     * caso não exista o curso, retorna nulo.
     * 
     * @param tmpCurso curso temporário
     * @param nomeDisciplina nome da disciplina
     * 
     * @return se for nulo, retorna nulo, caso contrário, 
     *         insere a disciplina no curso especificado.
     *          
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
     * Verifica se o curso existe na lista e apresenta sua disciplinas
     * caso não existe o curso, retorna nulo.
     * 
     * @param cursoVerficacao a verificação se o curso existe.
     * 
     * @return se for nulo, retorna nulo, caso contrário, 
     *         lista todas as disciplinas do curso.
     *        
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
     * Verifica se o curso existe, e então percorre as suas disciplinas,
     * caso a disicplina corresponda ao período especificado, ela é adicionada.
     * 
     * @param periodo período do curso
     * @param curso curso em si.
     * 
     * @return As disciplinas de acordo com o período.
     *          
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
     * Adiciona estudante ao curso, somente se o curso existir.
     * caso não exista, retorna falso.
     * 
     * @param tmpCurso objeto temporário
     * @param estudante objeto estudante
     * 
     * @return  se for falso, retorna falso. Caso contrário
     *          adiciona o estudante.
     *          
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
     * Procura o estudante na lista de cursos, somente se o curso existir.
     *
     * @param tmpCurso objeto temporário
     * @param nome nome do estudante
     * 
     * @return se nulo, retorna nulo. caso contrário, retorna o estudante 
     *         especificado no curso.
     *       
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
     * Verifica se o curso e o estudante existem.
     * Caso sim, permite a definição de notas.
     * 
     * @param tmpCurso objeto temporário
     * @param tmpEstudante objeto temporário
     * @param tmpDisciplina objeto temporário
     * @param notaBimestral nota bimestral do estudante
     * @param index média semestral do estudante
     * 
     * @return falso, caso não exista curso ou estudante
     *         caso contrário, retorna a disciplina, as notas bimestrais.
     *        
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
     * Verifica se o curso, estudante e disicplina existem.
     * E caso existam retorna a media semestral.
     * 
     * @param tmpCurso objeto temporário  
     * @param tmpEstudante objeto temporário
     * @param tmpDisciplina objeto temporário
     * 
     * @return caso não exista, retorna vazio. caso contrário,
     *         retorna a media semestral.
     *         
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