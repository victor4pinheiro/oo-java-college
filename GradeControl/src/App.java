import java.util.Scanner;

import view.CursoView;
import view.DisciplinaView;
import view.EstudanteView;

public class App {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    CursoView curso = new CursoView();
    DisciplinaView disciplina = new DisciplinaView();
    EstudanteView estudante = new EstudanteView();

    while (true) {
      System.out.println("1 - Adicionar curso ao sistema");
      System.out.println("2 - Mostrar os cursos ofertados");
      System.out.println("3 - Adicionar disciplina ao curso");
      System.out.println("4 - Listar todas as disciplinas de um curso");
      System.out.println("5 - Listar todas as disciplinas um período de um curso");
      System.out.println("6 - Adicionar estudante ao sistema");
      System.out.println("7 - Listar dados do estudante");
      System.out.println("8 - Definir a nota do estudante");
      int option = entrada.nextInt();

      switch (option) {
        case 1:
          curso.adicionarCurso();
          break;

        case 2:
          curso.listarCurso();
          break;

        case 3:
          disciplina.adicionarDisciplina();
          break;

        case 4:
          disciplina.listarTodasDisciplinas();
          break;
        case 5:
          disciplina.listarDisciplinasPorPeriodo();
          break;
        case 6:
          estudante.adicionarEstudante();
          break;

        case 7:
          estudante.listarDadosEstudante();
          break;

        case 8:
          estudante.definirNotaDisciplina();
          break;

        case 99:
          entrada.close();
          System.exit(0);
          break;

        default:
          System.out.println("Opção não identificada");
          break;
      }
    }
  }
}
