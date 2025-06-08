package Controller.carrinho;

import java.util.List;

import DTOs.carrinho.CarrinhoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.carrinho.CarrinhoDAOImpl;
import Modelos.carrinho.Carrinho;

public class CarrinhoCTRL extends ControllerInterface {

    @Override
    public void criar(InterfaceDTO carrinhoDTO) throws Exception {
        CarrinhoDTO dto = (CarrinhoDTO) carrinhoDTO;
        if (dto.id != null) {
            this.atualizar(carrinhoDTO);
            return;
        }

        new CarrinhoDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO carrinhoDTO) throws Exception {
        Carrinho dao = new CarrinhoDAOImpl().ler(((CarrinhoDTO) carrinhoDTO).id);
        return new CarrinhoDTO(
            dao.getId(),
            dao.getProduto(),
            dao.getPedido(),
            dao.getQuantidade()
        );
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Carrinho> carrinhos = new CarrinhoDAOImpl().listar();
        Object[][] data = new Object[carrinhos.size()][6];
        for (int i = 0; i < carrinhos.size(); i++) {
            Carrinho c = carrinhos.get(i);
            data[i][0] = c.getId();
            data[i][1] = c.getPedido().getId();
            data[i][2] = c.getProduto().getId();
            data[i][3] = c.getProduto().getNome();
            data[i][4] = c.getProduto().getValor();
            data[i][5] = c.getQuantidade();
        }
        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"ID", "Pedido ID", "Produto ID", "Produto Nome", "Produto Valor", "Quantidade"};
    }

    @Override
    public void atualizar(InterfaceDTO carrinhoDTO) throws Exception {
        new CarrinhoDAOImpl().atualizar(((CarrinhoDTO) carrinhoDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO carrinhoDTO) throws Exception {
        new CarrinhoDAOImpl().deletar(((CarrinhoDTO) carrinhoDTO).id);
    }
}
