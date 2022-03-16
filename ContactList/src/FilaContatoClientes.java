import java.util.LinkedList;
import java.util.Queue;

/**
 * Cria uma fila do tipo Contato e permite que o sistema possa adicionar
 * e listar contatos, além de ir para o próximo contato da fila
 * 
 * FilaContatoClientes
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 * 
 */
public class FilaContatoClientes {
    Queue<Contato> contatos = new LinkedList<Contato>();

    /**
     * Adiciona o contato para a fila
     * 
     * @param contato contato do tipo <Contato> a ser adicionado a fila
     * @return status de sucesso para a adição do contato, caso contrário, retorna
     *         falso
     */
    public boolean adicionarContatos(Contato contato) {
        return this.contatos.add(contato);
    }

    /**
     * Remove o primeiro contato e define que o novo contato é que estava na segunda
     * posição da fila para permitir que se possa mostrar o próximo contato
     * 
     * @return se for nulo, retorna nulo, caso contrário, retorna o atual contato
     *         que está no início da fila (ou seja, o próximo contato do antigo
     *         início)
     */
    public Contato proximoContato() {
        if (this.contatos.poll() == null)
            return null;
        if (this.contatos.size() == 0)
            return null;
        return this.contatos.element();
    }

    /**
     * Lista todos os contatos da fila se e somente se a fila não estiver vazia
     */
    public void listarContatos() {
        if (this.contatos.size() == 0) {
            System.out.println("Fila vazia");
            return;
        }

        for (Contato contato : this.contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Número de celular: " + contato.getNumeroCelular());
            System.out.println("Número de telefone residencial: " + contato.getNumeroTelefoneCasa());
            System.out.println("Número de telefone do trabalho: " + contato.getNumeroTelefoneTrabalho());
            System.out.println();
        }
    }
}