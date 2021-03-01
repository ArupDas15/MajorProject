<%@page import="java.util.List"%>
<%@page import="com.smart.shop.dblogic.AdminDao"%>
<%@page import="com.smart.shop.dao.AdminDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-img/services/safe.pngimg/services/safe.pngimg/services/submarine.pngimg/services/submarine.pngimg/services/circus.pngimg/services/circus.pngimg/services/cake.pngimg/services/cake.pngimg/services/game.pngimg/services/game.pngimg/services/cabin.pngimg/services/cabin.pngscale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Update Product</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="css/cust.css" rel="stylesheet">
        <!-- Plugin CSS -->
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/freelancer.min.css" rel="stylesheet">
        <style>
            .select-selected {
                background-color: DodgerBlue;
            }
        </style>
        <script type="text/javascript">

            function closeform() {
                document.getElementById('mdiv').style.display = 'none';
            }
            function showform() {
                document.getElementById('mdiv').style.display = 'block';
            }
        </script>
    </head>

    <body id="page-top">

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
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="product.jsp">Home</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="add_product.jsp">Add</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="remove_product.jsp">Remove</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Header -->
        <header class="masthead bg-primary text-white text-center">
            <div class="container">
                <img class="img-fluid mb-5 d-block mx-auto" src="img/stock.png" alt="">
                <h1 class="text-uppercase mb-0">Product</h1>
                <hr class="star-light">
                <h2 class="font-weight-light mb-0">Update Details </h2>
            </div>
        </header>

        <!-- Section -->
        <section id="update_product">
            <div class="container">
                <h2 class="text-center text-uppercase text-secondary mb-0">Update Product Details</h2>
                <hr class="star-dark mb-5">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <!--<form action="./UpdateProduct" method="post" name="update_prod_form" id="updateProdForm">-->
                        <table class="col-lg-12 text-uppercase text-center table-bordered">
                            <tr class="bg-success">
                                <th>Name</th>
                                <th>Category</th>
                                <th>Cost Price</th>
                                <th>Selling Price</th>
                                <th>Action</th>
                            </tr>
                            <%
                                AdminDAO dao = new AdminDao();
                                List list = dao.getAllProductDetails();
                                for (int i = 0; i < list.size() / 5; i++) {
                            %>
                            <tr>
                            <input type="hidden" name="pid" value="<%=list.get(0 + i * 5)%>">
                            <td><%=list.get(1 + i * 5)%></td>
                            <td><%=dao.getCategoryName(Integer.parseInt(list.get(2 + i * 5).toString()))%></td>
                            <td><%=list.get(3 + i * 5)%></td>
                            <td><%=list.get(4 + i * 5)%></td>
                            <td><input type="submit" class="btn btn-dark btn-block" value="Update" onclick="showform();"/></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <!--</form>-->
                    </div>
                </div>
            </div>

        </section>

        <div id="mdiv" class="modal">
            <form class="modal-content animate" action="./UpdateProduct" method="post">
                <div class="imgcontainer">
                    <span onclick="closeform('mdiv')" class="close" title="Close Modal">&times;</span>
                    <!--<img src="img/update.png" alt="Product" class="avatar">-->
                </div>

                <div class="container">
                    <label for="name"><b>Name</b></label>
                    <input type="text" placeholder="Enter New Product Name" name="name" style="text-transform:uppercase" required>
                    <label for="catname"><b>Category Name</b></label>
                    <input type="text" placeholder="Enter New Category" name="catname" style="text-transform:uppercase" required>
                    <label for="cost"><b>Cost Price</b></label>
                    <input type="text" placeholder="Enter Cost Price" name="cost" style="text-transform:uppercase" required>
                    <label for="sprice"><b>Selling Price</b></label>
                    <input type="text" placeholder="Enter Selling Price" name="sprice" style="text-transform:uppercase" maxlength="2" required>
                    <button type="submit">Submit</button>
                </div>
                <div class="container" style="background-color:#f1f1f1">
                    <button type="button" onclick="closeform('mdiv');" class="cancelbtn">Cancel</button>
                </div>
            </form>
        </div>

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

    </body>

</html>

