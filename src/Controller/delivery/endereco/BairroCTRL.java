package Controller.delivery.endereco;

import java.util.List;

import DTOs.delivery.endereco.BairroDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.delivery.endereco.Bairro;
import Modelos.delivery.endereco.BairroDAOImpl;

public class BairroCTRL extends ControllerInterface {
    
    @Override
    public void criar(InterfaceDTO bairroDTO) throws Exception {
        BairroDTO dto = (BairroDTO) bairroDTO;
        if (dto.id != null) {
            this.atualizar(bairroDTO);
            return;
        }
        new BairroDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO bairroDTO) throws Exception {
        Bairro bairro = new BairroDAOImpl().ler(((BairroDTO) bairroDTO).id);
        return (InterfaceDTO) new BairroDTO(bairro.getId(), bairro.getNome());
    }
    
    @Override
    public Object[][] listar() throws Exception {
        List<Bairro> bairros = new BairroDAOImpl().listar();
        
        Object[][] data = new Object[bairros.size()][2];
        for (int i = 0; i < bairros.size(); i++) {
            Bairro b = bairros.get(i);
            data[i][0] = b.getId();
            data[i][1] = b.getNome();
        }
        
        return data;

    }
    
    @Override
    public String[] titulos(){
        return new String[]{"Id", "Nome"};
    }    

    @Override
    public void atualizar(InterfaceDTO bairroDTO) throws Exception {
        new BairroDAOImpl().atualizar(((BairroDTO) bairroDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO bairroDTO) throws Exception {
        new BairroDAOImpl().deletar(((BairroDTO) bairroDTO).id);
    }
}
