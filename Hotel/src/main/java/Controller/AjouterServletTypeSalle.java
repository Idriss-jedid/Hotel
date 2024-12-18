package Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Roomtype;
import dao.RoomTypeDAO;

import java.io.IOException;



public class AjouterServletTypeSalle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RoomTypeDAO roomTypeDAO;

    public AjouterServletTypeSalle() {
        super();
    }

    @Override
    public void init() throws ServletException {
        roomTypeDAO = new RoomTypeDAO();
    }

    /**
     * Handles GET requests
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String hotelIdStr = request.getParameter("hotelId");
        String label = request.getParameter("label");
        String capacity = request.getParameter("capacity");
        String prixStr = request.getParameter("prix");
      

        try {
            int prix = Integer.parseInt(prixStr);
            int Capacity = Integer.parseInt(capacity);
            int hotelid = Integer.parseInt(hotelIdStr);
 

            Roomtype roomType = new Roomtype(label, Capacity,prix);
            
            boolean success = roomTypeDAO.addRoomType(roomType,hotelid);

            if (success) {
                request.setAttribute("message", "Room type added successfully!");
                request.setAttribute("messageType", "success");
            } else {
                request.setAttribute("message", "Failed to add room type.");
                request.setAttribute("messageType", "error");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid number format for prix or hotel ID.");
            request.setAttribute("messageType", "error");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error: " + e.getMessage());
            request.setAttribute("messageType", "error");
        }

        request.getRequestDispatcher("Vue/addRoomType.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
