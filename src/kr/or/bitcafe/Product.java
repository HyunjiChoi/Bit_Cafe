package kr.or.bitcafe;

public abstract class Product {
	String name;
	int price;
	boolean ispublish;
	public Product(String name,int price){
		this.name=name;
		this.price=price;
		this.ispublish=false;
	}
	protected abstract boolean make();
	protected abstract void cancleCart();
}