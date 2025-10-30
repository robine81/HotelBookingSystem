package dao;

import db.DBConnection;
import models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    public int addCustomer(Customer customer) throws SQLException{
        int rowsReturned = 0;
        String sqlQuery = "INSERT INTO customers (name, email, city) " +
                "VALUES (?, ?, ?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getCity());

            rowsReturned = stmt.executeUpdate();
            return rowsReturned;

        }
    }

    public List<Customer> getAllCustomers() throws SQLException{
        List<Customer> customers = new ArrayList<>();
        String sqlQuery = "SELECT * FROM customers";

        try( Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery)){
            while(rs.next()){
                customers.add(new Customer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("city")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return customers;
    }

    public Customer findCustomerByEmail(String email) throws SQLException{
        String sqlQuery = "SELECT * FROM customers WHERE email = ?";

        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
            stmt.setString(1, email);
            try( ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Customer(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("city"));
                }
            } catch (SQLException e2){
                e2.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public int updateCustomer(Customer customer) throws SQLException{
        int returnedRows = 0;

        return returnedRows;
    }

    public int deleteCustomer(Customer customer) throws SQLException{
        return 0;
    }
}
