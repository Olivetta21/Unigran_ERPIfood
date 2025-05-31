package Controller.carrinho.produto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTOs.carrinho.produto.ProdutoDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.carrinho.produto.Produto;
import Modelos.carrinho.produto.ProdutoDAOImpl;

public class ProdutoCTRL extends ControllerInterface {

    @Override
    public void criar(InterfaceDTO ProdutoDTO) throws Exception {
        ProdutoDTO dto = (ProdutoDTO) ProdutoDTO;
        if (dto.id != null) {
            this.atualizar(ProdutoDTO);
            return;
        }

        new ProdutoDAOImpl().criar(dto.builder());
        
        StringBuilder strb = new StringBuilder();
        strb.append("O produto ");
        strb.append(dto.nome);
        strb.append(" com valor: ");
        strb.append(dto.valor);
        strb.append(" foi cadastrado com sucesso!"); 
        JOptionPane.showMessageDialog(null, strb.toString(), "Cadastro de Produto", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO ProdutoDTO) throws Exception {
        Produto p = new ProdutoDAOImpl().ler(((ProdutoDTO)ProdutoDTO).id);
        ProdutoDTO dto = new ProdutoDTO(p.getId(), p.getNome(), p.getValor());
        return (InterfaceDTO) dto;
    }

    @Override
    public Object[][] listar() throws Exception {
        List<Produto> produtos = new ProdutoDAOImpl().listar();

        Object[][] data = new Object[produtos.size()][3];
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getNome();
            data[i][2] = p.getValor();
        }

        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"ID", "Nome", "Valor"};
    }

    @Override
    public void atualizar(InterfaceDTO ProdutoDTO) throws Exception {
        ProdutoDTO dto = (ProdutoDTO) ProdutoDTO;
        if (dto.nome == null || dto.valor == null) {
            JOptionPane.showMessageDialog(null, "Nome e valor do produto não podem ser nulos.", "Erro de Atualização", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new ProdutoDAOImpl().atualizar(dto.builder());

        StringBuilder strb = new StringBuilder();
        strb.append("O produto ");
        strb.append(dto.nome);
        strb.append(" com valor: ");
        strb.append(dto.valor);
        strb.append(" foi atualizado com sucesso!");
        JOptionPane.showMessageDialog(null, strb.toString(), "Atualização de Produto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void deletar(InterfaceDTO ProdutoDTO) throws Exception {
        ProdutoDTO dto = (ProdutoDTO) this.ler(ProdutoDTO);
        new ProdutoDAOImpl().deletar(dto.id);
        
        StringBuilder strb = new StringBuilder();
        strb.append("O produto ");
        strb.append(dto.nome);
        strb.append(" com valor: ");
        strb.append(dto.valor);
        strb.append(" foi deletado com sucesso!");
        JOptionPane.showMessageDialog(null, strb.toString(), "Deleção de Produto", JOptionPane.INFORMATION_MESSAGE);
    }
}
