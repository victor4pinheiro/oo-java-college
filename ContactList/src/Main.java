import java.util.Scanner;

/**
 * Permite que o usuário interaja, via linha de comando, com o programa,
 * permitindo adicionar contatos, verificar o próximo contato e sair do programa
 * 
 * Main
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class Main {
    public static void main(String[] args) {
        FilaContatoClientes contatoCallCenter = new FilaContatoClientes();
        /** Declaração da classe Scanner para entrada de dados */
        Scanner ler = new Scanner(System.in);
        /** Estrutura de repetição while contendo as opções */
        while (true) {
            System.out.println("Selecione as seguintes opções");
            System.out.println("[1] - |Adicionar contato|");
            System.out.println("[2] - |Próximo contato|");
            System.out.println("[3] - |Listar contatos|");
            System.out.println("[4] - |Sair do programa|");
            int option = ler.nextInt();

            /** Estrutura de condição para o usuário efetuar a opção escolhida, ou sair. */
            switch (option) {
                case 1: // Adicionar contato
                    String nome, numeroTelefoneCasa, numeroCelular, numeroTelefoneTrabalho = null;
                    System.out.println("|Adicionar Contato|");
                    System.out.println("Nome do contato:");
                    ler.nextLine(); // consumir sobras de linha

                    nome = ler.nextLine();
                    do {
                        System.out.println(
                                "Numero de telefone residencial.\n"
                                        + "(Ex.: (99) XXXX-XXXX ou (99) 9XXXX-XXXX):\n"
                                        + "Caso não exista, deixe nulo.");
                        numeroTelefoneCasa = ler.nextLine();
                    } while (!Contato.autenticarNumeroTelefone(numeroTelefoneCasa)
                            || numeroTelefoneCasa == null);

                    do {
                        System.out.println(
                                "Numero de celular.\n"
                                        + "(Ex.: (99) XXXX-XXXX ou (99) 9XXXX-XXXX):\n"
                                        + "Caso não exista, deixe nulo.");
                        numeroCelular = ler.nextLine();
                    } while (!Contato.autenticarNumeroTelefone(numeroCelular)
                            || numeroCelular == null);

                    do {
                        System.out.println(
                                "Numero de telefone de trabalho.\n"
                                        + "(Ex.: (99) XXXX-XXXX ou (99) 9XXXX-XXXX):\n"
                                        + "Caso não exista, deixe nulo.");
                        numeroTelefoneTrabalho = ler.nextLine();
                    } while (!Contato.autenticarNumeroTelefone(numeroTelefoneTrabalho)
                            || numeroTelefoneTrabalho == null);

                    Contato contato = Contato.adicionarContatos(nome, numeroCelular, numeroTelefoneCasa,
                            numeroTelefoneTrabalho);
                    contatoCallCenter.adicionarContatos(contato);
                    break;

                case 2: // Próximo contato
                    Contato tmp = contatoCallCenter.proximoContato();
                    if (tmp == null) {
                        System.out.println("Fila vazia");
                    } else {
                        System.out.println("Nome: " + tmp.getNome());
                        System.out.println("Número de celular: " + tmp.getNumeroCelular());
                        System.out.println("Número de telefone residencial: " + tmp.getNumeroTelefoneCasa());
                        System.out.println("Número de telefone do trabalho: " + tmp.getNumeroTelefoneTrabalho());
                    }
                    break;

                case 3: // Listar contatos
                    System.out.println("Lista de contatos");
                    contatoCallCenter.listarContatos();
                    break;

                case 4: // Sair do programa
                    System.out.println("\n===Você encerrou a lista de contatos.===");
                    ler.close();
                    System.exit(0);
                    break;

                default: // Em caso de opção desconhecida, executa default
                    System.out.println(
                            "Opção não reconhecida. Favor selecionar uma das opções disponíveis");
                    break;
            }
        }
    }
}