package DAO;

import connection.Conexao;
import models.Aluno;
import models.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HistoricoDAO {

    public void cadastrar(Historico h) {
        Connection con = Conexao.getConexao();
        String sql = "INSERT INTO historicopeso(data_novo_peso, peso_novo, id_aluno) VALUES (?,?,?)";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, h.getDataHist());
            smt.setFloat(2, h.getPeso());
            smt.setInt(3, h.getAluno().getIdal());
            smt.executeUpdate();

            // Calcular o IMC antes de exibir a mensagem de sucesso
            float imc = calcularIMC(h.getPeso(), h.getAluno().getIdal());

            // Obter a classificação do IMC
            String classificacao = getClassificacao(imc);

            // Exibindo a mensagem de sucesso com o valor do IMC e classificação
            JOptionPane.showMessageDialog(null, "Novo Peso cadastrado com sucesso!\nIMC: " + String.format("%.2f", imc) + "\nClassificação: " + classificacao);

            smt.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo Peso!: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private float calcularIMC(float peso, int idAluno) {
        float altura = obterAlturaDoBanco(idAluno);

        if (altura > 0) {
            return peso / (altura * altura);
        } else {
            JOptionPane.showMessageDialog(null, "Altura inválida. Não é possível calcular o IMC.");
            return 0;
        }
    }

    private float obterAlturaDoBanco(int idAluno) {
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("SELECT altura FROM aluno WHERE id = ?");
            stmt.setInt(1, idAluno);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getFloat("altura");
            } else {
                JOptionPane.showMessageDialog(null, "Altura não encontrada para o aluno com ID " + idAluno);
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter altura do banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    private String getClassificacao(float imc) {
        if (imc < 18.5) {
            return "Magreza extrema";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso ideal";
        } else if (imc >= 25 && imc < 30) {
            return "Excesso de peso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade tipo I";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade tipo II";
        } else {
            return "Obesidade tipo III";
        }
    }

    public void atualizar(Historico h) {
        Connection con = Conexao.getConexao();
        String sql = "UPDATE historicopeso SET data_novo_peso = ?, peso_novo = ?, id_aluno = ? WHERE id = ?";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, h.getDataHist());
            smt.setFloat(2, h.getPeso());
            smt.setInt(3, h.getAluno().getIdal());
            smt.setInt(4, h.getIdhist());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peso atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o histórico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir(Historico h) {
        String sql = "DELETE FROM historicopeso WHERE id = ?";
        Object[] options = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o registro de peso?", "Excluir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            try (Connection con = Conexao.getConexao(); PreparedStatement smt = con.prepareStatement(sql)) {

                smt.setInt(1, h.getIdhist());
                smt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Exclusão Realizada com Sucesso!");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();  // Isso pode ajudar a identificar problemas específicos
            }
        }

    }

    public List<Historico> listarHistoricos() {
        Connection con = Conexao.getConexao();
        List<Historico> lista = new ArrayList<>();
        String sql = "SELECT * FROM historicopeso INNER JOIN aluno ON aluno.id = historicopeso.id_aluno";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                Historico h = new Historico();
                h.setIdhist(resultado.getInt("historicopeso.id_aluno"));
                h.setDataHist(resultado.getString("historicopeso.data_novo_peso"));
                h.setPeso(resultado.getFloat("historicopeso.peso_novo"));

                Aluno a = new Aluno();
                a.setIdal(resultado.getInt("aluno.id"));
                a.setNome(resultado.getString("aluno.nome"));
                a.setAltura(resultado.getFloat("aluno.altura"));
                a.setPeso(resultado.getFloat("aluno.peso_inicial"));
                h.setAluno(a);
                h.setIdhist(resultado.getInt("historicopeso.id"));

                lista.add(h);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar registros " + e.getMessage());
        }
        return lista;

    }

    public List<Historico> buscaNome(String nomePesquisa) {
        Connection con = Conexao.getConexao();
        List<Historico> lista = new ArrayList<>();
        String sql = "SELECT * FROM historicopeso INNER JOIN aluno ON aluno.id = historicopeso.id_aluno WHERE aluno.nome LIKE ?;";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, "%" + nomePesquisa + "%"); // Use LIKE para buscar por parte do nome
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                Historico h = new Historico();
                h.setIdhist(resultado.getInt("historicopeso.id_aluno"));
                h.setDataHist(resultado.getString("historicopeso.data_novo_peso"));
                h.setPeso(resultado.getFloat("historicopeso.peso_novo"));

                Aluno a = new Aluno();
                a.setIdal(resultado.getInt("aluno.id"));
                a.setNome(resultado.getString("aluno.nome"));
                a.setAltura(resultado.getFloat("aluno.altura"));
                a.setPeso(resultado.getFloat("aluno.peso_inicial"));
                h.setAluno(a);
                h.setIdhist(resultado.getInt("historicopeso.id"));

                lista.add(h);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar registros " + e.getMessage());
        }
        return lista;
    }
}
