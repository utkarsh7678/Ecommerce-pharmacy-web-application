<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Getpharm</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Categories
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Prescription Medicines</a>
                        <a class="dropdown-item" href="#">OTC Medicines</a>
                        <a class="dropdown-item" href="#">Healthcare Products</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#cart-modal">
                        <i class="fas fa-shopping-cart"></i>
                        <span class="cart-items">(0)</span>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="login.jsp">Login as a user</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp">Register as a user</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="login_driver.jsp">Login as a delivery partner</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="register_driver.jsp">Register as a delivery partner</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Cart Modal -->
<div class="modal fade" id="cart-modal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header custom-bg text-white">
                <h5 class="modal-title" id="cartModalLabel">Your Cart</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="cart-body">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary checkout-btn" onclick="window.location='checkout.jsp'">Checkout</button>
            </div>
        </div>
    </div>
</div>