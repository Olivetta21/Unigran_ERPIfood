package Controller.carrinho.ingrediente;

import DTOs.carrinho.ingrediente.IngredienteEscolhaDTO;
import Modelos.carrinho.ingrediente.IngredienteEscolha;
import Modelos.carrinho.ingrediente.IngredienteEscolhaDAO;
import Modelos.carrinho.ingrediente.IngredienteEscolhaDAOImpl;

public class IngredienteEscolhaCTRL {
    public void criar(IngredienteEscolhaDTO ingredienteEscolhaDTO) throws Exception {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.criar(ingredienteEscolhaDTO.builder());
    }

    public IngredienteEscolha ler(int id) throws Exception {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(IngredienteEscolhaDTO ingredienteEscolhaDTO) throws Exception {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.atualizar(ingredienteEscolhaDTO.builder());
    }

    public void deletar(int id) throws Exception {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.deletar(id);
    }
}
