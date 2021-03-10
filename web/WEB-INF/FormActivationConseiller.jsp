<%-- 
    Document   : FormActivationConseiller
    Created on : 8 mars 2021, 16:14:28
    Author     : Nathan Ghozlan
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <!-- CSS only -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">CDA 2020</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarNav">
                    <ul class="navbar-nav nav-fill w-100">
                        <li class="nav-item active">
                            <a class="nav-link" href="AccueilServlet">Accueil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Deco"><span class="material-icons red600">
                                    logout
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        
        <form action="FormActiverConseiller" method="POST">
            <div class="content-login">
                <div class="card shadow-card">
                    <div class="card-header card-header-back">
                        <h5 class="card-title-perso text-center"> Activation/Désactivation du compte de ${user.person.nom}</h5>
                    </div>
                    <div>
                        <div class="card-body">
                            <div class="mb-3">
                                <label for="nom" class="my-label">Nom:</label>
                                <label>&nbsp;${user.person.nom}</label>
                            </div>
                            <div class="mb-3">
                                <label for="prenom" class="my-label">Prenom:</label>
                                <label>&nbsp;${user.person.prenom}</label>
                            </div>
                            <div class="mb-3">
                                <label for="login" class="my-label">Login:</label>
                                <label>&nbsp;${user.login}</label>
                            </div>
                            <div class="mb-3">
                                <label for="mdp" class="my-label">Password:</label>
                                <label>&nbsp;${user.mdp}</label>
                            </div>
                            <div class="mb-3">
                            <label for="Etat" class="my-label">Etat (1-Activer 0-Désactiver)</label>
                            <input type="text" class="form-control" value="${user.statut}" name="statut">
                        </div>
                        </div>

                        
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary btn-block">Valider état</button>
                            <button type="reset" class="btn btn-danger btn-block">Annuler</button>

                            <input type="hidden" name="userId" value="${user.id}">
                        </div>

                        <p class="text-center text-danger" id="msg"> ${msg} </p>
                    </div>
                </div>

            </div>
        </div>
    </form>



</body>
</html>
