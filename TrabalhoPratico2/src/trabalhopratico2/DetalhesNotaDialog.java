/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico2;

/**
 *
 * @author User
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalhesNotaDialog extends JDialog {
    private Anotacao nota;

    public DetalhesNotaDialog(Frame owner, Anotacao nota) {
        super(owner, "Detalhes da Nota", true);
        this.nota = nota;

        JLabel tituloLabel = new JLabel("Título: " + nota.getTitulo());
        JLabel dataLabel = new JLabel("Data de Criação: " + nota.getData().toString());
        JLabel descricaoLabel = new JLabel("Descrição:");
        JTextArea descricaoArea = new JTextArea(nota.getDescricao(), 10, 30);
        descricaoArea.setWrapStyleWord(true);
        descricaoArea.setLineWrap(true);
        descricaoArea.setEditable(false);
        JScrollPane descricaoScrollPane = new JScrollPane(descricaoArea);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(tituloLabel);
        contentPane.add(dataLabel);
        contentPane.add(descricaoLabel);
        contentPane.add(descricaoScrollPane);

        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPane = new JPanel();
        buttonPane.add(fecharButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPane, BorderLayout.CENTER);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }
}
