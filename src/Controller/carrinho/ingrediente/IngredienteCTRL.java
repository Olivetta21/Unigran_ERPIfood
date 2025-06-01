package Controller.carrinho.ingrediente;

import DTOs.carrinho.ingrediente.IngredienteDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.carrinho.ingrediente.Ingrediente;
import Modelos.carrinho.ingrediente.IngredienteDAOImpl;
import java.util.List;

public class IngredienteCTRL extends ControllerInterface{
    @Override
    public void criar (InterfaceDTO ingredienteDTO) throws Exception {
        IngredienteDTO dto = (IngredienteDTO) ingredienteDTO;
        if (dto.id != null) {
            this.atualizar(ingredienteDTO);
            return;
        }
        new IngredienteDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler (InterfaceDTO ingredienteDTO) throws Exception {
        Ingrediente ingrediente = new IngredienteDAOImpl().ler(((IngredienteDTO)ingredienteDTO).id);
        return (InterfaceDTO) new IngredienteDTO(ingrediente.getId(), ingrediente.getNome(), ingrediente.getValor());
    }
    
    @Override
    public Object[][] listar() throws Exception {
        List<Ingrediente> ingredientes = new IngredienteDAOImpl().listar();
        
        Object[][] data = new Object[ingredientes.size()][3];
        
        for (int i = 0; i < ingredientes.size(); i++){
            Ingrediente ingr = ingredientes.get(i);
            data[i][0] = ingr.getId();
            data[i][1] = ingr.getNome();
            data[i][2] = ingr.getValor();
        }
        
        return data;
    }
    
    @Override
    public String[] titulos() {
        return new String[]{"Id", "Nome", "Valor"};
    }

    @Override
    public void atualizar (InterfaceDTO ingredienteDTO) throws Exception {
        new IngredienteDAOImpl().atualizar(((IngredienteDTO)ingredienteDTO).builder());
    }

    @Override
    public void deletar (InterfaceDTO ingredienteDTO) throws Exception {
        new IngredienteDAOImpl().deletar(((IngredienteDTO) ingredienteDTO).id);
    }
}
