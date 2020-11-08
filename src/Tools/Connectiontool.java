package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiontool {
    private Connection con;

    public Connectiontool(Connection con) {
        this.con = con;
    }

    public Connectiontool() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver");


            this.con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                    "root",
                    "123456");

    }

    public Connection getConnection(){
            return  this.con;
    }

    public void close(){
        if (this.con!=null)
        {
            try{
                this.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
