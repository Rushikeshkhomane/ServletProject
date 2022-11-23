import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class StudentLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username1= req.getParameter("username");
       String password1=req.getParameter("password");
        String url="jdbc:mysql://localhost:3306/StudentDetails1";
        String username="root";
        String password="Calmness@99";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            String query="select * from student where email=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username1);
            ResultSet resultSet=preparedStatement.executeQuery();
            PrintWriter printWriter=resp.getWriter();
            while (resultSet.next()) {
                if (resultSet.getString("email").equalsIgnoreCase(username1) && resultSet.getString("firstname").equalsIgnoreCase(password1)) {

                    printWriter.println("successfully Login");
                } else {

                    printWriter.println("incorrect Login");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("sql Exception");
        }



    }
}
