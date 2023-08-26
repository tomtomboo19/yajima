package test.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.naming.*; 
import javax.sql.DataSource;

/**
 * Servlet implementation class InsertTest2
 */
@WebServlet("/InsertTest2")
public class InsertTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds;
		try{
			InitialContext initCtx = new InitialContext();
			String addr = "java:comp/env/jdbc/Servlet";
			ds = (DataSource)initCtx.lookup(addr);
		}catch(NamingException e){
			throw new ServletException(e);
		}
		
		try(Connection conn = ds.getConnection()){
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO class(cid,cname)"
							+" VALUES(8,'H組')";
			stmt.executeUpdate(sql);
			
		}catch(SQLException e){
			throw new ServletException(e);
		}
		request.getRequestDispatcher("insertTest2.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
