/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.13
 * Generated at: 2024-12-18 11:34:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Vue;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import model.HotelRoom;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model.HotelRoom");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Recherche d'Hôtels</title>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&family=Open+Sans:wght@400;600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        :root {\r\n");
      out.write("            --color-primary: #4a6cf7;\r\n");
      out.write("            --color-secondary: #6b7aff;\r\n");
      out.write("            --color-background: #f4f7ff;\r\n");
      out.write("            --color-text-dark: #2c3036;\r\n");
      out.write("            --color-text-light: #6b7280;\r\n");
      out.write("            --shadow-subtle: 0 10px 30px rgba(0, 0, 0, 0.05);\r\n");
      out.write("            --shadow-hover: 0 15px 40px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            --transition-smooth: all 0.3s cubic-bezier(0.25, 0.1, 0.25, 1);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        * {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: 'Open Sans', sans-serif;\r\n");
      out.write("            background: var(--color-background);\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("            line-height: 1.6;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            background: white;\r\n");
      out.write("            border-radius: 20px;\r\n");
      out.write("            box-shadow: var(--shadow-subtle);\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            max-width: 1200px;\r\n");
      out.write("            padding: 40px;\r\n");
      out.write("            transform: perspective(1000px) rotateX(-10deg);\r\n");
      out.write("            opacity: 0.9;\r\n");
      out.write("            transition: var(--transition-smooth);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container:hover {\r\n");
      out.write("            transform: perspective(1000px) rotateX(0);\r\n");
      out.write("            opacity: 1;\r\n");
      out.write("            box-shadow: var(--shadow-hover);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-family: 'Poppins', sans-serif;\r\n");
      out.write("            color: var(--color-primary);\r\n");
      out.write("            font-size: 2.2rem;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            margin-bottom: 30px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        form {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            gap: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label {\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            margin-bottom: 8px;\r\n");
      out.write("            color: var(--color-text-dark);\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            transition: var(--transition-smooth);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label i {\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("            color: var(--color-primary);\r\n");
      out.write("            opacity: 0.7;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"text\"], \r\n");
      out.write("        input[type=\"number\"], \r\n");
      out.write("        select {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 12px 15px;\r\n");
      out.write("            border: 2px solid #e5e7eb;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            font-size: 0.95rem;\r\n");
      out.write("            transition: var(--transition-smooth);\r\n");
      out.write("            outline: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"text\"]:focus, \r\n");
      out.write("        input[type=\"number\"]:focus, \r\n");
      out.write("        select:focus {\r\n");
      out.write("            border-color: var(--color-primary);\r\n");
      out.write("            box-shadow: 0 0 0 3px rgba(74, 108, 247, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background: var(--color-primary);\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 15px 40px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: var(--transition-smooth);\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            gap: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background: var(--color-secondary);\r\n");
      out.write("            transform: translateY(-5px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .results {\r\n");
      out.write("            margin-top: 40px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-item {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: flex-start;\r\n");
      out.write("            background: white;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            box-shadow: var(--shadow-subtle);\r\n");
      out.write("            transition: var(--transition-smooth);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-item:hover {\r\n");
      out.write("            transform: translateY(-5px);\r\n");
      out.write("            box-shadow: var(--shadow-hover);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-item .image-container {\r\n");
      out.write("            width: 150px;\r\n");
      out.write("            height: 150px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            margin-right: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-item img {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            object-fit: cover;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .hotel-details {\r\n");
      out.write("            flex-grow: 1;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .hotel-details h3 {\r\n");
      out.write("            font-size: 1.6rem;\r\n");
      out.write("            color: var(--color-text-dark);\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .hotel-details p {\r\n");
      out.write("            margin: 5px 0;\r\n");
      out.write("            color: var(--color-text-light);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .hotel-details .stars {\r\n");
      out.write("            color: gold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .modal {\r\n");
      out.write("            display: none;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background-color: rgba(0, 0, 0, 0.8);\r\n");
      out.write("            z-index: 1000;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .modal img {\r\n");
      out.write("            max-width: 90%;\r\n");
      out.write("            max-height: 90%;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .modal .close {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: 20px;\r\n");
      out.write("            right: 20px;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-size: 2em;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Recherche d'Hôtels</h1>\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/ServletRecherche\" method=\"post\">\r\n");
      out.write("            <label for=\"city\"><i class=\"fas fa-map-marker-alt\"></i>Ville :</label>\r\n");
      out.write("            <select id=\"city\" name=\"city\" required>\r\n");
      out.write("                <option value=\"Ariana\">Ariana</option>\r\n");
      out.write("                <option value=\"Beja\">Beja</option>\r\n");
      out.write("                <option value=\"Ben Arous\">Ben Arous</option>\r\n");
      out.write("                <option value=\"Bizerte\">Bizerte</option>\r\n");
      out.write("                <option value=\"Gabes\">Gabes</option>\r\n");
      out.write("                <option value=\"Gafsa\">Gafsa</option>\r\n");
      out.write("                <option value=\"Jendouba\">Jendouba</option>\r\n");
      out.write("                <option value=\"Kairouan\">Kairouan</option>\r\n");
      out.write("                <option value=\"Kasserine\">Kasserine</option>\r\n");
      out.write("                <option value=\"Kebili\">Kebili</option>\r\n");
      out.write("                <option value=\"Kef\">Kef</option>\r\n");
      out.write("                <option value=\"Mahdia\">Mahdia</option>\r\n");
      out.write("                <option value=\"Manouba\">Manouba</option>\r\n");
      out.write("                <option value=\"Medenine\">Medenine</option>\r\n");
      out.write("                <option value=\"Monastir\">Monastir</option>\r\n");
      out.write("                <option value=\"Nabeul\">Nabeul</option>\r\n");
      out.write("                <option value=\"Sfax\">Sfax</option>\r\n");
      out.write("                <option value=\"Sidi Bouzid\">Sidi Bouzid</option>\r\n");
      out.write("                <option value=\"Siliana\">Siliana</option>\r\n");
      out.write("                <option value=\"Sousse\">Sousse</option>\r\n");
      out.write("                <option value=\"Tataouine\">Tataouine</option>\r\n");
      out.write("                <option value=\"Tozeur\">Tozeur</option>\r\n");
      out.write("                <option value=\"Tunis\">Tunis</option>\r\n");
      out.write("                <option value=\"Zaghouan\">Zaghouan</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"stars\"><i class=\"fas fa-star\"></i>Nombre d'Étoiles :</label>\r\n");
      out.write("            <select id=\"stars\" name=\"stars\" required>\r\n");
      out.write("                <option value=\"1\">1 Étoile</option>\r\n");
      out.write("                <option value=\"2\">2 Étoiles</option>\r\n");
      out.write("                <option value=\"3\">3 Étoiles</option>\r\n");
      out.write("                <option value=\"4\">4 Étoiles</option>\r\n");
      out.write("                <option value=\"5\">5 Étoiles</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"roomType\"><i class=\"fas fa-bed\"></i>Type de Chambre :</label>\r\n");
      out.write("            <select id=\"roomType\" name=\"roomType\" required>\r\n");
      out.write("                <option value=\"VueJardin\">Vue Jardin</option>\r\n");
      out.write("                <option value=\"VueMer\">Vue Mer</option>\r\n");
      out.write("                <option value=\"suite\">Suite</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"capacity\"><i class=\"fas fa-users\"></i>Capacité Maximale :</label>\r\n");
      out.write("            <select id=\"capacity\" name=\"capacity\" required>\r\n");
      out.write("                <option value=\"1\">1 Personne</option>\r\n");
      out.write("                <option value=\"2\">2 Personnes</option>\r\n");
      out.write("                <option value=\"3\">3 Personnes</option>\r\n");
      out.write("                <option value=\"4\">4 Personnes</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"minPrice\"><i class=\"fas fa-dollar-sign\"></i>Prix Minimum :</label>\r\n");
      out.write("            <input type=\"number\" id=\"minPrice\" name=\"minPrice\" min=\"0\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"maxPrice\"><i class=\"fas fa-dollar-sign\"></i>Prix Maximum :</label>\r\n");
      out.write("            <input type=\"number\" id=\"maxPrice\" name=\"maxPrice\" min=\"0\" required>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\"><i class=\"fas fa-search\"></i>Rechercher</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        <hr>\r\n");
      out.write("\r\n");
      out.write("        <h2>Résultats de la Recherche :</h2>\r\n");
      out.write("        <div class=\"results\">\r\n");
      out.write("            ");

                List<HotelRoom> hotelResults = (List<HotelRoom>) request.getAttribute("hotelResults");
                if (hotelResults != null && !hotelResults.isEmpty()) {
                    for (HotelRoom hotel : hotelResults) {
            
      out.write("\r\n");
      out.write("            <div class=\"result-item\">\r\n");
      out.write("                <div class=\"image-container\">\r\n");
      out.write("                    <img src=\"images/");
      out.print( hotel.getImageUrl() );
      out.write("\" alt=\"Image de l'Hôtel\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"hotel-details\">\r\n");
      out.write("                    <h3>");
      out.print( hotel.getHotelName() );
      out.write("</h3>\r\n");
      out.write("                    <p>Ville : ");
      out.print( hotel.getCity() );
      out.write("</p>\r\n");
      out.write("                    <p>Étoiles : \r\n");
      out.write("                        ");
 
                            int stars = hotel.getNumberOfStars();
                            for (int i = 0; i < stars; i++) { 
                        
      out.write("\r\n");
      out.write("                        <i class=\"fas fa-star\" style=\"color: gold;\"></i>\r\n");
      out.write("                        ");
 
                            } 
                        
      out.write("\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p>Type de Chambre : ");
      out.print( hotel.getRoomType() );
      out.write("</p>\r\n");
      out.write("                    <p>Prix : ");
      out.print( hotel.getPrice() );
      out.write(" TND</p>\r\n");
      out.write("                    <p>Capacité : ");
      out.print( hotel.getCapacity() );
      out.write("</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");

                    }
                } else {
            
      out.write("\r\n");
      out.write("            <p style=\"text-align: center; font-size: 1.2em; color: var(--color-text-light);\">Aucun résultat trouvé</p>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
