<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.HotelRoom" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recherche d'Hôtels</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        :root {
            --color-primary: #4a6cf7;
            --color-secondary: #6b7aff;
            --color-background: #f4f7ff;
            --color-text-dark: #2c3036;
            --color-text-light: #6b7280;
            --shadow-subtle: 0 10px 30px rgba(0, 0, 0, 0.05);
            --shadow-hover: 0 15px 40px rgba(0, 0, 0, 0.1);
            --transition-smooth: all 0.3s cubic-bezier(0.25, 0.1, 0.25, 1);
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Open Sans', sans-serif;
            background: var(--color-background);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            line-height: 1.6;
        }

        .container {
            background: white;
            border-radius: 20px;
            box-shadow: var(--shadow-subtle);
            width: 100%;
            max-width: 1200px;
            padding: 40px;
            transform: perspective(1000px) rotateX(-10deg);
            opacity: 0.9;
            transition: var(--transition-smooth);
        }

        .container:hover {
            transform: perspective(1000px) rotateX(0);
            opacity: 1;
            box-shadow: var(--shadow-hover);
        }

        h1 {
            text-align: center;
            font-family: 'Poppins', sans-serif;
            color: var(--color-primary);
            font-size: 2.2rem;
            font-weight: 600;
            margin-bottom: 30px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        label {
            font-weight: 600;
            margin-bottom: 8px;
            color: var(--color-text-dark);
            display: flex;
            align-items: center;
            transition: var(--transition-smooth);
        }

        label i {
            margin-right: 10px;
            color: var(--color-primary);
            opacity: 0.7;
        }

        input[type="text"], 
        input[type="number"], 
        select {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e5e7eb;
            border-radius: 10px;
            font-size: 0.95rem;
            transition: var(--transition-smooth);
            outline: none;
        }

        input[type="text"]:focus, 
        input[type="number"]:focus, 
        select:focus {
            border-color: var(--color-primary);
            box-shadow: 0 0 0 3px rgba(74, 108, 247, 0.1);
        }

        button {
            background: var(--color-primary);
            color: white;
            border: none;
            padding: 15px 40px;
            border-radius: 10px;
            font-weight: 600;
            cursor: pointer;
            transition: var(--transition-smooth);
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
        }

        button:hover {
            background: var(--color-secondary);
            transform: translateY(-5px);
        }

        .results {
            margin-top: 40px;
        }

        .result-item {
            display: flex;
            align-items: flex-start;
            background: white;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: var(--shadow-subtle);
            transition: var(--transition-smooth);
        }

        .result-item:hover {
            transform: translateY(-5px);
            box-shadow: var(--shadow-hover);
        }

        .result-item .image-container {
            width: 150px;
            height: 150px;
            border-radius: 10px;
            overflow: hidden;
            margin-right: 20px;
        }

        .result-item img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .hotel-details {
            flex-grow: 1;
        }

        .hotel-details h3 {
            font-size: 1.6rem;
            color: var(--color-text-dark);
            margin-bottom: 10px;
        }

        .hotel-details p {
            margin: 5px 0;
            color: var(--color-text-light);
        }

        .hotel-details .stars {
            color: gold;
        }

        .modal {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.8);
            z-index: 1000;
            justify-content: center;
            align-items: center;
        }

        .modal img {
            max-width: 90%;
            max-height: 90%;
            border-radius: 10px;
        }

        .modal .close {
            position: absolute;
            top: 20px;
            right: 20px;
            color: white;
            font-size: 2em;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Recherche d'Hôtels</h1>
        <form action="${pageContext.request.contextPath}/ServletRecherche" method="post">
            <label for="city"><i class="fas fa-map-marker-alt"></i>Ville :</label>
            <select id="city" name="city" required>
                <option value="Ariana">Ariana</option>
                <option value="Beja">Beja</option>
                <option value="Ben Arous">Ben Arous</option>
                <option value="Bizerte">Bizerte</option>
                <option value="Gabes">Gabes</option>
                <option value="Gafsa">Gafsa</option>
                <option value="Jendouba">Jendouba</option>
                <option value="Kairouan">Kairouan</option>
                <option value="Kasserine">Kasserine</option>
                <option value="Kebili">Kebili</option>
                <option value="Kef">Kef</option>
                <option value="Mahdia">Mahdia</option>
                <option value="Manouba">Manouba</option>
                <option value="Medenine">Medenine</option>
                <option value="Monastir">Monastir</option>
                <option value="Nabeul">Nabeul</option>
                <option value="Sfax">Sfax</option>
                <option value="Sidi Bouzid">Sidi Bouzid</option>
                <option value="Siliana">Siliana</option>
                <option value="Sousse">Sousse</option>
                <option value="Tataouine">Tataouine</option>
                <option value="Tozeur">Tozeur</option>
                <option value="Tunis">Tunis</option>
                <option value="Zaghouan">Zaghouan</option>
            </select>

            <label for="stars"><i class="fas fa-star"></i>Nombre d'Étoiles :</label>
            <select id="stars" name="stars" required>
                <option value="1">1 Étoile</option>
                <option value="2">2 Étoiles</option>
                <option value="3">3 Étoiles</option>
                <option value="4">4 Étoiles</option>
                <option value="5">5 Étoiles</option>
            </select>

            <label for="roomType"><i class="fas fa-bed"></i>Type de Chambre :</label>
            <select id="roomType" name="roomType" required>
                <option value="VueJardin">Vue Jardin</option>
                <option value="VueMer">Vue Mer</option>
                <option value="suite">Suite</option>
            </select>

            <label for="capacity"><i class="fas fa-users"></i>Capacité Maximale :</label>
            <select id="capacity" name="capacity" required>
                <option value="1">1 Personne</option>
                <option value="2">2 Personnes</option>
                <option value="3">3 Personnes</option>
                <option value="4">4 Personnes</option>
            </select>

            <label for="minPrice"><i class="fas fa-dollar-sign"></i>Prix Minimum :</label>
            <input type="number" id="minPrice" name="minPrice" min="0" required>

            <label for="maxPrice"><i class="fas fa-dollar-sign"></i>Prix Maximum :</label>
            <input type="number" id="maxPrice" name="maxPrice" min="0" required>

            <button type="submit"><i class="fas fa-search"></i>Rechercher</button>
        </form>

        <hr>

        <h2>Résultats de la Recherche :</h2>
        <div class="results">
            <%
                List<HotelRoom> hotelResults = (List<HotelRoom>) request.getAttribute("hotelResults");
                if (hotelResults != null && !hotelResults.isEmpty()) {
                    for (HotelRoom hotel : hotelResults) {
            %>
            <div class="result-item">
                <div class="image-container">
                    <img src="images/<%= hotel.getImageUrl() %>" alt="Image de l'Hôtel">
                </div>
                <div class="hotel-details">
                    <h3><%= hotel.getHotelName() %></h3>
                    <p>Ville : <%= hotel.getCity() %></p>
                    <p>Étoiles : 
                        <% 
                            int stars = hotel.getNumberOfStars();
                            for (int i = 0; i < stars; i++) { 
                        %>
                        <i class="fas fa-star" style="color: gold;"></i>
                        <% 
                            } 
                        %>
                    </p>
                    <p>Type de Chambre : <%= hotel.getRoomType() %></p>
                    <p>Prix : <%= hotel.getPrice() %> TND</p>
                    <p>Capacité : <%= hotel.getCapacity() %></p>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <p style="text-align: center; font-size: 1.2em; color: var(--color-text-light);">Aucun résultat trouvé</p>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>