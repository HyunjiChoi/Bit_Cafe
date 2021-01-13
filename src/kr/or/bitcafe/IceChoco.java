package kr.or.bitcafe;

public class IceChoco extends Product {
	public IceChoco() {
		super("아이스초코",3000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getMilk()>=1)&&(Cafe.stock.getIce()>=1)&&(Cafe.stock.getSyrup()>=1)) {
			Cafe.stock.milkMinus();
			Cafe.stock.iceMinus();
			Cafe.stock.syrupMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.milkPlus();
		Cafe.stock.icePlus();
		Cafe.stock.syrupPlus();
		return;
	}
	@Override
	public String toString() {
		return "IceChoco";
	}
}