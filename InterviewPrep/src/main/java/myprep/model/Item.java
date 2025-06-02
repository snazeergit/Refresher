package myprep.model;

public class Item {
	String itemName;
	Integer itemPrice;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Item(String itemName, Integer itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}

}
