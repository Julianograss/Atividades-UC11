import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class atividade1 {
    public static void main(String[] args) {
    // --- 1. CONFIGURAÇÃO DE ESTILOS (CORES E FONTES) ---
        Font fontePrincipal = new Font("Arial", Font.BOLD, 14);
        Font fonteBotoes = new Font("Tahoma", Font.BOLD, 18);
        Color corFundoJanela = new Color(240, 240, 240); // Cinza claro
        Color corResultado = new Color(255, 255, 200); // Amarelo suave
        // --- 2. CONFIGURAÇÃO DA JANELA ---
        JFrame janela = new JFrame("Calculadora Completa - TDS");
        janela.setSize(400, 450);
        janela.setLayout(null);
        janela.getContentPane().setBackground(corFundoJanela);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // --- 3. COMPONENTES ---
        JLabel lblNum1 = new JLabel("Número 1:");
        lblNum1.setBounds(30, 30, 100, 25);
        lblNum1.setFont(fontePrincipal);
        janela.add(lblNum1);
        JTextField txtNum1 = new JTextField();
        txtNum1.setBounds(130, 30, 150, 30);
        janela.add(txtNum1);

        JLabel lblNum2 = new JLabel("Número 2:");
        lblNum2.setBounds(30, 70, 100, 25);
        lblNum2.setFont(fontePrincipal);
        janela.add(lblNum2);
        JTextField txtNum2 = new JTextField();
        txtNum2.setBounds(130, 70, 150, 30);
        janela.add(txtNum2);
        
        // Botões de Operação
        JButton btnSoma = new JButton("+");
        btnSoma.setBounds(50, 130, 60, 50);
        btnSoma.setFont(fonteBotoes);
        btnSoma.setBackground(Color.LIGHT_GRAY); // Azul claro
        janela.add(btnSoma);
        JButton btnSub = new JButton("-");
        btnSub.setBounds(120, 130, 60, 50);
        btnSub.setFont(fonteBotoes);
        btnSub.setBackground(Color.LIGHT_GRAY);
        janela.add(btnSub);
        JButton btnMult = new JButton("*");
        btnMult.setBounds(190, 130, 60, 50);
        btnMult.setFont(fonteBotoes);
        btnMult.setBackground(Color.LIGHT_GRAY);
        janela.add(btnMult);
        JButton btnDiv = new JButton("/");
        btnDiv.setBounds(260, 130, 60, 50);
        btnDiv.setFont(fonteBotoes);
        btnDiv.setBackground(Color.LIGHT_GRAY);
        janela.add(btnDiv);
        // Resultado
        JLabel lblRes = new JLabel("RESULTADO:");
        lblRes.setBounds(30, 210, 120, 25);
        lblRes.setFont(fontePrincipal);
        janela.add(lblRes);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(130, 210, 150, 35);
        txtResultado.setFont(new Font("Arial", Font.BOLD, 18));
        txtResultado.setEditable(false);
        txtResultado.setBackground(corResultado); // Aplicando a cor de destaque
        txtResultado.setForeground(Color.BLUE); // Texto em azul
        janela.add(txtResultado);
        // --- 4. LÓGICA DE EVENTOS ---
        ActionListener calcular = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(txtNum1.getText());
                    double n2 = Double.parseDouble(txtNum2.getText());
                    double resultado = 0;
                    String op = ((JButton)e.getSource()).getText();
                    if (op.equals("+")) resultado = n1 + n2;
                    else if (op.equals("-")) resultado = n1 - n2;
                    else if (op.equals("*")) resultado = n1 * n2;
                    else if (op.equals("/")) {
                    if (n2 == 0) {
                    JOptionPane.showMessageDialog(janela, "Erro: Divisão por zero!");
                    return;
                    }
                    resultado = n1 / n2;
                    }
                    txtResultado.setText(String.format("%.2f", resultado));
                }    
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Por favor, insira apenas números!");
                }
            }
        };
        // Adicionando o Listener aos botões
        btnSoma.addActionListener(calcular);
        btnSub.addActionListener(calcular);
        btnMult.addActionListener(calcular);
        btnDiv.addActionListener(calcular);
        janela.setVisible(true);
    }
}
