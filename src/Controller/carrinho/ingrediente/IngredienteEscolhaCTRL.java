package Controller.carrinho.ingrediente;

import java.util.List;

import DTOs.carrinho.ingrediente.IngredienteEscolhaDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.carrinho.ingrediente.IngredienteEscolha;
import Modelos.carrinho.ingrediente.IngredienteEscolhaDAOImpl;

public class IngredienteEscolhaCTRL extends ControllerInterface {

    @Override
    public void criar(InterfaceDTO ingredienteEscolhaDTO) throws Exception {
        IngredienteEscolhaDTO dto = (IngredienteEscolhaDTO) ingredienteEscolhaDTO;
        if (dto.id != null) {
            this.atualizar(ingredienteEscolhaDTO);
            return;
        }

        new IngredienteEscolhaDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO ingredienteEscolhaDTO) throws Exception {
        IngredienteEscolha ingr = new IngredienteEscolhaDAOImpl().ler(((IngredienteEscolhaDTO) ingredienteEscolhaDTO).id);
        return new IngredienteEscolhaDTO(
            ingr.getId(),
            ingr.getIngrediente(),
            ingr.getCarrinho(),
            ingr.getToExclude()
        );
    }
    @Override
    public Object[][] listar() throws Exception {
        List<IngredienteEscolha> ingredientes = new IngredienteEscolhaDAOImpl().listar();

        Object[][] data = new Object[ingredientes.size()][6];
        for (int i = 0; i < ingredientes.size(); i++) {
            IngredienteEscolha ingr = ingredientes.get(i);
            data[i][0] = ingr.getId();
            data[i][1] = ingr.getIngrediente().getId();
            data[i][2] = ingr.getIngrediente().getNome();
            data[i][3] = ingr.getIngrediente().getValor();
            data[i][4] = ingr.getCarrinho().getId();
            data[i][5] = ingr.getToExclude() ? "Excluir" : "Adicionar";
        }
        return data;
    }
    
    @Override
    public String[] titulos() {
        return new String[]{"ID", "Ingrediente ID", "Ingrediente Nome", "Ingrediente Valor", "Carrinho ID", "Adic. ou Excl."};
    }

    @Override
    public void atualizar(InterfaceDTO ingredienteEscolhaDTO) throws Exception {
        new IngredienteEscolhaDAOImpl().atualizar(((IngredienteEscolhaDTO) ingredienteEscolhaDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO ingredienteEscolhaDTO) throws Exception {
        new IngredienteEscolhaDAOImpl().deletar(((IngredienteEscolhaDTO) ingredienteEscolhaDTO).id);
    }
}
