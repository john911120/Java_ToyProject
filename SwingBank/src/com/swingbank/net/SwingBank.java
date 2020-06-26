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
		setTitle("스윙 은행입니다.");
		setLayout(new GridLayout(1, 2));
		JTextField tfName = new JTextField(30);
		JTextField tfBalance = new JTextField(20);
		JTextField tfMoney = new JTextField(20);
		
		JButton b1 = new JButton("계좌 만들기");
		JButton b2 = new JButton("예금하기");
		JButton b3 = new JButton("출금하기");
		JButton b4 = new JButton("파일으로 저장하기");
		
		// 잔액 수정 못하게 막는 코드
		tfBalance.setEditable(false);
		
		// JPanel 기본 레이아웃 FlowLayout
		JPanel p1 = new JPanel();
		p1.add(new JLabel("고객 이름"));
		p1.add(tfName);
		
		JPanel p2 = new JPanel();
		p2.add(new JLabel("현재 잔액"));
		p2.add(tfBalance);
		
		JPanel p3 = new JPanel();
		p3.add(new JLabel("원"));
		p3.add(tfMoney);
		
		JPanel p4 = new JPanel();
		p4.add(b2);
		p4.add(b3);
		p4.add(b4);
		
		// 좌측 화면
		JPanel p = new JPanel();
		p.add(p1);
		p.add(b1); // 계좌생성 버튼
		p.add(p2);
		p.add(p3);
		p.add(p4);
		
		// 우측 화면
		lst = new List();
		
		// JFrame 배치
		add(p); // 좌측
		add(lst); // 우측
		
		// 이름 작성하고 나서 계좌 만들기 버튼 누르면 동작되는 코드
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 맵에 키값 여부를 확인
				if(hm.containsKey(tfName.getText())) {
					new MessageBox("에러", "같은 계좌가 존재합니다.");
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
		
		// list 이벤트 코드
		lst.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tfName.setText(lst.getSelectedItem());
				String name = tfName.getText();
				// 잔액 표시 setText는 String으로 입력되어야함
				tfBalance.setText(hm.get(name).toString());
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem();
					int money = hm.get(name);
					// 잔액 수정하기
					int value = money+Integer.parseInt(tfMoney.getText());
					// 맵 수정
					hm.put(name, value);
					// 출력 수정
					tfBalance.setText(value+"");
					tfMoney.setText("");
				} catch (NullPointerException n) {
					new MessageBox("오류 발생", "계좌를 하나라도 선택해야합니다.");
				} catch (NumberFormatException f) {
					new MessageBox("입력 오류 발생", "숫자를 입력하세요");
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
						new MessageBox("잔액 부족", name+"님 잔액이 부족합니다.");
						return;
					}
					hm.put(name, value);
					tfBalance.setText(value+"");
					tfMoney.setText("");
				} catch(NullPointerException n) {
					new MessageBox("오류 발생", "다른 계좌를 선택하세요");
				} catch(NumberFormatException f) {
					new MessageBox("입력 오류", "숫자를 입력하세요");
				}
			}
		});
		// 파일 저장 가능한 이벤트 처리 코드
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File dir = new File("src\\com\\swingbank\\net");
				File file = new File(dir, "mybank.txt");
				try {
					FileWriter fw = new FileWriter(file);
					Set<String> set = hm.keySet(); // key 값을 set으로 가져온다.
					Iterator<String> it = set.iterator(); // 객체 가져온다.
					while(it.hasNext()) {
						String key = it.next(); // 이름 과 (키)를 가져온다.
						fw.write(key+" "); // 이름을 파일으로 내보낸다.
						fw.write(hm.get(key)+"\n"); // 잔액을 파일으로 보낸다.
					}
					fw.close(); // 값이 입력되게 설정
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
		// Scanner으로 String, int를 읽기
		// InputStream은 int만 읽기 가능
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
