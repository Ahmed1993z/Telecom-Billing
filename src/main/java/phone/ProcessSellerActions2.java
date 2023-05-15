package phone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import phone.*;
import user.Client;


/**
 * Servlet implementation class ProcessSellerActions2
 */
@WebServlet("/ProcessSellerActions2")
public class ProcessSellerActions2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessSellerActions2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;

         try {
             // Register JDBC driver
             Class.forName(JDBC_DRIVER);

             // Open a connection
             conn = DriverManager.getConnection(DB_URL, USER, PASS);

             // Execute SQL query
             String sql = "SELECT * FROM program";
             stmt = conn.prepareStatement(sql);
             rs = stmt.executeQuery();

             // Create a list of Program objects
             List<Program> programs = new ArrayList<>();
             while (rs.next()) {
                 String name = rs.getString("name");
                 int includedVoiceTime = rs.getInt("includedvoicetime");
                 int includedSMS = rs.getInt("includedsms");
                 int includedData = rs.getInt("includeddata");
                 double fixedPrice = rs.getDouble("fixedprice");
                 double voiceTimePrice = rs.getDouble("voicetimeprice");
                 double smsPrice = rs.getDouble("smsprice");
                 double dataPrice = rs.getDouble("dataprice");
                 programs.add(new Program(name, includedVoiceTime, includedSMS, includedData, fixedPrice, voiceTimePrice, smsPrice, dataPrice));
             }

             // Set the programs list as a request attribute
             request.setAttribute("program", programs);

             // Forward to the JSP page
             request.getRequestDispatcher("/DisplaySeller.jsp").forward(request, response);

         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (rs != null) {
                     rs.close();
                 }
                 if (stmt != null) {
                     stmt.close();
                 }
                 if (conn != null) {
                     conn.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/DisplaySeller4.jsp";
		String phonenumber = request.getParameter("phonenumber");
		String bill= request.getParameter("bill")		;
		String month= request.getParameter("month");
		String calls= request.getParameter("calls");
		
		updateDB(phonenumber, month, bill,calls);

		Client client = new Client(phonenumber,bill, month, calls);
		request.setAttribute("client", client);
		
		getServletContext().getRequestDispatcher(url).forward(request,response);
	 
	}
	protected void updateDB(String phonenumber , String bill,String month ,String calls) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
		    String user ="root";
		    String pw="root";
		    con= DriverManager.getConnection(url,user,pw);
		    System.out.println("Database connection established");
		    
		    String sql = "UPDATE client SET bill=?, calls=?, month=? WHERE number=?";
            PreparedStatement statement = con.prepareStatement(sql);

            // Set the parameter values for the SQL statement
            statement.setString(1, bill);
            statement.setString(2, calls);
            statement.setString(3, month);
            statement.setString(4, phonenumber);

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

