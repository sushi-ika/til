package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("押されました");
	}
}
