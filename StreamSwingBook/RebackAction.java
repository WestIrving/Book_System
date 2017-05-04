package StreamSwingBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RebackAction implements ActionListener{
	
	private String file;
	private JTextField jtf;
	

	public RebackAction(JTextField jtf,String file) {
		super();
		this.jtf=jtf;
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
			//获取输入信息msg
			String msg = jtf.getText();
			//设置标识flag，找到为true，没找到没false
					boolean flag=false;
					int i=0;
			//将借出的图书在blist中添加进去，并在状态上改为“可借”
			while(it.hasNext()){
		        i++;
				if(it.next().name.equals(msg)){
					flag=true;
					//判断该书状态
					if(blist.get(i).state=="可借"){
						JFrame jf2=new JFrame();
						JPanel jp=new JPanel();
						JLabel jl=new JLabel("该书未被借出 !");
						jp.setVisible(true);
						jl.setVisible(true);
						jp.add(jl);
						jf2.setLocationRelativeTo(null);
						jf2.add(jp);
						jf2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						jf2.setSize(500,100);
						jf2.setVisible(true);
						System.out.println("666666666");
					}else{
						blist.get(i-1).state="可借";
						blist.get(i-1).date=new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
						JFrame jf1=new JFrame();
						JPanel jp=new JPanel();
						JLabel jl=new JLabel("归还成功 !");
						jp.setVisible(true);
						jl.setVisible(true);
						jp.add(jl);
						jf1.setLocationRelativeTo(null);
						jf1.add(jp);
						jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						jf1.setSize(500,100);
						jf1.setVisible(true);
						System.out.println("7777777777");
					}
				}
			}
			if(!flag){
		    	JFrame jf3=new JFrame();
				JPanel jp=new JPanel();
				JLabel jl=new JLabel("未找到该书，请输入正确书名!");
				jp.setVisible(true);
				jl.setVisible(true);
				jp.add(jl);
				jf3.setLocationRelativeTo(null);
				jf3.add(jp);
				jf3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				jf3.setSize(500,100);
				jf3.setVisible(true);
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
