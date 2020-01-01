package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;

public class AddNew {
    private JPanel panel;
    private JTextField Name;
    private JPanel rootpanel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    String gender;


    public AddNew() {
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if("disable".equals(e.getActionCommand()))
            {
                maleRadioButton.setEnabled(true);
                femaleRadioButton.setEnabled(false);
            }
            }
        });
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("disable".equals(e.getActionCommand()))
                {
                    maleRadioButton.setEnabled(false);
                    femaleRadioButton.setEnabled(true);
                }
            }
        });
    }

    public JPanel getRootpanel() {
        return rootpanel;
    }

    public String getName() {
        return Name.getText();
    }

    public String getGender() {
        if(maleRadioButton.isSelected())
        {
           gender = maleRadioButton.getText();
        }
        else{
            gender = femaleRadioButton.getText();
        }
       return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
