package Controller;

import model.Account;
import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class AjouterAgentServlet
 */
//@WebServlet("/AjouterAgentServlet")
public class AjouterAgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AccountDAO accountDAO;

    public AjouterAgentServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "Agent";

        try {
            Account account = new Account(0, username, password, email, role);

            boolean success = accountDAO.addAccount(account);

            if (success) {
                request.setAttribute("message", "Agent ajouté avec succès !");
                request.setAttribute("messageType", "success");
            } else {
                request.setAttribute("message", "Échec de l'ajout de l'agent.");
                request.setAttribute("messageType", "error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erreur : " + e.getMessage());
            request.setAttribute("messageType", "error");
        }

        request.getRequestDispatcher("Vue/addAgent.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}