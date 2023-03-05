package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleWindow2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("はじめてのSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		
		frame.setLayout(new BorderLayout());//BorderLayoutで部品を自動的に配置する
		JLabel label = new JLabel("Hello, world!");//ラベルを生成して
		frame.add(label, BorderLayout.CENTER);//中央に配置
		
		JButton buttonN = new JButton("上ボタン");//ボタンを生成して
		buttonN.addActionListener(new SampleListener());//イベントハンドラ
		frame.add(buttonN, BorderLayout.NORTH);//上に配置
		JButton buttonS = new JButton("下ボタン");
		frame.add(buttonS, BorderLayout.SOUTH);
		buttonS.addActionListener(new ActionListener() {//匿名クラスでイベントハンドラを定義
			public void actionPerformed(ActionEvent e) {
				System.out.println("下ボタンが押されました");
			}
		});
		
		frame.setVisible(true);
		System.out.println("フレームを表示");
	}

}