<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css" media="screen,projection">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>

        <div class="container">
            <div class="row">
              <div class="col s12">
                <div class="card blue-grey darken-1 hoverable animated zoomInDown">
                  <form method="POST" action="/login">
                    <div class="card-content white-text">
                      <span class="card-title hide-on-small-only">Authentification</span>
                    </div>
                    <div class="input-field">
                      <i class="material-icons prefix">account_circle</i>
                      <input placeholder="Username" type="text" name="username" required>
                    </div>
                    <div class="input-field">
                      <i class="material-icons prefix">fingerprint</i>
                      <input placeholder="Password" type="password" name="password" class="validate" required>
                    </div>
                    <div class="card-action">
                      <button class="btn waves-effect blue-grey darken-4 waves-light" type="submit">Login
                          <i class="material-icons right">send</i>
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          

         <c:if test="${not empty errorMessage}">
          ERROR MESSAGE : <%= request.getAttribute("errorMessage") %>
        </c:if>



     <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    </body>
  </html>