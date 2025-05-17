package Modelos.delivery;

public interface DeliveryDAO {
    void criar(Delivery delivery) throws Exception;
    Delivery ler(int id) throws Exception;
    void atualizar(Delivery delivery) throws Exception;
    void deletar(int id) throws Exception;
}
