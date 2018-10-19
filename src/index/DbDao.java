package index;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DbDao {
    private Connection conn;
    private String driver;
    private String url;
    private String username;
    private String pass;
    
    public DbDao(){
        
    }
    
    public DbDao(String driver, String url, String username, String pass) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.pass = pass;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }
    
    // get database connection
    public Connection getConnection() throws Exception {
        if(conn == null){
            Class.forName(this.driver);
            conn = (Connection) DriverManager.getConnection(url, username, this.pass);
        }
        return conn;
    }
    
    // insert records
    public boolean insert(String sql, Object... args) throws Exception{
        PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]); 
        }
        if(pstmt.executeUpdate() != 1)
            return false;
        return true;
    }
    
    // execute query
    public ResultSet query(String sql, Object...args) throws Exception{
        PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i=0; i< args.length; i++) {
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt.executeQuery();
    }
    
    public void modify(String sql, Object...args) throws Exception{
        PreparedStatement pstmt = (PreparedStatement)getConnection().prepareStatement(sql);
        for(int i = 0; i< args.length; i++) {
            pstmt.setObject(i+1, args[i]);
        }
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public void closeConn() throws Exception{
        if(conn != null && !conn.isClosed())
            conn.close();
    }
}