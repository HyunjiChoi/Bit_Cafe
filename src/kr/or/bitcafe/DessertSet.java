package kr.or.bitcafe;

public class DessertSet extends Product {
	public DessertSet() {
		super("디저트 세트",15000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getCake()>=1)&&(Cafe.stock.getBread()>=1)&&(Cafe.stock.getMacaron()>=1)) {
			Cafe.stock.cakeMinus();
			Cafe.stock.breadMinus(); 
			Cafe.stock.macaronMinus();
			check = true;			
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.cakePlus();
		Cafe.stock.breadPlus(); 
		Cafe.stock.macaronPlus();
		return;
	}
	@Override
	public String toString() {
		return "DessertSet";
	}
}