package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectDatabase;
import model.ProduceModel;
import utils.Constract;

public class ProduceController {
	
	public List<ProduceModel> index() throws Exception{
		return refactors(ConnectDatabase.selectData(Constract.sqlProduce()));
	}
	
	public ProduceModel get(int id) throws Exception{
		return refactor(ConnectDatabase.selectData(Constract.sqlGetProduce(id)));
	}
	
	private List<ProduceModel> refactors(ResultSet resultSet) throws SQLException{
		List<ProduceModel> produces = new ArrayList<>();
		while(resultSet.next()) {
			ProduceModel model = new ProduceModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
			produces.add(model);
		}
		return produces;
	}
	
	private ProduceModel refactor(ResultSet resultSet) throws SQLException{
		ProduceModel model = null;
		while(resultSet.next()) {
			model = new ProduceModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
		}
		return model;
	}
	
	public static void main(String[] args) throws Exception{
		ProduceController controller = new ProduceController();
		System.out.println(controller.index().get(0).getImage());
	}
	
}
