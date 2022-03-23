package sistema;

import java.util.LinkedList;
import java.util.List;

public class Curso {
  private String codigo;
  private String nome;
  private int duracao;
  private String turno;
  private String modalidade;
  private String graduacao;
  List<Disciplina> disciplinas = new LinkedList<Disciplina>();

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

  public int getDuracao() {
    return duracao;
  }

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }

  public String getModalidade() {
    return modalidade;
  }

  public void setModalidade(String modalidade) {
    this.modalidade = modalidade;
  }

  public String getGraduacao() {
    return graduacao;
  }

  public void setGraduacao(String graduacao) {
    this.graduacao = graduacao;
  }

  public boolean adicionarDisciplina(Disciplina disciplina) {
    if (this.disciplinas.contains(disciplina))
      return false;
    return this.disciplinas.add(disciplina);
  }
}
