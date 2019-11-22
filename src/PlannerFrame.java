import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import components.map.Map;
import components.map.Map1L;

/**
 * This program aim to calculate the angle of transfer window between two stars
 * that are in a same system for Kerbal Space Program players.
 * 
 * @author Chenjie Wu
 *
 */
public class PlannerFrame extends JFrame {
    private JPanel mainPanel;

    private JButton calButton;
    private JButton clearButton;
    private InputPanel planet1;
    private InputPanel planet2;
    private JTextArea resultArea;

    private ArrayList<String> names;
    private ArrayList<Double> orbPer;

    private Map<String, Double> planetMap;

    public PlannerFrame() {
        this(250, 500);
    }

    public PlannerFrame(int width, int height) {

        this.planetMap = new Map1L<>();
        planetMap.add("kerbin", 426.0);
        planetMap.add("sarnus", 11987.0);

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridLayout(5, 1));

        this.planet1 = new InputPanel("Beginning planet or orbital period");
        this.planet2 = new InputPanel("Destination planet or orbital period");
        this.calButton = new JButton("Calculate!");
        calListener calLis = new calListener();
        this.calButton.addActionListener(calLis);
        this.clearButton = new JButton("clear");
        clearListener clearLis = new clearListener();
        this.clearButton.addActionListener(clearLis);

        this.resultArea = new JTextArea();
        this.resultArea.setPreferredSize(new Dimension(250, 100));
        this.resultArea
                .setCaretPosition(this.resultArea.getDocument().getLength());
        this.resultArea.setEditable(false);

        this.mainPanel.add(this.planet1);
        this.mainPanel.add(this.planet2);
        this.mainPanel.add(this.calButton);
        this.mainPanel.add(this.clearButton);
        this.mainPanel.add(this.resultArea);

        this.add(this.mainPanel);
        this.setSize(width, height);
        this.setTitle("Transfer Windows Planner");
    }

    class calListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = PlannerFrame.this.planet1.getText().toLowerCase();
            String s2 = PlannerFrame.this.planet2.getText().toLowerCase();
            double t1 = 0;
            double t2 = 0;
            boolean t1getted = false;
            boolean t2getted = false;

            for (Map.Pair<String, Double> pair: planetMap) {
                if (s1.equals(pair.key())){
                    t1 = pair.value();
                    t1getted = true;

                }

                if (s2.equals(pair.key())){
                    t2 = pair.value();
                    t2getted = true;
                }

            }

            try {
                if (!t1getted) {
                    t1 = Double.parseDouble(s1);
                }
                if (!t2getted) {
                    t2 = Double.parseDouble(s2);
                }
                double th = Math.pow(
                        (Math.pow(t1, 2 / 3.0) + Math.pow(t2, 2 / 3.0)), 1.5)
                        / Math.sqrt(32);
                double theta = (180 - (360 * th / t2)) % 360;

                PlannerFrame.this.resultArea.append("\nHohmann transfer time: "
                        + th + "\nTransfer phase angle (degree): " + theta);
            } catch (NumberFormatException e1) {
                PlannerFrame.this.resultArea.append(
                        "\nWe could not found this planet in out database!");
            }

        }
    }

    class clearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (PlannerFrame.this.planet1.getText().equals("")
                    && PlannerFrame.this.planet2.getText().equals("")) {
                PlannerFrame.this.resultArea.setText("");
            }
            PlannerFrame.this.planet1.clearText();
            PlannerFrame.this.planet2.clearText();

        }
    }
}
