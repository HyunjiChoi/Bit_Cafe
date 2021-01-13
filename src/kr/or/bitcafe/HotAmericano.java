package kr.or.bitcafe;

public class HotAmericano extends Product {
	public HotAmericano() {
		super("아메리카노",2000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getWater()>=1)&&(Cafe.stock.getEspresso()>=1)) {
			Cafe.stock.waterMinus();
			Cafe.stock.espressoMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.waterPlus();
		Cafe.stock.espressoPlus();
		return;
	}
	@Override
	public String toString() {
		return "HotAmericano";
	}
	
}