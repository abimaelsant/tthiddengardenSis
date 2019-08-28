package clienteDao;

import cliente.Cliente;
import java.util.Collection;

public interface ClienteInterface<T> {
    void insere(Cliente cliente);
    void edita(Cliente cliente);
    void deleta(Cliente cliente);
    Collection<?> lista();
    T buscaCliente(int id);
}
