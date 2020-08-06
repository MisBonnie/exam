package com.zzxx.exam.test;

import javax.swing.*;

public class NoLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("自定义布局");
        JPanel panel = new JPanel();
        // 自定义布局
        panel.setLayout(null);

        JButton b1 = new JButton("btn北");
        JButton b2 = new JButton("btn南");
        JButton b3 = new JButton("btn东");
        JButton b4 = new JButton("btn西");
        JButton b5 = new JButton("btn中");

        b1.setSize(100, 40);
        b1.setLocation(20, 20);
        panel.add(b1);

        frame.setSize(400, 300);
        frame.add(panel);
        frame.setVisible(true);
    }
}
