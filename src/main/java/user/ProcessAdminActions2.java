package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import phone.Program;

/**
 * Servlet implementation class ProcessAdminActions2
 */
@WebServlet("/ProcessAdminActions2")
public class ProcessAdminActions2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAdminActions2() {
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
		String url="/DisplayAdmin4.jsp";
		
		String name = request.getParameter("name");
		int voicetime= Integer.parseInt( request.getParameter("includedvoicetime"));
		int sms= Integer.parseInt(request.getParameter("includedsms"));
		int data= Integer.parseInt(request.getParameter("includeddata"));
		double fixedprice= Double.parseDouble(request.getParameter("fixedprice"));
		double voicetimeprice= Double.parseDouble(request.getParameter("voicetimeprice"));
		double smsprice= Double.parseDouble(request.getParameter("smsprice"));
		double dataprice= Double.parseDouble(request.getParameter("dataprice"));
		updateDB(name,voicetime,sms,data,fixedprice,voicetimeprice,smsprice,dataprice);

		Program program = new Program(name,voicetime,sms,data,fixedprice,voicetimeprice,smsprice,dataprice);
		request.setAttribute("program", program);
		
		getServletContext().getRequestDispatcher(url).forward(request,response);
	}
	protected void updateDB(String name, int voicetime, int sms, int data, double fixedprice, double voicetimeprice, double smsprice, double dataprice) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
		    String user ="root";
		    String pw="root";
		    con= DriverManager.getConnection(url,user,pw);
		    System.out.println("Database connection established");
		    
		    String sql = "UPDATE program SET name=?, includedvoicetime=?, includedsms=? , includeddata=?, fixedprice=?, voicetimeprice=?, smsprice=?, dataprice=?  WHERE name=?";
            PreparedStatement statement = con.prepareStatement(sql);

            // Set the parameter values for the SQL statement
            statement.setString(1, name);
            statement.setInt(2, voicetime);
            statement.setInt(3, sms);
            statement.setInt(4, data);
            statement.setDouble(5, fixedprice);
            statement.setDouble(6, voicetimeprice);
            statement.setDouble(7, smsprice);
            statement.setDouble(8, dataprice);
            statement.setString(9, name);


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
