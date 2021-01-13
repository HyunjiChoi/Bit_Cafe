package kr.or.bitcafe;

public class GrapefruitAde extends Product {
	public GrapefruitAde() {
		super("ÀÚ¸ù¿¡ÀÌµå",5000);
	}
	@Override
	public boolean make() {
		boolean check = false;
		if((Cafe.stock.getSpakling()>=1)&&(Cafe.stock.getIce()>=1)&&(Cafe.stock.getSyrup()>=1)) {
			Cafe.stock.spaklingMinus();
			Cafe.stock.iceMinus();
			Cafe.stock.syrupMinus();
			check = true;
		}
		return check;
	}
	public void cancleCart() {
		Cafe.stock.spaklingPlus();
		Cafe.stock.icePlus();
		Cafe.stock.syrupPlus();
		return;
	}
	@Override
	public String toString() {
		return "GrapeFruitAde";
	}
}
