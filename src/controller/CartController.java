package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CartModel;
import model.ConnectDatabase;
import utils.Constract;

public class CartController {
	
	public List<CartModel> index(int id) throws Exception{
		return refactors(ConnectDatabase.selectData(Constract.sqlGetCart(id)));
	}
	
	public boolean remove(int id) throws Exception{
		return !ConnectDatabase.excuteSQL(Constract.sqlRemoveCart(id));
	}
	
	public boolean insert (int idUser, int idProduce) throws Exception {
		return !ConnectDatabase.excuteSQL(Constract.sqlInsertCart(idUser, idProduce));
	}
	
	private List<CartModel> refactors(ResultSet resultSet) throws Exception{
		List<CartModel> carts = new ArrayList<>();
		while (resultSet.next()) {
			carts.add(new CartModel(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
		}
		return carts;
	}
	public static void main(String[] args)throws Exception{
		CartController mCartController = new CartController();
		System.out.println(mCartController.insert(1, 12));
	}
}
