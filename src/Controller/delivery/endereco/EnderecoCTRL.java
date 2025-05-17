package Controller.delivery.endereco;

import DTOs.delivery.endereco.EnderecoDTO;
import Modelos.delivery.endereco.Endereco;
import Modelos.delivery.endereco.EnderecoDAO;
import Modelos.delivery.endereco.EnderecoDAOImpl;

public class EnderecoCTRL {
    public void criar(EnderecoDTO enderecoDTO) throws Exception {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.criar(enderecoDTO.builder());
    }

    public Endereco ler(int id) throws Exception {
        EnderecoDAO dao = new EnderecoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(EnderecoDTO enderecoDTO) throws Exception {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.atualizar(enderecoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.deletar(id);
    }
}
