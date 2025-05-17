package Controller.pagamento;

import DTOs.pagamento.PagamentoDTO;
import Modelos.pagamento.Pagamento;
import Modelos.pagamento.PagamentoDAO;
import Modelos.pagamento.PagamentoDAOImpl;

public class PagamentoCTRL {
    public void criar(PagamentoDTO pagamentoDTO) throws Exception {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.criar(pagamentoDTO.builder());
    }

    public Pagamento ler(int id) throws Exception {
        PagamentoDAO dao = new PagamentoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(PagamentoDTO pagamentoDTO) throws Exception {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.atualizar(pagamentoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.deletar(id);
    }
}
