package dao;

import db.DBConnection;
import models.Customer;

import java.math.BigDecimal;
import java.sql.*;

import java.util.*;

public class ReportDAOImpl implements ReportDAO {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    public Map<Customer, Integer> numberOfBookingsPerCustomer () throws SQLException {
        Map<Customer, Integer> map = new HashMap<Customer, Integer>();
        String sql = """
                SELECT c.id as id, COUNT(DISTINCT b.id) as n from customers c INNER join bookings b ON c.id = b.customer_id GROUP BY c.id
                """;
        Connection conn = DBConnection.getConnection();
        try(PreparedStatement statement = conn.prepareStatement(sql)){
            try(ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    long id = rs.getInt("id");
                    long n = rs.getLong("n");
                    Optional<Customer> c = customerDAO.getCustomerById((int)id);
                    c.ifPresent(customer -> {
                        map.put(customer, Integer.valueOf(new BigDecimal(n).intValue()));
                    });
                }
            }
        }
        return map;
    }
    public Double calculateAveragePriceForBookings() throws SQLException {
        String sql = """
                SELECT AVG(r.price) as avg from bookings b INNER JOIN rooms r ON b.room_id = r.id;
                """;
        Connection conn = DBConnection.getConnection();
        try(PreparedStatement statement = conn.prepareStatement(sql)){
            try(ResultSet rs = statement.executeQuery()){
                if (rs.next()) {
                    Double avg = Double.valueOf(rs.getDouble("avg"));
                    return avg;
                }
            }
        }
        return 0.0;
    }
    public List<Customer> getListOfCustomersWhoNeverBooked() throws SQLException {
        List<Customer> ret = new ArrayList<Customer>();
        String sql = """
                SELECT c.id from customers c LEFT JOIN bookings b ON c.id = b.customer_id WHERE b.customer_id IS NULL;
                """;
        Connection conn = DBConnection.getConnection();
        try(PreparedStatement statement = conn.prepareStatement(sql)){
            try(ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    long id = rs.getInt("id");
                    customerDAO.getCustomerById((int)id).ifPresent(customer -> {
                        ret.add(customer);
                    });
                }
            }
        }
        return ret;
    }
}
