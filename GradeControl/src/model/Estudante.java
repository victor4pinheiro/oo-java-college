package model;

import java.util.LinkedList;
import java.util.List;
/**
 * Classe que permite a adição de estudante, e listá-lo 
 * nas disciplinas pertencentes.
 * 
 * Curso
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class Estudante {
  private String nome;
  private int matricula;
  private Curso curso;
  private int periodo;
  List<Disciplina> disciplinas = new LinkedList<Disciplina>();
  /**
     * Retorna o valor de nome para poder ser usado em outros contextos
     * 
     * @return o nome do estudante no atual objeto.
     */
  public String getNome() {
    return nome;
  }
   /**
     * Permite a adição de um valor ao nome do estudante.
     *
     * @param nome Nome do estudante
     * 
     */
  public void setNome(String nome) {
    this.nome = nome;
  }
  /**
     * Retorna o valor de matrícula para poder ser usado em outros contextos
     * 
     * @return a matrícula do estudante no atual objeto.
     */
  public int getMatricula() {
    return matricula;
  }
   /**
     * Permite a adição de um valor a matrícula do estudante.
     *
     * @param matricula Matrícula do estudante.
     * 
     */
  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }
  /**
     * Retorna o valor de curso para poder ser usado em outros contextos
     * 
     * @return o curso do estudante no atual objeto.
     */
  public Curso getCurso() {
    return curso;
  }
   /**
     * Permite a adição de um valor ao curso do estudante.
     *
     * @param curso Curso da disciplina
     * 
     */
  public void setCurso(Curso curso) {
    this.curso = curso;
  }
  /**
     * Retorna o valor de período para poder ser usado em outros contextos
     * 
     * @return o período do estudante no atual objeto.
     */
  public int getPeriodo() {
    return periodo;
  }
    /**
     * Permite a adição de um valor ao período do estudante.
     *
     * @param periodo Período da disciplina
     * 
     */
  public void setPeriodo(int periodo) {
    this.periodo = periodo;
  }
  /**
     * Retorna o valor de List<Disciplina> get Disciplinas para poder ser usado em outros contextos.
     * 
     * @return a lista de disciplinas no atual objeto.
     */
  public List<Disciplina> getDisciplinas() {
    return disciplinas;
  }
   /**
     * Permite a adição de um valor a lista de disciplinas.
     *
     * @param disciplinas Lista das disciplinas
     * 
     */
  public void setDisciplinas(List<Disciplina> disciplinas) {
    this.disciplinas = disciplinas;
  }
  /**
     * Método que verifica se a disciplina existe
     * e adiciona as notas bimestrais do estudante.
     * 
     *@param tmpDisciplina objeto temporário
     *@param notaBimestral Nota bimestral do estudante
     *@param index         Média da nota do estudante
     
     * @return caso não exista disciplina, retorna falso
     *         caso contrário, retorna as notas.
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