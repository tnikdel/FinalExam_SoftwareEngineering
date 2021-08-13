package com.example.Taban300337079;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{
    Connection con;
    public DatabaseService(Connection con){
        this.con = con;
    }

    //Add method
    @Override
    public void add(Customer cat) throws ClassNotFoundException, SQLException {

        String quer1 = "INSERT INTO savingstable VALUES(?,?,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1,cat.getCustno());
        query.setString(2, cat.getCustname());
        query.setString(3, cat.getCdep());
        query.setString(4, cat.getNyears());
        query.setString(5, cat.getSavtype());

        query.executeUpdate();

    }

    //Edit method
    @Override
    public Customer edit(Customer cat, String custno) throws SQLException, ClassNotFoundException {

        PreparedStatement query;
        query = con.prepareStatement("Update savingstable set custno=?, custname=?,cdep=?, nyears=?, savtype=? where custno=? ");
        query.setString(1,cat.getCustno());
        query.setString(2, cat.getCustname());
        query.setString(3, cat.getCdep());
        query.setString(4, cat.getNyears());
        query.setString(5, cat.getSavtype());

        query.setString(6,custno);

        query.executeUpdate();
        return cat;
    }

    //delete method
    @Override
    public void delete(String custno) throws SQLException {

        String quer1 = "Delete from savingstable where catcode =?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1,custno);
        query.executeUpdate();

    }

    //search method
    public Customer search(String custname) throws SQLException,ClassNotFoundException{

        String quer1 = "Select * from savingstable where custname =?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1,custname);

        ResultSet rs = query.executeQuery();

        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }

        Customer obj1 = null;

        obj1 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getString("cdep"),rs.getString("nyears"),rs.getString("savtype"));

        return obj1;
    }

    //Display method
    @Override
    public List<Customer> display() throws ClassNotFoundException, SQLException {
        List<Customer> Catlist = new ArrayList<Customer>();

        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        Customer obj1 = null;

        while (rs.next()) {
            obj1 = new Customer(rs.getString("custno"),rs.getString("custname"),rs.getString("cdep"),rs.getString("nyears"),rs.getString("savtype"));

            Catlist.add(obj1);
        }
        return Catlist;

    }

    //The display 2 method ---> for the items table
   /* public List<Items> display2(String catcode) throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Items> Itemlist = new ArrayList<Items>();
        String quer1 = "Select itemcode,itemdesc from item where catcode=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, catcode);
        ResultSet rs = query.executeQuery();

        Items obj2;

        //display records if there is data;
        while (rs.next()) {
            obj2 = new Items(rs.getString("itemcode"),
                    rs.getString("itemdesc")); Itemlist.add(obj2);
        }
        return Itemlist;
    }
*/
}



