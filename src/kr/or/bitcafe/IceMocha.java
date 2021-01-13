package kr.or.bitcafe;

public class IceMocha extends Product {
	public IceMocha() {
		super("아이스모카",4000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getMilk()>=1)&&(Cafe.stock.getEspresso()>=1)&&(Cafe.stock.getIce()>=1)&&(Cafe.stock.getSyrup()>=1)) {
			Cafe.stock.milkMinus();
			Cafe.stock.espressoMinus();
			Cafe.stock.iceMinus();
			Cafe.stock.syrupMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.milkPlus();
		Cafe.stock.espressoPlus();
		Cafe.stock.icePlus();
		Cafe.stock.syrupPlus();
		return;
	}
	@Override
	public String toString() {
		return "IceMocha";
	}
}