package utils;

import model.UserModel;

public class Constract {
	public static UserModel MYMODEL = null;
	
	public static String sqlLogin(String email, String password) {
		return "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "';";
	}
	
	public static String sqlRegister(String email, String name, String password) {
		return "INSERT INTO users(email, name, password) VALUES ('" + email + "', '" + name + "', '" + password + "';";
	}
	
	public static String sqlProduce() {
		return "SELECT * FROM produces";
	}
	
	public static String sqlGetProduce(int id) {
		return "SELECT * FROM produces WHERE id = " + id;
	}
	
	public static String sqlInsertCart(int idUser, int idProduce) {
		return "INSERT INTO carts(id_user, id_produce) VALUES (" + idUser + ", " + idProduce + ");";
	}
	
	public static String sqlGetCart(int idUser) {
		return "SELECT * FROM carts WHERE id_user = " + idUser;
	}
	
	public static String sqlRemoveCart(int id) {
		return "DELETE FROM carts WHERE id = " + id;
	}
	
}
