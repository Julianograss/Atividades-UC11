import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalculadoraTDS_V2 {
    // Variáveis Globais para a lógica
    static String valorAcumulado = "";
    static double num1 = 0, num2 = 0;
    static String operacao = "";
    public static void main(String[] args) {
        JFrame janela = new JFrame("Calculadora TDS - Nível 2");
        janela.setSize(300, 450);
        janela.setLayout(null);
        janela.getContentPane().setBackground(new Color(50, 50, 50)); // Fundo Escuro
        // --- VISOR ---
        JTextField visor = new JTextField();
        visor.setBounds(20, 20, 245, 60);
        visor.setFont(new Font("Monospaced", Font.BOLD, 28));
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setEditable(false);
        visor.setBackground(Color.BLACK);
        visor.setForeground(Color.GREEN); // Estilo Matrix/Retrô
        janela.add(visor);
        // --- FONTES E CORES ---
        Font fonteBotoes = new Font("Arial", Font.BOLD, 18);
        Color corBotoesNum = new Color(80, 80, 80);
        Color corBotoesOp = new Color(255, 140, 0); // Laranja
        // --- LÓGICA DOS NÚMEROS ---
        ActionListener cliqueNumero = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String textoBotao = ((JButton)e.getSource()).getText();
        valorAcumulado += textoBotao;
        visor.setText(valorAcumulado);
        }
        };
        // --- LÓGICA DAS OPERAÇÕES ---
        ActionListener cliqueOperacao = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        num1 = Double.parseDouble(visor.getText());
        operacao = ((JButton)e.getSource()).getText();
        valorAcumulado = ""; // Limpa para o próximo número
        visor.setText("");
        }
        };
        // --- LÓGICA DO IGUAL (=) ---
        ActionListener cliqueIgual = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        num2 = Double.parseDouble(visor.getText());
        double resultado = 0;
        if (operacao.equals("+")) resultado = num1 + num2;
        else if (operacao.equals("-")) resultado = num1 - num2;
        else if (operacao.equals("*")) resultado = num1 * num2;
        else if (operacao.equals("/")) resultado = num1 / num2;
        visor.setText(String.valueOf(resultado));
        valorAcumulado = ""; // Reseta a string para novos cálculos
        }
        };
        // --- CRIAÇÃO DOS BOTÕES (Exemplo de uma linha) ---
        // Alunos: Repitam o processo para criar os botões de 0 a 9 e as operações
        JButton btn7 = new JButton("7");
        btn7.setBounds(20, 100, 55, 55);
        btn7.setFont(fonteBotoes);
        btn7.addActionListener(cliqueNumero);
        janela.add(btn7);
        JButton btn8 = new JButton("8");
        btn8.setBounds(85, 100, 55, 55);
        btn8.setFont(fonteBotoes);
        btn8.addActionListener(cliqueNumero);
        janela.add(btn8);
        JButton btnSoma = new JButton("+");
        btnSoma.setBounds(210, 100, 55, 55);
        btnSoma.setBackground(corBotoesOp);
        btnSoma.addActionListener(cliqueOperacao);
        janela.add(btnSoma);
        JButton btnIgual = new JButton("=");
        btnIgual.setBounds(210, 295, 55, 55);
        btnIgual.setBackground(Color.CYAN);
        btnIgual.addActionListener(cliqueIgual);
        janela.add(btnIgual);
        // --- BOTÃO LIMPAR (C) ---
        JButton btnLimpar = new JButton("C");
        btnLimpar.setBounds(20, 295, 55, 55);
        btnLimpar.addActionListener(e -> {
        valorAcumulado = "";
        visor.setText("");
        });
        janela.add(btnLimpar);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}