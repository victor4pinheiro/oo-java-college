package model;

import java.util.LinkedList;
import java.util.List;

 /**
 * Classe que permite a adição de cursos, de disciplinas e da lista de suas informações.
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
/**
 * Adiciona disciplina ao curso.
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
