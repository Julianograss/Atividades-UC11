package atividade1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JogoPacman1 extends JPanel implements ActionListener {
    private final int BLOCO = 30, LINHAS = 11, COLUNAS = 11;
    private int pacmanX = 1, pacmanY = 1;
    private int[][] mapa = {
        {1,1,1,1,1,1,1,1,1,1,1}, {1,0,0,0,0,1,0,0,0,0,1}, {1,0,1,1,0,1,0,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1}, {1,1,0,1,1,0,1,1,0,1,1}, {1,0,0,0,0,0,0,0,0,0,1},
        {1,1,0,1,1,0,1,1,0,1,1}, {1,0,0,0,0,0,0,0,0,0,1}, {1,0,1,1,0,1,0,1,1,0,1},
        {1,0,0,0,0,1,0,0,0,0,1}, {1,1,1,1,1,1,1,1,1,1,1}
    };

    public JogoPacman1() {
        setPreferredSize(new Dimension(COLUNAS * BLOCO, LINHAS * BLOCO));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int px = pacmanX, py = pacmanY;
                if (e.getKeyCode() == KeyEvent.VK_UP) py--;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) py++;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) px--;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) px++;
                if (mapa[py][px] != 1) { pacmanX = px; pacmanY = py; mapa[py][px] = 2; }
            }
        });
        new Timer(100, this).start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (mapa[i][j] == 1) { g.setColor(Color.BLUE); g.fillRect(j*BLOCO, i*BLOCO, BLOCO, BLOCO); }
                else if (mapa[i][j] == 0) { g.setColor(Color.WHITE); g.fillOval(j*BLOCO+12, i*BLOCO+12, 6, 6); }
            }
        }
        g.setColor(Color.YELLOW); g.fillArc(pacmanX*BLOCO, pacmanY*BLOCO, BLOCO, BLOCO, 30, 300);
    }
    public void actionPerformed(ActionEvent e) { repaint(); }
}
