package com.swingbank.net;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageBox extends JFrame {

	public MessageBox(String title, String msg) {
		setTitle(title);
		
		setLayout(new FlowLayout());
		JLabel lb = new JLabel(msg);
		JButton closeBtn = new JButton("프로그램 종료");
		add(lb);
		add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); 는 화면에 안보이지만 메모리에는 남아있다.
				dispose();
			}
		});
		// 프로그램 크기 및 표시 여부
		setSize(300, 100);
		setVisible(true);
	}

}
