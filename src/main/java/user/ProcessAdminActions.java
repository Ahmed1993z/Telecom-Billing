package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import user.Sellers;
import phone.Program;
/**
 * Servlet implementation class ProcessAdminActions
 */
@WebServlet("/ProcessAdminActions")
public class ProcessAdminActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAdminActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/DisplayAdmin3.jsp";
		String name = request.getParameter("name");
		int voicetime= Integer.parseInt( request.getParameter("includedvoicetime"));
		int sms= Integer.parseInt(request.getParameter("includedsms"));
		int data= Integer.parseInt(request.getParameter("includeddata"));
		double fixedprice= Double.parseDouble(request.getParameter("fixedprice"));
		double voicetimeprice= Double.parseDouble(request.getParameter("voicetimeprice"));
		double smsprice= Double.parseDouble(request.getParameter("smsprice"));
		double dataprice= Double.parseDouble(request.getParameter("dataprice"));
		updateDB2(name,voicetime,sms,data,fixedprice,voicetimeprice,smsprice,dataprice);

		Program program = new Program(name,voicetime,sms,data,fixedprice,voicetimeprice,smsprice,dataprice);
		request.setAttribute("program", program);
		
		getServletContext().getRequestDispatcher(url).forward(request,response);
	}
	protected void updateDB2(String name, int voicetime, int sms, int data, double fixedprice, double voicetimeprice, double smsprice, double dataprice) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
		    String user ="root";
		    String pw="root";
		    con= DriverManager.getConnection(url,user,pw);
		    System.out.println("Database connection established");
		    
		    Statement s = con.createStatement();
		    String query = "INSERT INTO program " + "(name,includedvoicetime,includedesms,includeddata,fixedprice,voicetimeprice,smsprice,dataprice) " + "VALUES ('" +  name+ "', '" + voicetime +"', '" + sms + "', '" + data + "', '" + fixedprice + "', '" +  voicetimeprice + "', '" + smsprice +  "', '" + dataprice + "')";
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/DisplayAdmin2.jsp";
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		String surname= request.getParameter("surname");
		String name= request.getParameter("name");
		String role= request.getParameter("role");
		updateDB(username, password ,surname,name,role);

		Sellers seller = new Sellers(username, password, surname,name,role);
		request.setAttribute("seller", seller);
		
		getServletContext().getRequestDispatcher(url).forward(request,response);
		
	}
	protected void updateDB(String username , String password, String surname, String name, String role ) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
		    String user ="root";
		    String pw="root";
		    con= DriverManager.getConnection(url,user,pw);
		    System.out.println("Database connection established");
		    
		    Statement s = con.createStatement();
		    String query = "INSERT INTO seller " + "(username, password, surname, name, role) " + "VALUES ('" +  username+ "', '" + password +"', '" + surname + "', '" + name + "', '" + role +  "')";
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

}
