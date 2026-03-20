package atividade1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FliperamaTDS {

    static JLabel lblTituloJogo;
    static JLabel lblDescricao;
    static JPanel pnlPreview;
    static JLabel lblCapaJogo;
        public void janelaArcade(){
            JFrame janela = new JFrame("TDS ARCADE STATION");
            janela.setSize(1000, 600);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setLayout(new BorderLayout());
            janela.setLocationRelativeTo(null);
            janela.getContentPane().setBackground(Color.BLACK);
            // --- 1. CABEÇALHO NEON ---
            JLabel lblHeader = new JLabel("ARCADE MULTIGAMES", SwingConstants.CENTER);
            lblHeader.setFont(new Font("Monospaced", Font.BOLD, 40));
            lblHeader.setForeground(new Color(0, 255, 255)); // Ciano Neon
            lblHeader.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
            janela.add(lblHeader, BorderLayout.NORTH);
            // --- 2. GRADE DE JOGOS (CENTRO) ---
            JPanel pnlJogos = new JPanel(new GridLayout(0, 3, 25, 25));
            pnlJogos.setBackground(Color.BLACK);
            pnlJogos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            // Lista de jogos para o fliperama
            String[] jogos = {"PAC-MAN", "SPACE INVADERS", "SNAKE TDS", "TETRIS", "PONG",
            "STREET JAVA"};

            for (String jogo : jogos) {
                JButton btnJogo = criarBotaoArcade(jogo);

                // Ação ao clicar: Muda o preview lateral
                btnJogo.addActionListener(e -> atualizarPreview(jogo));

                pnlJogos.add(btnJogo);
            }
            JScrollPane scroll = new JScrollPane(pnlJogos);
            scroll.setBorder(null);
            scroll.getViewport().setBackground(Color.BLACK);
            janela.add(scroll, BorderLayout.CENTER);
            // --- 3. PAINEL DE PREVIEW (EAST) ---
            pnlPreview = new JPanel();
            pnlPreview.setPreferredSize(new Dimension(350, 0));
            pnlPreview.setBackground(new Color(20, 20, 20));
            pnlPreview.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
            pnlPreview.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 255), 2)); // BordaMagenta
            // Criamos o label para a imagem
            lblCapaJogo = new JLabel();
            lblCapaJogo.setPreferredSize(new Dimension(300, 200));
            lblCapaJogo.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            lblCapaJogo.setHorizontalAlignment(SwingConstants.CENTER);
            pnlPreview.add(lblCapaJogo); // Adiciona antes do título ou descrição
            lblTituloJogo = new JLabel("SELECIONE UM JOGO");
            lblTituloJogo.setFont(new Font("Monospaced", Font.BOLD, 22));
            lblTituloJogo.setForeground(Color.YELLOW);
            pnlPreview.add(lblTituloJogo);
            lblDescricao = new JLabel("<html><body style='text-align: center'>Aguardandoficha...<br>Pressione um botão para ver detalhes.</body></html>");
            lblDescricao.setForeground(Color.WHITE);
            lblDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
            pnlPreview.add(lblDescricao);
            JButton btnStart = new JButton("INSERT COIN / START");
            btnStart.setPreferredSize(new Dimension(250, 60));
            btnStart.setBackground(new Color(0, 255, 0));
            btnStart.setFont(new Font("Monospaced", Font.BOLD, 18));
            //btnStart.addActionListener(e -> JOptionPane.showMessageDialog(janela, "CARREGANDOJOGO... PREPARE-SE!"));
            pnlPreview.add(btnStart);
            btnStart.addActionListener(e -> {
                String verificado = lblTituloJogo.getText();
                switch (verificado) {
                    case "SNAKE TDS":
                        janela.setVisible(false);

                        JFrame janelaSnake = new JFrame("Snake game TDS");
                        JogoSnake1 jogosnake = new JogoSnake1();

                        janelaSnake.add(jogosnake);
                        janelaSnake.pack();
                        janelaSnake.setLocationRelativeTo(null);
                        janelaSnake.setVisible(true);
                        break;
                    case "PAC-MAN":
                        janela.setVisible(false);

                        JFrame janelaPacman = new JFrame("Pac-man TDS");
                        JogoPacman1 jogopacman = new JogoPacman1();

                        janelaPacman.add(jogopacman);
                        janelaPacman.pack();
                        janelaPacman.setLocationRelativeTo(null);
                        janelaPacman.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(janela, "Jogo em desenvolvimento!");
                }

            });
            janela.add(pnlPreview, BorderLayout.EAST);
            janela.setVisible(true);
        }
        // Estilização dos botões estilo Arcade
        public static JButton criarBotaoArcade(String nome) {
            JButton btn = new JButton(nome);
            btn.setFont(new Font("Monospaced", Font.BOLD, 20));
            btn.setBackground(new Color(40, 40, 40));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

            // Efeito de Hover (Opcional para os alunos desafiados)
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(80, 80, 80)); }
                @Override
                public void mouseExited(MouseEvent e) { btn.setBackground(new Color(40, 40, 40)); }
            });

            return btn;
        }
        public static void atualizarPreview(String jogo) {
            String caminhoImagem = "res/" + jogo + ".jpg"; 
            lblTituloJogo.setText(jogo);
            try {
                ImageIcon iconeOriginal = new ImageIcon(caminhoImagem);
                // Redimensiona a imagem para caber no preview (300x200)
                Image imgRedimensionada = iconeOriginal.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                lblCapaJogo.setIcon(new ImageIcon(imgRedimensionada));
                lblCapaJogo.setText(""); // Limpa o texto caso a imagem carregue
            } 
            catch (Exception e) {
                lblCapaJogo.setIcon(null);
                lblCapaJogo.setText("Imagem não encontrada");
            }

            switch(jogo) {
                case "PAC-MAN": lblDescricao.setText("<html>Coma todas as pastilhas e fuja dosfantasmas!</html>"); 
                break;
                case "TETRIS": lblDescricao.setText("<html>Encaixe as peças perfeitamente para eliminarlinhas.</html>"); 
                break;
                default: lblDescricao.setText("<html>Um clássico dos arcades disponível paravocê.</html>"); break;
            }
    }
    public static void main(String[] args) {
        FliperamaTDS janelaArc = new FliperamaTDS();
        janelaArc.janelaArcade();
    }
}