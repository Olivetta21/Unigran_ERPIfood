package Controller.contato;

import DTOs.contato.TelefoneDTO;
import Modelos.contato.Telefone;
import Modelos.contato.TelefoneDAO;
import Modelos.contato.TelefoneDAOImpl;

public class TelefoneCTRL {
    public void criar(TelefoneDTO telefoneDTO) throws Exception {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.criar(telefoneDTO.builder());
    }

    public Telefone ler(int id) throws Exception {
        TelefoneDAO dao = new TelefoneDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(TelefoneDTO telefoneDTO) throws Exception {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.atualizar(telefoneDTO.builder());
    }

    public void deletar(int id) throws Exception {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.deletar(id);
    }
}
