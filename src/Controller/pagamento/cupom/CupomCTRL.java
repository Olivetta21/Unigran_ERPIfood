package Controller.pagamento.cupom;

import java.util.List;

import DTOs.pagamento.cupom.CupomDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.pagamento.cupom.Cupom;
import Modelos.pagamento.cupom.CupomDAOImpl;

public class CupomCTRL extends ControllerInterface{
    @Override
    public void criar(InterfaceDTO cupomDTO) throws Exception {
        CupomDTO dto = (CupomDTO) cupomDTO;
        if (dto.id != null) {
            this.atualizar(cupomDTO);
            return;
        }
        new CupomDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO cupomDTO) throws Exception {
        Cupom cupom = new CupomDAOImpl().ler(((CupomDTO) cupomDTO).id);
        return new CupomDTO(
            cupom.getId(),
            cupom.getValor(),
            cupom.getCodigo(),
            cupom.getValidade(),
            cupom.getPagamento()
        );
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Cupom> cupons = new CupomDAOImpl().listar();
        Object[][] data = new Object[cupons.size()][5];
        for (int i = 0; i < cupons.size(); i++) {
            Cupom cupom = cupons.get(i);
            data[i][0] = cupom.getId();
            data[i][1] = cupom.getValor();
            data[i][2] = cupom.getCodigo();
            data[i][3] = cupom.getValidade();
            data[i][4] = cupom.getPagamento() != null ? cupom.getPagamento().getId() : null;
        }
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"ID", "Valor", "Código", "Validade", "Pagamento ID"};
    }

    @Override
    public void atualizar(InterfaceDTO cupomDTO) throws Exception {
        new CupomDAOImpl().atualizar(((CupomDTO) cupomDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO cupomDTO) throws Exception {
        new CupomDAOImpl().deletar(((CupomDTO) cupomDTO).id);
    }
}
