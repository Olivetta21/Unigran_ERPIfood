package Controller;

import java.util.List;

import DTOs.StatusPedidoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.StatusPedido;
import Modelos.StatusPedidoDAOImpl;

public class StatusPedidoCTRL extends ControllerInterface {
    
    @Override
    public void criar(InterfaceDTO statusPedidoDTO) throws Exception {
        StatusPedidoDTO dto = (StatusPedidoDTO) statusPedidoDTO;
        if (dto.id != null) {
            this.atualizar(statusPedidoDTO);
            return;
        }
        new StatusPedidoDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO statusPedidoDTO) throws Exception {
        StatusPedido stP = new StatusPedidoDAOImpl().ler(((StatusPedidoDTO)statusPedidoDTO).id);
        return (InterfaceDTO) new StatusPedidoDTO(stP.getId(), stP.getProgresso());    
    }
    
    @Override
    public Object[][] listar() throws Exception {
        List<StatusPedido> statusPedidos = new StatusPedidoDAOImpl().listar();
        
        Object[][] data = new Object[statusPedidos.size()][2];
        
        for (int i = 0; i < statusPedidos.size(); i++) {
            StatusPedido stP = statusPedidos.get(i);
            data[i][0] = stP.getId();
            data[i][1] = stP.getProgresso();
        }
        
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"Id", "Progresso"};
    }
    
    @Override
    public void atualizar(InterfaceDTO statusPedidoDTO) throws Exception {
        new StatusPedidoDAOImpl().atualizar(((StatusPedidoDTO)statusPedidoDTO).builder());
    }

    public void deletar(InterfaceDTO statusPedidoDTO) throws Exception {
        new StatusPedidoDAOImpl().deletar(((StatusPedidoDTO)statusPedidoDTO).id);
    }
}
