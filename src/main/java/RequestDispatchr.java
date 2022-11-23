import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet(value = "/login1",loadOnStartup = 0)
public class RequestDispatchr extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       resp.setContentType("text/html");
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        if ("abc".equalsIgnoreCase(username) && "abc".equalsIgnoreCase(password))
        {
            RequestDispatcher welcome=  req.getRequestDispatcher("welcome");
            welcome.forward(req,resp);
        }
        else {
            resp.getWriter().println("invalid credentials");
            RequestDispatcher error=  req.getRequestDispatcher("LoginPage1.html");
            error.include(req,resp);
        }
    }
}
