package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Client;
import phone.Program;
import user.Sellers;

import java.sql.*;

/**
 * Servlet implementation class ProcessSellerActions
 */
@WebServlet("/ProcessSellerActions")
public class ProcessSellerActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessSellerActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/DisplaySeller3.jsp";
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		String surname= request.getParameter("surname");
		String name= request.getParameter("name");
		String role= request.getParameter("role");
		String vatnumber= request.getParameter("vatnumber");
		String phonenumber= request.getParameter("phonenumber");
		String program= request.getParameter("program");
	
		updateDB2(username, password ,surname,name,role,vatnumber,phonenumber,program);

		Client client = new Client(username, password, surname,name,role,vatnumber,phonenumber,program,null,null,null,null);
		request.setAttribute("Client", client);
		
		getServletContext().getRequestDispatcher(url).forward(request,response);
	 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/DisplaySeller2.jsp";
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		String surname= request.getParameter("surname");
		String name= request.getParameter("name");
		String role= request.getParameter("role");
		String vatnumber= request.getParameter("vatnumber");
		String phonenumber= request.getParameter("phonenumber");
		String program= request.getParameter("program");
	
		updateDB(username, password ,surname,name,role,vatnumber,phonenumber,program);

		Client client = new Client(username, password, surname,name,role,vatnumber,phonenumber,program);
		request.setAttribute("Client", client);
		
		getServletContext().getRequestDispatcher(url).forward(request,response);
	 
	}
	protected void updateDB(String username , String password, String surname, String name, String role , String vatnumber,String phonenumber, String program) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
		    String user ="root";
		    String pw="root";
		    con= DriverManager.getConnection(url,user,pw);
		    System.out.println("Database connection established");
		    
		    Statement s = con.createStatement();
		    String query = "INSERT INTO client " + "(username, password, surname, name, role, vatnumber, number, program) " + "VALUES ('" +  username+ "', '" + password +"', '" + surname + "', '" + name + "', '" + role +  "', '" + vatnumber + "', '" + phonenumber + "', '" + program + "')";
		    s.executeUpdate(query);

		    con.close();
	        System.out.println("Database connection closed");

		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	protected void updateDB2(String username , String password, String surname, String name, String role , String vatnumber,String phonenumber, String program) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
		    String user ="root";
		    String pw="root";
		    con= DriverManager.getConnection(url,user,pw);
		    System.out.println("Database connection established");
		    
		    String sql = "UPDATE program SET username=?, password=?, surname=? , name=?, role=?, vatnumber=?, number=?, program=?  WHERE username=?";
            PreparedStatement statement = con.prepareStatement(sql);

            // Set the parameter values for the SQL statement
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, surname);
            statement.setString(4, name);
            statement.setString(5, role);
            statement.setString(6, vatnumber);
            statement.setString(7, phonenumber);
            statement.setString(8, program);
            statement.setString(9, username);
          

            // Execute the SQL statement
            int rowsUpdated = statement.executeUpdate();

            // Send the response to the client
            

		    con.close();
	        System.out.println("Database connection closed");

		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	}


