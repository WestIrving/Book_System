package StreamSwingBook;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jb5Action extends JFrame implements ActionListener{

	private String file;
	
	
	public jb5Action(String file){
		super();
		this.file=file;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame jf=new JFrame();
		JPanel jp=new  JPanel();
		JTextField jtf=new JTextField(10);
		JButton jb=new JButton("归还该图书");
		jp.add(jtf);
		jp.add(jb);
		JButton jb1=new JButton("返回");
		jp.add(jb1);
		this.setLocationRelativeTo(null);
		this.add(jp);
        this.setTitle("请输入归还图书名称: ");
		this.add(jp);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,400);
		this.setVisible(true);
		jb.addActionListener(new RebackAction(jtf, file));
	}

}
