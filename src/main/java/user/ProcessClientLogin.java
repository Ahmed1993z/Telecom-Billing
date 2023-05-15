package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.Client;
import java.sql.*;
/**
 * Servlet implementation class ProcessClientLogin
 */
@WebServlet("/ProcessClientLogin")
public class ProcessClientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessClientLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/DisplayClient2.jsp";
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if (checkExistingUser(username, password)) {
		    // perform login process
		    HttpSession session = request.getSession();
		    session.setAttribute("username", username);
		    session.setAttribute("password", password);
		   
		    response.sendRedirect("DisplayClient2.jsp");
		}
		else {
		    // show error message or redirect to error page
		    response.sendRedirect("error.jsp");
		}
			 
	}
	protected boolean checkExistingUser(String username, String password) {
	    Connection con;
	    ResultSet rs;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/test";
	        String user = "root";
	        String pw = "root";
	        con = DriverManager.getConnection(url, user, pw);

	        System.out.println("Database connection established");

	        PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE username = ? AND password = ? ");
	        ps.setString(1, username);
	        ps.setString(2, password);
	      
	        rs = ps.executeQuery();

	        boolean userExists = rs.next();

	        rs.close();
	        ps.close();
	        con.close();

	        System.out.println("Database connection closed");

	        return userExists;

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


}
