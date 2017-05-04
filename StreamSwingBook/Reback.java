package StreamSwingBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Reback implements ActionListener{
	
	private JFrame jf;
	
	

	public Reback(JFrame jf) {
		super();
		this.jf = jf;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
