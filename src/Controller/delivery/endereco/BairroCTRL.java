package Controller.delivery.endereco;

import DTOs.delivery.endereco.BairroDTO;
import Modelos.delivery.endereco.Bairro;
import Modelos.delivery.endereco.BairroDAO;
import Modelos.delivery.endereco.BairroDAOImpl;

public class BairroCTRL {
    public void criar(BairroDTO bairroDTO) throws Exception {
        BairroDAO dao = new BairroDAOImpl();
        dao.criar(bairroDTO.builder());
    }

    public Bairro ler(int id) throws Exception {
        BairroDAO dao = new BairroDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(BairroDTO bairroDTO) throws Exception {
        BairroDAO dao = new BairroDAOImpl();
        dao.atualizar(bairroDTO.builder());
    }

    public void deletar(int id) throws Exception {
        BairroDAO dao = new BairroDAOImpl();
        dao.deletar(id);
    }
}
