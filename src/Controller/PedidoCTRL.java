package Controller;

import java.util.List;

import DTOs.PedidoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.Pedido;
import Modelos.PedidoDAO;
import Modelos.PedidoDAOImpl;

public class PedidoCTRL extends ControllerInterface{

    @Override
    public void criar(InterfaceDTO pedidoDTO) throws Exception {
        PedidoDTO dto = (PedidoDTO) pedidoDTO;
        if (dto.id != null) {
            this.atualizar(pedidoDTO);
            return;
        } 
        new PedidoDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO pedidoDTO) throws Exception {
        Pedido pedido = new PedidoDAOImpl().ler(((PedidoDTO) pedidoDTO).id);
        return new PedidoDTO(pedido.getId(), pedido.getCliente(), pedido.getData_pedido(), 
                             pedido.getStatus(), pedido.getEntrega(), pedido.getReembolso());
    }

    @Override
    public Object[][] listar() throws Exception {
        PedidoDAO pedidoDAO = new PedidoDAOImpl();
        List<Pedido> pedidos = pedidoDAO.listar();
        
        Object[][] data = new Object[pedidos.size()][6];
        
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getCliente().getNome();
            data[i][2] = p.getData_pedido();
            data[i][3] = p.getStatus().getProgresso();
            String endereco = 
                            p.getEntrega().getEndereco().getBairro().getNome() + " - " +
                            p.getEntrega().getEndereco().getRua() + " " +
                            p.getEntrega().getEndereco().getNumero() + " " +
                            p.getEntrega().getEndereco().getComplemento();
            data[i][4] = endereco;
            data[i][5] = p.getReembolso();
        }
        
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[] {"ID", "Cliente", "Data do Pedido", "Status", "Entrega", "Reembolso"};
    }

    @Override
    public void atualizar(InterfaceDTO pedidoDTO) throws Exception {
        new PedidoDAOImpl().atualizar(((PedidoDTO) pedidoDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO pedidoDTO) throws Exception {
        new PedidoDAOImpl().deletar(((PedidoDTO) pedidoDTO).id);
    }
}
