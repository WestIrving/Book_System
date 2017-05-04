package StreamSwingBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewAddAction extends JFrame implements ActionListener{
	
	private JTextField jtf;
	private String file;
	
	public NewAddAction(JTextField jtf,String file) {
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
			//获取输入的图书名称msg
			String msg = jtf.getText();
			boolean flag=false;
			    //创建一个指向blist集合的遍历器
				Iterator<Book> it=blist.iterator();
				//判断blist.name是否等于输入的 msg
					while(it.hasNext()){
						if(it.next().name.equals(msg)){
							flag=true;
							JFrame jf1=new JFrame();
							JPanel jp=new JPanel();
							JLabel jl=new JLabel("已存在该书名!");
							jp.setVisible(true);
							jl.setVisible(true);
							jp.add(jl);
							jf1.setLocationRelativeTo(null);
							jf1.add(jp);
							jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							jf1.setSize(500,100);
							jf1.setVisible(true);
							System.out.println("-----------------------");
						}
						
					}
					if(flag==false){
						blist.add(new Book(msg, "可借", new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())), 0));
						JFrame jf2=new JFrame();
						JPanel jp=new JPanel();
						JLabel jl=new JLabel("添加成功!");
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
		
