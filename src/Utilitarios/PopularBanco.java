package Utilitarios;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Conexao.Conexao;

public class PopularBanco {
    public static void tudo() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja popular o banco de dados com dados de teste?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Connection conn = Conexao.get();
        String sql =
            "begin;"+
                "DELETE FROM cupom;"+
                "DELETE FROM pagamento;"+
                "DELETE FROM ingrediente_escolha;"+
                "DELETE FROM carrinho;"+
                "DELETE FROM produto;"+
                "DELETE FROM ingrediente;"+
                "DELETE FROM pedido;"+
                "DELETE FROM status_pedido;"+
                "DELETE FROM entrega;"+
                "DELETE FROM endereco;"+
                "DELETE FROM bairro;"+
                "DELETE FROM cartao;"+
                "DELETE FROM funcionario;"+
                "DELETE FROM cliente;"+
                "DELETE FROM telefone;"+
                "DELETE FROM login;"+                
                "INSERT INTO public.login (id, login, senha) VALUES (1, 'ivan', 'senhaivan'), (3, 'Kelvin', 'senhakervins');"+
                "INSERT INTO public.telefone (id, ddd, numero) VALUES (2, '67', '99999999'), (3, '48', '88888888'), (4, '33', '40301020'), (5, '12', '10203040'), (7, '67', '996021942');"+
                "INSERT INTO public.cliente (id, nome, telefone_id) VALUES (1, 'Cliente Premium', 4), (2, 'Cliente Bad Boys', 5), (4, 'Cliente', 2), (5, 'Ivan Luiz Pivetta de Oliveira', 7);"+
                "INSERT INTO public.funcionario (id, nome, telefone_id, login_id, cpf, rg) VALUES (3, 'Kelvin Pivetta', 3, 3, '89883113883', '8319494'), (1, 'Ivan Luiz Pivetta de Oliveira', 2, 1, '12332112344', '1234321');"+
                "INSERT INTO public.cartao (id, numero, cvv, iscredito, cliente_id) VALUES (4, '1231224412312244', 412, false, 1), (2, '5553834681730222', 321, false, 2), (5, '8872874295717522', 777, true, 1);"+
                "INSERT INTO public.bairro (id, nome) VALUES (1, 'teste'), (2, '22'), (5, 'Numero tres'), (3, 'Vila Avestruz Que Voa'), (16, 'Reaven Clouds'), (35, 'Canaa III');"+
                "INSERT INTO public.endereco (id, cep, bairro_id, complemento, rua, numero) VALUES (3, '79804020', 3, 'Escritorio', 'Mangueiras', 99), (4, '79820200', 16, 'Casa', 'Éther', 111), (5, '79840497', 35, 'casa', 'Tio Juca', 3240);"+
                "INSERT INTO public.entrega (id, chave, endereco_id, valor) VALUES (2, 'PEIXE', 4, 12.50), (4, 'JANELA', 3, 7.81), (5, 'COLA', 5, 10.50);"+
                "INSERT INTO public.status_pedido (id, progresso) VALUES (1, 'Aguardando Pagamento'), (2, 'Em preparação'), (3, 'Saiu para Entrega');"+
                "INSERT INTO public.pedido (id, cliente_id, data_pedido, status_pedido_id, entrega_id, reembolsado) VALUES (3, 1, '2025-06-01 20:47:21.423849', 1, 2, 'no'), (2, 1, '2025-06-01 20:47:08.974378', 3, 4, NULL), (4, 5, '2025-06-01 20:54:16.459069', 2, 5, NULL);"+
                "INSERT INTO public.ingrediente (id, nome, valor) VALUES (1, 'Alface', 0.50), (2, 'Bacon', 2.00);"+
                "INSERT INTO public.produto (id, nome, valor) VALUES (8, 'X salada', 18.00), (10, 'X Tudo', 25.99);"+
                "INSERT INTO public.carrinho (id, pedido_id, produto_id, quantidade) VALUES (1, 2, 8, 1), (3, 4, 10, 5), (4, 4, 8, 2), (5, 2, 10, 3);"+
                "INSERT INTO public.ingrediente_escolha (id, ingrediente_id, carrinho_id, toexclude) VALUES (1, 1, 4, false), (2, 2, 4, true), (4, 2, 5, false);"+
                "INSERT INTO public.pagamento (id, pedido_id, pix, dinheiro, cartao) VALUES (3, 4, 44.00, 66.00, 55.00), (2, 4, 0.00, 88.00, 77.00), (5, 2, 20.00, 0.00, 0.00), (6, 3, 0.00, 0.00, 30.00);"+
                "INSERT INTO public.cupom (id, valor, codigo, validade, pagamento_id) VALUES (1, 5.00, 'f345', '2025-01-01', 3), (2, 6.00, 'hesoyam', '2026-12-31', 5), (4, 3.00, 'asdasd', '2025-12-31', 6);"+
            "commit;";
        
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Banco de dados populado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao popular" +
                    " o banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
