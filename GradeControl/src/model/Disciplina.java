package model;

public class Disciplina {
  private float nota1, nota2;
  private float media;
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

  public float getNota1() {
    return nota1;
  }

  public void setNota1(float nota1) {
    this.nota1 = nota1;
  }

  public float getNota2() {
    return nota2;
  }

  public void setNota2(float nota2) {
    this.nota2 = nota2;
  }

  public float getMedia() {
    return media;
  }

  public void setMedia() {
    this.media = (this.nota1 + this.nota2 / 2);
  }
}