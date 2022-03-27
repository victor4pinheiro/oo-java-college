package model;

import java.util.LinkedList;
import java.util.List;
 /**
 * Classe para permitir listar e definir notas para o estudante.
 */
public class Estudante {
  private String nome;
  private int matricula;
  private Curso curso;
  private int periodo;
  List<Disciplina> disciplinas = new LinkedList<Disciplina>();

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getMatricula() {
    return matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public int getPeriodo() {
    return periodo;
  }

  public void setPeriodo(int periodo) {
    this.periodo = periodo;
  }

  public List<Disciplina> getDisciplinas() {
    return disciplinas;
  }

  public void setDisciplinas(List<Disciplina> disciplinas) {
    this.disciplinas = disciplinas;
  }
   /**
 * 
 */
  public boolean definirNotaDisciplina(Disciplina tmpDisciplina, Float notaBimestral, int index) {
    for (Disciplina disciplina : disciplinas) {
      if (disciplina.equals(tmpDisciplina)) {
        disciplina.setNotas(notaBimestral, index);
        return true;
      }
    }
    return false;
  }
}