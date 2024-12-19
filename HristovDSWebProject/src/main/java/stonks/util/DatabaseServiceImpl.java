package stonks.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import stonks.Valute;

public class DatabaseServiceImpl implements DatabaseService {
    private static final String DB_URL = "jdbc:postgresql://services.tms-studio.ru:8095/service_db";
    private final Connection conn = DriverManager.getConnection("jdbc:postgresql://services.tms-studio.ru:8095/service_db", "service_admin", "srv0983_");

    public DatabaseServiceImpl() throws SQLException {
        System.out.println("Connection is " + (this.conn.isValid(0) ? "up" : "down"));
    }

    public Valute getValuteOfDate(LocalDate date) throws SQLException {
        PreparedStatement select = this.conn.prepareStatement("SELECT * FROM val_curs WHERE date=?");
        select.setDate(1, Date.valueOf(date));
        ResultSet resultSet = select.executeQuery();
        return resultSet.next() ? new Valute(resultSet.getString("valute_name"), resultSet.getDouble("value")) : null;
    }

    public void saveMaxValuteOfDate(String fio, Valute valute, LocalDate date) throws SQLException {
        PreparedStatement insert = this.conn.prepareStatement("INSERT INTO val_curs (fio, valute_name, value, date) VALUES (?, ?, ?, ?)");
        insert.setString(1, fio);
        insert.setString(2, valute.getName());
        insert.setDouble(3, valute.getValue());
        insert.setDate(4, Date.valueOf(date));
        insert.executeUpdate();
    }
}