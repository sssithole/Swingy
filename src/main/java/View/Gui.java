package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements Idisplay {

    private JFrame initWindow, selectWindow;
    private JButton select,create;
    private JPanel one, two;
    private Container con;


    public Gui() {
        initWindow = new JFrame();
        initWindow.setSize(600,600);
        initWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initWindow.getContentPane().setBackground(Color.WHITE);
        initWindow.setLayout(null);
        initWindow.setVisible(true);
        con = initWindow.getContentPane();

        select = new JButton("Select Hero");
        create = new JButton("Create Hero");
        one = new JPanel();
        two = new JPanel();

        one.setBounds(100,100,150,50);
        one.setBackground(Color.BLACK);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectHero();
            }
        });
        one.add(select);
        con.add(one);

        two.setBounds(350,100,150,50);
        two.setBackground(Color.BLACK);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHero();
            }
        });
        two.add(create);
        con.add(two);

    }


    @Override
    public void initGame() {

    }

    @Override
    public void getHero() {

    }

    @Override
    public void selectHero() {
        selectWindow = new JFrame();
        selectWindow.setSize(600,600);
        selectWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectWindow.getContentPane().setBackground(Color.WHITE);
        selectWindow.setLayout(null);
        selectWindow.setVisible(true);
        con = selectWindow.getContentPane();

    }

    @Override
    public void createHero() {

    }

    @Override
    public void printStat() {

    }

    @Override
    public void playGame() {

    }
}
