package com.example.Taban300337079;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(Customer cat) throws ClassNotFoundException, SQLException;
    public Customer edit(Customer cat, String catcode) throws SQLException, ClassNotFoundException;
    public void delete(String catcode) throws SQLException;
    public List<Customer> display() throws ClassNotFoundException, SQLException;


}
