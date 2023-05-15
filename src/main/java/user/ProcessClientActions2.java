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
 * Servlet implementation class ProcessClientActions2
 */
@WebServlet("/ProcessClientActions2")
public class ProcessClientActions2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessClientActions2() {
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
		
		String username = request.getParameter("username");
		 Connection con;
		    ResultSet rs;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/test";
	        String user = "root";
	        String pw = "root";
	        con = DriverManager.getConnection(url, user, pw);

	        PreparedStatement ps = con.prepareStatement("SELECT bill, money FROM client WHERE username = ?");
	        ps.setString(1, username);
	        rs = ps.executeQuery();
	        rs.next();

	        int bill = rs.getInt("bill");
	        int money = rs.getInt("money");

	        if (money >= bill) { // If there is enough money to pay the bill
	            money -= bill;
	            bill = 0;
	        } else { // If there is not enough money to pay the bill
	            bill -= money;
	            money = 0;
	        }

	        // Update the client's bill and money in the database
	        ps = con.prepareStatement("UPDATE client SET bill = ?, money = ? WHERE username = ?");
	        ps.setInt(1, bill);
	        ps.setInt(2, money);
	        ps.setString(3, username);
	        ps.executeUpdate();

	        request.setAttribute("bill", bill);
	        request.setAttribute("money", money);

	        rs.close();
	        ps.close();
	        con.close();

	        System.out.println("Database connection closed");
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    RequestDispatcher rd = request.getRequestDispatcher("DisplayClient5.jsp");
	    rd.forward(request, response);
	}
	    
	}


