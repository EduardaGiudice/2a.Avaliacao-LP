/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import DAO.AlunoDAO;
import models.Aluno;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduarda
 */
public class Form_aluno extends javax.swing.JFrame {

    /**
     * Creates new form Form_aluno
     */
    public Form_aluno() {
        initComponents();
        preencherTabela();
        jBAtualizarAluno.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jB_Voltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jT_id_aluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jT_Nome = new javax.swing.JTextField();
        jF_Cpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jF_DataNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jT_Peso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jT_Altura = new javax.swing.JTextField();
        jBCadastrarAluno = new javax.swing.JButton();
        jBAtualizarAluno = new javax.swing.JButton();
        jBCancelarAluno = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jB_Voltar2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_Alunos = new javax.swing.JTable();
        jB_Novo = new javax.swing.JButton();
        JB_Editar = new javax.swing.JButton();
        JBExcluirAl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 51, 153));
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciamento de Alunos");

        jB_Voltar.setBackground(new java.awt.Color(255, 204, 204));
        jB_Voltar.setForeground(new java.awt.Color(255, 51, 153));
        jB_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-voltar-35.png"))); // NOI18N
        jB_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jB_Voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(97, 97, 97))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jB_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setText("ID:");

        jT_id_aluno.setEditable(false);
        jT_id_aluno.setBackground(new java.awt.Color(204, 204, 204));
        jT_id_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_id_alunoActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        jLabel4.setText("Nome:");

        jT_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_NomeActionPerformed(evt);
            }
        });

        try {
            jF_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Data de Nascimento:");

        try {
            jF_DataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jF_DataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jF_DataNascimentoActionPerformed(evt);
            }
        });

        jLabel6.setText("Peso(kg):");

        jLabel7.setText("Altura(m):");

        jBCadastrarAluno.setBackground(new java.awt.Color(255, 51, 153));
        jBCadastrarAluno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBCadastrarAluno.setText("Cadastrar");
        jBCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarAlunoActionPerformed(evt);
            }
        });

        jBAtualizarAluno.setBackground(new java.awt.Color(255, 51, 153));
        jBAtualizarAluno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBAtualizarAluno.setText("Atualizar");
        jBAtualizarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarAlunoActionPerformed(evt);
            }
        });

        jBCancelarAluno.setBackground(new java.awt.Color(255, 51, 153));
        jBCancelarAluno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBCancelarAluno.setText("Cancelar");
        jBCancelarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jLabel2))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jT_id_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jT_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jF_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(144, 144, 144)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBCadastrarAluno)
                                .addGap(18, 18, 18)
                                .addComponent(jBAtualizarAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBCancelarAluno)
                                .addGap(31, 31, 31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jF_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_Altura, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 47, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jT_id_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jF_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jF_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jT_Altura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAtualizarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Gerenciamento Alunos", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jPanel4.setBackground(new java.awt.Color(255, 51, 153));
        jPanel4.setToolTipText("");

        jB_Voltar2.setBackground(new java.awt.Color(255, 204, 204));
        jB_Voltar2.setForeground(new java.awt.Color(255, 51, 153));
        jB_Voltar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-voltar-35.png"))); // NOI18N
        jB_Voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Voltar2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Listagem de Alunos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_Voltar2)
                .addGap(79, 79, 79)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Voltar2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jT_Alunos.setBackground(new java.awt.Color(255, 204, 255));
        jT_Alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CPF", "Nome", "Data Nascimento", "Peso Inicial(kg)", "Altura(m)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_Alunos.setGridColor(new java.awt.Color(0, 0, 0));
        jT_Alunos.setSelectionBackground(new java.awt.Color(255, 102, 204));
        jScrollPane1.setViewportView(jT_Alunos);

        jB_Novo.setBackground(new java.awt.Color(255, 51, 153));
        jB_Novo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jB_Novo.setText("Novo");
        jB_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_NovoActionPerformed(evt);
            }
        });

        JB_Editar.setBackground(new java.awt.Color(255, 51, 153));
        JB_Editar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JB_Editar.setText("Editar");
        JB_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EditarActionPerformed(evt);
            }
        });

        JBExcluirAl.setBackground(new java.awt.Color(255, 51, 153));
        JBExcluirAl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBExcluirAl.setText("Excluir");
        JBExcluirAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirAlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jB_Novo)
                .addGap(37, 37, 37)
                .addComponent(JB_Editar)
                .addGap(36, 36, 36)
                .addComponent(JBExcluirAl)
                .addGap(168, 168, 168))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JB_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JBExcluirAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Alunos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jT_id_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_id_alunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_id_alunoActionPerformed

    private void jF_DataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jF_DataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jF_DataNascimentoActionPerformed

    private void jB_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_NovoActionPerformed
        jT_id_aluno.setText("");
        jF_Cpf.setText("");
        jT_Nome.setText("");
        jF_DataNascimento.setText("");
        jT_Peso.setText("");
        jT_Altura.setText("");
        jBAtualizarAluno.setVisible(false);
        jBCadastrarAluno.setVisible(true);
        jTabbedPane1.setSelectedIndex(0);//Quando Cadastra um novo aluno ja viaja pra tela de listagem

    }//GEN-LAST:event_jB_NovoActionPerformed

    private void jBCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarAlunoActionPerformed
        try {
            Aluno a = new Aluno();

            a.setCpf(jF_Cpf.getText());
            a.setDataNascimento(jF_DataNascimento.getText());
            a.setNome(jT_Nome.getText());

            // Tratamento de exceção para a conversão de String para float
            try {
                float peso = Float.parseFloat(jT_Peso.getText());
                a.setPeso(peso);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um valor válido para o peso.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Sai do método se houver erro na conversão
            }

            try {
                float altura = Float.parseFloat(jT_Altura.getText());
                a.setAltura(altura);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um valor válido para a altura.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Sai do método se houver erro na conversão
            }

            AlunoDAO alDao = new AlunoDAO();
            alDao.cadastrar(a);
            preencherTabela(); //Quando cadastra um novo aluno ja preenche a tabela de listagem
            jTabbedPane1.setSelectedIndex(1);//Quando Cadastra um novo aluno ja viaja pra tela de listagem

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBCadastrarAlunoActionPerformed
    public void preencherTabela() {
        AlunoDAO alDao = new AlunoDAO();
        List<Aluno> lista = alDao.listarAlunos();
        DefaultTableModel modeloTabela = (DefaultTableModel) jT_Alunos.getModel();
        modeloTabela.setRowCount(0);

        for (Aluno a : lista) {
            modeloTabela.addRow(new Object[]{a.getIdal(), a.getCpf(), a.getNome(), a.getDataNascimento(), a.getPeso(), a.getAltura()});
        }
    }

    private void jT_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_NomeActionPerformed

    private void JB_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EditarActionPerformed
        int opcao = jT_Alunos.getSelectedRow(); //seleciona a linha que quero editar
        if (opcao >= 0) { //verifica se tem alguma linha selecionada, alguma linha selecionada é diferente de 0

            jT_id_aluno.setText(jT_Alunos.getValueAt(opcao, 0).toString()); //selecionar qual coluna vai verificar
            jF_Cpf.setText(jT_Alunos.getValueAt(opcao, 1).toString());
            jT_Nome.setText(jT_Alunos.getValueAt(opcao, 2).toString());
            jF_DataNascimento.setText(jT_Alunos.getValueAt(opcao, 3).toString());
            jT_Peso.setText(jT_Alunos.getValueAt(opcao, 4).toString());
            jT_Altura.setText(jT_Alunos.getValueAt(opcao, 5).toString());
            jTabbedPane1.setSelectedIndex(0); //Quando atualiza um novo aluno ja viaja pra tela de listagem
            jBAtualizarAluno.setVisible(true);
            jBCadastrarAluno.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Voce deve selecionar uma linha para editar!");
        }
    }//GEN-LAST:event_JB_EditarActionPerformed

    private void jBAtualizarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarAlunoActionPerformed
        Aluno a = new Aluno();

        a.setIdal(Integer.parseInt(jT_id_aluno.getText()));
        a.setCpf(jF_Cpf.getText());
        a.setNome(jT_Nome.getText());
        a.setDataNascimento(jF_DataNascimento.getText());

