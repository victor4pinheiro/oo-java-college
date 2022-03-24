import java.util.Scanner;

import controller.SistemaController;
import view.CursoView;
import view.DisciplinaView;
import view.EstudanteView;

public class App {
  public static void main(String[] args) {
    SistemaController sistema = new SistemaController();
    CursoView curso = new CursoView();
    DisciplinaView disciplina = new DisciplinaView();
    EstudanteView estudante = new EstudanteView();

    while (true) {
      Scanner entrada = new Scanner(System.in);
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
          curso.adicionarCurso(entrada, sistema);
          break;
        case 2:
          curso.listarCurso(sistema);
          break;
        case 3:
          disciplina.adicionarDisciplina(entrada, sistema);
          break;
        case 4:
          disciplina.listarTodasDisciplinas(entrada, sistema);
          break;
        case 5:
          disciplina.listarDisciplinasPorPeriodo(entrada, sistema);
          break;
        case 6:
          estudante.adicionarEstudante(entrada, sistema);
          break;
        case 7:
          estudante.listarDadosEstudante(entrada, sistema);
          break;
        case 8:
          estudante.definirNotaDisciplina(entrada, sistema);
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
