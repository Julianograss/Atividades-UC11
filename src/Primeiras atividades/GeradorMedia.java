import java.awt.event.*;
import javax.swing.*;
public class GeradorMedia {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Entrada de dados - TDS");
        janela.setSize(1000,500);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbln1 = new JLabel("Digite a primeira nota: ");
        lbln1.setBounds(20, 20, 150, 25);
        janela.add(lbln1);
        JTextField txtn1 = new JTextField();
        txtn1.setBounds(200,20,200,25);
        janela.add(txtn1);

        JLabel lbln2 = new JLabel("Digite a segunda nota: ");
        lbln2.setBounds(20, 60, 150, 25);
        janela.add(lbln2);
        JTextField txtn2 = new JTextField();
        txtn2.setBounds(200,60,200,25);
        janela.add(txtn2);

        JButton btnResultado = new JButton("Gerar Resultado");
        btnResultado.setBounds(120,120,150,40);
        janela.add(btnResultado);

        btnResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nota1 = txtn1.getText();
                String nota2 = txtn2.getText();

                double n1 = Double.parseDouble(nota1);
                double n2 = Double.parseDouble(nota2);

                double media = (n1+n2)/2;
                String res = "";

                if (media >= 7)
                    res = "Aprovado";
                else
                    res = "Reprovado";
                JOptionPane.showMessageDialog(janela,"Media final: "+media+"\nSituação: "+res);
            }
        });
        








        /*JLabel lblNome = new JLabel("Digite seu nome: ");
        lblNome.setBounds(20,20,150,25);
        janela.add(lblNome);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(150,20,200,25);
        janela.add(txtNome);

        JLabel lblIdade = new JLabel("Digite sua idade:");
        lblIdade.setBounds(20, 60, 150, 25);
        janela.add(lblIdade);
        JTextField txtIdade = new JTextField();
        txtIdade.setBounds(150, 60, 50, 25);
        janela.add(txtIdade);

        JButton btnCalcular = new JButton("Processar Dados");
        btnCalcular.setBounds(120,120,150,40);
        janela.add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                String nome = txtNome.getText();
                String textoidade = txtIdade.getText();

                int idade = Integer.parseInt(textoidade);
                int diasVividos = idade*365;

                JOptionPane.showMessageDialog(janela,"Olá " +nome+"\nVocê já viveu aproximadamente "+diasVividos+" dias");
            }
        });
        */
        janela.setVisible(true);
       }
}
