package DBConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Samuel on 07-04-16.
 */
public class Gui extends JFrame{
    private JComboBox box;
    private JLabel picture;

    private static String[] filename = {};//cikel.png};
    private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};

    public Gui(){
        super("de titel");
        setLayout(new FlowLayout());

        box = new JComboBox(filename);

        box.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if(event.getStateChange()==ItemEvent.SELECTED);
                            picture.setIcon(pics[box.getSelectedIndex()]);
                    }
                }
        );
    }

}
