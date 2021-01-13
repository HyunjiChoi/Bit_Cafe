package kr.or.bitcafe;

public class HotMocha extends Product {
	public HotMocha() {
		super("ÇÖ¸ðÄ«",4000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getMilk()>=1)&&(Cafe.stock.getEspresso()>=1)&&(Cafe.stock.getSyrup()>=1)) {
			Cafe.stock.milkMinus();
			Cafe.stock.espressoMinus();
			Cafe.stock.syrupMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.milkPlus();
		Cafe.stock.espressoPlus();
		Cafe.stock.syrupPlus();
		return;
	}
	@Override
	public String toString() {
		return "HotMocha";
	}
}