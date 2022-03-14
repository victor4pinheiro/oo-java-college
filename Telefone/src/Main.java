import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        FilaContatoClientes contatoCallCenter = new FilaContatoClientes();
        /** Declaração da classe Scanner para entrada de dados */
        Scanner ler = new Scanner(System.in);
        /** estrutura de repetição while contendo as opções */
        while (true) {
            System.out.println("Selecione as seguintes opções");
            System.out.println("[1] - |Adicionar contato|");
            System.out.println("[2] - |Próximo contato|");
            System.out.println("[3] - |Sair do programa|");
            int option = ler.nextInt();

            /** Estrutura de condição para o usuário efetuar a opção escolhida, ou sair. */
            switch (option) {
                case 1:
                    System.out.println("|Adicionar Contato|");
                    System.out.println("Nome do contato:");
                    String nome = ler.nextLine();
                    String numeroTelefoneCasa, numeroCelular, numeroTelefoneTrabalho = null;

                    ler.nextLine();
                    do {
                        System.out.println(
                                "Numero de telefone residencial (Ex: (61) xxxx-xxxx):");
                        numeroTelefoneCasa = ler.nextLine();
                    } while (!contatoCallCenter.autenticarNumeroTelefone(numeroTelefoneCasa));

                    do {
                        System.out.println(
                                "Numero de celular (Ex: (61) xxxxx-xxxx):");
                        numeroCelular = ler.nextLine();
                    } while (!contatoCallCenter.autenticarNumeroTelefone(numeroCelular));

                    do {
                        System.out.println(
                                "Numero de telefone de trabalho (Ex: (61) xxxxx-xxxx):");
                        numeroTelefoneTrabalho = ler.nextLine();
                    } while (!contatoCallCenter.autenticarNumeroTelefone(numeroTelefoneTrabalho));

                    contatoCallCenter.adicionarContato(nome, numeroTelefoneCasa, numeroCelular, numeroTelefoneTrabalho);
                    break;
                case 2:
                    if (!contatoCallCenter.removerContato()) {
                        System.out.println("\n===Fila vazia===\n");
                    } else {
                        System.out.println("Próximo Contato:");
                        contatoCallCenter.proximoContato();
                    }
                    break;

                case 3:
                    System.out.println("\n===Você encerrou a lista de contatos.===");
                    System.exit(0);
                    break;

                default:
                    System.out.println(
                            "Opção não reconhecida. Favor selecionar uma das opções disponíveis");
                    break;
            }
        }
    }
}