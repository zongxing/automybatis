package com.mashensoft.automybatis;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AutoGeneratorUI extends JFrame{
	public AutoGeneratorUI() {
		
		
		GridLayout g = new GridLayout(2, 1);
		this.setLayout(g);
		FlowLayout f1 = new FlowLayout();
		JPanel p1 = new JPanel(f1);
		//输入框
		JLabel tableLabel = new JLabel("表名：");
		JTextField tableField = new JTextField(13);
		p1.add(tableLabel);
		p1.add(tableField);
		this.add(p1);
		FlowLayout f2 = new FlowLayout();
		JPanel p2 = new JPanel(f2);
		//按钮
		JButton submit = new JButton("生成");
		p2.add(submit);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用自动生成代码的方法
				System.out.println("生成代码");
				autoGenerate();
			}
		});
		this.add(p2);
		
		
		
		this.setTitle("自动生成代码工具");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 200, 200, 200);
		this.setVisible(true);
		this.pack();
	}
	
	public static void autoGenerate() {
		
	}
	
	
	
	public static void main(String[] args) {
		new AutoGeneratorUI();
	}
}
