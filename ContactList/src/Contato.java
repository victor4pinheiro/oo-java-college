import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe para permitir a adição de contatos e autenticação dos números de
 * telefones
 * 
 * Contato
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class Contato {
    private String nome;
    private String numeroCelular;
    private String numeroTelefoneCasa;
    private String numeroTelefoneTrabalho;

    /**
     * Atribui os valores passados via parâmetro para os respectivos atributos
     * 
     * @param nome                   nome do contato a ser adicionado
     * @param numeroCelular          número do celular a ser adicionado
     * @param numeroTelefoneCasa     número do telefone residencial a ser adicionado
     * @param numeroTelefoneTrabalho número do telefone de trabalho a ser adicionado
     */
    public Contato(String nome, String numeroCelular, String numeroTelefoneCasa, String numeroTelefoneTrabalho) {
        this.nome = nome;
        this.numeroCelular = numeroCelular;
        this.numeroTelefoneCasa = numeroTelefoneCasa;
        this.numeroTelefoneTrabalho = numeroTelefoneTrabalho;
    }

    /**
     * Retorna o valor do nome para poder ser usado em outros contextos
     * 
     * @return nome do contato no atual objeto (no contexto do programa, na
     *         atual posição da fila)
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o valor do número de celular para poder ser usado em outros contextos
     * 
     * @return número de celular do contato no atual objeto (no contexto do
     *         programa, na atual posição da fila)
     */
    public String getNumeroCelular() {
        return numeroCelular;
    }

    /**
     * Retorna o valor do número de telefone residencial para poder ser usado em
     * outros contextos
     * 
     * @return número de telefone residencial do contato no atual objeto (no
     *         contexto do programa, na atual posição da fila)
     */
    public String getNumeroTelefoneCasa() {
        return numeroTelefoneCasa;
    }

    /**
     * Retorna o valor do número de telefone de trabalho para poder ser usado em
     * outros contextos
     * 
     * @return número de telefone de trabalho do contato no atual objeto (no
     *         contexto do programa, na atual posição da fila)
     */
    public String getNumeroTelefoneTrabalho() {
        return numeroTelefoneTrabalho;
    }

    /**
     * Adiciona os contatos passados via parâmetro por meio do construtor Contato()
     * 
     * @param nome                   nome do contato
     * @param numeroCelular          número de celular
     * @param numeroTelefoneCasa     número de telefone residencial
     * @param numeroTelefoneTrabalho número de telefone de trabalho
     * @return construtor do Contato() para atribuir os respectivos valores
     */
    public static Contato adicionarContatos(String nome, String numeroCelular, String numeroTelefoneCasa,
            String numeroTelefoneTrabalho) {
        return new Contato(nome, numeroCelular, numeroTelefoneCasa, numeroTelefoneTrabalho);
    }

    /**
     * Verifica se o valor passado via parâmetro corresponde a regex pré-definida
     * 
     * @param numeroTelefone número de telefone a ser verificado (ou seja, se é
     *                       válido)
     * @return verdadeiro caso o parâmetro corresponde, caso contrário, retorna
     *         falso
     */
    public static boolean autenticarNumeroTelefone(String numeroTelefone) {
        String pattern = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(numeroTelefone);
        return match.matches();
    }
}