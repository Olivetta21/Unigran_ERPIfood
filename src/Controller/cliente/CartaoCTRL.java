package Controller.cliente;

import DTOs.cliente.CartaoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.cliente.Cartao;
import Modelos.cliente.CartaoDAO;
import Modelos.cliente.CartaoDAOImpl;
import java.util.List;

public class CartaoCTRL extends ControllerInterface{

    @Override
    public void criar(InterfaceDTO cartaoDTO) throws Exception {
        CartaoDTO dto = (CartaoDTO) cartaoDTO;
        if (dto.id != null) {
            this.atualizar(cartaoDTO);
            return;
        }
        new CartaoDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO cartaoDTO) throws Exception {
        Cartao cartao = new CartaoDAOImpl().ler(((CartaoDTO) cartaoDTO).id);
        return new CartaoDTO(cartao.getId(), cartao.getNumero(), cartao.getCVV(), cartao.isCredito(), cartao.getCliente());
    }

    @Override
    public Object[][] listar() throws Exception {
        CartaoDAO cartaoDAO = new CartaoDAOImpl();
        List<Cartao> cartoes = cartaoDAO.listar();

        Object[][] data = new Object[cartoes.size()][5];

        for (int i = 0; i < cartoes.size(); i++) {
            Cartao cartao = cartoes.get(i);
            data[i][0] = cartao.getId();
            data[i][1] = cartao.getNumero();
            data[i][2] = cartao.getCVV();
            data[i][3] = cartao.isCredito() ? "Crédito" : "Débito";
            data[i][4] = cartao.getCliente().getNome();
        }

        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"Id", "Número", "CVV", "Tipo", "Cliente"};
    }

    @Override
    public void atualizar(InterfaceDTO cartaoDTO) throws Exception {
        new CartaoDAOImpl().atualizar(((CartaoDTO) cartaoDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO cartaoDTO) throws Exception {
        new CartaoDAOImpl().deletar(((CartaoDTO) cartaoDTO).id);
    }
}
