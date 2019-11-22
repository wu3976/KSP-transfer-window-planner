import javax.swing.JFrame;

/**
 * Main method that starts the JFrame.
 * 
 * @author Chenjie Wu
 *
 */
public class Main {
    /**
     *
     * @param args
     *            Console argument
     */
    public static void main(String[] args) {
        PlannerFrame planner = new PlannerFrame();
        planner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        planner.setVisible(true);
    }
}
