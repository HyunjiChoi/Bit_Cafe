package kr.or.bitcafe;

import java.io.IOException;
import java.util.Scanner;

public class CafeUI {
	
	Scanner sc = new Scanner(System.in);
	Cafe cafe = new Cafe("bit cafe", "1588-1588", "서울특별시 강남구");
	String id;
	String pwd;
	String name;
	Man man;
	
	//1.초기화면
	public void mainUI() throws IOException {
		
		boolean start = true;
		
		do {
			System.out.printf("반갑습니다. %s입니다.\n", cafe.name);
			System.out.println("원하시는 메뉴를 선택해주세요.");
			System.out.println("1. Sign in 2. Sign up 0. System exit");
			String select = sc.nextLine();
			
			switch(select) {
			case "0": System.exit(0);
			case "1": // sign in
				System.out.print("id > ");
				this.id = sc.nextLine();
				System.out.print("pwd > ");
				this.pwd = sc.nextLine();
				this.man = cafe.signIn(this.id, this.pwd);
				if(this.man!=null) { // user = null -> 로그인 실패
					start = false;
				}else {
					System.out.println("일치하는 회원 정보가 없습니다.");
				}
				break;
			case "2": // sign up		
				System.out.print("id> ");
				this.id = sc.nextLine();
				if(cafe.checkID(this.id)) {
					System.out.print("pwd> ");
					this.pwd = sc.nextLine();
					System.out.print("name> ");
					this.name = sc.nextLine();
					cafe.signUp(this.id, this.pwd, this.name);
				}else {
					System.out.println("중복된 ID입니다.");
				}
				break;
			default: System.out.println("wrong select");
				break;
			}
		}
		while(start);
	}
	
