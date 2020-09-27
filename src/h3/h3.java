package h3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MatchGUI extends JFrame {
    int score1 = 0;
    int score2 = 0;
    JButton buttonLeft = new JButton("AC MILAN");
    JButton buttonRight = new JButton("REAL MADRID");
    JLabel result = new JLabel(score1 + " x " + score2, SwingConstants.CENTER);
    JLabel lastScorer = new JLabel("Last scorer: N/A", SwingConstants.CENTER);
    JLabel winner = new JLabel("DRAW", SwingConstants.CENTER);
    Font fnt = new Font("Times new roman",Font.PLAIN,20);

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRight) {
            buttonRight.setBackground(Color.CYAN);
        }
    }

    MatchGUI() {
        super("Super match");
        setLayout(new BorderLayout());
        setSize(750, 300);

        buttonLeft.setFont(fnt);
        buttonRight.setFont(fnt);
        result.setFont(fnt);
        winner.setFont(fnt);
        lastScorer.setFont(fnt);

        add(buttonLeft, BorderLayout.WEST);
        add(buttonRight, BorderLayout.EAST);
        add(result, BorderLayout.CENTER);
        add(winner, BorderLayout.NORTH);
        add(lastScorer, BorderLayout.SOUTH);

        buttonLeft.addActionListener(ae -> {
            score1++;
            result.setText(score1 + " : " + score2);
            lastScorer.setText("Last scorer: AC MILAN");
            if (score1 > score2) {
                winner.setText("AC MILAN wins");
            }
            if (score2 == score1) {
                winner.setText("DRAW");
            }
            getContentPane().setBackground(Color.YELLOW);
        });

        buttonRight.addActionListener(ae -> {
            score2++;
            result.setText(score1 + " : " + score2);
            lastScorer.setText("Last scorer: REAL MADRID");
            if (score2 > score1) {
                winner.setText("REAL MADRID wins");
            }
            if (score2 == score1) {
                winner.setText("DRAW");
            }
        });

        setVisible(true);
        setResizable(false);
        setBackground(Color.CYAN);
    }
}

public class h3 {
    public static void main(String[] args) {
        new MatchGUI();
    }
}
