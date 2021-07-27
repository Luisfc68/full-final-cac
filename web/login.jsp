<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login CaC</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Propios -->
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/validation.js" type="text/javascript"></script>
</head>
<body class="text-center">
    <main id="login" class="mx-auto rounded px-5 pt-5 pb-0">
        <img class="mb-4" src="img/logo.jpg" alt="Logo">
        <h2 class="pb-4">
            Ingreso al sistema
        </h2>
        
        <% 
            Boolean error = (Boolean)session.getAttribute("errorClave");
            if( error!= null && error ){ 
        %>
            <p class="text-danger border border-danger rounded" > Usuario o contraseña incorrectos. </p>
        <% } %>
        
        <form action="./LoginServlet" method="POST" class="needs-validation" novalidate>
            <div class="form-group text-left">
                <label for="nombre-usuario" class="font-weight-bold">
                    Nombre:
                </label>
                <input type="text" class="form-control" name="nombre-usuario" id="nombre-usuario" placeholder="Nombre de usuario" required>
            </div>
            <div class="form-group text-left">
                <label for="clave" class="font-weight-bold">
                    Contraseña:
                </label>
                <input type="password" class="form-control" placeholder="Contraseña" name="clave" id="clave" required>
            </div>
            <input class="mt-3 mb-0 btn btn-lg btn-outline-dark" type="submit" value="Ingresar">
        </form>
        <p class="pt-3 pb-4">&copy;Copyright </p>
    </main>
</body>
</html>