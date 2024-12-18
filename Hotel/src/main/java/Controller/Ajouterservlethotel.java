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


//@WebServlet("/Ajouterservlethotel")
@MultipartConfig
public class Ajouterservlethotel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Hoteldao hoteldao;

    public Ajouterservlethotel() {
        super();
    }

    @Override
    public void init() throws ServletException {
        hoteldao = new Hoteldao();
    }

    /**
     * Gère les requêtes GET
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String starsStr = request.getParameter("stars");
        String description = request.getParameter("description");
        Part file = request.getPart("image"); 
        String imageFileName = file.getSubmittedFileName(); 

        try {
            int stars = Integer.parseInt(starsStr); 

            Hotel hotel = new Hotel(name, city, stars, description, imageFileName);

            boolean success = hoteldao.addHotel(hotel);

            String uploadPath = "C:/Users/21652/Desktop/idriss_malek/Hotel/src/main/webapp/images/" + imageFileName;

            try {
                // Enregistrement du fichier image sur le serveur
                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = file.getInputStream();

                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (success) {
                request.setAttribute("message", "Hôtel ajouté avec succès !");
                request.setAttribute("messageType", "success");
            } else {
                request.setAttribute("message", "Échec de l'ajout de l'hôtel.");
                request.setAttribute("messageType", "error");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Format de nombre invalide pour les étoiles.");
            request.setAttribute("messageType", "error");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erreur : " + e.getMessage());
            request.setAttribute("messageType", "error");
        }

        request.getRequestDispatcher("Vue/addHotel.jsp").forward(request, response);
    }

    /**
     * Gère les requêtes POST
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}