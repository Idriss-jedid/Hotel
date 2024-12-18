<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Hôtel - Formulaire Élégant</title>
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

        .form-container {
            background: white;
            border-radius: 20px;
            box-shadow: var(--shadow-subtle);
            width: 100%;
            max-width: 700px;
            padding: 40px;
            transform: perspective(1000px) rotateX(-10deg);
            opacity: 0.9;
            transition: var(--transition-smooth);
        }

        .form-container:hover {
            transform: perspective(1000px) rotateX(0);
            opacity: 1;
            box-shadow: var(--shadow-hover);
        }

        .form-header {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-header h1 {
            font-family: 'Poppins', sans-serif;
            color: var(--color-primary);
            font-size: 2.2rem;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .form-header p {
            color: var(--color-text-light);
            font-size: 0.9rem;
        }

        .form-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .form-group label {
            font-weight: 600;
            margin-bottom: 8px;
            color: var(--color-text-dark);
            display: flex;
            align-items: center;
            transition: var(--transition-smooth);
        }

        .form-group label i {
            margin-right: 10px;
            color: var(--color-primary);
            opacity: 0.7;
        }

        .form-group input, 
        .form-group textarea {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e5e7eb;
            border-radius: 10px;
            font-size: 0.95rem;
            transition: var(--transition-smooth);
            outline: none;
        }

        .form-group input:focus, 
        .form-group textarea:focus {
            border-color: var(--color-primary);
            box-shadow: 0 0 0 3px rgba(74, 108, 247, 0.1);
        }

        .form-group.full-width {
            grid-column: span 2;
        }

        .submit-section {
            grid-column: span 2;
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .submit-btn {
            background: var(--color-primary);
            color: white;
            border: none;
            padding: 15px 40px;
            border-radius: 10px;
            font-weight: 600;
            cursor: pointer;
            transition: var(--transition-smooth);
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .submit-btn:hover {
            background: var(--color-secondary);
            transform: translateY(-5px);
        }

        @media (max-width: 768px) {
            .form-grid {
                grid-template-columns: 1fr;
            }

            .form-group.full-width,
            .submit-section {
                grid-column: span 1;
            }
        }
    </style>
</head>
<body>
    <div class="form-container">
        <div class="form-header">
            <h1>Ajouter un Hôtel</h1>
            <p>Remplissez les détails de votre établissement avec soin</p>
        </div>
        <form action="${pageContext.request.contextPath}/Ajouterservlethotel" method="post" enctype="multipart/form-data" class="form-grid">
            <div class="form-group">
                <label for="name"><i class="fas fa-building"></i>Nom de l'Hôtel</label>
                <input type="text" id="name" name="name" placeholder="Ex: Grand Palace Resort" required>
            </div>

            <div class="form-group">
                <label for="city"><i class="fas fa-map-marker-alt"></i>Ville</label>
                <input type="text" id="city" name="city" placeholder="Ex: Paris" required>
            </div>

            <div class="form-group">
                <label for="stars"><i class="fas fa-star"></i>Nombre d'Étoiles</label>
                <input type="number" id="stars" name="stars" min="1" max="5" placeholder="1-5" required>
            </div>

            <div class="form-group">
                <label for="image"><i class="fas fa-image"></i>Image de l'Hôtel</label>
                <input type="file" id="image" name="image" accept="image/*" required>
            </div>

            <div class="form-group full-width">
                <label for="description"><i class="fas fa-pen"></i>Description</label>
                <textarea id="description" name="description" placeholder="Décrivez votre hôtel en détail..." rows="5" required></textarea>
            </div>

            <div class="submit-section">
                <button type="submit" class="submit-btn">
                    <i class="fas fa-plus"></i>Ajouter l'Hôtel
                </button>
            </div>
        </form>
    </div>
</body>
</html>