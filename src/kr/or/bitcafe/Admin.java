package kr.or.bitcafe;

public class Admin extends Man{

	public Admin() {
		super("Admin", "1234", "관리자");
	}
	
	public void showAdminMenu() {
		System.out.println("고객용 메뉴판에 추가되어 있는 메뉴");
		for(int i=0; i<Cafe.AdminMenu.size(); i++) {
			if(Cafe.AdminMenu.get(i).ispublish == true) {
				System.out.printf("[%d] %s\n",i+1,Cafe.AdminMenu.get(i).toString());
			}
		}
		System.out.println("고객용 메뉴판에 추가되어 있지 않은 메뉴");
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
				System.out.printf("%s(을)를 고객용 메뉴판가 추가했습니다..\n",Cafe.AdminMenu.get(i).toString());
			}else {
				System.out.println("이미 추가 되어 있는 메뉴입니다.");
			}			
		}else {
			System.out.println("메뉴 번호를 잘못 입력했습니다.");
		}
	}
	
	public void removeMenu(String select) {
		int  i = Integer.parseInt(select)-1;
		if(0<=i && i<=10){
			if(Cafe.AdminMenu.get(i).ispublish == true) {
				Cafe.AdminMenu.get(i).ispublish = false;
				Cafe.UserMenu.remove(i);
				System.out.printf("%s(을)를  고객용 메뉴판에서 삭제했습니다..\n",Cafe.AdminMenu.get(i).toString());
			}else {
				System.out.println("추가되어 있지 않은 메뉴입니다.");
			}			
		}else {
			System.out.println("메뉴 번호를 잘못 입력했습니다.");
		}
	}

}
