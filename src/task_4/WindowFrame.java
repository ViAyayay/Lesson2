package task_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowFrame extends JFrame {

    public WindowFrame(){
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400 , 400);

        JTextArea jta = new JTextArea();
        jta.setEnabled(false);
        jta.setDisabledTextColor(new Color(0x09409C));

        JPanel chatPanel = new JPanel();
        JPanel enterPanel = new JPanel();

        getTextField(chatPanel, jta);
        getEnterField(enterPanel, jta);

        setVisible(true);
    }

    private void getEnterField(JPanel panel, JTextArea jta) {
        JTextField enterTextField = new JTextField();
        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ButtonListener(enterTextField, jta));
//        insertButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jta.append(enterTextField.getText()+"\n");
//                enterTextField.setText("");
//            }
//        });
        panel.setLayout((new BorderLayout()));
        panel.add(enterTextField, BorderLayout.CENTER);
        enterTextField.addActionListener(new ButtonListener(enterTextField, jta));
        panel.add(insertButton, BorderLayout.AFTER_LINE_ENDS);
        panel.setEnabled(false);
        add(panel, BorderLayout.PAGE_END);
    }

    private void getTextField(JPanel panel, JTextArea jta) {
        panel.setLayout(new BorderLayout());
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        panel.add(jsp);
        add(panel, BorderLayout.CENTER);
    }
}
