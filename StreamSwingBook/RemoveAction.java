package StreamSwingBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveAction implements ActionListener{
	private JTextField jtf;
	private String file;
	
	public RemoveAction(JTextField jtf,String file) {
		super();
		this.jtf = jtf;
		this.file=file;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//获取输入的图书名称msg
		String msg = jtf.getText();
		ArrayList<Book> blist=new ArrayList<Book>();
		
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			blist=(ArrayList)ois.readObject();
			ois.close();
			Iterator<Book> it=blist.iterator();
			 
			//设置标识flag，找到为true，没找到没false
			boolean flag=false;
			int i=0;
			//检查blist集合中是否存在输出的图书名称
			while(it.hasNext()){
				
				if(it.next().name.equals(msg)){
				    //进入if说明存在，即删除
					blist.remove(i);
					//弹出删除成功的提示窗口面板
					JFrame jf1=new JFrame();
					JPanel jp=new JPanel();
					JLabel jl=new JLabel("删除成功!");
					jp.setVisible(true);
					jl.setVisible(true);
					jp.add(jl);
					jf1.setLocationRelativeTo(null);
					jf1.add(jp);
					jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf1.setSize(500,100);
					jf1.setVisible(true);
					flag = true;
					break;
				}
				i++;//i用来记录it遍历的次数
			}
			    if(!flag){  //从if进来说明没有找到输入的书名
			    	
			    	//提示"请输入正确书名 !"
					JFrame jf2=new JFrame();
					JPanel jp=new JPanel();
					JLabel jl=new JLabel("没有找到输入的书名,请输入正确书名 !");
					jp.setVisible(true);
					jl.setVisible(true);
					jp.add(jl);
					jf2.setLocationRelativeTo(null);
					jf2.add(jp);
					jf2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf2.setSize(500,100);
					jf2.setVisible(true);
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
