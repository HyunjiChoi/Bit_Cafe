package kr.or.bitcafe;

public class HotLatte extends Product {
	public HotLatte() {
		super("ÇÖ¶ó¶¼",3000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getMilk()>=1)&&(Cafe.stock.getEspresso()>=1)) {
			Cafe.stock.milkMinus();
			Cafe.stock.espressoMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.milkPlus();
		Cafe.stock.espressoPlus();
		return;
	}
	@Override
	public String toString() {
		return "HotLatte";
	}
}