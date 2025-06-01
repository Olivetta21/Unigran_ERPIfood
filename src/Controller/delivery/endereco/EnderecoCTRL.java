package Controller.delivery.endereco;

import DTOs.delivery.endereco.EnderecoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.delivery.endereco.Endereco;
import Modelos.delivery.endereco.EnderecoDAOImpl;
import java.util.List;

public class EnderecoCTRL extends ControllerInterface{

    @Override
    public void criar(InterfaceDTO enderecoDTO) throws Exception {
        EnderecoDTO dto = (EnderecoDTO) enderecoDTO;
        if (dto.id != null) {
            this.atualizar(enderecoDTO);
            return;
        }        
        new EnderecoDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO enderecoDTO) throws Exception {
        Endereco ender = new EnderecoDAOImpl().ler(((EnderecoDTO) enderecoDTO).id);
        return new EnderecoDTO(ender.getId(), ender.getCep(), ender.getBairro(), ender.getComplemento(), ender.getRua(), ender.getNumero());
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Endereco> enderecos = new EnderecoDAOImpl().listar();
        
        Object[][] data = new Object[enderecos.size()][7];
        
        for (int i = 0; i < enderecos.size(); i++) {
            Endereco ender = enderecos.get(i);
            data[i][0] = ender.getId();
            data[i][1] = ender.getCep();
            data[i][2] = ender.getBairro().getId();
            data[i][3] = ender.getBairro().getNome();
            data[i][4] = ender.getComplemento();
            data[i][5] = ender.getRua();
            data[i][6] = ender.getNumero();
        }
        
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"ID", "CEP", "Bairro ID", "Bairro Nome", "Complemento", "Rua", "Número"};
    }

    @Override
    public void atualizar(InterfaceDTO enderecoDTO) throws Exception {
        new EnderecoDAOImpl().atualizar(((EnderecoDTO) enderecoDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO enderecoDTO) throws Exception {
        new EnderecoDAOImpl().deletar(((EnderecoDTO) enderecoDTO).id);
    }
}
