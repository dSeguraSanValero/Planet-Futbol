package com.svalero.dao;

import com.svalero.domain.Product;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface ProductDAO {

    @SqlQuery("SELECT * FROM productos")
    @UseRowMapper(ProductMbapper.class)
    List<Product> getProducts();

    @SqlUpdate("INSERT INTO productos (name, price, category, model, color) VALUES (?, ?, ?, ?, ?)")
    void addProduct (String name, int price, String category, String model, String color);

    @SqlUpdate("UPDATE productos SET name = ?, price = ?, category = ?, model = ?, color = ? WHERE id = ?")
    void editProduct (String name, int price, String category, String model, String color, int id);

    @SqlUpdate("DELETE FROM productos WHERE id = ?")
    void removeProduct(int id);


}

