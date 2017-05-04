package StreamSwingBook;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jb6Action extends JFrame implements ActionListener{

	private JFrame jf;
	
	
	public jb6Action(JFrame jf){
		super();
		this.jf=jf;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
