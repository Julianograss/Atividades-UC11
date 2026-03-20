import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PrimeiraJanela {
    public static void main(String[] args) {
        // 1. Criar o container principal (Janela)
        JFrame janela = new JFrame("Primeira aula com java swing");
        janela.setSize(300, 200);
        janela.setLayout(null); // Layout livre para posicionar o botão manualmente
        //janela.setBackground(new Color(200, 300, 400));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 2. Criar o botão
        JButton botao = new JButton("Clique aqui!");
            botao.setBounds(75, 60, 150, 40); // x, y, largura, altura
            // 3. Adicionar a ação ao botão (O que acontece ao clicar)
            botao.setBackground(Color.GREEN);
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(janela, "teste");
                }
            }
            );
        JButton botao2 = new JButton("Fechar janela!");
            botao2.setBounds(75, 20, 150, 40);
            botao2.setBackground(Color.RED);
            botao2.addActionListener(e -> {
                System.exit(0);
            }
        );
        // 4. Adicionar o botão na janela e tornar visível
        janela.add(botao);
        janela.add(botao2);
        janela.setVisible(true);
    }
}