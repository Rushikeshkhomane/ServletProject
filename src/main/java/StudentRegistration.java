

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/register")
public class StudentRegistration implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        LocalDateTime.now();
        servletResponse.setContentType("text/html");
        String firstName=servletRequest.getParameter("firstName");
        String lastName=servletRequest.getParameter("lastName");
        String email=servletRequest.getParameter("email");
      //  String image=servletRequest.getParameter("image");

//
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
            String query="Insert into student(id,firstname,lastname,email) values(?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        PrintWriter printWriter =servletResponse.getWriter();
        printWriter.println(firstName+"\t"+lastName+"\t"+email);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
