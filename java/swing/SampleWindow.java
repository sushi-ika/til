package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleWindow {
	public static void main(String[] args) {
		JFrame frame = new JFrame("はじめてのSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		
		frame.setLayout(null);//レイアウトマネージャを無効にして座標指定による配置
		JLabel label = new JLabel("Hello, world!");//ラベルを生成して
		label.setLocation(10, 10);//ラベルの座標と
		label.setSize(200,20);//サイズを指定
		frame.add(label);//フレームに追加
		JButton button = new JButton("押してね");
		button.addActionListener(new SampleListener());//イベントハンドラ
		button.setLocation(250, 100);
		button.setSize(100,20);
		frame.add(button);
		frame.setVisible(true);
		System.out.println("フレームを表示");
	}

}
