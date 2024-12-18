package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Account;
import model.Hotel;
import model.Roomtype;
import dao.AccountDAO;
import dao.Hoteldao;
import dao.RoomTypeDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AccountDAO accountDAO;
    private Hoteldao hoteldao;
    private RoomTypeDAO roomdao;

    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAO();
        hoteldao = new Hoteldao();
        roomdao = new RoomTypeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            Account account = accountDAO.authenticate(email, password);

            if (account != null) {

                HttpSession session = request.getSession();
                session.setAttribute("user", account);

                if ("Agent".equals(account.getRole())) {

                    try {
                        List<Hotel> hotels = hoteldao.getAllHotels();
                        List<Roomtype> rooms = roomdao.getAllRoomTypes();


                        request.setAttribute("hotels", hotels);

                        request.setAttribute("rooms", rooms);


                        request.getRequestDispatcher("Vue/agent_dashboard.jsp").forward(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération des hôtels.");
                    }
                } else if ("admin".equals(account.getRole())) {

                    try {
                        List<Account> agents = accountDAO.getAgents();


                        request.setAttribute("agents", agents);


                        request.getRequestDispatcher("Vue/admin_dashboard.jsp").forward(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération des agents.");
                    }
                } else {

                    request.setAttribute("message", "Rôle inattendu détecté.");
                    request.getRequestDispatcher("Vue/login.jsp").forward(request, response);
                }
            } else {

                request.setAttribute("message", "Email ou mot de passe invalide.");
                request.getRequestDispatcher("Vue/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Une erreur est survenue lors de la connexion. Veuillez réessayer.");
            request.getRequestDispatcher("Vue/login.jsp").forward(request, response);
        }
    }
}