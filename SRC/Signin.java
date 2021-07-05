import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;
import javax.servlet.http.*;  
 
public class Signin extends HttpServlet {  
public void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("email1");  
String p=request.getParameter("psw1");  
  System.out.println(n);        
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","admin");  
  
PreparedStatement ps=con.prepareStatement(  
"select PASSWORD from registeruser where EMAIL=?");  
  
ps.setString(1,n);  
ResultSet rs=ps.executeQuery();
String password=null;
while (rs.next()) {
    password=rs.getString(1);
   
} 

if(p.equals(password))  
response.sendRedirect("welcome.html");
else
   out.println("incorrect password or email");
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}

private void alert(String string) {
	// TODO Auto-generated method stub
	
}  
  
}