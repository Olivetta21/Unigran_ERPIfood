package Controller.contato;

import java.util.List;

import DTOs.contato.TelefoneDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.contato.Telefone;
import Modelos.contato.TelefoneDAOImpl;

public class TelefoneCTRL extends ControllerInterface {

    @Override
    public void criar(InterfaceDTO telefoneDTO) throws Exception {
        TelefoneDTO dto = (TelefoneDTO) telefoneDTO;
        if (dto.id != null) {
            this.atualizar(telefoneDTO);
            return;
        }
        new TelefoneDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO telefoneDTO) throws Exception {
        Telefone telefone = new TelefoneDAOImpl().ler(((TelefoneDTO) telefoneDTO).id);
        return new TelefoneDTO(telefone.getId(), telefone.getDdd(), telefone.getNumero());
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Telefone> telefones = new TelefoneDAOImpl().listar();

        Object[][] data = new Object[telefones.size()][3];

        for (int i = 0; i < telefones.size(); i++) {
            Telefone tel = telefones.get(i);
            data[i][0] = tel.getId();
            data[i][1] = tel.getDdd();
            data[i][2] = tel.getNumero();
        }

        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"Id", "DDD", "Número"};
    }

    @Override
    public void atualizar(InterfaceDTO telefoneDTO) throws Exception {
        new TelefoneDAOImpl().atualizar(((TelefoneDTO) telefoneDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO telefoneDTO) throws Exception {
        new TelefoneDAOImpl().deletar(((TelefoneDTO) telefoneDTO).id);
    }
}
