//importing Various packages
import java.sql.*;
import javax.swing.*;
//Create class connect
public class connect
{   
    //Create Variables for connect class
    Connection con;
	Statement st=null;
	ResultSet rs;
	PreparedStatement pst=null;
	//Defining Constructor
	public connect( )
{           
	try{    
	         //try to Connect Database Connection From JDBC:ODBC Driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Calling get function
			con=DriverManager.getConnection("jdbc:odbc:FlightDb");
        }
		catch (Exception ex){}
}
//Defining close method for closing connection
public void Close( )
{
try{ 
//closing statement
st.close();
//closing prepare statement
pst.close();
//closing connection
con.close();
}catch(Exception ex){}
}
}

