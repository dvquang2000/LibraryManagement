package com.quangdo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.quangdo.connectMySQL.ConnectMySQL;
import com.quangdo.exception.ApplicationException;

import com.quangdo.model.Category;

public class CategoryDao {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Category> getListCategories (){
		try {
			String query = "select * from category";
			connection = new ConnectMySQL().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while (rs.next()) {
				Category category = new Category(rs.getInt(1), rs.getString(2));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationException("Getting list category has error", e);
		}

	}
	
	public static void main(String[] args) {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.getListCategories();
		System.out.println(categories);
	}
}
