package StreamSwingBook;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu extends JFrame{
	
	public Menu(){
		
		String file="C:\\Users\\Administrator.SKY-20170306IYS\\Desktop\\Bookdata.dat";
		
		try {
			ObjectOutputStream oops=new ObjectOutputStream(new FileOutputStream(file));
			
			Book b1=new Book("西游记","可借",new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())),4);
			Book b2=new Book("三国演义","不可借",new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())),2);
			Book b3=new Book("水浒传","可借",new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())),6);
			Book b4=new Book("红楼梦","不可借",new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())),9);
			
			ArrayList blist=new ArrayList();
			blist.add(b1);
			blist.add(b2);
			blist.add(b3);
			blist.add(b4);
			
			oops.writeObject(blist);
			
			oops.close();
			
			JFrame jf=new JFrame();
			JButton send = new JButton("发送");
			JPanel jp =new JPanel();
			JPanel jp1 =new JPanel();
			JButton jb1 = new JButton("1·  新增图书");
			JButton jb2 = new JButton("2·  查看图书");
			JButton jb3 = new JButton("3·  删除图书");
			JButton jb4 = new JButton("4·  借出图书");
			JButton jb5 = new JButton("5·  归还图书");
			JButton jb6 = new JButton("6·  退出图书");
	        jp.add(jb1);
	        jp.add(jb2);
	        jp.add(jb3);
	        jp.add(jb4);
	        jp.add(jb5);
	        jp.add(jb6);
			jf.add(jp);
			jf.setLocationRelativeTo(null);
			jf.setTitle("图书管理系统");
			jf.add(jp);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setSize(400,400);
			jf.setVisible(true);
			
			//绑定jb 1.新增图书   监听
			jb1.addActionListener(new jb1Action(file));
			//绑定 jb2.查看图书   监听
			jb2.addActionListener(new jb2Action(file));
			//绑定 jb3.删除图书   监听
			jb3.addActionListener(new jb3Action(file));;
			//绑定 jb4.借出图书   监听
			jb4.addActionListener(new jb4Action(file));
			//绑定 jb5.归还图书   监听
			jb5.addActionListener(new jb5Action(file));
			//绑定 jb6.退出图书   监听
			jb6.addActionListener(new jb6Action(jf));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new Menu();
	}

}
