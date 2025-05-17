package Controller.cliente;

import DTOs.cliente.CartaoDTO;
import Modelos.cliente.Cartao;
import Modelos.cliente.CartaoDAO;
import Modelos.cliente.CartaoDAOImpl;

public class CartaoCTRL {
    public void criar(CartaoDTO cartaoDTO) throws Exception {
        CartaoDAO dao = new CartaoDAOImpl();
        dao.criar(cartaoDTO.builder());
    }

    public Cartao ler(int id) throws Exception {
        CartaoDAO dao = new CartaoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(CartaoDTO cartaoDTO) throws Exception {
        CartaoDAO dao = new CartaoDAOImpl();
        dao.atualizar(cartaoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        CartaoDAO dao = new CartaoDAOImpl();
        dao.deletar(id);
    }
}
