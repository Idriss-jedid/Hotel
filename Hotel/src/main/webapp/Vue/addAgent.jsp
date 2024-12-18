<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Agent</title>
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
            perspective: 1000px;
        }

        .agent-container {
            background: white;
            border-radius: 20px;
            box-shadow: var(--shadow-subtle);
            width: 100%;
            max-width: 500px;
            padding: 40px;
            transform: perspective(1000px) rotateX(-10deg);
            opacity: 0.9;
            transition: var(--transition-smooth);
        }

        .agent-container:hover {
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

        .agent-form {
            display: flex;
            flex-direction: column;
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

        .form-group input {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e5e7eb;
            border-radius: 10px;
            font-size: 0.95rem;
            transition: var(--transition-smooth);
            outline: none;
        }

        .form-group input:focus {
            border-color: var(--color-primary);
            box-shadow: 0 0 0 3px rgba(74, 108, 247, 0.1);
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
            justify-content: center;
            align-items: center;
            gap: 10px;
            margin-top: 10px;
        }

        .submit-btn:hover {
            background: var(--color-secondary);
            transform: translateY(-5px);
        }

        .password-requirements {
            font-size: 0.8rem;
            color: var(--color-text-light);
            margin-top: 5px;
            opacity: 0.7;
        }

        @media (max-width: 480px) {
            .agent-container {
                width: 95%;
                padding: 20px;
            }
        }

        /* Validation styles */
        .form-group input:valid {
            border-color: #2ecc71;
        }

        .form-group input:invalid {
            border-color: #e74c3c;
        }
    </style>
</head>
<body>
    <div class="agent-container">
        <div class="form-header">
            <h1>Ajouter un Agent</h1>
            <p>Créez un nouveau compte agent</p>
        </div>
        <form action="${pageContext.request.contextPath}/AjouterAgentServlet" method="post" class="agent-form">
            <div class="form-group">
                <label for="username"><i class="fas fa-user"></i>Nom d'utilisateur</label>
                <input 
                    type="text" 
                    id="username" 
                    name="username" 
                    required 
                    placeholder="Entrez le nom d'utilisateur"
                    minlength="3"
                    maxlength="20"
                    pattern="^[a-zA-Z0-9_-]{3,20}$"
                >
            </div>

            <div class="form-group">
                <label for="password"><i class="fas fa-lock"></i>Mot de passe</label>
                <input 
                    type="password" 
                    id="password" 
                    name="password" 
                    required 
                    placeholder="Entrez le mot de passe"
                    minlength="8"
                    pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$"
                >
                <p class="password-requirements">
                    Le mot de passe doit contenir au moins 8 caractères, 
                    dont une lettre, un chiffre et un caractère spécial
                </p>
            </div>

            <div class="form-group">
                <label for="email"><i class="fas fa-envelope"></i>Email</label>
                <input 
                    type="email" 
                    id="email" 
                    name="email" 
                    required 
                    placeholder="Entrez l'adresse email"
                >
            </div>

            <button type="submit" class="submit-btn">
                <i class="fas fa-user-plus"></i>Ajouter Agent
            </button>
        </form>
    </div>
</body>
</html>