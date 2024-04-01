package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.InputDto;
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
    	request.getRequestDispatcher("/WEB-INF/view/test.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	InputDto input_data = new InputDto();
    	TestProc proc = new TestProc();
    	
    	// リクエストパラメータを取得
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        input_data.setWeight(Double.parseDouble(weight));
        input_data.setHeight(Double.parseDouble(height));
        
        // リクエストスコープに保存
        request.setAttribute("output_data", proc.TestProcess(input_data));

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/output.jsp");
        dispatcher.forward(request, response);
	}
}