	//2. 사용자별 메뉴
	public void UersUI(){
		boolean start = true;
		System.out.printf("반갑습니다. %s님\n", man.name);
		System.out.println("원하시는 메뉴를 입력해주세요.");
		
		if(man.isAdmin) {
			Admin admin = (Admin)man;
			do {
				System.out.println("[1]가게정보  [2]재고관리  [3]메뉴관리 [4]매출확인 [5]로그아웃");
				String select = sc.nextLine();
				switch(select) {
				case "1" : //[1]가게정보
					cafe.cafeInfo();
					break;
					
				case "2" : //[2]재고관리
					System.out.println("*****재고 현황 *****");
					cafe.stock.StockSatus();
					System.out.println("*****************");
					System.out.println("충전하고 싶은 재고 번호와 수량을 차례로 입력해주세요.");
					System.out.print("재고 >");
					int choiceStock = Integer.parseInt(sc.nextLine());
					System.out.print("수량 >");
					int amount = Integer.parseInt(sc.nextLine());
					String stockName = cafe.stock.restock(choiceStock, amount);
					if(stockName != null) {
						System.out.printf("%s가 %d개 충전되었습니다.\n", stockName, amount);
					}else {
					}
					break;
					
				case "3" ://[3]메뉴관리
					System.out.println("******************************");
					cafe.admin.showAdminMenu();
					System.out.println("******************************");
					System.out.println("[1]메뉴 추가 [2]메뉴 삭제 [0]이전 화면");
					String selectMenu = sc.nextLine();
					switch(selectMenu) {
						case "1" : 
							System.out.println("추가할 메뉴를 선택해주세요.");
							selectMenu = sc.nextLine();
							cafe.admin.addMenu(selectMenu);
							break;
						case "2" : 
							System.out.println("삭제할 메뉴를 입력해주세요.");
							selectMenu = sc.nextLine();
							cafe.admin.removeMenu(selectMenu);
							break;
						case "0" : System.out.println("이전 화면으로 돌아갑니다.");
						break;
						default : System.out.println("잘못 입력했습니다.");
						break;
					}
					break;
				case "4" : //[4]매출확인
					System.out.println("******************************");
					cafe.showSales();
					System.out.println("******************************");
					break;
				case "5" : //[5]로그아웃
					System.out.println("");
					start = false;
					break;
				}		
			}while(start);
		}else {
			start = true;
			User user = (User)man;
			int totalPrice = 0; 
			boolean power = true;
			do {
				System.out.println("[1]회원정보 확인  [2]메뉴선택  [3]장바구니 [4]카드충전 [5]결제하기 [6]로그아웃");
				String select = sc.nextLine();
				switch(select) {
				case "1" : //[1]회원정보확인
					System.out.println(user.toString());
					break;
				case "2" : //[2]메뉴선택
					System.out.println("********메뉴판********");
					user.showUserMenu();
					System.out.println("*********************");
					System.out.println("원하시는 메뉴 번호를 입력하세요.");
					int selectMenuNum = Integer.parseInt(sc.nextLine());
					String selectMenuName = user.addProduct(selectMenuNum);
					if(selectMenuName != null) {
						System.out.printf("선택하신 %s가 장바구니에 추가되었습니다.\n", selectMenuName);						
					}else {
						System.out.println("초기화면으로 돌아갑니다.");				
					}
					break;
				case "3" : //[3]장바구니
					System.out.println("********장바구니*********");
					if(user.showCart()) {
						System.out.println("**********************");
						System.out.println("[1]선택 삭제 [2]장바구니 비우기 [0]이전 화면");
						String selectMenu = sc.nextLine();
						switch(selectMenu) {
						case"1" : 
							System.out.print("삭제할 장바구니 번호를 입력하세요 >");
							int num = Integer.parseInt(sc.nextLine());
							if(user.minusProduct(num)) {
								System.out.printf("%d번째 장바구니 품목을 삭제했습니다.\n",num);
							}else {
								System.out.println("잘못 입력했습니다.");
							}
							break;
						case"2" : 
							user.minusProduct();
							System.out.println("장바구니를 비웠습니다...");
						break;
						case"0" : System.out.println("이전 화면으로....");
						break;
						}						
					}
					break;
				case "4" : //[4]카드충전
					System.out.println("*****선불 카드 충전 *****");
					System.out.println("충전하실 금액을 입력하세요.");
					int money = Integer.parseInt(sc.nextLine());
					user.chargePoint(money);
					System.out.printf("%d원을 충전합니다.\n", money);
					System.out.printf("현재 카드의 남은 잔액은 %d원입니다.\n",user.point);
					break;
			
				case "5" : //[5]결제하기
					totalPrice  = 0;
					System.out.println("*****계산서******");
					if(user.showCart()){
						System.out.println("***************");
						for(Product product : user.cart) {
							totalPrice += product.price;
						}
						System.out.printf("총 결제 금액은 [%d]원 입니다\n", totalPrice);
						System.out.println("결제 하시겠습니까?");
						System.out.println("[1]결제하기  [2]뒤로가기...");
						boolean power1 = true;
						while(power1) {
							switch(sc.nextLine()) {
							case "1" :
								System.out.println("*****결제하기*****");
								System.out.println("*****결제   전*****");
								user.couponPoint_Balance();
								if(user.couponCheck()){
									System.out.println("쿠폰을 사용하시겠습니까?");
									System.out.println("[1]쿠폰 사용 [2]쿠폰미사용");
									boolean power2 = true;
									while(power2) {
										switch(sc.nextLine()) {
										case "1" :
											if(user.payment(totalPrice-2000)) {
												user.coupon -= 10;
												Cafe.sales += (totalPrice-2000);
												System.out.println("*****결제   후*****");
												user.couponPoint_Balance();
												power2 = false;
											}
											break;
										case "2" :
											if(user.payment(totalPrice)) {
												Cafe.sales += (totalPrice);
												System.out.println("*****결제   후*****");
												user.couponPoint_Balance();
												power2 = false;
											}
											break;
										default : System.out.println("다시 입력해주세요.");
										break;
										}
									}									
								}else {
									if(user.payment(totalPrice)) {
										user.coupon += user.cart.size();
										Cafe.sales += (totalPrice);
									}
								}
								power1 = false;								
						case "2" :	
							System.out.println("뒤로가기.....");
							power1 = false;
							break;
						default : System.out.println("입력 오류... 다시 입력해주세요.");
							break;
						}	
					}
				}
					break;
				case "6" : //[6]로그아웃
					System.out.println("로그아웃합니다.");
					start = false;
					break;
				}
			}while(start);	
		}		
	}	
}