import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperCalculadoraSwing extends JFrame {
    private JSpinner txtNum;
    private JPanel panCalc;
    private JLabel lblResto, lblCubo, lblRaizQ, lblRaizC, lblAbs;

    public SuperCalculadoraSwing() {
        setTitle("Super Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Digite um valor:");
        lblTitulo.setBounds(20, 20, 120, 25);
        add(lblTitulo);

        txtNum = new JSpinner(new SpinnerNumberModel(1, -1000, 1000, 1));
        txtNum.setBounds(140, 20, 60, 25);
        add(txtNum);

        JButton btnCalc = new JButton("Calcular");
        btnCalc.setBounds(220, 20, 120, 25);
        add(btnCalc);

        panCalc = new JPanel();
        panCalc.setLayout(null);
        panCalc.setBounds(20, 60, 340, 180);
        panCalc.setVisible(false);
        add(panCalc);

        lblResto = new JLabel("Resto da divisão por 2: ");
        lblResto.setBounds(10, 10, 300, 25);
        panCalc.add(lblResto);

        lblCubo = new JLabel("Elevado ao cubo: ");
        lblCubo.setBounds(10, 35, 300, 25);
        panCalc.add(lblCubo);

        lblRaizQ = new JLabel("Raiz quadrada: ");
        lblRaizQ.setBounds(10, 60, 300, 25);
        panCalc.add(lblRaizQ);

        lblRaizC = new JLabel("Raiz cúbica: ");
        lblRaizC.setBounds(10, 85, 300, 25);
        panCalc.add(lblRaizC);

        lblAbs = new JLabel("Valor absoluto: ");
        lblAbs.setBounds(10, 110, 300, 25);
        panCalc.add(lblAbs);

        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = (Integer) txtNum.getValue();
                int resto = num % 2;
                double cubo = Math.pow(num, 3);
                double raizQ = Math.sqrt(num);
                double raizC = Math.cbrt(num);
                int abs = Math.abs(num);

                lblResto.setText("Resto da divisão por 2: " + resto);
                lblCubo.setText("Elevado ao cubo: " + String.format("%.2f", cubo));
                lblRaizQ.setText("Raiz quadrada: " + String.format("%.2f", raizQ));
                lblRaizC.setText("Raiz cúbica: " + String.format("%.2f", raizC));
                lblAbs.setText("Valor absoluto: " + abs);

                panCalc.setVisible(true);
            }

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SuperCalculadoraSwing().setVisible(true);
        });
    }
}