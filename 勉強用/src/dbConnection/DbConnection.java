package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	// DBName
	private final String DBNAME = "jdbc:postgresql://localhost:5432/postgres";
	// UserId
	private final String USERID = "postgres";
	// PassWord
	private final String PASSWORD = "postgres";

	// SQL接続するメソッド
	public Connection DBConn() {
		// DBへの接続
		Connection conn = null;
		try {
			// 接続を試みる。
			Class.forName("org.postgresql.Driver").newInstance();
			conn = DriverManager.getConnection(DBNAME,USERID , PASSWORD);
			conn.close();

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
}
