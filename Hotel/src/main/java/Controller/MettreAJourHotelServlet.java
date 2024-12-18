package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Hotel;
import dao.Hoteldao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class MettreAJourHotelServlet
 */
//@WebServlet("/MettreAJourHotelServlet")
@MultipartConfig
public class MettreAJourHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Hoteldao hoteldao;

    public MettreAJourHotelServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        hoteldao = new Hoteldao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String city = request.getParameter("city");
            int stars = Integer.parseInt(request.getParameter("stars"));
            String description = request.getParameter("description");
            Part file = request.getPart("image"); 

            String imageFileName = file.getSubmittedFileName(); 



            Hotel hotel = new Hotel(name, city, stars, description, imageFileName, id);


            boolean success = hoteldao.updateHotel(hotel);


            String path = "C:/Users/21652/Desktop/idriss_malek/Hotel/src/main/webapp/images/" + imageFileName;

            try {

                FileOutputStream fos = new FileOutputStream(path);
                InputStream is = file.getInputStream();

                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (success) {

                request.setAttribute("message", "Hôtel mis à jour avec succès !");
                request.setAttribute("messageType", "success");
            } else {

                request.setAttribute("message", "Échec de la mise à jour de l'hôtel.");
                request.setAttribute("messageType", "error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erreur : " + e.getMessage());
            request.setAttribute("messageType", "error");
        }


        request.getRequestDispatcher("Vue/editHotel.jsp").forward(request, response);
    }
}