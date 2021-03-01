

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-img/services/safe.pngimg/services/safe.pngimg/services/submarine.pngimg/services/submarine.pngimg/services/circus.pngimg/services/circus.pngimg/services/cake.pngimg/services/cake.pngimg/services/game.pngimg/services/game.pngimg/services/cabin.pngimg/services/cabin.pngscale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Welcome Page</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- Plugin CSS -->
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/freelancer.min.css" rel="stylesheet">

    </head>



    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
        <div class="container">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">Smart Shop</a>
            <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#login">Sign in</a>
                    </li>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#services">Services</a>
                    </li>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">About</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header class="masthead bg-primary text-white text-center">
        <div class="container">
            <img class="img-fluid mb-5 d-block mx-auto" src="img/login.png" alt="">
            <h1 class="text-uppercase mb-0">Smart Shop</h1>
            <hr class="star-light">
            <h2 class="font-weight-light mb-0"> SHAPING THE FUTURE IN A FAST-CHANGING WORLD </h2>
        </div>
    </header>

    <!-- Login Section -->
    <section id="login">
        <div class="container">
            <h2 class="text-center text-uppercase text-secondary mb-0">Sign in</h2>
            <hr class="star-dark mb-5">
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <form action="./SignIn" method="post" name="login-form" id="loginForm">
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                <label>Email Address</label>
                                <input class="form-control" name="uid" id="email" type="email" placeholder="Email Address" required="required" data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                <label>Password</label>
                                <input class="form-control" name="pass" id="pass" type="password" placeholder="Password (6-Digit)" required="required" data-validation-required-message="Please enter your password.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-xl" id="signin" name="signIn_btn" value="Sign in"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>


    <!-- Services Grid Section -->
    <section class="portfolio" id="services">
        <div class="container">
            <h2 class="text-center text-uppercase text-secondary mb-0">Services</h2>
            <hr class="star-dark mb-5">
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
                        <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                            <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                <i class="fas fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img class="img-fluid" src="img/services/blockchain.png" alt="">
                    </a>
                </div>
                <div class="col-md-6 col-lg-4">
                    <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-2">
                        <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                            <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                <i class="fas fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img class="img-fluid" src="img/services/decentrized.png" alt="">
                    </a>
                </div>
                <div class="col-md-6 col-lg-4">
                    <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-3">
                        <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                            <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                <i class="fas fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img class="img-fluid" src="img/services/model.png" alt="">
                    </a>
                </div>
                <div class="col-md-6 col-lg-4">
                    <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-4">
                        <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                            <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                <i class="fas fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img class="img-fluid" src="img/services/trust.png" alt="">
                    </a>
                </div>
                <div class="col-md-6 col-lg-4">
                    <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-5">
                        <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                            <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                <i class="fas fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img class="img-fluid" src="img/services/safe.png" alt="">
                    </a>
                </div>
                <div class="col-md-6 col-lg-4">
                    <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-6">
                        <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                            <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                <i class="fas fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img class="img-fluid" src="img/services/goal.png" alt="">
                    </a>
                </div>
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section class="bg-primary text-white mb-0" id="about">
        <div class="container">
            <h2 class="text-center text-uppercase text-white">About</h2>
            <hr class="star-light mb-5">
            <div class="row">
                <div class="col-lg-4 ml-auto">
                    <p class="lead">Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop</p>
                </div>
                <div class="col-lg-4 mr-auto">
                    <p class="lead">Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop Smart Shop</p>
                </div>
            </div>

        </div>
    </section>

    <!-- Footer -->
    <footer class="footer text-center">
        <div class="container">
            <div class="row">
                <div class="col-md-4 mb-5 mb-lg-0">
                    <h4 class="text-uppercase mb-4">Location</h4>
                    <p class="lead mb-0">2215 Smart Shop
                        <br>Tumkur</p>
                </div>
                <div class="col-md-4 mb-5 mb-lg-0">
                    <h4 class="text-uppercase mb-4">Around the Web</h4>
                    <ul class="list-inline mb-0">
                        <li class="list-inline-item">
                            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                <i class="fab fa-fw fa-facebook-f"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                <i class="fab fa-fw fa-google-plus-g"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                <i class="fab fa-fw fa-twitter"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                <i class="fab fa-fw fa-linkedin-in"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                <i class="fab fa-fw fa-dribbble"></i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <h4 class="text-uppercase mb-4">About Us</h4>
                    <p class="lead mb-0">Smart Shop is a future shop, Created by Anonymous
                        <a href="">Smart Shop</a>.</p>
                </div>
            </div>
        </div>
    </footer>

    <div class="copyright py-4 text-center text-white">
        <div class="container">
            <small>Copyright &copy; Smart Shop 2018</small>
        </div>
    </div>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
        <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>

    <!-- Portfolio Modals -->

    <!-- Portfolio Modal 1 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
        <div class="portfolio-modal-dialog bg-white">
            <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                <i class="fa fa-3x fa-times"></i>
            </a>
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-secondary text-uppercase mb-0">Smart Shop</h2>
                        <hr class="star-dark mb-5">
                        <img class="img-fluid mb-5" src="img/services/blockchain.png" alt="">
                        <p class="mb-5">Block Chain</p>
                        <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                            <i class="fa fa-close"></i>
                            Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 2 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
        <div class="portfolio-modal-dialog bg-white">
            <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                <i class="fa fa-3x fa-times"></i>
            </a>
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-secondary text-uppercase mb-0">Smart Shop</h2>
                        <hr class="star-dark mb-5">
                        <img class="img-fluid mb-5" src="img/services/decentrized.png" alt="">
                        <p class="mb-5">Smart Shop</p>
                        <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                            <i class="fa fa-close"></i>
                            Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 3 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
        <div class="portfolio-modal-dialog bg-white">
            <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                <i class="fa fa-3x fa-times"></i>
            </a>
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-secondary text-uppercase mb-0">Smart Shop</h2>
                        <hr class="star-dark mb-5">
                        <img class="img-fluid mb-5" src="img/services/model.png" alt="">
                        <p class="mb-5">Smart Shop</p>
                        <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                            <i class="fa fa-close"></i>
                            Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 4 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-4">
        <div class="portfolio-modal-dialog bg-white">
            <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                <i class="fa fa-3x fa-times"></i>
            </a>
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-secondary text-uppercase mb-0">Smart Shop</h2>
                        <hr class="star-dark mb-5">
                        <img class="img-fluid mb-5" src="img/services/trust.png" alt="">
                        <p class="mb-5">Smart Shop</p>
                        <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                            <i class="fa fa-close"></i>
                            Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 5 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-5">
        <div class="portfolio-modal-dialog bg-white">
            <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                <i class="fa fa-3x fa-times"></i>
            </a>
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-secondary text-uppercase mb-0">Smart Shop</h2>
                        <hr class="star-dark mb-5">
                        <img class="img-fluid mb-5" src="img/services/safe.png" alt="">
                        <p class="mb-5">Smart Shop</p>
                        <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                            <i class="fa fa-close"></i>
                            Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 6 -->

    <div class="portfolio-modal mfp-hide" id="portfolio-modal-6">
        <div class="portfolio-modal-dialog bg-white">
            <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                <i class="fa fa-3x fa-times"></i>
            </a>
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-secondary text-uppercase mb-0">Smart Shop</h2>
                        <hr class="star-dark mb-5">
                        <img class="img-fluid mb-5" src="img/services/goal.png" alt="">
                        <p class="mb-5">Smart Shop</p>
                        <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                            <i class="fa fa-close"></i>
                            Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/freelancer.min.js"></script>



</html>
