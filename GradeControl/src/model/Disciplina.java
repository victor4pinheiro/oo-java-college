package model;

/**
 * Classe que permite adicionar uma disciplina, e retornar
 * sua nota semestral.
 *
 * Curso
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 */
public class Disciplina {
  private float notas[] = { -1, -1 };
  private String codigo;
  private String nome;
  private String descricao;
  private String turno;
  private float cargaHoraria;
  private int periodo;
  private String modalidade;
  private String docente;

  /**
   * Retorna o valor de código para poder ser usado em outros contextos
   * 
   * @return o código da disciplina no atual objeto.
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Permite a adição de um valor ao codigo da disciplina.
   *
   * @param codigo Codigo da disciplina
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  /**
   * Retorna o valor de nome para poder ser usado em outros contextos
   * 
   * @return o nome da disciplina no atual objeto.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Permite a adição de um valor ao nome da disciplina.
   *
   * @param nome Nome da disciplina
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Retorna o valor de descrição para poder ser usado em outros contextos
   * 
   * @return a descrição da disciplina no atual objeto.
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * Permite a adição de um valor a descricao da disciplina.
   *
   * @param descricao Descrição da disciplina
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  /**
   * Retorna o valor de turno para poder ser usado em outros contextos
   * 
   * @return o turno da disciplina no atual objeto.
   */
  public String getTurno() {
    return turno;
  }

  /**
   * Permite a adição de um valor ao turno da disciplina.
   *
   * @param turno Turno da disciplina
   */
  public void setTurno(String turno) {
    this.turno = turno;
  }

  /**
   * Retorna o valor da cargaHoraria para poder ser usado em outros contextos
   * 
   * @return a Carga Horária da disciplina no atual objeto.
   */
  public float getCargaHoraria() {
    return cargaHoraria;
  }

  /**
   * Permite a adição de um valor a cargaHoraria da disciplina.
   *
   * @param cargaHoraria Carga horária da disciplina.
   */
  public void setCargaHoraria(float cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  /**
   * Retorna o valor de período para poder ser usado em outros contextos
   * 
   * @return o período da disciplina no atual objeto.
   */
  public int getPeriodo() {
    return periodo;
  }

  /**
   * Permite a adição de um valor ao período da disciplina.
   *
   * @param periodo Periodo da disciplina.
   */
  public void setPeriodo(int periodo) {
    this.periodo = periodo;
  }

  /**
   * Retorna o valor de modalidade para poder ser usado em outros contextos
   * 
   * @return a modalidade da disciplina no atual objeto.
   */
  public String getModalidade() {
    return modalidade;
  }

  /**
   * Permite a adição de um valor a modalidade da disciplina.
   *
   * @param modalidade Modalidade da disciplina
   */
  public void setModalidade(String modalidade) {
    this.modalidade = modalidade;
  }

  /**
   * Retorna o valor de docente para poder ser usado em outros contextos
   * 
   * @return o docente da disciplina no atual objeto.
   */
  public String getDocente() {
    return docente;
  }

  /**
   * Permite a adição de um valor ao docente da disciplina.
   *
   * @param docente Docente da disciplina
   */
  public void setDocente(String docente) {
    this.docente = docente;
  }

  /**
   * Retorna o valor de notas para poder ser usado em outros contextos
   * 
   * @return as notas da disciplina no atual objeto.
   */
  public float[] getNotas() {
    return notas;
  }

  /**
   * Permite a adição de um valor as notas da disciplina.
   *
   * @param nota  Nota da disciplina
   * @param index Média da disciplina
   */
  public void setNotas(float nota, int index) {
    this.notas[index] = nota;
  }

  /**
   * Método para retornar a media semestral do estudante pertencente a disciplina.
   *
   * @return a média semestral.
   */
  public float retornaMediaSemestral() {
    return (this.notas[0] + this.notas[1]) / 2;
  }
}