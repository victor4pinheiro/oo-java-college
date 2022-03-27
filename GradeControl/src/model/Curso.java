package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe que permite a adição de um curso, além de adicionar
 * e listar disicplinas e estudantes pertencentes a ele.
 *
 * 
 * 
 * Curso
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
  public class Curso {
  private String codigo;
  private String nome;
  private int duracao;
  private String turno;
  private String modalidade;
  private String graduacao;
  public List<Disciplina> disciplinas = new LinkedList<Disciplina>();
  public List<Estudante> estudantes = new LinkedList<Estudante>();

  /**
     * Retorna o valor do codigo para poder ser usado em outros contextos
     * 
     * @return codigo do curso no atual objeto 
     */
  public String getCodigo() {
    return codigo;
  }
  
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  /**
     * Retorna o valor do nome para poder ser usado em outros contextos
     * 
     * @return nome do contato no atual objeto (no contexto do programa, na
     *         atual posição da fila)
     */
  public String getNome() {
    return nome;
  }
  /**
     * Permite a adição de um valor ao noem do curso.
     *
     */
  public void setNome(String nome) {
    this.nome = nome;
  }
  /**
     * Retorna o valor do nome para poder ser usado em outros contextos
     * 
     * @return nome do contato no atual objeto (no contexto do programa, na
     *         atual posição da fila)
     */
  public int getDuracao() {
    return duracao;
  }
  /**
     * Permite a adição de um valor a duração do curso.
     *
     */
  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }
    /**
     * Retorna o valor do turno para poder ser usado em outros contextos
     * 
     * @return turno do curso no atual objeto 
     *         
     */  
  public String getTurno() {
    return turno;
  }
  /**
     * Permite a adição de um valor ao turno do curso.
     *
     */
  public void setTurno(String turno) {
    this.turno = turno;
  }
  /**
     * Retorna o valor da modalidade para poder ser usado em outros contextos
     * 
     * @return a modalidade do curso no atual objeto.
     *         
     */
  public String getModalidade() {
    return modalidade;
  }
  /**
     * Permite a adição de um valor a modalidade do curso.
     *
     */
  public void setModalidade(String modalidade) {
    this.modalidade = modalidade;
  }
  /**
     * Retorna o valor de graduação para poder ser usado em outros contextos
     * 
     * @return a graduação do curso no atual objeto.
     */
  public String getGraduacao() {
    return graduacao;
  }
  /**
     * Permite a adição de um valor a graduação do curso.
     *
     */
  public void setGraduacao(String graduacao) {
    this.graduacao = graduacao;
  }
 /**
     * Método para adicionar disciplina ao curso, 
     * somente se o curso existir.
     * 
     * 
     * @return caso não exista, retorna falso, caso contrário,
     *         retorna a nova disciplina adicionada.
     *        
     *  
     */ 

  public boolean adicionarDisciplina(Disciplina novaDisciplina) {
    for (Disciplina disciplina : disciplinas) {
      if (disciplina.getNome().equals(novaDisciplina.getNome()) ||
          disciplina.getCodigo().equals(novaDisciplina.getCodigo()))
        return false;
    }
    return this.disciplinas.add(novaDisciplina);
  }
}
