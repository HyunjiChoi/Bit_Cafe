package kr.or.bitcafe;

public class IceAmericano extends Product {
	public IceAmericano() {
		super("아이스아메리카노",2000);
	}
	@Override
	public boolean make() {
		boolean success=false;
		if((Cafe.stock.getWater()>=1)&&(Cafe.stock.getEspresso()>=1)&&(Cafe.stock.getIce()>=1)) {
			Cafe.stock.waterMinus();
			Cafe.stock.espressoMinus();
			Cafe.stock.iceMinus();
			success=true;
//			return true;
		}
//		return false;
		return success;
	}
	public void cancleCart() {
		Cafe.stock.waterPlus();
		Cafe.stock.espressoPlus();
		Cafe.stock.icePlus();
		return;
	}
	@Override
	public String toString() {
		return "IceAmericano";
		
	}
	
}