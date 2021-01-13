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

	public void showUserMenu() { //자동 호출
		for(int i=0;i<Cafe.UserMenu.size();i++) {
			if(Cafe.UserMenu.get(i).ispublish==true) {
				switch(Cafe.UserMenu.get(i).toString()) {
				case "IceAmericano" : System.out.printf("[1] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotAmericano" : System.out.printf("[2] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "IceLatte" : System.out.printf("[3] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotLatte" : System.out.printf("[4] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "IceMocha" : System.out.printf("[5] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotMocha" : System.out.printf("[6] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "IceChoco" : System.out.printf("[7] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "HotChoco" : System.out.printf("[8] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "LemonAde" : System.out.printf("[9] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "GrapefruitAde" : System.out.printf("[10] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				break;
				case "DessertSet" : System.out.printf("[11] %s  %d원\n", Cafe.UserMenu.get(i),Cafe.UserMenu.get(i).price); 
				}
			}
		}
			//ispublish가 true인 product객체들만 출력하기
			//Product 객체 나열 ...
			//1.아메리카노 2. 라떼, 3. 모카 ...
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
					default: System.out.println("잘못 입력했습니다.");
					break;
					}
				}else {
					System.out.println("재료가 부족합니다...");
				}
			}else {
				System.out.println("메뉴 번호을 다시 확인해주세요....");
			}
		}else {
			System.out.println("메뉴 번호을 다시 확인해주세요....");
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
				System.out.printf("[%d번 카트] %s \n",i+1,cart.get(i));
			}
			result = true;
		}else {
			System.out.println("현재 장바구니가 비어있습니다.");
		}
		return result;
	}
	
	public int chargePoint(int money) {
		this.point += money;
		return this.point;
	}
	
	
	public void couponPoint_Balance() {
		System.out.printf("%s님의 쿠폰[%d]개, 카드잔액[%d]원 입니다\n",this.name,this.coupon,this.point);
	}
	
	public boolean couponCheck() {
		boolean result = false;
		if(this.coupon>=10) {
			System.out.println("쿠폰을 사용할 수 있습니다..");
			result = true;
		}else {
			System.out.println("쿠폰을 사용할 수 없습니다..");
			System.out.println("쿠폰은 10개단위로 사용 가능합니다.");
			System.out.println("결제 중 ..... ");
		}
			return result;
	}
	
	public boolean payment(int totalPrice) {
		boolean result;
		if(this.point>=totalPrice) {
			result = true;
			this.point -= totalPrice;
			System.out.println("결제가 정상적으로 처리되었습니다.");
			this.coupon += this.cart.size();
			for(int i=0; i<cart.size(); i++) {
				item.add(cart.get(i));
			}
			cart.clear();
		}else {
			System.out.println("카드 잔액이 부족합니다. 충전해주세요...");
			result = false;
		}
		return result;
	}
}
