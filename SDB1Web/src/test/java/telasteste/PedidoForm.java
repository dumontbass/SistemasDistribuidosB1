package telasteste;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/1/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PedidoForm {
    private JButton button1;
    private JComboBox comboBox1;

    public PedidoForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("kjhkjhkjhkjh");
            }
        });
    }

    public void setData(PedidoAction data) {
    }

    public void getData(PedidoAction data) {
    }

    public boolean isModified(PedidoAction data) {
        return false;
    }
}
