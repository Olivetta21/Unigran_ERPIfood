package Controller.delivery;

import DTOs.delivery.EntregaDTO;
import Modelos.delivery.Entrega;
import Modelos.delivery.EntregaDAO;
import Modelos.delivery.EntregaDAOImpl;

public class EntregaCTRL {
    public void criar(EntregaDTO entregaDTO) throws Exception {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.criar(entregaDTO.builder());
    }

    public Entrega ler(int id) throws Exception {
        EntregaDAO dao = new EntregaDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(EntregaDTO entregaDTO) throws Exception {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.atualizar(entregaDTO.builder());
    }

    public void deletar(int id) throws Exception {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.deletar(id);
    }
}
