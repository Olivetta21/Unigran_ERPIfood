package Controller.carrinho;

import DTOs.carrinho.CarrinhoDTO;
import Modelos.carrinho.CarrinhoDAO;
import Modelos.carrinho.CarrinhoDAOImpl;
import Modelos.carrinho.Carrinho;

public class CarrinhoCTRL {
    public void criar(CarrinhoDTO carrinhoDTO) throws Exception {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.criar(carrinhoDTO.builder());
    }

    public Carrinho ler(int id) throws Exception {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(CarrinhoDTO carrinhoDTO) throws Exception {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.atualizar(carrinhoDTO.builder());
    }

    public void deletar(int id) throws Exception {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.deletar(id);
    }
}
