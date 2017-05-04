package StreamSwingBook;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendAction extends JFrame implements ActionListener{
	
	private JTextField jtf;
    private String file;


	public SendAction(JTextField jtf,String file){
		super();
		this.jtf = jtf;
		this.file=file;
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Book> blist=new ArrayList<Book>();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			blist=(ArrayList)ois.readObject();
			ois.close();
			Iterator<Book> it=blist.iterator();
			//得到输入框信息
			String msg = jtf.getText();
			//设置标识flag，找到为true，没找到没false
					boolean flag=false;
					int i=0;
			while(it.hasNext()){
				if(it.next().name.equals(msg)){
					flag=true;
					i++;
				}
			}
			if(flag){  //如果flag为true说明msg在blist中找到，并在状态上改为“借出”,借阅次数加1
				if(blist.get(i-1).state.equals("可借")){
					blist.get(i-1).state="不可借";
					blist.get(i-1).date=new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
					blist.get(i-1).sentno++;
					//弹出借阅成功！的提示窗口面板
					JFrame jf1=new JFrame();
					JPanel jp=new JPanel();
					JLabel jl=new JLabel(" 借阅成功! ");
					jp.setVisible(true);
					jl.setVisible(true);
					jp.add(jl);
					jf1.setLocationRelativeTo(null);
					jf1.add(jp);
					jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf1.setSize(500,100);
					jf1.setVisible(true);
				}else{
					//弹出该书未被借出！的提示窗口面板
					JFrame jf2=new JFrame();
					JPanel jp=new JPanel();
					JLabel jl=new JLabel(" 该书已被借出! ");
					jp.setVisible(true);
					jl.setVisible(true);
					jp.add(jl);
					jf2.setLocationRelativeTo(null);
					jf2.add(jp);
					jf2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf2.setSize(500,100);
					jf2.setVisible(true);
					
				}
			}else{
				//提示"请输入正确书名 !"
				JFrame jf=new JFrame();
				JPanel jp=new JPanel();
				JLabel jl=new JLabel("没有找到输入的书名,请输入正确书名 !");
				jp.setVisible(true);
				jl.setVisible(true);
				jp.add(jl);
				jf.setLocationRelativeTo(null);
				jf.add(jp);
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				jf.setSize(500,100);
				jf.setVisible(true);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ArrayList<Book> newblist=new ArrayList<Book>();
			newblist=blist;
			ObjectOutputStream oops=new ObjectOutputStream(new FileOutputStream(file));
			
            oops.writeObject(newblist);
			
			oops.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	

}
