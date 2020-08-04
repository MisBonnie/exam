package com.zzxx.exam.test;

import javax.swing.*;
import java.net.URL;

/** 图片加载测试 */
public class JFrameTest {
	public static void main(String[] args) {
		// 从package中加载资源(image, text, 等 ...)
		// JFrameTest.class 与 img.png 在同一个包里
		// URL url = JFrameTest.class.getResource("img.jpeg");
		// 也可以使用绝对package路径加载资源: 如:
		URL url = JFrameTest.class.getResource("/com/zzxx/exam/test/img.jpeg");
		// InputStream in = url.openStream();
		ImageIcon ico = new ImageIcon(url);
		JFrame frame = new JFrame("测试图片加载");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(ico);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(640, 640);
		frame.setVisible(true);
	}
}
