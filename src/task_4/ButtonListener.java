package task_4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;

    public ButtonListener(JTextField jtf, JTextArea jta) {
        textField = jtf;
        textArea = jta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append(textField.getText()+"\n");
        textField.setText("");
    }
}
