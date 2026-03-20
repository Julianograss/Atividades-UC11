package teste;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

// --- MODELO DE DADOS ---
class Produto {
    String nome;
    double preco;
    public Produto(String nome, double preco) { this.nome = nome; this.preco = preco; }
}

// --- INTERFACE PRINCIPAL ---
public class PDVCompleto extends JFrame {
    private JTextField txtCodigo;
    private JTable tblItens;
    private DefaultTableModel modelo;
    private JLabel lblTotal;
    private HashMap<String, Produto> bancoFake;

    public PDVCompleto() {
        inicializarBanco();
        configurarJanela();
        configurarAtalhos();
    }

    private void inicializarBanco() {
        bancoFake = new HashMap<>();
        bancoFake.put("123", new Produto("Arroz 5kg", 25.50));
        bancoFake.put("456", new Produto("Feijão 1kg", 8.90));
        bancoFake.put("789", new Produto("Coca-Cola 2L", 12.00));
    }

    private void configurarJanela() {
        setTitle("TDS - Frente de Caixa (PDV)");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Tabela de Itens
        String[] colunas = {"Cód", "Descrição", "Qtd", "V. Unit", "Total"};
        modelo = new DefaultTableModel(colunas, 0);
        tblItens = new JTable(modelo);
        add(new JScrollPane(tblItens), BorderLayout.CENTER);

        // Painel Lateral de Entrada
        JPanel pnlLateral = new JPanel(new GridBagLayout());
        pnlLateral.setPreferredSize(new Dimension(300, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtCodigo = new JTextField();
        txtCodigo.setFont(new Font("Arial", Font.BOLD, 18));
        txtCodigo.setBorder(BorderFactory.createTitledBorder("CÓDIGO (Enter)"));
        txtCodigo.addActionListener(e -> adicionarItem());

        lblTotal = new JLabel("R$ 0,00", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("Monospaced", Font.BOLD, 45));
        lblTotal.setForeground(new Color(0, 153, 51));
        lblTotal.setBorder(BorderFactory.createTitledBorder("TOTAL"));

        gbc.gridy = 0; pnlLateral.add(txtCodigo, gbc);
        gbc.gridy = 1; pnlLateral.add(lblTotal, gbc);
        
        JTextArea dicas = new JTextArea("\nF1: Finalizar\nF2: Cancelar Item\nF3: Sangria");
        dicas.setEditable(false);
        dicas.setBackground(getBackground());
        gbc.gridy = 2; pnlLateral.add(dicas, gbc);

        add(pnlLateral, BorderLayout.EAST);
    }

    private void adicionarItem() {
        Produto p = bancoFake.get(txtCodigo.getText());
        if (p != null) {
            modelo.addRow(new Object[]{txtCodigo.getText(), p.nome, 1, p.preco, p.preco});
            atualizarTotal();
            txtCodigo.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        }
    }

    private void atualizarTotal() {
        double soma = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            soma += (double) modelo.getValueAt(i, 4);
        }
        lblTotal.setText(String.format("R$ %.2f", soma));
    }

    private void configurarAtalhos() {
        InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("F1"), "finalizar");
        am.put("finalizar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Venda Finalizada com Sucesso!");
                modelo.setRowCount(0);
                atualizarTotal();
            }
        });

        im.put(KeyStroke.getKeyStroke("F2"), "cancelar");
        am.put("cancelar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String senha = JOptionPane.showInputDialog("Senha do Gerente para cancelar:");
                if("admin".equals(senha) && tblItens.getSelectedRow() != -1) {
                    modelo.removeRow(tblItens.getSelectedRow());
                    atualizarTotal();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PDVCompleto().setVisible(true));
    }
}