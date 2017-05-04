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

public class jb3Action extends JFrame implements ActionListener{
	
	private String file;
	
	public jb3Action(String file){
		super();
		this.file=file;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame jf=new JFrame();
		JPanel jp=new  JPanel();
		JTextField jtf=new JTextField(10);
		JButton jb=new JButton("删除");
		JButton jb1=new JButton("返回");
		jp.add(jb1);
		jp.add(jtf);
		jp.add(jb);
		jf.setLocationRelativeTo(null);
		jf.add(jp);
		jf.setTitle("请输入删除图书名称: ");
		jf.add(jp);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(400,400);
		jf.setVisible(true);
		// TODO Auto-generated method stub
		//绑定，“删除图书”按钮监听
		jb.addActionListener(new RemoveAction(jtf,file));

}
}
