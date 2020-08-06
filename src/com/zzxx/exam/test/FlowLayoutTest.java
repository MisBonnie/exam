package com.zzxx.exam.test;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("流水布局");
        frame.setSize(300, 400);
        JPanel panel = new JPanel();
        // 创建流水布局, 并且设置panel为流水布局
        FlowLayout flow = new FlowLayout();
        panel.setLayout(flow);

        // 给panel添加几个组件
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("btn" + i);
            panel.add(button);
        }
        frame.add(panel);
        frame.setVisible(true);

    }
}
