package Interfaces;


public abstract class ControllerInterface {
    public abstract void criar(InterfaceDTO dto) throws Exception;
    public abstract InterfaceDTO ler(InterfaceDTO dto) throws Exception;
    public abstract void atualizar(InterfaceDTO dto) throws Exception;
    public abstract Object[][] listar() throws Exception;
    public abstract String[] titulos();
    public abstract void deletar(InterfaceDTO dto) throws Exception;
}
