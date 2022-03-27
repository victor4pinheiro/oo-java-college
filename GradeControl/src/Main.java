import java.util.Scanner;

import controller.SistemaController;
import view.CursoView;
import view.DisciplinaView;
import view.EstudanteView;
 /**
 * Permite que o usuário interaja, via linha de comando, com o programa,
 * permitindo adicionar nota, curso, disciplina, estudante e listá-los respectivamente.
 * 
 * Main
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class Main {
  public static void main(String[] args) {
    SistemaController sistema = new SistemaController();
    CursoView curso = new CursoView();
    DisciplinaView disciplina = new DisciplinaView();
    EstudanteView estudante = new EstudanteView();
     /** Estrutura de repetição while contendo as opções */
    while (true) {
      /** Declaração da classe Scanner para entrada de dados */
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
     /** Estrutura de condição para o usuário efetuar a opção escolhida, ou sair. */
      switch (option) {
        case 1://Adicionar curso
          curso.adicionarCurso(entrada, sistema);
          break;
        case 2://Listar curso
          curso.listarCurso(sistema);
          break;
        case 3://Adicionar disciplina
          disciplina.adicionarDisciplina(entrada, sistema);
          break;
        case 4://Listar tidas as disciplinas.
          disciplina.listarTodasDisciplinas(entrada, sistema);
          break;
        case 5://listar disciplinas por período.
          disciplina.listarDisciplinasPorPeriodo(entrada, sistema);
          break;
        case 6://Adicionar estudante
          estudante.adicionarEstudante(entrada, sistema);
          break;
        case 7://Listar dados do estudante
          estudante.listarDadosEstudante(entrada, sistema);
          break;
        case 8://Definir nota para disciplina.
          estudante.definirNotaDisciplina(entrada, sistema);
          break;
        case 99://Sair
          entrada.close();
          System.exit(0);
          break;

        default://Opção não reconhecida.(executa default)
          System.out.println("Opção não identificada");
          break;
      }
    }
  }
}
