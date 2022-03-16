import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cria uma fila de contatos baseando-se no formato de uma lista encadeada
 * permitindo aos usuários que possam inserir contatos e ir para o próximo
 * contato permitindo que a empresa de call center possa contatar os seus
 * clientes
 * 
 * FilaContatoClientes
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class FilaContatoClientes {
    private Contato inicio, fim;
    private int filaTamanho;

    /**
     * Definindo os atributos de um contato usando o formato de uma lista encadeada
     */
    private class Contato {
        String nome;
        String numeroCelular;
        String numeroTelefoneCasa;
        String numeroTelefoneTrabalho;
        Contato proximo;
    }

    /**
     * Definindo os valores iniciais da fila de contatos
     */
    public FilaContatoClientes() {
        this.inicio = null;
        this.fim = null;
        this.filaTamanho = 0;
    }

    /**
     * Adicionando os valores do nome e dos números de telefones residencial, de
     * trabalho e do celular ao contato
     *
     * @param nome                   nome do contato
     * @param numeroTelefoneCasa     telefone residencial (se houver)
     * @param numeroCelular          telefone celular (mais comum de ocorrer)
     * @param numeroTelefoneTrabalho telefone do trabalho em caso dos outros
     *                               estiverem nulos
     */
    public void adicionarContato(String nome, String numeroTelefoneCasa, String numeroCelular,
            String numeroTelefoneTrabalho) {
        Contato velhoContato = this.fim;
        this.fim = new Contato();
        this.fim.nome = nome;
        this.fim.numeroTelefoneCasa = numeroTelefoneCasa;
        this.fim.numeroCelular = numeroCelular;
        this.fim.numeroTelefoneTrabalho = numeroTelefoneTrabalho;

        if (this.filaTamanho == 0)
            this.inicio = this.fim;
        else
            velhoContato.proximo = this.fim;

        this.filaTamanho++;
        return;
    }

    /**
     * Lista todos os contatos usando o conceito de interação de uma lista encadeada
     * se e somente se a lista não estiver nula
     */
    public void listarContato() {
        if (this.inicio == null) {
            System.out.println("Lista vazia");
            return;
        }

        Contato atualContato = this.inicio;
        int quantidadeContatos = 1;

        System.out.println("Lista de contatos");

        while (atualContato != null) {
            System.out.println("Contato nº" + quantidadeContatos);
            System.out.println("Nome: " + atualContato.nome);
            System.out.println("Número do telefone residencial: " + atualContato.numeroTelefoneCasa);
            System.out.println("Número de celular: " + atualContato.numeroCelular);
            System.out.println("Número de telefone do trabalho: " + atualContato.numeroTelefoneTrabalho);
            System.out.print("\n");
            atualContato = atualContato.proximo;
            quantidadeContatos++;
        }
    }

    /**
     * Verifica se a fila está vazia, interropendo caso sim. Caso tenha valores, vai
     * ao próximo, indica que a fila diminuiu seu tamanho
     */
    public boolean removerContato() {
        if (this.inicio == this.fim)
            return false;

        this.inicio = this.inicio.proximo;

        filaTamanho--;
        return true;
    }

    /**
     * Verifica se o número digitado está formatado conforme os modelos: (XX)
     * XXXXX-XXXX e (XX) XXXX-XXXX
     * 
     * @param numeroTelefone numero de telefone (celular, residencial ou do
     *                       trabalho) a ser verificado
     * @return boolean status da verificação
     */
    public boolean autenticarNumeroTelefone(String numeroTelefone) {
        String pattern = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(numeroTelefone);
        return match.matches();
    }

    /** Imprime o próximo contato após o primeiro ser removido. */
    public void proximoContato() {
        System.out.println("Nome: " + this.inicio.nome);
        System.out.println("Número de telefone residencial: " + this.inicio.numeroTelefoneCasa);
        System.out.println("Número de telefone do trabalho: " + this.inicio.numeroTelefoneTrabalho);
        System.out.println("Número do celular: " + this.inicio.numeroCelular);
    }
}