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


/**
 *
 * @author sofiapetersen
 */
public class EditarAnotacaoDialog extends JDialog {
    private Anotacao nota;
    private JTextField tituloField;
    private JTextArea descricaoArea;
    private JLabel dataField;  
    private JButton salvarButton;
    private JButton cancelarButton;

    public EditarAnotacaoDialog(Frame owner, Anotacao nota) {
        super(owner, "Editar Nota", true);
        this.nota = nota;

        JLabel tituloLabel = new JLabel("Novo Título:");
        tituloField = new JTextField(nota.getTitulo(), 20);

        JLabel dataLabel = new JLabel("Data de Edição:");
        String dataCriacao = nota.getData().toString();
        dataField = new JLabel(dataCriacao);

        JLabel descricaoLabel = new JLabel("Nova Descrição:");
        descricaoArea = new JTextArea(nota.getDescricao(), 3, 20);
        JScrollPane descricaoScrollPane = new JScrollPane(descricaoArea);

        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

    salvarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String novoTitulo = tituloField.getText();
        String novaDescricao = descricaoArea.getText();

        if (!novoTitulo.isEmpty() && !novaDescricao.isEmpty()) {
            LocalDate dataAtual = LocalDate.now(); 
            nota.getData().setData(dataAtual.getDayOfMonth(), dataAtual.getMonthValue(), dataAtual.getYear());

            nota.setTitulo(novoTitulo);
            nota.setDescricao(novaDescricao);
            dispose(); 
        }
    }
});

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 3));
        contentPane.add(dataLabel);
        contentPane.add(dataField);
        contentPane.add(tituloLabel);
        contentPane.add(tituloField);
        contentPane.add(descricaoLabel);
        contentPane.add(new JScrollPane(descricaoArea));

        JPanel buttonPane = new JPanel();
        buttonPane.add(salvarButton);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPane, BorderLayout.CENTER);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }
}