// Tratamento de exceção para a conversão de String para float
        try {
            float peso = Float.parseFloat(jT_Peso.getText());
            a.setPeso(peso);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido para o peso.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se houver erro na conversão
        }

        try {
            float altura = Float.parseFloat(jT_Altura.getText());
            a.setAltura(altura);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido para a altura.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se houver erro na conversão
        }

        AlunoDAO aldao = new AlunoDAO();
        aldao.atualizar(a);
        preencherTabela();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jBAtualizarAlunoActionPerformed

    private void jBCancelarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarAlunoActionPerformed
        jT_id_aluno.setText("");
        jF_Cpf.setText("");
        jT_Nome.setText("");
        jF_DataNascimento.setText("");
        jT_Peso.setText("");
        jT_Altura.setText("");
        jBAtualizarAluno.setVisible(false);
        jBCadastrarAluno.setVisible(true);
        jTabbedPane1.setSelectedIndex(1);//Quando cancela ja viaja pra tela de listagem

    }//GEN-LAST:event_jBCancelarAlunoActionPerformed

    private void JBExcluirAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirAlActionPerformed
        int opcao = jT_Alunos.getSelectedRow(); //seleciona a linha que quero editar
        if (opcao >= 0) { //verifica se tem alguma linha selecionada, alguma linha selecionada é diferente de 0
            Aluno a = new Aluno();
            a.setIdal(Integer.parseInt(jT_Alunos.getValueAt(opcao, 0).toString())); //selecionar qual coluna vai verificar
            a.setCpf(jT_Alunos.getValueAt(opcao, 1).toString());
            a.setNome(jT_Alunos.getValueAt(opcao, 2).toString());
            a.setDataNascimento(jT_Alunos.getValueAt(opcao, 3).toString());

            a.setPeso(Float.parseFloat(jT_Alunos.getValueAt(opcao, 4).toString()));
            a.setAltura(Float.parseFloat(jT_Alunos.getValueAt(opcao, 5).toString()));

            AlunoDAO aldao = new AlunoDAO();
            aldao.excluir(a); //chamando o método excluir
            preencherTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Voce deve selecionar uma linha para editar!");
        }
    }//GEN-LAST:event_JBExcluirAlActionPerformed

    private void jB_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VoltarActionPerformed
        Menu mn = new Menu();
        this.dispose(); //fecha o frame
        mn.setVisible(true);

    }//GEN-LAST:event_jB_VoltarActionPerformed

    private void jB_Voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Voltar2ActionPerformed
        Menu mn = new Menu();
        this.dispose(); //fecha o frame
        mn.setVisible(true);

    }//GEN-LAST:event_jB_Voltar2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBExcluirAl;
    private javax.swing.JButton JB_Editar;
    private javax.swing.JButton jBAtualizarAluno;
    private javax.swing.JButton jBCadastrarAluno;
    private javax.swing.JButton jBCancelarAluno;
    private javax.swing.JButton jB_Novo;
    private javax.swing.JButton jB_Voltar;
    private javax.swing.JButton jB_Voltar2;
    private javax.swing.JFormattedTextField jF_Cpf;
    private javax.swing.JFormattedTextField jF_DataNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_Altura;
    private javax.swing.JTable jT_Alunos;
    private javax.swing.JTextField jT_Nome;
    private javax.swing.JTextField jT_Peso;
    private javax.swing.JTextField jT_id_aluno;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}