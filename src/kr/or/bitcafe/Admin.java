package kr.or.bitcafe;

public class Admin extends Man{

	public Admin() {
		super("Admin", "1234", "������");
	}
	
	public void showAdminMenu() {
		System.out.println("���� �޴��ǿ� �߰��Ǿ� �ִ� �޴�");
		for(int i=0; i<Cafe.AdminMenu.size(); i++) {
			if(Cafe.AdminMenu.get(i).ispublish == true) {
				System.out.printf("[%d] %s\n",i+1,Cafe.AdminMenu.get(i).toString());
			}
		}
		System.out.println("���� �޴��ǿ� �߰��Ǿ� ���� ���� �޴�");
		for(int i=0; i<Cafe.AdminMenu.size(); i++) {
			if(Cafe.AdminMenu.get(i).ispublish == false) {
				System.out.printf("[%d] %s\n",i+1,Cafe.AdminMenu.get(i).toString());
			}
		}
	}
	
	public void addMenu(String select) {
		int  i = Integer.parseInt(select)-1;		
		if(0<=i && i<=10) {
			if(Cafe.AdminMenu.get(i).ispublish == false) {
				Cafe.AdminMenu.get(i).ispublish = true;
				Cafe.UserMenu.add(Cafe.AdminMenu.get(i));
				System.out.printf("%s(��)�� ���� �޴��ǰ� �߰��߽��ϴ�..\n",Cafe.AdminMenu.get(i).toString());
			}else {
				System.out.println("�̹� �߰� �Ǿ� �ִ� �޴��Դϴ�.");
			}			
		}else {
			System.out.println("�޴� ��ȣ�� �߸� �Է��߽��ϴ�.");
		}
	}
	
	public void removeMenu(String select) {
		int  i = Integer.parseInt(select)-1;
		if(0<=i && i<=10){
			if(Cafe.AdminMenu.get(i).ispublish == true) {
				Cafe.AdminMenu.get(i).ispublish = false;
				Cafe.UserMenu.remove(i);
				System.out.printf("%s(��)��  ���� �޴��ǿ��� �����߽��ϴ�..\n",Cafe.AdminMenu.get(i).toString());
			}else {
				System.out.println("�߰��Ǿ� ���� ���� �޴��Դϴ�.");
			}			
		}else {
			System.out.println("�޴� ��ȣ�� �߸� �Է��߽��ϴ�.");
		}
	}

}
