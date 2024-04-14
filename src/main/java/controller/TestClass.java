package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.InputDto;
import model.OutputDto;
import model.TestProc;

// URL：プロジェクト名/Testで呼び出される
@WebServlet("/Test")
public class TestClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	InputDto input_data = new InputDto();
    	OutputDto output_data = new OutputDto();
    	TestProc proc = new TestProc();
    	TestDao dao = new TestDao();
    	
    	// リクエストパラメータを取得
    	String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        input_data.setWeight(Double.parseDouble(weight));
        input_data.setHeight(Double.parseDouble(height));
        output_data = proc.CalcBmi(input_data);       
        
        try {
			dao.AddTest(name, Integer.parseInt(String.valueOf(output_data.getBmi())));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        
        // リクエストスコープに保存
        request.setAttribute("output_data", output_data);
        try {
			ResultSet result = dao.SelectTest(name);
			request.setAttribute("select_data", result);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/output.jsp");
        dispatcher.forward(request, response);
	}
}
