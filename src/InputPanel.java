import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
    private JTextField input;
    private JLabel label;

    public InputPanel(String labelText) {
        this.setLayout(new BorderLayout());

        this.input = new JTextField();
        this.input.setColumns(10);

        this.label = new JLabel(labelText);

        this.add(this.label, BorderLayout.CENTER);
        this.add(this.input, BorderLayout.EAST);
    }

    public void clearText() {
        this.input.setText("");
    }

    public String getText() {
        return this.input.getText();
    }
}
