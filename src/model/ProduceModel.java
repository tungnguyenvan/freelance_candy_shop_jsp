package model;

public class ProduceModel {
	private int id;
	private String name;
	private int price;
	private String desc;
	private String image;
	public ProduceModel(int id, String name, int price, String desc, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
}
