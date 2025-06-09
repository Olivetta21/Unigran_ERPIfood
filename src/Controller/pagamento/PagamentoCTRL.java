package Controller.pagamento;

import java.util.List;

import DTOs.pagamento.PagamentoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.pagamento.Pagamento;
import Modelos.pagamento.PagamentoDAOImpl;

public class PagamentoCTRL extends ControllerInterface{
    @Override
    public void criar(InterfaceDTO pagamentoDTO) throws Exception {
        PagamentoDTO dto = (PagamentoDTO) pagamentoDTO;
        if (dto.id != null) {
            this.atualizar(pagamentoDTO);
            return;
        }
        new PagamentoDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO pagamentoDTO) throws Exception {
        Pagamento pagto = new PagamentoDAOImpl().ler(((PagamentoDTO) pagamentoDTO).id);
        return new PagamentoDTO(
            pagto.getId(),
            pagto.getPedido(),
            pagto.getPix(),
            pagto.getCartao(),
            pagto.getDinheiro()
        );
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Pagamento> pagamentos = new PagamentoDAOImpl().listar();
        Object[][] data = new Object[pagamentos.size()][5];
        for (int i = 0; i < pagamentos.size(); i++) {
            Pagamento pagto = pagamentos.get(i);
            data[i][0] = pagto.getId();
            data[i][1] = pagto.getPedido().getId();
            data[i][2] = pagto.getPix();
            data[i][3] = pagto.getCartao();
            data[i][4] = pagto.getDinheiro();
        }
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"ID", "Pedido ID", "Pix", "Cartão", "Dinheiro"};
    }

    @Override
    public void atualizar(InterfaceDTO pagamentoDTO) throws Exception {
        new PagamentoDAOImpl().atualizar(((PagamentoDTO) pagamentoDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO pagamentoDTO) throws Exception {
        new PagamentoDAOImpl().deletar(((PagamentoDTO) pagamentoDTO).id);
    }
}
