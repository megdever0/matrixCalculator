import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler implements ActionListener {
    JFrame jframe;
    public MenuHandler(JFrame frame) {
        jframe = new JFrame();
        jframe = frame;
    }

    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Quit"))
            System.exit(0);
    }
}
