package testServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servise.Service;
import testalgo.algoTest1;
import dbConnection.DbConnection;
import form.Testfinputform;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// DB接続
		DbConnection DBconn = new DbConnection();

		// インスタンスの生成
		Service service = new Service();
		service.setPoriTest(new algoTest1());
		Testfinputform form = new Testfinputform();

		// formにセット
		form.setName((String)request.getParameter("test"));
		System.out.println(form);

		// 実行（具体的な処理の実行）
		service.doprocess(form);

		// 値をセット（本当はここでやりたくないなぁ）
		request.setAttribute("test",form.getOutput());

		// 遷移する。
		 RequestDispatcher disp = request.getRequestDispatcher("./jsp/kekka.jsp");
	     disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
