package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            if(maleRadioButton.isSelected())
            {
                maleRadioButton.setEnabled(true);
                femaleRadioButton.setEnabled(false);
            }
            else
            {
                maleRadioButton.setEnabled(false);
                femaleRadioButton.setEnabled(true);
            }
            }
        });
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(femaleRadioButton.isSelected())
                {
                    maleRadioButton.setEnabled(false);
                    femaleRadioButton.setEnabled(true);
                }
                else
                {
                    maleRadioButton.setEnabled(true);
                    femaleRadioButton.setEnabled(false);
                }
            }
        });
    }

    public JRadioButton getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public JRadioButton getMaleRadioButton() {
        return maleRadioButton;
    }

    public JPanel getRootpanel() {
        return rootpanel;
    }

    public String getName() {
        return Name.getText();
    }

    public void setName(JTextField name) {
        Name = name;
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

    public void setName(String fullName) {
    }
}
