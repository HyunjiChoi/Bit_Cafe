package kr.or.bitcafe;
import java.io.Serializable;
public class Man implements Serializable {
	String name;
	String id;
	String pwd;
	Boolean isAdmin;
	Man(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		if(id.equals("Admin")) {
			this.isAdmin = true;			
		}else {
			this.isAdmin = false;
		}
	}
}