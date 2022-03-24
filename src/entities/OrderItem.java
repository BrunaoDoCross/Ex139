package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;

	private Product product;
	
	public OrderItem(Integer quatity, Double price, Product product) {
		this.quantity = quatity;
		this.price = price;
		this.product = product;
	}

	public OrderItem() {

	}

	public Integer getQuatity() {
		return quantity;
	}

	public void setQuatity(Integer quatity) {
		this.quantity = quatity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public Double subTotal() {
		return quantity * price;
	}
}
