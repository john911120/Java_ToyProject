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
		JButton closeBtn = new JButton("���α׷� ����");
		add(lb);
		add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false); �� ȭ�鿡 �Ⱥ������� �޸𸮿��� �����ִ�.
				dispose();
			}
		});
		// ���α׷� ũ�� �� ǥ�� ����
		setSize(300, 100);
		setVisible(true);
	}

}
