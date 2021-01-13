package kr.or.bitcafe;

public class IceLatte extends Product {
	public IceLatte() {
		super("¾ÆÀÌ½º¶ó¶¼",3000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getMilk()>=1)&&(Cafe.stock.getEspresso()>=1)&&(Cafe.stock.getIce()>=1)) {
			Cafe.stock.milkMinus();
			Cafe.stock.espressoMinus();
			Cafe.stock.iceMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.milkPlus();
		Cafe.stock.espressoPlus();
		Cafe.stock.icePlus();
		return;
	}
	@Override
	public String toString() {
		return "IceLatte";
	}
}