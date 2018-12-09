package model;

public class CartModel {
	private int id;
	private int idUser;
	private int idProduce;
	public CartModel(int id, int idUser, int idProduce) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idProduce = idProduce;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdProduce() {
		return idProduce;
	}
	public void setIdProduce(int idProduce) {
		this.idProduce = idProduce;
	}
	
	
}
