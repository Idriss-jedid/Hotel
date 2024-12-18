package Controller;
import dao.HotelRoomDAO;
import dao.RoomTypeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class MettreAJourTypeRoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int roomTypeId = Integer.parseInt(request.getParameter("id"));
            int hotelId = Integer.parseInt(request.getParameter("hotelId"));
            String label = request.getParameter("label");
            int capacity = Integer.parseInt(request.getParameter("capacity"));
            double price = Double.parseDouble(request.getParameter("price"));


            HotelRoomDAO hotelRoomDAO = new HotelRoomDAO();
            RoomTypeDAO roomTypeDAO = new RoomTypeDAO();


            hotelRoomDAO.updateHotelIdByRoomTypeId(roomTypeId, hotelId);


            roomTypeDAO.updateRoomTypeDetails(roomTypeId, label, capacity, price);

            response.sendRedirect("Vue/editRoom.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
