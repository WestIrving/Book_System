package StreamSwingBook;

import java.io.Serializable;

public class Book implements Serializable{

	public String name;  //图书名称
	public String state;  //图书状态
	public String date;   //图书借阅日期
	public int sentno;  //图书被借次数
	public Book(String name, String state, String date,int sentno) {
		
		this.name = name;
		this.state = state;
		this.date = date;
		this.sentno=sentno;
	}
	@Override
	public String toString() {
		return "name=" + name + ", state=" + state + ", date=" + date + ", sentno=" + sentno +"\n";
		
	}
	



}