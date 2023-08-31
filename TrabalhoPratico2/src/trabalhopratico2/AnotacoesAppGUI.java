package trabalhopratico2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author sofiapetersen
 */
public class AnotacoesAppGUI extends JFrame {

    private AnotacoesApp anotacoesApp;
    private JTextArea descricaoArea;
    private Anotacao notaSelecionada;

    private JList<String> anotacoesList;
    private final JButton ordenarDataButton;
    private final JButton ordenarAlfabeticoButton;
    private final JButton adicionarButton;
    private final JButton editarButton;
    private final JButton excluirButton;
    private JTextArea anotacaoTextArea;
    private final JButton salvarEdicaoButton;
    private final JButton cancelarEdicaoButton;
    private JTextField tituloField;
    private JLabel dataField;
    private final JButton detalhesNotaButton;
    private int paginaAtual = 1;
    private int notasPorPagina = 5;
    private final JButton paginaAnteriorButton;
    private final JButton proximaPaginaButton;

    private PaginaNotas paginaAtualNotas;

   

    private void atualizarListaAnotacoes() {
        descricaoArea = new JTextArea(10, 30);
        descricaoArea.setLineWrap(true);

        DefaultListModel<String> model = new DefaultListModel<>();
        int inicio = (paginaAtual - 1) * notasPorPagina;
        int fim = Math.min(anotacoesApp.getLista().size(), paginaAtual * notasPorPagina);
        for (int i = inicio; i < fim; i++) {
            Anotacao nota = anotacoesApp.getLista().get(i);
            model.addElement(nota.getTitulo());
        }
        anotacoesList.setModel(model);

        // Atualiza a seleção com base na nova página
        if (paginaAtualNotas != null) {
            int selectedIndex = paginaAtualNotas.getNotaSelecionadaIndex();
            if (selectedIndex != -1) {
                int indiceNotaSelecionada = (paginaAtual - 1) * notasPorPagina + selectedIndex;
                notaSelecionada = anotacoesApp.getLista().get(indiceNotaSelecionada);
            }
        }
    }

    
    private void atualizarCamposAnotacaoSelecionada() {
        int selectedIndex = anotacoesList.getSelectedIndex();
        if (selectedIndex != -1) {
            int indiceNotaSelecionada = (paginaAtual - 1) * notasPorPagina + selectedIndex;
            if (indiceNotaSelecionada < anotacoesApp.getLista().size()) {
                notaSelecionada = anotacoesApp.getLista().get(indiceNotaSelecionada);
                tituloField.setText(notaSelecionada.getTitulo());

                String dataCriacao = notaSelecionada.getData().toString();
                dataField.setText(dataCriacao);

                anotacaoTextArea.setText(notaSelecionada.getDescricao());
            }
        } else {
            tituloField.setText("");
            dataField.setText("");
            anotacaoTextArea.setText("");
        }
    }




    public AnotacoesAppGUI() {
        anotacoesApp = new AnotacoesApp();
        paginaAtualNotas = new PaginaNotas(anotacoesApp.getLista(), 0);

        anotacoesList = new JList<>();
        ordenarDataButton = new JButton("Ordenar por Data");
        ordenarAlfabeticoButton = new JButton("Ordenar por Alfabeto");
        adicionarButton = new JButton("Adicionar Nota");
        editarButton = new JButton("Editar Nota");
        excluirButton = new JButton("Excluir Nota");
        anotacaoTextArea = new JTextArea(10, 30);
        salvarEdicaoButton = new JButton("Salvar");
        cancelarEdicaoButton = new JButton("Cancelar");
        detalhesNotaButton = new JButton("Detalhes Nota");
        paginaAnteriorButton = new JButton("Página Anterior");
        proximaPaginaButton = new JButton("Próxima Página");
       
        
        // painel dos botões
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(7, 1, 5, 5));
    
    JPanel paginaButtonPanel = new JPanel();
    paginaButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

    paginaButtonPanel.add(paginaAnteriorButton);
    paginaButtonPanel.add(proximaPaginaButton);

    buttonPanel.add(adicionarButton);
    buttonPanel.add(detalhesNotaButton);
    buttonPanel.add(editarButton);
    buttonPanel.add(excluirButton);
    buttonPanel.add(ordenarDataButton);
    buttonPanel.add(ordenarAlfabeticoButton);

    // painel das notas
    JPanel anotacaoPanel = new JPanel();
    anotacaoPanel.setLayout(new BorderLayout(10, 10));
    anotacaoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    anotacaoPanel.add(new JScrollPane(anotacoesList), BorderLayout.CENTER);
    anotacaoPanel.add(paginaButtonPanel, BorderLayout.SOUTH);
    

        ordenarDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anotacoesApp.ordenar();
                atualizarListaAnotacoes();
            }
        });
        
        anotacoesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = anotacoesList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        notaSelecionada = anotacoesApp.getLista().get((paginaAtual - 1) * notasPorPagina + selectedIndex);
                        tituloField.setText(notaSelecionada.getTitulo());

                        String dataCriacao = notaSelecionada.getData().toString();
                        dataField.setText(dataCriacao);

                        anotacaoTextArea.setText(notaSelecionada.getDescricao());
                    } else {
                        tituloField.setText("");
                        dataField.setText("");
                        anotacaoTextArea.setText("");
                    }
                }
            }
        });
        
        paginaAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paginaAtual > 1) {
                    paginaAtual--;
                    paginaAtualNotas.setNotaSelecionadaIndex(0); 
                    atualizarListaAnotacoes();
                    int totalPaginas = (int) Math.ceil((double) anotacoesApp.getLista().size() / notasPorPagina);
                    int selectedIndex = (paginaAtual - 1) * notasPorPagina;
                    if (selectedIndex < anotacoesApp.getLista().size()) {
                        anotacoesList.setSelectedIndex(selectedIndex);
                    }
                }
            }
        });

        proximaPaginaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalPaginas = (int) Math.ceil((double) anotacoesApp.getLista().size() / notasPorPagina);
                if (paginaAtual < totalPaginas) {
                    paginaAtual++;
                    paginaAtualNotas.setNotaSelecionadaIndex(paginaAtual-1); 
                    atualizarListaAnotacoes();
                    int selectedIndex = (paginaAtual - 1) * notasPorPagina;
                    if (selectedIndex < anotacoesApp.getLista().size()) {
                        anotacoesList.setSelectedIndex(selectedIndex);
                    }
                }
            }
        });




        ordenarAlfabeticoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anotacoesApp.ordenarPorTitulo();
                atualizarListaAnotacoes();
            }
        });
        
        detalhesNotaButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = anotacoesList.getSelectedIndex();
        if (selectedIndex != -1) {
            Anotacao notaSelecionada = anotacoesApp.getLista().get(selectedIndex + ((paginaAtual-1)*5));
            DetalhesNotaDialog detalhesDialog = new DetalhesNotaDialog(AnotacoesAppGUI.this, notaSelecionada);
            detalhesDialog.setVisible(true);
        }
    }
});

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarAnotacao dialog = new AdicionarAnotacao(AnotacoesAppGUI.this, anotacoesApp);
                dialog.setVisible(true);

                
                atualizarListaAnotacoes();
            }
        });
        
        editarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = anotacoesList.getSelectedIndex();
        if (selectedIndex != -1) {
            Anotacao notaSelecionada = anotacoesApp.getLista().get(selectedIndex + ((paginaAtual-1)*5));

            
            LocalDate dataAtual = LocalDate.now();
            notaSelecionada.getData().setData(dataAtual.getDayOfMonth(), dataAtual.getMonthValue(), dataAtual.getYear());

            EditarAnotacaoDialog editarDialog;
            editarDialog = new EditarAnotacaoDialog(AnotacoesAppGUI.this, notaSelecionada);
            editarDialog.setVisible(true);

            atualizarListaAnotacoes();
            atualizarCamposAnotacaoSelecionada();
        }
    }
});


        
        anotacoesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = anotacoesList.locationToIndex(e.getPoint());
                if (selectedIndex != -1) {
                    int indiceNotaSelecionada = (paginaAtual - 1) * notasPorPagina + selectedIndex;
                    notaSelecionada = anotacoesApp.getLista().get(indiceNotaSelecionada);
                    atualizarCamposAnotacaoSelecionada();
                }
            }
        });


        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = anotacoesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    anotacoesApp.remover(selectedIndex);
                    atualizarListaAnotacoes();
                }
            }
        });

salvarEdicaoButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (notaSelecionada != null) {
            String novaDescricao = descricaoArea.getText();
            if (!novaDescricao.isEmpty()) {
                notaSelecionada.setDescricao(novaDescricao);
                atualizarListaAnotacoes(); // Atualiza a lista de anotações
                atualizarCamposAnotacaoSelecionada(); // Atualiza a exibição da nota na interface
                notaSelecionada = null;
            }
        }
    }
});

        cancelarEdicaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = anotacoesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Anotacao notaSelecionada = anotacoesApp.getLista().get(selectedIndex);
                    anotacaoTextArea.setText(notaSelecionada.toString());
                }
            }
        });

        // Layout da interface
        setLayout(new BorderLayout());

        buttonPanel.setLayout(new GridLayout(10, 1, 1, 1));
        // Resto do seu código (adição de botões, etc.)

        anotacaoPanel.setLayout(new BoxLayout(anotacaoPanel, BoxLayout.Y_AXIS));
        anotacaoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // Resto do seu código (listeners, adição de componentes, etc.)

        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.add(buttonPanel);
        contentPanel.add(anotacaoPanel);

        add(contentPanel, BorderLayout.CENTER);

        setTitle("Aplicativo de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnotacoesAppGUI::new);
    }
}