package model;

 /**
 * Classe que permite a adição de disciplina.
 */
public class Disciplina {
  private float notas[] = { 0, 0 };
  private String codigo;
  private String nome;
  private String descricao;
  private String turno;
  private float cargaHoraria;
  private int periodo;
  private String modalidade;
  private String docente;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }

  public float getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(float cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public int getPeriodo() {
    return periodo;
  }

  public void setPeriodo(int periodo) {
    this.periodo = periodo;
  }

  public String getModalidade() {
    return modalidade;
  }

  public void setModalidade(String modalidade) {
    this.modalidade = modalidade;
  }

  public String getDocente() {
    return docente;
  }

  public void setDocente(String docente) {
    this.docente = docente;
  }

  public float[] getNotas() {
    return notas;
  }

  public void setNotas(float nota, int index) {
    this.notas[index] = nota;
  }

  public float retornaMediaSemestral() {
    return (this.notas[0] + this.notas[1]) / 2;
  }
}