package sistema;

public class Estudante {
  private String nome;
  private long matricula;
  private Curso curso;
  private int periodo;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public long getMatricula() {
    return matricula;
  }

  public void setMatricula(long matricula) {
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
}