import java.awt.*;
import javax.swing.*;
public class CineTDSV2 {
    private static int contador = 0;
    public JLabel lblSecaoAtual = new JLabel();
    public JButton clicado;
    
    public void janelaPrincipal(){
        // 1. Janela Principal
        JFrame janela = new JFrame("CineTDS - Streaming");
        janela.setSize(900, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null); 
        janela.setLocationRelativeTo(null);// Layout nulo para posicionar os grandes blocos
        // --- 2. PAINEL LATERAL (GÊNEROS) ---
        JPanel pnlGeneros = new JPanel();
        pnlGeneros.setBounds(0, 0, 200, 600);
        pnlGeneros.setBackground(new Color(30, 30, 30));
        pnlGeneros.setLayout(null);
        janela.add(pnlGeneros);
        JLabel lblMenu = new JLabel("GÊNEROS");
        lblMenu.setForeground(Color.GRAY);
        lblMenu.setFont(new Font("Arial", Font.BOLD, 14));
        lblMenu.setBounds(20, 30, 100, 25);
        pnlGeneros.add(lblMenu);

        lblSecaoAtual.setForeground(Color.WHITE);
        lblSecaoAtual.setFont(new Font("Arial", Font.BOLD, 14));
        lblSecaoAtual.setBounds(20, 10, 200, 25);
        // Exemplo de botão de gênero para os alunos replicarem
        String[] generos = {"Home", "Ação", "Comédia", "Drama", "Terror", "Ficção"};
        for (int i = 0; i < generos.length; i++) {
            JButton btnG = new JButton(generos[i]);
            btnG.setBounds(0, 70 + (i * 40), 200, 35);
            btnG.setForeground(Color.WHITE);
            btnG.setBackground(new Color(30, 30, 30));
            btnG.setBorderPainted(false);
            btnG.setFocusPainted(false);
            btnG.setHorizontalAlignment(SwingConstants.LEFT);
            pnlGeneros.add(btnG);
            
            btnG.addActionListener(e -> {
                // Reseta todos os botões para a cor padrão primeiro
                clicado = (JButton)e.getSource();
                clicado.setBackground(Color.RED);
                for (int j = 0; j < generos.length; j++){
                    clicado = (JButton)e.getSource();
                    clicado.setBackground(new Color(30, 30, 30));
                    lblSecaoAtual.setText("Filmes de: " + clicado.getText());
                }
                // (Pode ser feito com um loop ou variáveis)
                pnlGeneros.add(lblSecaoAtual);
            });    
        }
        // --- 3. PAINEL DE CONTEÚDO (ONDE FICAM OS FILMES) ---
        // Este painel precisa ser alto (ex: 1200px) para a barra de rolagem aparecer
        JPanel pnlFilmes = new JPanel();
        pnlFilmes.setLayout(null);
        pnlFilmes.setPreferredSize(new Dimension(650, 1200)); // Altura maior que a janela
        pnlFilmes.setBackground(new Color(20, 20, 20));
        // --- 4. BARRA DE ROLAGEM (JScrollPane) ---
        JScrollPane scroll = new JScrollPane(pnlFilmes);
        scroll.setBounds(200, 0, 685, 560); // Posicionado ao lado da barra lateral
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        janela.add(scroll);
        // --- 5. ADICIONANDO UM FILME DE EXEMPLO NO PAINEL DE FILMES ---
        // Os alunos devem replicar este bloco mudando o 'y' para descer a página
        JPanel card1 = criarCardFilme("Matrix", "A realidade é uma simulação.", 30, 80);
        pnlFilmes.add(card1);
        JPanel card2 = criarCardFilme("Inception", "Sonhos dentro de sonhos.", 230, 80);
        pnlFilmes.add(card2);
        // Exemplo de filme posicionado mais abaixo para testar o Scroll
        JPanel card3 = criarCardFilme("Java: O Filme", "Um café, um bug.", 30, 450);
        pnlFilmes.add(card3);

        JLabel contadorFilmes = new JLabel("Exibindo "+contador+" filmes de "+generos[1]);
        contadorFilmes.setForeground(Color.WHITE);
        contadorFilmes.setFont(new Font("Arial", Font.BOLD, 14));
        contadorFilmes.setBounds(10, 10, 200, 25);
        pnlFilmes.add(contadorFilmes);
        
        janela.setVisible(true);
    }
        
    // Método auxiliar para os alunos não precisarem repetir tanto código
    public static JPanel criarCardFilme(String titulo, String sinopse, int x, int y) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(x, y, 180, 300);
        card.setBackground(new Color(45, 45, 45));
        JLabel lblImg = new JLabel("POSTER", SwingConstants.CENTER);
        lblImg.setBounds(10, 10, 160, 220);
        lblImg.setForeground(Color.LIGHT_GRAY);
        lblImg.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        card.add(lblImg);
        JLabel lblT = new JLabel(titulo);
        lblT.setBounds(10, 240, 160, 20);
        lblT.setForeground(Color.WHITE);
        card.add(lblT);
        JButton btn = new JButton("Ver");
        btn.setBounds(10, 265, 160, 25);
        btn.addActionListener(e -> JOptionPane.showMessageDialog(null, sinopse));
        card.add(btn);
        contador++;
        return card;
    }
    public static int getContagem() {
        return contador;
    }
    public static void main(String[] args) {
        CineTDSV2 exibir = new CineTDSV2();
        exibir.janelaPrincipal();
    }
}
