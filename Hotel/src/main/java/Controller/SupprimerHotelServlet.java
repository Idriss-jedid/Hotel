package Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.Hoteldao;

import java.io.IOException;

public class SupprimerHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Hoteldao hoteldao;

    public SupprimerHotelServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        hoteldao = new Hoteldao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idParam = request.getParameter("id");


        System.out.println("Hotel ID received: " + idParam);

        try {
            if (idParam == null || idParam.trim().isEmpty()) {
                throw new IllegalArgumentException("Hotel ID is missing or invalid.");
            }

            int id = Integer.parseInt(idParam); 
            boolean success = hoteldao.deleteHotel(id); 

            if (success) {
                request.setAttribute("message", "Hotel deleted successfully!");
                request.setAttribute("messageType", "success");
            } else {
                request.setAttribute("message", "Hotel not found or could not be deleted.");
                request.setAttribute("messageType", "error");
            }

        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid Hotel ID format: " + idParam);
            request.setAttribute("messageType", "error");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Unexpected error occurred: " + e.getMessage());
            request.setAttribute("messageType", "error");
        }


        request.getRequestDispatcher("Vue/agent_dashboard.jsp").forward(request, response);
    }
    /**
     * Handles POST requests
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
