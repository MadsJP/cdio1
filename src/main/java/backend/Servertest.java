package backend;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/hello/*")
public class Servertest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("Navn");
            String password = req.getParameter("Password");
            DAO dao = new DAO();
            boolean valid = dao.validUser(username, password);
            if(valid){
                resp.sendRedirect("/OversigtBorger.html");
            }
            resp.sendRedirect("/BorgerLogIn.html");
            //resp.getWriter().write(valid+"Fsarvel" + req.getRequestURI());
        } catch (Exception ex) {
            Logger.getLogger(Servertest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("input");
        System.out.println(input);
        resp.sendRedirect("/");
    }
}