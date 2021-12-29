package Service;

import dao.ProductDao;
import model.Products;

import java.sql.SQLException;
import java.util.List;

public class ProductsService {
    public static List<Products> products = ProductDao.getAllProducts();

    public List<Products> fillAll(){
        products = ProductDao.getAllProducts();
        return products;
    }

    public void createProduct(Products product) throws SQLException {
        ProductDao.addProduct(product);
        products = ProductDao.getAllProducts();
    }

    public void editProduct(Products product) {
        ProductDao.updateProduct(product);
        products = ProductDao.getAllProducts();
    }

    public void deleteProduct(int id) {
        ProductDao.deleteProduct(id);
        products = ProductDao.getAllProducts();
    }

    public int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
