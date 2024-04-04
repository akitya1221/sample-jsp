package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SampleDao {
	public void AddTest(String name, int bmi) throws SQLException {
        Connection conn;
        String url = "jdbc:mysql://localhost/sample_jsp_db";
        String user = "root";
        String password = "password";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        
        // Mysqlの接続情報
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("DB接続しました");
        try {
            String sql = "INSERT INTO sample (name, bmi) VALUES (?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, name);
            stat.setInt(2,bmi);
            stat.executeUpdate();
            System.out.println("データ登録完了");
        }
        finally {
            conn.close();
            System.out.println("DB切断しました");
        }    
    }
}
