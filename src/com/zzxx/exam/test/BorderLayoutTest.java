package com.zzxx.exam.test;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("边框布局");
        frame.setSize(300, 400);
        JPanel panel = new JPanel();
        // 创建边框布局, 并且设置panel为边框布局
        BorderLayout border = new BorderLayout();
        panel.setLayout(border);

        JButton b1 = new JButton("btn北");
        JButton b2 = new JButton("btn南");
        JButton b2_1 = new JButton("btn南1");
        JButton b3 = new JButton("btn东");
        JButton b4 = new JButton("btn西");
        JButton b5 = new JButton("btn中");

        JPanel southPanel = new JPanel();
        southPanel.add(b2);
        southPanel.add(b2_1);

        panel.add(b1, BorderLayout.NORTH);
//        panel.add(b2, BorderLayout.SOUTH);
//        panel.add(b2_1, BorderLayout.SOUTH);
        panel.add(southPanel, BorderLayout.SOUTH);
        panel.add(b3, BorderLayout.EAST);
        panel.add(b4, BorderLayout.WEST);
        panel.add(b5, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
