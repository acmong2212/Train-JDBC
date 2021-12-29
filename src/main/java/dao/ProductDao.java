package dao;

import model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.ConnectMySQL.getConnection;

public class ProductDao {
    //cai nay de ket noi toi SQL
    private static Connection connection = getConnection();

    //Tao method hien thi du lieu trong bang
    public static List<Products> getAllProducts() {
        String sqlGetAll = "SELECT * FROM products";

        try {
            //gui cau lenh SQL len java xu ly
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);

            //cai nay chua du lieu trong bang
            ResultSet resultSet = preparedStatement.executeQuery(sqlGetAll);

            List<Products> productsList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");

                productsList.add(new Products(id, name, price, img));
            }
            return productsList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addProduct(Products products) {
        String addSQL = "INSERT INTO `apple-store`.`products` (`name`, `price`, `img`) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addSQL);
            preparedStatement.setString(1, products.getName());
            preparedStatement.setInt(2, products.getPrice());
            preparedStatement.setString(3, products.getImg());

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int id) {
        String deleteSQL = "DELETE FROM products where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Products products) {
        String UPDATE_USERS_SQL = "update products set name = ?,price= ?, img =? where (id = ?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, products.getName());
            preparedStatement.setInt(2, products.getPrice());
            preparedStatement.setString(3, products.getImg());
            preparedStatement.setInt(4, products.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}