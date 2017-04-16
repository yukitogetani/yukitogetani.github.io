

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	// DBName
	private final String DBNAME = "jdbc:postgresql://localhost:5432/postgres";
	// UserId
	private final String USERID = "postgres";
	// PassWord
	private final String PASSWORD = "postgres";

	// SQLServerに接続するメソッド
	private Connection DBConn() {
		// DBへの接続
		Connection conn = null;
		try {
			// 接続を試みる。
			Class.forName("org.postgresql.Driver").newInstance();
			conn = DriverManager.getConnection(DBNAME,USERID , PASSWORD);

			// 問題なければリターン
			System.out.println("OK");
			return conn;
		} catch (Exception e) {
			// エラーだったらnull返す。
			e.printStackTrace();
			System.out.println("NG");
			return null;
		}
	}

	// DBアクセスするメソッド
	public Statement Dbconnection() throws SQLException {
		DAO Dbconn = new DAO();
		Connection conn = Dbconn.DBConn();
		Statement st = conn.createStatement();
		return  st;
	}

}
