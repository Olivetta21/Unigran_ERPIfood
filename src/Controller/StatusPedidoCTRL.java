package Controller;

import DTOs.StatusPedidoDTO;
import Modelos.StatusPedido;
import Modelos.StatusPedidoDAO;
import Modelos.StatusPedidoDAOImpl;

public class StatusPedidoCTRL {
    public void criar(StatusPedidoDTO statusPedidoDTO) throws Exception {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.criar(statusPedidoDTO.builder());
    }

    public StatusPedido ler(int id) throws Exception {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(StatusPedidoDTO statusPedidoDTO) throws Exception {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.atualizar(statusPedidoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.deletar(id);
    }
}
