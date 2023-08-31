/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sofiapetersen
 */
public class AdicionarAnotacao extends JDialog {
    private JTextField tituloField;
    private JTextArea descricaoArea;
    private JLabel dataField;  // Alteração: Mudança para JLabel
    private JButton adicionarButton;
    private JButton cancelarButton;
    private AnotacoesApp anotacoesApp;

    public AdicionarAnotacao(Frame owner, AnotacoesApp anotacoesApp) {
        super(owner, "Adicionar Nota", true);

        this.anotacoesApp = anotacoesApp;

        JLabel tituloLabel = new JLabel("Título:");
        tituloField = new JTextField(20);

        JLabel dataLabel = new JLabel("Data de Criação:");
        String dataCriacao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dataField = new JLabel(dataCriacao);

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoArea = new JTextArea(3, 20);
        JScrollPane descricaoScrollPane = new JScrollPane(descricaoArea);

        adicionarButton = new JButton("Adicionar");
        cancelarButton = new JButton("Cancelar");

        adicionarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = tituloField.getText();
        String descricao = descricaoArea.getText();

        if (!titulo.isEmpty() && !descricao.isEmpty()) {
            LocalDate dataAtual = LocalDate.now();  // Obter a data atual
            int dia = dataAtual.getDayOfMonth();
            int mes = dataAtual.getMonthValue();
            int ano = dataAtual.getYear();

            anotacoesApp.inserir(titulo, descricao, dia, mes, ano);
            dispose(); // Fecha a janela após adicionar
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        }
    }
});

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 3));
        contentPane.add(dataLabel);
        contentPane.add(dataField);
        contentPane.add(new JLabel("Título:"));
        contentPane.add(tituloField);
        contentPane.add(new JLabel("Descrição:"));
        contentPane.add(new JScrollPane(descricaoArea));

        JPanel buttonPane = new JPanel();
        buttonPane.add(adicionarButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPane, BorderLayout.CENTER);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }
}