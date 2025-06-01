package Controller.delivery;

import DTOs.delivery.EntregaDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.delivery.Entrega;
import Modelos.delivery.EntregaDAOImpl;
import java.util.List;

public class EntregaCTRL extends ControllerInterface{

    @Override
    public void criar(InterfaceDTO entregaDTO) throws Exception {
        EntregaDTO dto = (EntregaDTO) entregaDTO;
        if (dto.id != null) {
            this.atualizar(entregaDTO);
            return;
        }
        new EntregaDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO entregaDTO) throws Exception {
        Entrega entr = new EntregaDAOImpl().ler(((EntregaDTO) entregaDTO).id);
        return new EntregaDTO(entr.getId(), entr.getChave(), entr.getEndereco(), entr.getValor());
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Entrega> entregas = new EntregaDAOImpl().listar();
        
        Object[][] data = new Object[entregas.size()][8];
        
        for (int i = 0; i < entregas.size(); i++) {
            Entrega entr = entregas.get(i);
            data[i][0] = entr.getId();
            data[i][1] = entr.getChave();
            data[i][2] = entr.getEndereco().getCep();
            data[i][3] = entr.getEndereco().getBairro().getNome();
            data[i][4] = entr.getEndereco().getComplemento();
            data[i][5] = entr.getEndereco().getRua();
            data[i][6] = entr.getEndereco().getNumero();
            data[i][7] = entr.getValor();
        }
        
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"ID", "Chave", "CEP", "Bairro", "Complemento", "Rua", "Número", "Valor"};
    }

    @Override
    public void atualizar(InterfaceDTO entregaDTO) throws Exception {
        new EntregaDAOImpl().atualizar(((EntregaDTO) entregaDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO entregaDTO) throws Exception {
        new EntregaDAOImpl().deletar(((EntregaDTO) entregaDTO).id);
    }
}
