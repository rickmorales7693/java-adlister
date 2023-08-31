import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("/profile");
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace this block with real authentication logic
        boolean validAttempt = authenticate(username, password);

        if (validAttempt) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/WEB-INF/login.jsp");
        }
    }

    private boolean authenticate(String username, String password) {
        // Implement your authentication logic here, e.g., database checks.
        return username.equals("admin") && password.equals("password");
    }
}
