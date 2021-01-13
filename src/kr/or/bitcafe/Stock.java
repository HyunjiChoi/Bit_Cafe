package kr.or.bitcafe;

public class Stock {
	private int water;
	private int milk;
	private int espresso;
	private int syrup;
	private int ice;
	private int spakling;
	private int cake;
	private int bread;
	private int macaron;
	
	//생성자
	public Stock() {
		this.water = 100;
		this.milk = 0;
		this.espresso=100;
		this.syrup=0;
		this.ice=100;
		this.spakling=0;
		this.cake=0;
		this.bread=0;
		this.macaron=0;
	}
	
	public void waterMinus() {
		this.water--;
	}
	public void milkMinus() {
		this.milk--;
	}
	public void espressoMinus() {
		this.espresso--;
	}
	public void syrupMinus() {
		this.syrup--;
	}
	public void iceMinus() {
		this.ice--;
	}
	public void spaklingMinus() {
		this.spakling--;
	}
	public void cakeMinus() {
		this.cake--;
	}
	public void breadMinus() {
		this.bread--;
	}
	public void macaronMinus() {
		this.macaron--;
	}
	
	public void waterPlus() {
		this.water++;
	}
	public void milkPlus() {
		this.milk++;
	}
	public void espressoPlus() {
		this.espresso++;
	}
	public void syrupPlus() {
		this.syrup++;
	}
	public void icePlus() {
		this.ice++;
	}
	public void spaklingPlus() {
		this.spakling++;
	}
	public void cakePlus() {
		this.cake++;
	}
	public void breadPlus() {
		this.bread++;
	}
	public void macaronPlus() {
		this.macaron++;
	}
	
	//getter
	public int getWater() {
		return water;
	}
	public int getMilk() {
		return milk;
	}
	public int getEspresso() {
		return espresso;
	}
	public int getSyrup() {
		return syrup;
	}
	public int getIce() {
		return ice;
	}
	public int getSpakling() {
		return spakling;
	}
	public int getCake() {
		return cake;
	}
	public int getBread() {
		return bread;
	}
	public int getMacaron() {
		return macaron;
	}
	
	
	//restock
	public String restock(int choiceStock,int amount) {
		String stockName = null;
		switch(choiceStock){
		case 1:
			this.water+=amount;
			stockName = "water";
			break;
		case 2: 
			this.milk+=amount;
			stockName = "milk";
			break;
		case 3: 
			this.espresso+=amount;
			stockName = "espresso";
			break;
		case 4: 
			this.syrup+=amount;
			stockName = "syrup";
			break;
		case 5: 
			this.ice+=amount;
			stockName = "ice";
			break;
		case 6: 
			this.spakling+=amount;
			stockName = "spakling";
			break;
		case 7: 
			this.cake+=amount;
			stockName = "cake";
			break;
		case 8: 
			this.bread+=amount;
			stockName = "amount";
			break;
		case 9: 
			this.macaron+=amount;
			stockName = "macaron";
			break;
			
		default: 
			System.out.println("******오류 발생******");
			System.out.println("잘못 입력했습니다....");
		break;
		}
		return stockName;
	}
	
	public void StockSatus() {
		System.out.printf("[1] %s : %d\n", "water", water);
		System.out.printf("[2] %s : %d\n", "milk", milk);
		System.out.printf("[3] %s : %d\n", "espresso", espresso);
		System.out.printf("[4] %s : %d\n", "syrup", syrup);
		System.out.printf("[5] %s : %d\n", "ice", ice);
		System.out.printf("[6] %s : %d\n", "spakling", spakling);
		System.out.printf("[7] %s : %d\n", "cake", cake);
		System.out.printf("[8] %s : %d\n", "bread", bread);
		System.out.printf("[9] %s : %d\n", "macaron", macaron);
	}
	
}