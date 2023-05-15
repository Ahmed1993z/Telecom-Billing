package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import user.Client;

/**
 * Servlet implementation class ProcessClientActions
 */
@WebServlet("/ProcessClientActions")
public class ProcessClientActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessClientActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");

        // Set up the database connection
        Connection con;
	    ResultSet rs;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/test";
	        String user = "root";
	        String pw = "root";
	        con = DriverManager.getConnection(url, user, pw);

	        System.out.println("Database connection established");

	        PreparedStatement ps = con.prepareStatement("SELECT Calls FROM client WHERE username = ?  ");
	        ps.setString(1, username);
	       
	      
	        rs = ps.executeQuery();
	        rs.next();
	        String calls=rs.getString("Calls");
	        request.setAttribute("Calls", calls);
	        
	        rs.close();
	        ps.close();
	        con.close();
	        
	     

	        System.out.println("Database connection closed");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("DisplayClient4.jsp");
	    rd.forward(request, response);
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // Retrieve the username from the form data
        String username = request.getParameter("username");

        // Set up the database connection
        Connection con;
	    ResultSet rs;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/test";
	        String user = "root";
	        String pw = "root";
	        con = DriverManager.getConnection(url, user, pw);

	        System.out.println("Database connection established");

	        PreparedStatement ps = con.prepareStatement("SELECT bill FROM client WHERE username = ?  ");
	        ps.setString(1, username);
	       
	      
	        rs = ps.executeQuery();
	        rs.next();
	        String bill=rs.getString("bill");
	        request.setAttribute("bill", bill);
	        
	        rs.close();
	        ps.close();
	        con.close();
	        
	     

	        System.out.println("Database connection closed");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("DisplayClient3.jsp");
	    rd.forward(request, response);
	}


}
     