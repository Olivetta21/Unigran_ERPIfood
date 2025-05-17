package Controller.carrinho.produto;

import DTOs.carrinho.produto.ProdutoDTO;
import Modelos.carrinho.produto.Produto;
import Modelos.carrinho.produto.ProdutoDAO;
import Modelos.carrinho.produto.ProdutoDAOImpl;

public class ProdutoCTRL {
    public void criar(ProdutoDTO ProdutoDTO) throws Exception {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.criar(ProdutoDTO.builder());
    }

    public Produto ler(int id) throws Exception {
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(ProdutoDTO ProdutoDTO) throws Exception {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.atualizar(ProdutoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.deletar(id);
    }
}
