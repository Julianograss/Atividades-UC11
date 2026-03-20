import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class atividade2 {
    static String valorAcumulado = "";
    static double num1 = 0, num2 = 0;
    static String operacao = "";
    static String valorMostrado = "";

    public static void main(String[] args) {
        Font fonteBotoes = new Font("Arial", 1, 14);
        Font fontePrincipal = new Font("Times New Roman", 1, 14);
        Color corOperacoes = new Color(255, 182, 104);
        

        JFrame janela = new JFrame("Calculadora");
        janela.setSize(800, 550);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(Color.DARK_GRAY);
        janela.setLocationRelativeTo(null);

        JTextField visor = new JTextField();
        visor.setBounds(15, 20, 350, 60);
        visor.setFont(new Font("Monospaced", Font.BOLD, 28));
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setEditable(false);
        visor.setBackground(Color.BLACK);
        visor.setForeground(Color.GREEN);
        janela.add(visor);

        JTextField calculo = new JTextField();

        ActionListener cliqueNumero = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoBotao = ((JButton)e.getSource()).getText();
                valorAcumulado += textoBotao;
                valorMostrado += textoBotao;
                visor.setText(valorMostrado);
                calculo.setText(valorAcumulado);
                }
        };

        ActionListener cliqueOperacao = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(calculo.getText());
                operacao = ((JButton)e.getSource()).getText();
                valorAcumulado = "";
                valorMostrado = valorMostrado+operacao;
                visor.setText(valorMostrado);
            }
        };

        ActionListener cliqueIgual = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(calculo.getText());
                double resultado = 0;
                if (operacao.equals("+")) resultado = num1 + num2;
                else if (operacao.equals("-")) resultado = num1 - num2;
                else if (operacao.equals("*")) resultado = num1 * num2;
                else if (operacao.equals("/")) resultado = num1 / num2;
                visor.setText(valorMostrado+"="+(String.valueOf(resultado)));
                valorAcumulado = ""; 
            }
        };


        JButton btnSoma = new JButton("+");
        btnSoma.setBounds(290, 100, 75, 75);
        btnSoma.setFont(fonteBotoes);
        btnSoma.setBackground(corOperacoes);
        btnSoma.addActionListener(cliqueOperacao);
        janela.add(btnSoma);
        JButton btnSub = new JButton("-");
        btnSub.setBounds(290, 200, 75, 75);
        btnSub.setFont(fonteBotoes);
        btnSub.setBackground(corOperacoes);
        btnSub.addActionListener(cliqueOperacao);
        janela.add(btnSub);
        JButton btnMult = new JButton("*");
        btnMult.setBounds(290, 300, 75, 75);
        btnMult.setFont(fonteBotoes);
        btnMult.setBackground(corOperacoes);
        btnMult.addActionListener(cliqueOperacao);
        janela.add(btnMult);
        JButton btnDiv = new JButton("/");
        btnDiv.setBounds(290, 400, 75, 75);
        btnDiv.setFont(fonteBotoes);
        btnDiv.setBackground(corOperacoes);
        btnDiv.addActionListener(cliqueOperacao);
        janela.add(btnDiv);
        
        JButton btnn1 = new JButton("1");
        btnn1.setBounds(15, 300, 75, 75);
        btnn1.setFont(fonteBotoes);
        btnn1.setBackground(Color.LIGHT_GRAY);
        btnn1.addActionListener(cliqueNumero);
        janela.add(btnn1);

        JButton btnn2 = new JButton("2");
        btnn2.setBounds(105, 300, 75, 75);
        btnn2.setFont(fonteBotoes);
        btnn2.setBackground(Color.LIGHT_GRAY);
        btnn2.addActionListener(cliqueNumero);
        janela.add(btnn2);

        JButton btnn3 = new JButton("3");
        btnn3.setBounds(195, 300, 75, 75);
        btnn3.setFont(fonteBotoes);
        btnn3.setBackground(Color.LIGHT_GRAY);
        btnn3.addActionListener(cliqueNumero);
        janela.add(btnn3);

        JButton btnn4 = new JButton("4");
        btnn4.setBounds(195, 200, 75, 75);
        btnn4.setFont(fonteBotoes);
        btnn4.setBackground(Color.LIGHT_GRAY);
        btnn4.addActionListener(cliqueNumero);
        janela.add(btnn4);

        JButton btnn5 = new JButton("5");
        btnn5.setBounds(105, 200, 75, 75);
        btnn5.setFont(fonteBotoes);
        btnn5.setBackground(Color.LIGHT_GRAY);
        btnn5.addActionListener(cliqueNumero);
        janela.add(btnn5);

        JButton btnn6 = new JButton("6");
        btnn6.setBounds(15, 200, 75, 75);
        btnn6.setFont(fonteBotoes);
        btnn6.setBackground(Color.LIGHT_GRAY);
        btnn6.addActionListener(cliqueNumero);
        janela.add(btnn6);

        JButton btnn7 = new JButton("7");
        btnn7.setBounds(15, 100, 75, 75);
        btnn7.setFont(fonteBotoes);
        btnn7.setBackground(Color.LIGHT_GRAY);
        btnn7.addActionListener(cliqueNumero);
        janela.add(btnn7);

        JButton btnn8 = new JButton("8");
        btnn8.setBounds(105, 100, 75, 75);
        btnn8.setFont(fonteBotoes);
        btnn8.setBackground(Color.LIGHT_GRAY);
        btnn8.addActionListener(cliqueNumero);
        janela.add(btnn8);

        JButton btnn9 = new JButton("9");
        btnn9.setBounds(195, 100, 75, 75);
        btnn9.setFont(fonteBotoes);
        btnn9.setBackground(Color.LIGHT_GRAY);
        btnn9.addActionListener(cliqueNumero);
        janela.add(btnn9);

        JButton btnn0 = new JButton("0");
        btnn0.setBounds(105, 400, 75, 75);
        btnn0.setFont(fonteBotoes);
        btnn0.setBackground(Color.LIGHT_GRAY);
        btnn0.addActionListener(cliqueNumero);
        janela.add(btnn0);

        JButton btnIgual = new JButton("=");
        btnIgual.setBounds(195, 400, 75, 75);
        btnIgual.setFont(fonteBotoes);
        btnIgual.setBackground(new Color(144, 238, 144));
        janela.add(btnIgual);
        btnIgual.addActionListener(cliqueIgual);
        janela.add(btnIgual);


        JButton btnLimpar = new JButton("C");
        btnLimpar.setBounds(15, 400, 75, 75);
        btnLimpar.setFont(fonteBotoes);
        btnLimpar.setBackground(new Color(255, 127, 127));
        janela.add(btnLimpar);
        btnLimpar.addActionListener(e -> {
        valorAcumulado = "";
        valorMostrado = "";
        visor.setText("");
        });

        janela.setVisible(true);
    }
}
