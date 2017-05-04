package StreamSwingBook;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class jb1Action extends JFrame implements ActionListener{
	private String file;
	

	public jb1Action(String file) throws HeadlessException {
		super();
		this.file = file;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//创建一个新面板，上面有“新增”按钮
		JFrame jf=new JFrame();
		JPanel jp=new  JPanel();
		JTextField jtf=new JTextField(10);
		JButton jb=new JButton("新增");
		JButton jb1=new JButton("返回");
		jp.add(jtf);
		jp.add(jb);
		jp.add(jb1);
		jf.setLocationRelativeTo(null);
		jf.add(jp);
        jf.setTitle("请输入新增图书名称: ");
		jf.add(jp);
		jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jf.setSize(400,400);
		jf.setVisible(true);
		// TODO Auto-generated method stub
		//绑定 .新增按钮   监听
		jb.addActionListener(new NewAddAction(jtf,file));
		jb1.addActionListener(new Reback(this));
		
	}

}
