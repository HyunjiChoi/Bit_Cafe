package kr.or.bitcafe;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Cafe {

	static ArrayList<Product> AdminMenu;
	static ArrayList<Product> UserMenu;
	HashMap<String,Man> users;
	
	Admin admin;
	static Stock stock;
	
	
	File userInfo_txt = new File("UserInfo.txt");
	FileOutputStream fos;
	FileInputStream fis;
	ObjectOutputStream out;
	ObjectInputStream in;
	BufferedOutputStream bos;
	BufferedInputStream bis;
	
	String name;
	String number;
	String adress;
	static int sales;

	public Cafe(String name, String number, String adress) {
		this.name = name;
		this.number = number;
		this.adress = adress;
		this.admin = new Admin();
		this.users = new HashMap<String,Man>();
		this.AdminMenu = new ArrayList<Product>();
		this.UserMenu = new ArrayList<Product>();
		this.stock = new Stock();
		this.sales = 0;
		this.AdminMenu.add(new IceAmericano());	//0번방
		this.AdminMenu.add(new HotAmericano());	//1
		this.AdminMenu.add(new IceLatte());		//2
		this.AdminMenu.add(new HotLatte());		//3
		this.AdminMenu.add(new IceChoco());		//4
		this.AdminMenu.add(new HotChoco());		//5
		this.AdminMenu.add(new IceMocha());		//6
		this.AdminMenu.add(new HotMocha());		//7
		this.AdminMenu.add(new LemonAde());		//8
		this.AdminMenu.add(new GrapefruitAde());//9
		this.AdminMenu.add(new DessertSet());	//10
		this.users.put(admin.id, admin);
	}
	public Man signIn(String id, String pwd) {
		Man man = null;
		load();
		man = users.get(id);
		return man;
	}
	public boolean checkID(String id) {
		boolean check = false;
		if(!users.containsKey(id)){
			check = true;
		}
		return check;
	}
	public boolean checkPW(String id) {
		boolean check = false;
		if(!users.containsValue(id)){
			check = true;
		}
		return check;
	}
	public void signUp(String id, String pwd, String name) {
			User user = new User(id, pwd, name);
			users.put(id, user);
			save();
			return;
	}
	public void showSales() {
		System.out.println("카페 총 매출: "+this.sales);
	}
	public void cafeInfo() {
		System.out.println("카페 상호명: "+ this.name);
		System.out.println("카페 전화번호:" + this.number);
		System.out.println("카페 주소: "+this.adress);
	}
	public void save() {
		try {
			fos = new FileOutputStream(userInfo_txt);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);
			out.writeObject(users);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		try {
			fis = new FileInputStream(userInfo_txt);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			users = (HashMap<String,Man>)in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}