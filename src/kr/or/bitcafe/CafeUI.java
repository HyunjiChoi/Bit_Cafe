package kr.or.bitcafe;

import java.io.IOException;
import java.util.Scanner;

public class CafeUI {
	
	Scanner sc = new Scanner(System.in);
	Cafe cafe = new Cafe("bit cafe", "1588-1588", "����Ư���� ������");
	String id;
	String pwd;
	String name;
	Man man;
	
	//1.�ʱ�ȭ��
	public void mainUI() throws IOException {
		
		boolean start = true;
		
		do {
			System.out.printf("�ݰ����ϴ�. %s�Դϴ�.\n", cafe.name);
			System.out.println("���Ͻô� �޴��� �������ּ���.");
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
				if(this.man!=null) { // user = null -> �α��� ����
					start = false;
				}else {
					System.out.println("��ġ�ϴ� ȸ�� ������ �����ϴ�.");
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
					System.out.println("�ߺ��� ID�Դϴ�.");
				}
				break;
			default: System.out.println("wrong select");
				break;
			}
		}
		while(start);
	}
	
	//2. ����ں� �޴�
	public void UersUI(){
		boolean start = true;
		System.out.printf("�ݰ����ϴ�. %s��\n", man.name);
		System.out.println("���Ͻô� �޴��� �Է����ּ���.");
		
		if(man.isAdmin) {
			Admin admin = (Admin)man;
			do {
				System.out.println("[1]��������  [2]������  [3]�޴����� [4]����Ȯ�� [5]�α׾ƿ�");
				String select = sc.nextLine();
				switch(select) {
				case "1" : //[1]��������
					cafe.cafeInfo();
					break;
					
				case "2" : //[2]������
					System.out.println("*****��� ��Ȳ *****");
					cafe.stock.StockSatus();
					System.out.println("*****************");
					System.out.println("�����ϰ� ���� ��� ��ȣ�� ������ ���ʷ� �Է����ּ���.");
					System.out.print("��� >");
					int choiceStock = Integer.parseInt(sc.nextLine());
					System.out.print("���� >");
					int amount = Integer.parseInt(sc.nextLine());
					String stockName = cafe.stock.restock(choiceStock, amount);
					if(stockName != null) {
						System.out.printf("%s�� %d�� �����Ǿ����ϴ�.\n", stockName, amount);
					}else {
					}
					break;
					
				case "3" ://[3]�޴�����
					System.out.println("******************************");
					cafe.admin.showAdminMenu();
					System.out.println("******************************");
					System.out.println("[1]�޴� �߰� [2]�޴� ���� [0]���� ȭ��");
					String selectMenu = sc.nextLine();
					switch(selectMenu) {
						case "1" : 
							System.out.println("�߰��� �޴��� �������ּ���.");
							selectMenu = sc.nextLine();
							cafe.admin.addMenu(selectMenu);
							break;
						case "2" : 
							System.out.println("������ �޴��� �Է����ּ���.");
							selectMenu = sc.nextLine();
							cafe.admin.removeMenu(selectMenu);
							break;
						case "0" : System.out.println("���� ȭ������ ���ư��ϴ�.");
						break;
						default : System.out.println("�߸� �Է��߽��ϴ�.");
						break;
					}
					break;
				case "4" : //[4]����Ȯ��
					System.out.println("******************************");
					cafe.showSales();
					System.out.println("******************************");
					break;
				case "5" : //[5]�α׾ƿ�
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
				System.out.println("[1]ȸ������ Ȯ��  [2]�޴�����  [3]��ٱ��� [4]ī������ [5]�����ϱ� [6]�α׾ƿ�");
				String select = sc.nextLine();
				switch(select) {
				case "1" : //[1]ȸ������Ȯ��
					System.out.println(user.toString());
					break;
				case "2" : //[2]�޴�����
					System.out.println("********�޴���********");
					user.showUserMenu();
					System.out.println("*********************");
					System.out.println("���Ͻô� �޴� ��ȣ�� �Է��ϼ���.");
					int selectMenuNum = Integer.parseInt(sc.nextLine());
					String selectMenuName = user.addProduct(selectMenuNum);
					if(selectMenuName != null) {
						System.out.printf("�����Ͻ� %s�� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.\n", selectMenuName);						
					}else {
						System.out.println("�ʱ�ȭ������ ���ư��ϴ�.");				
					}
					break;
				case "3" : //[3]��ٱ���
					System.out.println("********��ٱ���*********");
					if(user.showCart()) {
						System.out.println("**********************");
						System.out.println("[1]���� ���� [2]��ٱ��� ���� [0]���� ȭ��");
						String selectMenu = sc.nextLine();
						switch(selectMenu) {
						case"1" : 
							System.out.print("������ ��ٱ��� ��ȣ�� �Է��ϼ��� >");
							int num = Integer.parseInt(sc.nextLine());
							if(user.minusProduct(num)) {
								System.out.printf("%d��° ��ٱ��� ǰ���� �����߽��ϴ�.\n",num);
							}else {
								System.out.println("�߸� �Է��߽��ϴ�.");
							}
							break;
						case"2" : 
							user.minusProduct();
							System.out.println("��ٱ��ϸ� ������ϴ�...");
						break;
						case"0" : System.out.println("���� ȭ������....");
						break;
						}						
					}
					break;
				case "4" : //[4]ī������
					System.out.println("*****���� ī�� ���� *****");
					System.out.println("�����Ͻ� �ݾ��� �Է��ϼ���.");
					int money = Integer.parseInt(sc.nextLine());
					user.chargePoint(money);
					System.out.printf("%d���� �����մϴ�.\n", money);
					System.out.printf("���� ī���� ���� �ܾ��� %d���Դϴ�.\n",user.point);
					break;
			
				case "5" : //[5]�����ϱ�
					totalPrice  = 0;
					System.out.println("*****��꼭******");
					if(user.showCart()){
						System.out.println("***************");
						for(Product product : user.cart) {
							totalPrice += product.price;
						}
						System.out.printf("�� ���� �ݾ��� [%d]�� �Դϴ�\n", totalPrice);
						System.out.println("���� �Ͻðڽ��ϱ�?");
						System.out.println("[1]�����ϱ�  [2]�ڷΰ���...");
						boolean power1 = true;
						while(power1) {
							switch(sc.nextLine()) {
							case "1" :
								System.out.println("*****�����ϱ�*****");
								System.out.println("*****����   ��*****");
								user.couponPoint_Balance();
								if(user.couponCheck()){
									System.out.println("������ ����Ͻðڽ��ϱ�?");
									System.out.println("[1]���� ��� [2]�����̻��");
									boolean power2 = true;
									while(power2) {
										switch(sc.nextLine()) {
										case "1" :
											if(user.payment(totalPrice-2000)) {
												user.coupon -= 10;
												Cafe.sales += (totalPrice-2000);
												System.out.println("*****����   ��*****");
												user.couponPoint_Balance();
												power2 = false;
											}
											break;
										case "2" :
											if(user.payment(totalPrice)) {
												Cafe.sales += (totalPrice);
												System.out.println("*****����   ��*****");
												user.couponPoint_Balance();
												power2 = false;
											}
											break;
										default : System.out.println("�ٽ� �Է����ּ���.");
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
							System.out.println("�ڷΰ���.....");
							power1 = false;
							break;
						default : System.out.println("�Է� ����... �ٽ� �Է����ּ���.");
							break;
						}	
					}
				}
					break;
				case "6" : //[6]�α׾ƿ�
					System.out.println("�α׾ƿ��մϴ�.");
					start = false;
					break;
				}
			}while(start);	
		}		
	}	
}