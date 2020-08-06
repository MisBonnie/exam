package com.zzxx.exam.test;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("网格布局");
        frame.setSize(300, 400);
        JPanel panel = new JPanel();
        // 创建网格布局, 并且设置panel为网格布局
        GridLayout grid = new GridLayout(3, 4);
        panel.setLayout(grid);

        // 给panel添加几个组件
        for (int i = 0; i < 13; i++) {
            JButton button = new JButton("btn" + i);
            panel.add(button);
        }
        frame.add(panel);
        frame.setVisible(true);
    }
}
