package StreamSwingBook;

import java.awt.Dimension;
import java.awt.HeadlessException;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class jb2Action extends JFrame implements ActionListener{

	private String file;
	
	
	public jb2Action(String file){
		super();
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
			System.out.println("图书名称"+"     "+"图书状态"+"     "+"图书出入日期"+"     "+"借出次数");
			System.out.println(blist);
			System.out.println("************************");
			
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
