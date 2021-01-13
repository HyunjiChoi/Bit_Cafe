package kr.or.bitcafe;

public class HotChoco extends Product {
	public HotChoco() {
		super("ÇÖÃÊÄÚ",3000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getMilk()>=1)&&(Cafe.stock.getSyrup()>=1)) {
			Cafe.stock.milkMinus();
			Cafe.stock.syrupMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.milkPlus();
		Cafe.stock.syrupPlus();
		return;
	}
	@Override
	public String toString() {
		return "HotChoco";
	}
}