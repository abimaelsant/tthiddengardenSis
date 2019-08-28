package produtoDao;

import produto.Produto;
import java.util.Collection;

public interface ProdutoInterface<T> {
    void insere(Produto produto);
    void edita(Produto produto);
    void deleta(Produto produto);
    Collection<?> lista();
    T buscaProduto(int id);
}
