package forms;

import DAO.HistoricoDAO;
import connection.Conexao;
import models.Aluno;
import models.Historico;
import pesquisa.Pes_aluno;
import interfaces.DadosCallback;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class Form_historico extends javax.swing.JFrame {

    public void setDadosCallback(DadosCallback callback) {
        this.callback = callback;
    }

    private DadosCallback callback;

    Aluno aluno;
    Historico historico;
    float altura;
    float imc;

    public Form_historico() {
        initComponents();
    }

    public Form_historico(Aluno aluno) {
        initComponents();
        this.aluno = aluno;
    }

    public Form_historico(Aluno aluno, Historico historico) {
        initComponents();
        this.aluno = aluno;
        this.historico = historico;
        jT_id_Novo_Peso.setText(String.valueOf(historico.getIdhist()));
        jT_Novo_Peso.setText(Float.toString(historico.getPeso()));
        jF_Data_Pesagem.setText(historico.getDataHist());
        jT_idAluno.setText(String.valueOf(historico.getAluno().getIdal()));
        jT_nomeAluno.setText(String.valueOf(historico.getAluno().getNome()));

    }

    public Form_historico(Aluno aluno, Historico historico, DadosCallback callback) {
        initComponents();
        this.aluno = aluno;
        this.historico = historico;
        this.callback = callback;
        jT_id_Novo_Peso.setText(String.valueOf(historico.getIdhist()));
        jT_Novo_Peso.setText(Float.toString(historico.getPeso()));
        jF_Data_Pesagem.setText(historico.getDataHist());

        jT_idAluno.setText(String.valueOf(historico.getAluno().getIdal()));
        jT_nomeAluno.setText(String.valueOf(historico.getAluno().getNome()));

    }

    public Form_historico(Aluno aluno, Historico historico, DadosCallback callback, Form_historico_listagem formlistagem) {
        initComponents();
        this.aluno = aluno;
        this.historico = historico;
        this.callback = callback;
        jT_id_Novo_Peso.setText(String.valueOf(historico.getIdhist()));
        jT_Novo_Peso.setText(Float.toString(historico.getPeso()));
        jF_Data_Pesagem.setText(historico.getDataHist());
        jT_idAluno.setText(String.valueOf(historico.getAluno().getIdal()));
        jT_nomeAluno.setText(String.valueOf(historico.getAluno().getNome()));

    }

    public void mostrarRegistro() {

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from aluno");

            ResultSet rs = stmt.executeQuery();

            String idBusca = jT_idAluno.getText();
            int idBuscaInt = Integer.parseInt(idBusca);
            while (rs.next()) {

                int idBanco = rs.getInt("id");

                if (idBuscaInt == idBanco) {
                    altura = rs.getFloat("altura");
                }
            }

        } catch (Exception e) {
        }
    }

    private float calcularIMC() {
        mostrarRegistro(); // Chama o método para obter a altura do banco de dados

        String peso = jT_Novo_Peso.getText();
        float pesoFloat = Float.parseFloat(peso);

        if (altura > 0) {
            return imc = pesoFloat / (altura * altura);
        } else {
            // Tratar o caso em que a altura é zero para evitar divisão por zero
            JOptionPane.showMessageDialog(null, "Altura inválida. Não é possível calcular o IMC.");
            return 0; // Ou outro valor apropriado, dependendo dos requisitos do seu aplicativo
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

    public void gerarRelatorio(Aluno aluno, Historico historico) {
        try {
            File arquivo = new File("src\\relatorio\\historico.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            try (FileWriter writer = new FileWriter(arquivo, true)) {
                if (historico != null) {
                    float imc = calcularIMC(); // Chama o método para calcular o IMC

                    // Obter a classificação do IMC
                    String classificacao = getClassificacao(imc);

                    writer.write("Data da Pesagem:" + historico.getDataHist()
                            + "\nNome:" + aluno.getNome()
                            + "\nCPF: " + aluno.getCpf()
                            + "\nIMC: " + String.format("%.2f", imc)
                            + "\nClassificação: " + classificacao + "\n\n");

                    writer.flush();
                    System.out.println("Relatório salvo com sucesso!");
                } else {
                    System.out.println("Erro ao gerar relatório: histórico é nulo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar o relatório no arquivo: " + e.getMessage());
        }
    }

    public void ocultarBotaoSelecionarAluno() {
        JB_Selecionar_Aluno.setVisible(false);
    }

    public void ocultarBotaoCadastrar() {
        jB_Cadastrar.setVisible(false);
    }

    public void ocultarBotaoAtualizar() {
        jB_Atualizar_Novo_Peso.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jT_nomeAluno = new javax.swing.JTextField();
        JB_Selecionar_Aluno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jT_Novo_Peso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jF_Data_Pesagem = new javax.swing.JFormattedTextField();
        jT_idAluno = new javax.swing.JTextField();
        jB_Cadastrar = new javax.swing.JButton();
        jB_Atualizar_Novo_Peso = new javax.swing.JButton();
        jB_Cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jT_id_Novo_Peso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 51, 153));
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciamento de Pesos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setText("Aluno:");

        jT_nomeAluno.setEditable(false);
        jT_nomeAluno.setBackground(new java.awt.Color(204, 204, 204));

        JB_Selecionar_Aluno.setText("...");
        JB_Selecionar_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Selecionar_AlunoActionPerformed(evt);
            }
        });

        jLabel3.setText("Novo Peso:");

        jT_Novo_Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_Novo_PesoActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Pesagem:");

        try {
            jF_Data_Pesagem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jF_Data_Pesagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jF_Data_PesagemActionPerformed(evt);
            }
        });

        jT_idAluno.setEditable(false);
        jT_idAluno.setBackground(new java.awt.Color(204, 204, 204));
        jT_idAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_idAlunoActionPerformed(evt);
            }
        });

        jB_Cadastrar.setBackground(new java.awt.Color(255, 51, 153));
        jB_Cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Cadastrar.setText("Cadastrar");
        jB_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CadastrarActionPerformed(evt);
            }
        });

        jB_Atualizar_Novo_Peso.setBackground(new java.awt.Color(255, 51, 153));
        jB_Atualizar_Novo_Peso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Atualizar_Novo_Peso.setText("Atualizar");
        jB_Atualizar_Novo_Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Atualizar_Novo_PesoActionPerformed(evt);
            }
        });

        jB_Cancelar.setBackground(new java.awt.Color(255, 51, 153));
        jB_Cancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Cancelar.setText("Cancelar");
        jB_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("ID:");

        jT_id_Novo_Peso.setEditable(false);
        jT_id_Novo_Peso.setBackground(new java.awt.Color(204, 204, 204));
        jT_id_Novo_Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_id_Novo_PesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_idAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jT_nomeAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JB_Selecionar_Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_Cadastrar)
                        .addGap(66, 66, 66)
                        .addComponent(jB_Atualizar_Novo_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jB_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_id_Novo_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jT_Novo_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jF_Data_Pesagem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jF_Data_Pesagem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jT_Novo_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jT_id_Novo_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_idAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JB_Selecionar_Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Atualizar_Novo_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jT_Novo_PesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_Novo_PesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_Novo_PesoActionPerformed

    private void jB_Atualizar_Novo_PesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Atualizar_Novo_PesoActionPerformed
        Historico h = new Historico();

        h.setIdhist(Integer.parseInt(jT_id_Novo_Peso.getText()));
        h.setPeso(Float.parseFloat(jT_Novo_Peso.getText()));
        h.setDataHist(jF_Data_Pesagem.getText());

        Aluno a = new Aluno();
        a.setIdal(Integer.parseInt(jT_idAluno.getText()));
        a.setNome(jT_nomeAluno.getText());
        h.setAluno(a);

        HistoricoDAO histdao = new HistoricoDAO();
        histdao.atualizar(h);

        if (callback != null) {
            callback.onAtualizacaoConcluida();
        }

        this.dispose();

    }//GEN-LAST:event_jB_Atualizar_Novo_PesoActionPerformed

    private void jB_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CadastrarActionPerformed
        Historico h = new Historico();

        h.setPeso(Float.parseFloat(jT_Novo_Peso.getText()));
        h.setDataHist(jF_Data_Pesagem.getText());
        h.setAluno(this.aluno);

        HistoricoDAO histdao = new HistoricoDAO();
        histdao.cadastrar(h);

        gerarRelatorio(aluno, h);

        if (callback != null) {
            callback.onCadastroConcluido();
        }
        this.dispose();
    }//GEN-LAST:event_jB_CadastrarActionPerformed

    private void JB_Selecionar_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Selecionar_AlunoActionPerformed
        Pes_aluno pesqal = new Pes_aluno(this, true);
        pesqal.setVisible(true);

        this.aluno = pesqal.getA();

        jT_idAluno.setText("" + aluno.getIdal());
        jT_nomeAluno.setText(aluno.getNome());

    }//GEN-LAST:event_JB_Selecionar_AlunoActionPerformed

    private void jB_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jB_CancelarActionPerformed

    private void jT_id_Novo_PesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_id_Novo_PesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_id_Novo_PesoActionPerformed

    private void jF_Data_PesagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jF_Data_PesagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jF_Data_PesagemActionPerformed

    private void jT_idAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_idAlunoActionPerformed

    }//GEN-LAST:event_jT_idAlunoActionPerformed

    public void setCallback(DadosCallback callback) {
        this.callback = callback;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_historico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Selecionar_Aluno;
    private javax.swing.JButton jB_Atualizar_Novo_Peso;
    private javax.swing.JButton jB_Cadastrar;
    private javax.swing.JButton jB_Cancelar;
    private javax.swing.JFormattedTextField jF_Data_Pesagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jT_Novo_Peso;
    private javax.swing.JTextField jT_idAluno;
    private javax.swing.JTextField jT_id_Novo_Peso;
    private javax.swing.JTextField jT_nomeAluno;
    // End of variables declaration//GEN-END:variables
}
