package kr.or.bitcafe;

import java.util.ArrayList;

public class User extends Man {
	
	int point;
	int coupon;
	ArrayList<Product> cart;
	ArrayList<Product> item;
	
	User(String id, String pwd, String name) {
		super(id, pwd, name);
		this.point = 0;
		this.coupon = 0;
		this.cart = new ArrayList<Product>();
		this.item = new ArrayList<Product>();
	}
	
	@Override
	public String toString() {
		return "User [point=" + point + ", coupon=" + coupon + ", name=" + name + ", id=" + id + "]";
	}

	public void showUserMenu() { //�ڵ� ȣ��
		for(int i=0;i<Cafe.UserMenu.size();i++) {
			if(Cafe.UserMenu.get(i).ispublish==true) {
				switch(Cafe.UserMenu.get(i).toString()) {
				case "IceAmericano" : System.out.printf("[1] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotAmericano" : System.out.printf("[2] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "IceLatte" : System.out.printf("[3] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotLatte" : System.out.printf("[4] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "IceMocha" : System.out.printf("[5] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotMocha" : System.out.printf("[6] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "IceChoco" : System.out.printf("[7] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotChoco" : System.out.printf("[8] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "LemonAde" : System.out.printf("[9] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "GrapefruitAde" : System.out.printf("[10] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "DessertSet" : System.out.printf("[11] %s  %d��\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				}
			}
		}
			//ispublish�� true�� product��ü�鸸 ����ϱ�
			//Product ��ü ���� ...
			//1.�Ƹ޸�ī�� 2. ��, 3. ��ī ...
	}
	public String addProduct(int selectMenuNum){
		String selectMenuName = null;
		if(0<selectMenuNum && selectMenuNum<12) {
			if(Cafe.AdminMenu.get(selectMenuNum-1).ispublish==true) {
				if(Cafe.AdminMenu.get(selectMenuNum-1).make()) {
					switch(selectMenuNum) {
					case 1 :
						cart.add(new IceAmericano());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();			
						break;				
					case 2 :
						cart.add(new HotAmericano());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 3 :
						cart.add(new IceLatte());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;	
					case 4 :
						cart.add(new HotLatte());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 5 :
						cart.add(new IceMocha());	
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 6 :	
						cart.add(new HotMocha());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 7 :
						cart.add(new IceChoco());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 8 :
						cart.add(new HotChoco());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 9 :
						cart.add(new LemonAde());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 10 :
						cart.add(new GrapefruitAde());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					case 11 :
						cart.add(new DessertSet());
						selectMenuName = Cafe.AdminMenu.get(selectMenuNum-1).toString();
						break;
					default: System.out.println("�߸� �Է��߽��ϴ�.");
					break;
					}
				}else {
					System.out.println("��ᰡ �����մϴ�...");
				}
			}else {
				System.out.println("�޴� ��ȣ�� �ٽ� Ȯ�����ּ���....");
			}
		}else {
			System.out.println("�޴� ��ȣ�� �ٽ� Ȯ�����ּ���....");
		}
		return selectMenuName;
	}
	
	public boolean minusProduct(int num) {
		boolean result = false;
		if(cart.get(num-1)!=null) {
			cart.get(num-1).cancleCart();
			cart.remove(num-1);
			result = true;
		}
		return result;
	}
	
	public void minusProduct() {
		cart.clear();
	}
	
	public boolean showCart() {
		boolean result = false;
		if(cart.size() != 0) {			
			for(int i=0; i<cart.size(); i++) {
				System.out.printf("[%d�� īƮ] %s \n",i+1,cart.get(i));
			}
			result = true;
		}else {
			System.out.println("���� ��ٱ��ϰ� ����ֽ��ϴ�.");
		}
		return result;
	}
	
	public int chargePoint(int money) {
		this.point += money;
		return this.point;
	}
	
	
	public void couponPoint_Balance() {
		System.out.printf("%s���� ����[%d]��, ī���ܾ�[%d]�� �Դϴ�\n",this.name,this.coupon,this.point);
	}
	
	public boolean couponCheck() {
		boolean result = false;
		if(this.coupon>=10) {
			System.out.println("������ ����� �� �ֽ��ϴ�..");
			result = true;
		}else {
			System.out.println("������ ����� �� �����ϴ�..");
			System.out.println("������ 10�������� ��� �����մϴ�.");
			System.out.println("���� �� ..... ");
		}
			return result;
	}
	
	public boolean payment(int totalPrice) {
		boolean result;
		if(this.point>=totalPrice) {
			result = true;
			this.point -= totalPrice;
			System.out.println("������ ���������� ó���Ǿ����ϴ�.");
			this.coupon += this.cart.size();
			for(int i=0; i<cart.size(); i++) {
				item.add(cart.get(i));
			}
			cart.clear();
		}else {
			System.out.println("ī�� �ܾ��� �����մϴ�. �������ּ���...");
			result = false;
		}
		return result;
	}
}
