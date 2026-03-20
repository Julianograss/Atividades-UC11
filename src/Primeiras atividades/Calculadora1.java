import java.awt.event.*;
import javax.swing.*; 
import java.awt.*;

public class atividade3 {
    public static void main(String[] args) {
        /*import java.awt.event.*;
        import javax.swing.*; 
        import java.awt.*; */
        JFrame janela = new JFrame("Calculadora teste");
        janela.setSize(500,800);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbln1 = new JLabel("Digite o primeiro numero: ");
        lbln1.setBounds(10, 10, 200, 25);
        janela.add(lbln1);
        JTextField txtn1 = new JTextField();
        txtn1.setBounds(10,30,200,25);
        janela.add(txtn1);

        JLabel lbln2 = new JLabel("Digite o segundo numero: ");
        lbln2.setBounds(10, 60, 200, 25);
        janela.add(lbln2);
        JTextField txtn2 = new JTextField();
        txtn2.setBounds(10,80,200,25);
        janela.add(txtn2);

        JLabel lbltexto = new JLabel("Escolha a operação!");
        lbltexto.setBounds(10, 100, 300, 50);
        janela.add(lbltexto);

        JButton btnMais = new JButton("1) Soma (+)");
        btnMais.setBounds(10, 150, 150, 50);
        janela.add(btnMais);

        btnMais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

            }
        });

        JButton btnMenos = new JButton("2) Subtração (-)");
        btnMenos.setBounds(10, 200, 150, 50);
        janela.add(btnMenos);

        JButton btnMultiplicação = new JButton("3) Multiplicação (*)");
        btnMultiplicação.setBounds(10, 250, 150, 50);
        janela.add(btnMultiplicação);

        JButton btnDivisão = new JButton("4) Divisão (/)");
        btnDivisão.setBounds(10, 300, 150, 50);
        janela.add(btnDivisão);

        janela.setVisible(true);
    }
}
