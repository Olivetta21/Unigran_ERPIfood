package Controller.cliente;

import java.util.List;

import DTOs.cliente.ClienteDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.cliente.Cliente;
import Modelos.cliente.ClienteDAO;
import Modelos.cliente.ClienteDAOImpl;

public class ClienteCTRL extends ControllerInterface {

    @Override
    public void criar(InterfaceDTO clienteDTO) throws Exception {
        ClienteDTO dto = (ClienteDTO) clienteDTO;
        if (dto.id != null) {
            this.atualizar(clienteDTO);
            return;
        }
        new ClienteDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO clienteDTO) throws Exception {
        Cliente cliente = new ClienteDAOImpl().ler(((ClienteDTO) clienteDTO).id);
        return (InterfaceDTO) new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getTelefone());
    }

    @Override
    public Object[][] listar() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        List<Cliente> clientes = clienteDAO.listar();

        Object[][] data = new Object[clientes.size()][3];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cli = clientes.get(i);
            data[i][0] = cli.getId();
            data[i][1] = cli.getNome();
            data[i][2] = cli.getTelefone().getDdd() + " " + cli.getTelefone().getNumero();
        }

        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"Id", "Nome", "Telefone"};
    }

    @Override
    public void atualizar(InterfaceDTO clienteDTO) throws Exception {
        new ClienteDAOImpl().atualizar(((ClienteDTO) clienteDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO clienteDTO) throws Exception {
        new ClienteDAOImpl().deletar(((ClienteDTO) clienteDTO).id);
    }
}
