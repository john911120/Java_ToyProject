package com.swingbank.net;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingBank extends JFrame {

	HashMap<String, Integer> hm = new HashMap<>();
	List lst;
	
	public SwingBank() {
		setTitle("���� �����Դϴ�.");
		setLayout(new GridLayout(1, 2));
		JTextField tfName = new JTextField(30);
		JTextField tfBalance = new JTextField(20);
		JTextField tfMoney = new JTextField(20);
		
		JButton b1 = new JButton("���� �����");
		JButton b2 = new JButton("�����ϱ�");
		JButton b3 = new JButton("����ϱ�");
		JButton b4 = new JButton("�������� �����ϱ�");
		
		// �ܾ� ���� ���ϰ� ���� �ڵ�
		tfBalance.setEditable(false);
		
		// JPanel �⺻ ���̾ƿ� FlowLayout
		JPanel p1 = new JPanel();
		p1.add(new JLabel("�� �̸�"));
		p1.add(tfName);
		
		JPanel p2 = new JPanel();
		p2.add(new JLabel("���� �ܾ�"));
		p2.add(tfBalance);
		
		JPanel p3 = new JPanel();
		p3.add(new JLabel("��"));
		p3.add(tfMoney);
		
		JPanel p4 = new JPanel();
		p4.add(b2);
		p4.add(b3);
		p4.add(b4);
		
		// ���� ȭ��
		JPanel p = new JPanel();
		p.add(p1);
		p.add(b1); // ���»��� ��ư
		p.add(p2);
		p.add(p3);
		p.add(p4);
		
		// ���� ȭ��
		lst = new List();
		
		// JFrame ��ġ
		add(p); // ����
		add(lst); // ����
		
		// �̸� �ۼ��ϰ� ���� ���� ����� ��ư ������ ���۵Ǵ� �ڵ�
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �ʿ� Ű�� ���θ� Ȯ��
				if(hm.containsKey(tfName.getText())) {
					new MessageBox("����", "���� ���°� �����մϴ�.");
					return;
				}
				
				if(tfName.getText().isEmpty()) {
					return;
				}
				
				String name = tfName.getText();
				lst.add(tfName.getText());
				hm.put(name, 0);
			}
			
		});
		
		// list �̺�Ʈ �ڵ�
		lst.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tfName.setText(lst.getSelectedItem());
				String name = tfName.getText();
				// �ܾ� ǥ�� setText�� String���� �ԷµǾ����
				tfBalance.setText(hm.get(name).toString());
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem();
					int money = hm.get(name);
					// �ܾ� �����ϱ�
					int value = money+Integer.parseInt(tfMoney.getText());
					// �� ����
					hm.put(name, value);
					// ��� ����
					tfBalance.setText(value+"");
					tfMoney.setText("");
				} catch (NullPointerException n) {
					new MessageBox("���� �߻�", "���¸� �ϳ��� �����ؾ��մϴ�.");
				} catch (NumberFormatException f) {
					new MessageBox("�Է� ���� �߻�", "���ڸ� �Է��ϼ���");
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem();
					int money = hm.get(name);
					int value = money-Integer.parseInt(tfMoney.getText());
					if(value < 0) {
						new MessageBox("�ܾ� ����", name+"�� �ܾ��� �����մϴ�.");
						return;
					}
					hm.put(name, value);
					tfBalance.setText(value+"");
					tfMoney.setText("");
				} catch(NullPointerException n) {
					new MessageBox("���� �߻�", "�ٸ� ���¸� �����ϼ���");
				} catch(NumberFormatException f) {
					new MessageBox("�Է� ����", "���ڸ� �Է��ϼ���");
				}
			}
		});
		// ���� ���� ������ �̺�Ʈ ó�� �ڵ�
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File dir = new File("src\\com\\swingbank\\net");
				File file = new File(dir, "mybank.txt");
				try {
					FileWriter fw = new FileWriter(file);
					Set<String> set = hm.keySet(); // key ���� set���� �����´�.
					Iterator<String> it = set.iterator(); // ��ü �����´�.
					while(it.hasNext()) {
						String key = it.next(); // �̸� �� (Ű)�� �����´�.
						fw.write(key+" "); // �̸��� �������� ��������.
						fw.write(hm.get(key)+"\n"); // �ܾ��� �������� ������.
					}
					fw.close(); // ���� �Էµǰ� ����
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		setSize(600, 300);
		setVisible(true);
		load();
	}
	
	private void load() {
		hm.clear();
		File dir = new File("src\\com\\swingbank\\net");
		File file = new File(dir, "mybank.txt");
		// Scanner���� String, int�� �б�
		// InputStream�� int�� �б� ����
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()) {
				String key = sc.next();
				int value = sc.nextInt();
				hm.put(key, value);
				lst.add(key);
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SwingBank();
	}

}
