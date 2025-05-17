package Controller.carrinho.ingrediente;

import DTOs.carrinho.ingrediente.IngredienteDTO;
import Modelos.carrinho.ingrediente.Ingrediente;
import Modelos.carrinho.ingrediente.IngredienteDAO;
import Modelos.carrinho.ingrediente.IngredienteDAOImpl;

public class IngredienteCTRL {
    public void criar (IngredienteDTO ingredienteDTO) throws Exception {
        IngredienteDAO dao = new IngredienteDAOImpl();
        dao.criar(ingredienteDTO.builder());
    }

    public Ingrediente ler (int id) throws Exception {
        IngredienteDAO dao = new IngredienteDAOImpl();
        return dao.ler(id);
    }

    public void atualizar (IngredienteDTO ingredienteDTO) throws Exception {
        IngredienteDAO dao = new IngredienteDAOImpl();
        dao.atualizar(ingredienteDTO.builder());
    }

    public void deletar (int id) throws Exception {
        IngredienteDAO dao = new IngredienteDAOImpl();
        dao.deletar(id);
    }
}
