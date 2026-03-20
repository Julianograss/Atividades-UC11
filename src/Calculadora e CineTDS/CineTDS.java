import java.awt.*;
import javax.swing.*;
public class CineTDS {
    public static void main(String[] args) {
        // 1. Janela Principal
        JFrame janela = new JFrame("CineTDS - Seu Catálogo de Filmes");
        janela.setSize(800, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(20, 20, 20)); // Fundo "Dark Mode"
        janela.setLocationRelativeTo(null);
        janela.setLayout(null);
        // 2. Título do Aplicativo
        JLabel lblTitulo = new JLabel("CineTDS");
        lblTitulo.setBounds(30, 20, 200, 40);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setForeground(Color.RED);
        janela.add(lblTitulo);
        // 3. Campo de Busca
        JTextField txtBusca = new JTextField("Pesquisar filme...");
        txtBusca.setBounds(500, 30, 250, 30);
        janela.add(txtBusca);
        // 4. Criando um Card de Filme (Exemplo)
        // O aluno deve repetir este bloco para criar mais filmes
        JPanel cardFilme1 = new JPanel();
        cardFilme1.setBounds(30, 100, 160, 280);
        cardFilme1.setBackground(new Color(40, 40, 40));
        cardFilme1.setLayout(null);
        JPanel cardFilme2 = new JPanel();
        cardFilme2.setBounds(215, 100, 160, 280);
        cardFilme2.setBackground(new Color(40, 40, 40));
        cardFilme2.setLayout(null);
        JPanel cardFilme3 = new JPanel();
        cardFilme3.setBounds(400, 100, 160, 280);
        cardFilme3.setBackground(new Color(40, 40, 40));
        cardFilme3.setLayout(null);
        JPanel cardFilme4 = new JPanel();
        cardFilme4.setBounds(585, 100, 160, 280);
        cardFilme4.setBackground(new Color(40, 40, 40));
        cardFilme4.setLayout(null);
        // --- IMAGEM DO FILME ---
        //imagem 1
        JLabel lblPoster = new JLabel();
        lblPoster.setBounds(5, 5, 150, 200);
        lblPoster.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        // Lógica para carregar e redimensionar imagem
        try {
            ImageIcon iconeOriginal = new ImageIcon("src/res/img1.png"); // Nome do arquivo
            Image img = iconeOriginal.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            lblPoster.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblPoster.setText("Sem Imagem");
            lblPoster.setForeground(Color.WHITE);
        }
        cardFilme1.add(lblPoster);
        //imagem 2
        JLabel lblPoster2 = new JLabel();
        lblPoster2.setBounds(5, 5, 150, 200);
        lblPoster2.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        try {
            ImageIcon iconeOriginal2 = new ImageIcon("src/res/img2.png"); // Nome do arquivo
            Image img2 = iconeOriginal2.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            lblPoster2.setIcon(new ImageIcon(img2));
        } catch (Exception e) {
            lblPoster2.setText("Sem Imagem");
            lblPoster2.setForeground(Color.WHITE);
        }
        cardFilme2.add(lblPoster2);
        //imagem 3
        JLabel lblPoster3 = new JLabel();
        lblPoster3.setBounds(5, 5, 150, 200);
        lblPoster3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
  
        try {
            ImageIcon iconeOriginal3 = new ImageIcon("src/res/img3.png"); // Nome do arquivo
            Image img3 = iconeOriginal3.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            lblPoster3.setIcon(new ImageIcon(img3));
        } catch (Exception e) {
            lblPoster3.setText("Sem Imagem");
            lblPoster3.setForeground(Color.WHITE);
        }
        cardFilme3.add(lblPoster3);

        //imagem 4
        JLabel lblPoster4 = new JLabel();
        lblPoster4.setBounds(5, 5, 150, 200);
        lblPoster4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
  
        try {
            ImageIcon iconeOriginal4 = new ImageIcon("src/res/img4.jpg"); // Nome do arquivo
            Image img4 = iconeOriginal4.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            lblPoster4.setIcon(new ImageIcon(img4));
        } catch (Exception e) {
            lblPoster4.setText("Sem Imagem");
            lblPoster4.setForeground(Color.WHITE);
        }
        cardFilme4.add(lblPoster4);

        // --- TÍTULO E BOTÃO ---
        JLabel lblNomeFilme = new JLabel("O Programador");
        lblNomeFilme.setBounds(5, 210, 150, 25);
        lblNomeFilme.setForeground(Color.WHITE);
        lblNomeFilme.setFont(new Font("Arial", Font.BOLD, 14));
        cardFilme1.add(lblNomeFilme);
        JButton btnAssistir = new JButton("Detalhes");
        btnAssistir.setBounds(5, 240, 150, 30);
        btnAssistir.setBackground(Color.RED);
        btnAssistir.setForeground(Color.WHITE);
        btnAssistir.setFocusPainted(false);
        btnAssistir.addActionListener(e -> {
            JOptionPane.showMessageDialog(janela,
            "Sinopse: Um desenvolvedor Java que descobre que o café é infinito.",
            "Detalhes do Filme",
            JOptionPane.INFORMATION_MESSAGE);
        });
        //titulo 2
        JLabel lblNomeFilme2 = new JLabel("A origem do Python");
        lblNomeFilme2.setBounds(5, 210, 150, 25);
        lblNomeFilme2.setForeground(Color.WHITE);
        lblNomeFilme2.setFont(new Font("Arial", Font.BOLD, 14));
        cardFilme2.add(lblNomeFilme2);
        JButton btnAssistir2 = new JButton("Detalhes");
        btnAssistir2.setBounds(5, 240, 150, 30);
        btnAssistir2.setBackground(Color.RED);
        btnAssistir2.setForeground(Color.WHITE);
        btnAssistir2.setFocusPainted(false);
        btnAssistir2.addActionListener(e -> {
            JOptionPane.showMessageDialog(janela,
            "Sinopse: Onde tudo começou para o Python.",
            "Detalhes do Filme",
            JOptionPane.INFORMATION_MESSAGE);
        });
        //titulo 3
        JLabel lblNomeFilme3 = new JLabel("Clean code: O filme");
        lblNomeFilme3.setBounds(5, 210, 150, 25);
        lblNomeFilme3.setForeground(Color.WHITE);
        lblNomeFilme3.setFont(new Font("Arial", Font.BOLD, 14));
        cardFilme3.add(lblNomeFilme3);
        JButton btnAssistir3 = new JButton("Detalhes");
        btnAssistir3.setBounds(5, 240, 150, 30);
        btnAssistir3.setBackground(Color.RED);
        btnAssistir3.setForeground(Color.WHITE);
        btnAssistir3.setFocusPainted(false);
        btnAssistir3.addActionListener(e -> {
            JOptionPane.showMessageDialog(janela,
            "Sinopse: Codigo limpo versão filme",
            "Detalhes do Filme",
            JOptionPane.INFORMATION_MESSAGE);
        });
        //titulo 4
        JLabel lblNomeFilme4 = new JLabel("Hellraiser");
        lblNomeFilme4.setBounds(5, 210, 150, 25);
        lblNomeFilme4.setForeground(Color.WHITE);
        lblNomeFilme4.setFont(new Font("Arial", Font.BOLD, 14));
        cardFilme4.add(lblNomeFilme4);
        JButton btnAssistir4 = new JButton("Detalhes");
        btnAssistir4.setBounds(5, 240, 150, 30);
        btnAssistir4.setBackground(Color.RED);
        btnAssistir4.setForeground(Color.WHITE);
        btnAssistir4.setFocusPainted(false);
        btnAssistir4.addActionListener(e -> {
            JOptionPane.showMessageDialog(janela,
            "Sinopse: segue Frank Cotton, um viciado em prazeres que abre uma caixa mágica misteriosa e é despedaçado por Cenobitas",
            "Detalhes do Filme",
            JOptionPane.INFORMATION_MESSAGE);
        });

        //JScrollPane scrollPane = new JScrollPane();

        cardFilme1.add(btnAssistir);
        cardFilme2.add(btnAssistir2);
        cardFilme3.add(btnAssistir3);
        cardFilme4.add(btnAssistir4);
        
        // Adiciona o card na janela
        janela.add(cardFilme1);
        janela.add(cardFilme2);
        janela.add(cardFilme3);
        janela.add(cardFilme4);
        //janela.add(scrollPane);
        janela.setVisible(true);
    }
}