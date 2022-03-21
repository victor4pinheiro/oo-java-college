package sistema;

import java.util.ArrayList;
import java.util.List;

public class Curso {
  private String codigo;
  private String nome;
  private String duracao;
  private String turno;
  private String modalidade;
  private String graduacao;
  List<Disciplina> disciplinas = new ArrayList<Disciplina>();

  public Curso(String codigo, String nome, String duracao, String turno, String modalidade, String graduacao) {
    this.codigo = codigo;
    this.nome = nome;
    this.duracao = duracao;
    this.turno = turno;
    this.modalidade = modalidade;
    this.graduacao = graduacao;
  }

  public String getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public String getDuracao() {
    return duracao;
  }

  public String getTurno() {
    return turno;
  }

  public String getModalidade() {
    return modalidade;
  }

  public String getGraduacao() {
    return graduacao;
  }

  public List<Disciplina> getDisciplinas() {
    return disciplinas;
  }

  public boolean adicionarDisciplina(Disciplina disciplina) {
    if (this.disciplinas.contains(disciplina))
      return false;
    return this.disciplinas.add(disciplina);
  }
}
