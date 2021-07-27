<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedido</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Propios -->
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/validation.js" type="text/javascript"></script>
</head>
<body>
    
    <% 
        if(session.getAttribute("usuario") == null)
            request.getRequestDispatcher("./login.jsp").forward(request, response);
    %>
    
    <main id="formulario-pedido" class="mx-auto rounded p-3">
        <div class="text-center p-1">
            <img src="img/logo.jpg" alt="Logo">
            <h2 class="mt-3 mb-1">
                Formulario de pedido
            </h2>
            <p class="mt-2 mb-0">
                La fecha de entrega será coordinada telefónicamente
            </p>
        </div>

        <h2 class="text-center mt-1 mb-3">
            Tu pedido
        </h2>
        <form class="needs-validation" action="./PedidoServlet" method="POST" novalidate>
            <div class="form-row mb-3">
                <div class="col-sm-6">
                    <label for="nombre">Nombre </label>
                    <input class="form-control" type="text" name="nombre" id="nombre" required>
                </div>
                <div class="col-sm-6">
                    <label for="apellido">Apellido </label>
                    <input class="form-control" type="text" name="apellido" id="apellido" required>
                </div>
            </div>

            <div class="form-group">
                <label for="username">Nombre de usuario</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                    </div>
                    <input class="form-control" type="text" name="username" id="username" required value="<%=((Usuario)session.getAttribute("usuario")).getNombreUsuario()%>" readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="correo">Email (Opcional)</label>
                <input class="form-control" type="email" name="correo" id="correo">
            </div>
            <div class="form-group">
                <label for="direccion">Dirección</label>
                <input class="form-control" type="text" name="direccion" id="direccion" required>
            </div>

            <div class="form-row">
                <div class="col-sm-4">
                    <label for="localidad">Localidad</label>
                    <select class="custom-select" id="localidad" name="localidad" required>
                        <option value="" selected>Selecciona...</option>
                        <option value="palermo">Palermo</option>
                        <option value="belgrano">Belgrano</option>
                        <option value="nunez">Núñez</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label for="provincia">Provincia</label>
                    <select class="custom-select" id="provincia" name="provincia" required>
                        <option value="" selected>Selecciona...</option>
                        <option value="buenos-aires">Buenos Aires</option>
                        <option value="cordoba">Córdoba</option>
                        <option value="santa-fe">Santa Fe</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label for="cod-postal">Código Postal</label>
                    <input class="form-control" type="number" name="cod-postal" id="cod-postal" required>
                </div>
            </div>

            <hr>
            
            <div class="form-group text-center">
                <h4>Forma de pago</h4>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="formapago" id="credito" value="credito" required>
                    <label class="form-check-label" for="credito">
                        Tarjeta de crédito
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="formapago" id="mercadopago" value="mercadopago" required>
                    <label class="form-check-label" for="mercadopago">
                        Mercado Pago
                    </label>
                </div>
            </div>

            <div class="form-row">
                <div class="col-sm-6">
                    <label for="nombre-titular">Nombre del titular</label>
                    <input class="form-control" type="text" name="nombre-titular" id="nombre-titular" required>
                    <small class="form-text text-muted">Nombre como se muestra en la tarjeta</small>
                </div>
                <div class="col-sm-6">
                    <label for="numero-tarjeta">Número de tarjeta</label>
                    <input class="form-control" type="number" name="numero-tarjeta" id="numero-tarjeta" required>
                </div>
            </div>

            <div class="form-row justify-content-center">
                <div class="col-sm-4">
                    <label for="vencimiento">Fecha de vto.</label>
                    <input class="form-control" type="month" name="vencimiento" id="vencimiento" required>
                </div>
                <div class="col-sm-4">
                    <label for="cod-tarjeta">Código</label>
                    <input class="form-control" type="number" name="cod-tarjeta" id="cod-tarjeta" required>
                </div>
            </div>

            <hr>

            <div class="text-center">
                <input class="btn btn-md btn-outline-dark" id="btn-pedido" type="submit" value="Ingresar la solicitud">
            </div>

        </form>
    </main>
</body>
</html>