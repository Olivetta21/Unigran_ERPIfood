package Controller.pagamento.cupom;

import DTOs.pagamento.cupom.CupomDTO;
import Modelos.pagamento.cupom.Cupom;
import Modelos.pagamento.cupom.CupomDAO;
import Modelos.pagamento.cupom.CupomDAOImpl;

public class CupomCTRL {
    public void criar(CupomDTO cupomDTO) throws Exception {
        CupomDAO dao = new CupomDAOImpl();
        dao.criar(cupomDTO.builder());
    }

    public Cupom ler(int id) throws Exception {
        CupomDAO dao = new CupomDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(CupomDTO cupomDTO) throws Exception {
        CupomDAO dao = new CupomDAOImpl();
        dao.atualizar(cupomDTO.builder());
    }

    public void deletar(int id) throws Exception {
        CupomDAO dao = new CupomDAOImpl();
        dao.deletar(id);
    }
}
