package DAO;

import connection.Conexao;
import models.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO {

    public void cadastrar(Aluno a) {
        Connection con = Conexao.getConexao();
        String sql = "INSERT INTO aluno (cpf,nome,data_nascimento,peso_inicial,altura) VALUES(?,?,?,?,?)";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, a.getCpf());
            smt.setString(2, a.getNome());
            smt.setString(3, a.getDataNascimento());
            smt.setFloat(4, a.getPeso());
            smt.setFloat(5, a.getAltura());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            smt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + ex.getMessage());
        }
    }

    public void atualizar(Aluno a) {
        Connection con = Conexao.getConexao();
        String sql = "UPDATE aluno SET cpf = ?, nome = ?, data_nascimento = ?, peso_inicial = ?, altura = ? WHERE id = ?";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, a.getCpf());
            smt.setString(2, a.getNome());
            smt.setString(3, a.getDataNascimento());
            smt.setFloat(4, a.getPeso());
            smt.setFloat(5, a.getAltura());
            smt.setInt(6, a.getIdal());
            smt.executeUpdate();
            smt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir(Aluno a) {
        Connection con = Conexao.getConexao();
        String sql = "DELETE FROM aluno WHERE id = ?";
        Object[] options = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o aluno(a) " + a.getNome() + "?", "Excluir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareCall(sql)) {
                smt.setInt(1, a.getIdal());
                smt.executeUpdate();
                smt.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Aluno excluido com Sucesso");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o aluno" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<Aluno> listarAlunos() {
        Connection con = Conexao.getConexao();
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno ORDER BY id";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery(); //executar uma consulta
            while (resultado.next()) {
                Aluno a = new Aluno();
                a.setIdal(resultado.getInt("id"));
                a.setCpf(resultado.getString("cpf"));
                a.setNome(resultado.getString("nome"));
                a.setDataNascimento(resultado.getString("data_nascimento"));
                a.setPeso(resultado.getFloat("peso_inicial"));
                a.setAltura(resultado.getFloat("altura"));
                lista.add(a); //sempre listar todos os itens
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar alunos" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

}
