package com.shepe.admin.division;

public class DivisionInVO {
	private int ingredient_no;
	private String ingredient_nm;
	private String ingredient_categ;
	private int ingredient_price;
	private String ingredient_thumbimg;
	private String ingredient_amt;
	private int ingredient_sell_sum;
	
	
	public int getIngredient_no() {
		return ingredient_no;
	}
	public void setIngredient_no(int ingredient_no) {
		this.ingredient_no = ingredient_no;
	}
	public String getIngredient_nm() {
		return ingredient_nm;
	}
	public void setIngredient_nm(String ingredient_nm) {
		this.ingredient_nm = ingredient_nm;
	}
	public String getIngredient_categ() {
		return ingredient_categ;
	}
	public void setIngredient_categ(String ingredient_categ) {
		this.ingredient_categ = ingredient_categ;
	}
	public int getIngredient_price() {
		return ingredient_price;
	}
	public void setIngredient_price(int ingredient_price) {
		this.ingredient_price = ingredient_price;
	}
	public String getIngredient_thumbimg() {
		return ingredient_thumbimg;
	}
	public void setIngredient_thumbimg(String ingredient_thumbimg) {
		this.ingredient_thumbimg = ingredient_thumbimg;
	}
	public String getIngredient_amt() {
		return ingredient_amt;
	}
	public void setIngredient_amt(String ingredient_amt) {
		this.ingredient_amt = ingredient_amt;
	}
	public int getIngredient_sell_sum() {
		return ingredient_sell_sum;
	}
	public void setIngredient_sell_sum(int ingredient_sell_sum) {
		this.ingredient_sell_sum = ingredient_sell_sum;
	}
	
	@Override
	public String toString() {
		return "DivisionInVO [ingredient_sq=" + ingredient_no + ", ingredient_nm=" + ingredient_nm
				+ ", ingredient_categ=" + ingredient_categ + ", ingredient_price=" + ingredient_price
				+ ", ingredient_thumbimg=" + ingredient_thumbimg + ", ingredient_amt=" + ingredient_amt
				+ ", ingredient_sell_sum=" + ingredient_sell_sum + "]";
	}
	
	
}
