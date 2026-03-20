package atividade2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMTDS extends JFrame{
    public double saldo = 1000, saque = 0, deposito = 0;
    public int j = 30;
    public String btn = "";
    public JFrame jnlOperacoes = new JFrame("Sistema de Caixa Eletrônico");
    public String[] btnsOperacoes = {"Saldo", "Saque", "Depósito", "Sair"};
    public BotaoArredondado btnEntrar = new BotaoArredondado("Entrar", 30);
    public BotaoArredondado btnSaldo = criarBtn(btnsOperacoes[0], j), btnSaque = criarBtn(btnsOperacoes[1], j), btnDeposito = criarBtn(btnsOperacoes[2], j), btnSair = criarBtn(btnsOperacoes[3], j);
    static String valorAcumulado = "";
    static double num1 = 0, num2 = 0;
    static String operacao = "";
    public JTextField txtVisor = new JTextField();
   
    public ATMTDS(){
        setTitle("Sistema de Caixa Eletrônico");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnlLogin = new JPanel();
        pnlLogin.setBackground(Color.GRAY);
        pnlLogin.setLayout(new BoxLayout(pnlLogin, BoxLayout.Y_AXIS));
        pnlLogin.setBorder(BorderFactory.createEmptyBorder(20, 120, 20, 120));

        JPanel pnlLogInfos = new JPanel(new GridLayout(2,2, -50, 20));
        //pnlLogInfos.setBackground(Color.BLACK);
        pnlLogInfos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));

        JLabel lblSaudacao = new JLabel("BEM-VINDO AO BANCO JAVA");
        lblSaudacao.setFont(new Font("Serif", Font.BOLD, 21));
        lblSaudacao.setBorder(BorderFactory.createEmptyBorder(140,0,0,0));
        lblSaudacao.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblNumConta = new JLabel("Número da Conta:");
        lblNumConta.setFont(new Font("Arial", Font.BOLD, 14));
        pnlLogInfos.add(lblNumConta);

        JTextField txtNumConta = new JTextField();
        txtNumConta.setFont(new Font("Monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        pnlLogInfos.add(txtNumConta);

        JLabel lblSenha = new JLabel("Senha: ");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
        pnlLogInfos.add(lblSenha);

        JPasswordField pswSenConta = new JPasswordField();
        pnlLogInfos.add(pswSenConta);
        
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setBackground(new Color(34, 139, 34));
        btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEntrar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btnEntrar.setFocusPainted(false);
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(e -> {
            String conta = txtNumConta.getText();
            char[] senconta = pswSenConta.getPassword();
            if (conta.isEmpty() && senconta.length == 0){
                JOptionPane.showMessageDialog(this, "Preencha todos os campos");
            } else {
                setVisible(false);
                conta();
            }
        });

        pnlLogin.add(lblSaudacao, BorderLayout.NORTH);
        pnlLogin.add(Box.createRigidArea(new Dimension(0, 15)));
        pnlLogin.add(pnlLogInfos);
        pnlLogin.add(Box.createRigidArea(new Dimension(0, 25)));
        pnlLogin.add(btnEntrar);

        add(pnlLogin, BorderLayout.CENTER);
        setVisible(true);
    }
    public void telaOperacoes(){
        jnlOperacoes.setSize(600, 500);
        jnlOperacoes.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jnlOperacoes.setLocationRelativeTo(null);
        jnlOperacoes.setLayout(new BorderLayout());

        JLabel lblSlcOp = new JLabel("Selecione a Operação", SwingConstants.CENTER);
        lblSlcOp.setFont(new Font("Serif", Font.BOLD, 18));
        lblSlcOp.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        jnlOperacoes.add(lblSlcOp, BorderLayout.NORTH);

        JPanel pnlOperacoes = new JPanel();
        pnlOperacoes.setLayout(new BorderLayout());
        pnlOperacoes.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JPanel pnlOperaInfos = new JPanel(new GridLayout(2,2, 20, 20));
        //pnlOperaInfos.setBackground(Color.GRAY);
        pnlOperaInfos.setPreferredSize(new Dimension(300, 200));
        
        btnsOperacoes[0] = "Saldo";
        btnSaldo.addActionListener(e -> JOptionPane.showMessageDialog(jnlOperacoes,"Saldo atual: R$"+saldo+"0"));
        btnsOperacoes[1] = "Saque";
        btnsOperacoes[2] = "Depósito";
        btnsOperacoes[3] = "Sair";
        btnSair.addActionListener(e ->{
            jnlOperacoes.setVisible(false);
            setVisible(true);
        });

        pnlOperaInfos.add(btnSaldo);
        pnlOperaInfos.add(btnSaque);
        pnlOperaInfos.add(btnDeposito);
        pnlOperaInfos.add(btnSair);

        pnlOperacoes.add(pnlOperaInfos, BorderLayout.CENTER);
      
        jnlOperacoes.add(pnlOperacoes, BorderLayout.CENTER);
        jnlOperacoes.setVisible(true);
    }
    public void conta(){
        telaOperacoes();
        btnSaque.addActionListener(e ->{
            JFrame jnlSaque = new JFrame();
            jnlSaque.setTitle("Sistema de Caixa Eletrônico");
            jnlSaque.setSize(600, 500);
            jnlSaque.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jnlSaque.setLocationRelativeTo(null);
            jnlSaque.setLayout(new BorderLayout());

            JPanel pnlSaque = new JPanel(new BorderLayout());
            //pnlSaque.setBackground(Color.GRAY);
            pnlSaque.setLayout(new BoxLayout(pnlSaque, BoxLayout.Y_AXIS));
            pnlSaque.setBorder(BorderFactory.createEmptyBorder(10, 170, 10, 170));

            JLabel lblMsgSaque = new JLabel("Quanto deseja sacar?", SwingConstants.CENTER);
            lblMsgSaque.setFont(new Font("Serif", Font.BOLD, 21));
            lblMsgSaque.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            lblMsgSaque.setAlignmentX(Component.CENTER_ALIGNMENT);

            txtVisor.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            txtVisor.setFont(new Font("Monospaced", Font.PLAIN, 28));
            txtVisor.setHorizontalAlignment(JTextField.RIGHT);
            txtVisor.setEditable(false);
            txtVisor.setBackground(Color.WHITE);
            txtVisor.setForeground(Color.BLACK);

            JPanel pnlSaqueInfos = new JPanel(new GridLayout(4, 3, 5,5));
            pnlSaqueInfos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));

            String[] btnsGerais = {"1", "2","3","4","5","6","7","8","9","AC","0","C"};

            for(String btns : btnsGerais){
                BotaoArredondado btnArredondado = criarBtns(btns, j);
                pnlSaqueInfos.add(btnArredondado);
            }

            JButton btnSacar = new JButton("Sacar");
            btnSacar.setBackground(Color.GREEN);
            btnSacar.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnSacar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            btnSacar.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnSacar.addActionListener(e1 -> {
                double sacar = Double.parseDouble(txtVisor.getText());
                if (sacar > saldo){
                    JOptionPane.showMessageDialog(jnlSaque,"Não é possivel sacar o valor");
                    valorAcumulado = "";
                    txtVisor.setText(valorAcumulado);
                } else {
                    saldo = saldo-sacar;
                    valorAcumulado = "";
                    txtVisor.setText(valorAcumulado);
                }
            });

            pnlSaque.add(lblMsgSaque, BorderLayout.NORTH);
            pnlSaque.add(Box.createRigidArea(new Dimension(0,10)));
            pnlSaque.add(txtVisor);
            pnlSaque.add(Box.createRigidArea(new Dimension(0,10)));
            pnlSaque.add(pnlSaqueInfos);
            pnlSaque.add(Box.createRigidArea(new Dimension(0,10)));
            pnlSaque.add(btnSacar);

            jnlSaque.add(pnlSaque, BorderLayout.CENTER);
            jnlSaque.setVisible(true);
        });
        btnDeposito.addActionListener(e ->{
            JFrame jnlDeposito = new JFrame();
            jnlDeposito.setTitle("Sistema de Caixa Eletrônico");
            jnlDeposito.setSize(600, 500);
            jnlDeposito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jnlDeposito.setLocationRelativeTo(null);
            jnlDeposito.setLayout(new BorderLayout());

            JPanel pnlDeposito = new JPanel(new BorderLayout());
            //pnlDeposito.setBackground(Color.GRAY);
            pnlDeposito.setLayout(new BoxLayout(pnlDeposito, BoxLayout.Y_AXIS));
            pnlDeposito.setBorder(BorderFactory.createEmptyBorder(10, 170, 10, 170));

            JLabel lblMsgDeposito = new JLabel("Quanto deseja Depositar?", SwingConstants.CENTER);
            lblMsgDeposito.setFont(new Font("Serif", Font.BOLD, 21));
            lblMsgDeposito.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            lblMsgDeposito.setAlignmentX(Component.CENTER_ALIGNMENT);

            txtVisor.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            txtVisor.setFont(new Font("Monospaced", Font.PLAIN, 28));
            txtVisor.setHorizontalAlignment(JTextField.RIGHT);
            txtVisor.setEditable(false);
            txtVisor.setBackground(Color.WHITE);
            txtVisor.setForeground(Color.BLACK);

            JPanel pnlDepositoInfos = new JPanel(new GridLayout(4, 3, 5,5));
            pnlDepositoInfos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));

            String[] btnsGerais = {"1", "2","3","4","5","6","7","8","9","AC","0","C"};

            for(String btns : btnsGerais){
                BotaoArredondado btnArredondado = criarBtns(btns, j);
                pnlDepositoInfos.add(btnArredondado);
            }

            JButton btnDepositar = new JButton("Depositar");
            btnDepositar.setBackground(Color.GREEN);
            btnDepositar.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnDepositar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            btnDepositar.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnDepositar.addActionListener(e1 -> {
                double depositar = Double.parseDouble(txtVisor.getText());
                saldo = saldo+depositar;
                valorAcumulado = "";
                txtVisor.setText(valorAcumulado);
            });

            pnlDeposito.add(lblMsgDeposito, BorderLayout.NORTH);
            pnlDeposito.add(Box.createRigidArea(new Dimension(0,10)));
            pnlDeposito.add(txtVisor);
            pnlDeposito.add(Box.createRigidArea(new Dimension(0,10)));
            pnlDeposito.add(pnlDepositoInfos);
            pnlDeposito.add(Box.createRigidArea(new Dimension(0,10)));
            pnlDeposito.add(btnDepositar);

            jnlDeposito.add(pnlDeposito, BorderLayout.CENTER);
            jnlDeposito.setVisible(true);
        });
    }
    public BotaoArredondado criarBtns(String btn, int j){
        BotaoArredondado botao = new BotaoArredondado(btn, j); 
        botao.setBackground(new Color(173, 216, 230));
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.addActionListener(cliqueNumero);

        return botao;
    }
    public BotaoArredondado criarBtn(String btn, int j){
        BotaoArredondado botao = new BotaoArredondado(btn, j); 
        botao.setBackground(new Color(41, 128, 185));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return botao;
    }
    public ActionListener cliqueNumero = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String textoBotao = ((BotaoArredondado)e.getSource()).getText();
            if (textoBotao == "AC"){
                valorAcumulado = "";
                txtVisor.setText("");
            } else if (textoBotao == "C"){
                valorAcumulado = valorAcumulado.substring(0, valorAcumulado.length() - 1);
                txtVisor.setText(valorAcumulado);
            } else {
                valorAcumulado += textoBotao;
                txtVisor.setText(valorAcumulado);
            }
        }
    };
    public static void main(String[] args) {
        new ATMTDS();
    }
}