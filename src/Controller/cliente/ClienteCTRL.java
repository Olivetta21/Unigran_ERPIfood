package Controller.cliente;

import DTOs.cliente.ClienteDTO;
import Modelos.cliente.Cliente;
import Modelos.cliente.ClienteDAO;
import Modelos.cliente.ClienteDAOImpl;

public class ClienteCTRL {
    public void criar(ClienteDTO clienteDTO) throws Exception {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.criar(clienteDTO.builder());
    }

    public Cliente ler(int id) throws Exception {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(ClienteDTO clienteDTO) throws Exception {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.atualizar(clienteDTO.builder());
    }

    public void deletar(int id) throws Exception {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.deletar(id);
    }
}
