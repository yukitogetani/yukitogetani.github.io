import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Reflectiontest {


	private String bbbb = "SELECT * FROM SHOZIKIN";

	public List test() throws InstantiationException, IllegalAccessException {

		// 設定したObjectを格納する。
		List<ShozikinSearchResult> list = new ArrayList<ShozikinSearchResult>();
		DAO dao = new DAO();

		try {
			Statement st = dao.Dbconnection();
			// 今まで通りResultSetでやってみる。
			ResultSet rs = st.executeQuery(bbbb);

			// リフレクション使って直打ちをやめる（とりあえず）
			while(rs.next()) {
				// 親クラスのDB情報に突っ込む
				// とりあえず変数名を取得してみた。 これがリフレクションらしい。
				Class<?> c = this.getClass().getSuperclass();
				Object obj = c.newInstance();
				Field[] f = c.getDeclaredFields();
				Method[] m = c.getMethods();
				System.out.println(f[0].getName());
				System.out.println(m[1].getName());
				try {
					// 呼び出し完了フラグ
					for (int i = 0; i < f.length; i++) {
						boolean SetterCallFlg = false;
						int j = 0;

						while(!SetterCallFlg) {
							System.out.println("-------------------処理開始-----------------");
							String args = new String(rs.getString(f[i].getName()));
							System.out.println("設定する値(DB値）：" + rs.getString(f[i].getName()));
							//setterを呼び出すか判定。
							String comp = "set" + f[i].getName();
							System.out.println("比較元:" + m[j].getName());
							System.out.println("比較先:" + comp);
							System.out.println(m[j].getName().equals(comp));
							if(m[j].getName().equals(comp)){
								m[j].invoke(obj,args);
								// 呼び出し完了フラグ
								SetterCallFlg = true;
								System.out.println("呼び出されたメソッド:" + m[j].getName());
							}
							j += 1;
						}
					}
					// リストへ
					list.add((ShozikinSearchResult)obj);

				} catch (SecurityException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();

				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// リストのテスト
		for(ShozikinSearchResult a : list) {
			System.out.println("所属区分" + a.getShozikbn());
			System.out.println("名前" + a.getName());
		}
		return list;
	}
}
