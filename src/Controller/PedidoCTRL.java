package Controller;

import DTOs.PedidoDTO;
import Modelos.Pedido;
import Modelos.PedidoDAO;
import Modelos.PedidoDAOImpl;

public class PedidoCTRL {
    public void criar(PedidoDTO pedidoDTO) throws Exception {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.criar(pedidoDTO.builder());
    }

    public Pedido ler(int id) throws Exception {
        PedidoDAO dao = new PedidoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(PedidoDTO pedidoDTO) throws Exception {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.atualizar(pedidoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.deletar(id);
    }
}
