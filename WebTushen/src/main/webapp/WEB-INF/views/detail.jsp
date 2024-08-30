<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tushen Crochet Shop</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="<c:url value='/template/user/lib/lightbox/css/lightbox.min.css' />" rel="stylesheet">
    <link href="<c:url value='/template/user/lib/owlcarousel/assets/owl.carousel.min.css' />" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="<c:url value='/template/user/css/bootstrap.min.css' />" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="<c:url value='/template/user/css/style.css' />" rel="stylesheet">
</head>

<body>

<!-- Spinner Start -->
<div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
    <div class="spinner-grow text-primary" role="status"></div>
</div>
<!-- Spinner End -->


<!-- Navbar start -->
<div class="container-fluid fixed-top">
    <div class="container topbar bg-primary d-none d-lg-block">
        <div class="d-flex justify-content-between">
            <div class="top-info ps-2">
                <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">123 Street, New York</a></small>
                <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">Email@Example.com</a></small>
            </div>
            <div class="top-link pe-2">
                <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
            </div>
        </div>
    </div>
    <div class="container px-0">
        <nav class="navbar navbar-light bg-white navbar-expand-xl">
            <a href="index.html" class="navbar-brand"><h1 class="text-primary display-6">Tushen Craft</h1></a>
            <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars text-primary"></span>
            </button>
            <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                <div class="navbar-nav mx-auto">
                    <a href="<c:url value="/home"/>" class="nav-item nav-link active">Home</a>
                    <a href="<c:url value="/shop"/>" class="nav-item nav-link">Shop</a>
                    <a href="<c:url value="/about"/>" class="nav-item nav-link">About Us</a>
                </div>
                <div class="d-flex m-3 me-0">
                    <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fas fa-search text-primary"></i></button>
                    <a href="<c:url value='/user/cart' />" class="position-relative me-4 my-auto">
                        <i class="fa fa-shopping-bag fa-2x"></i>
                        <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span>
                    </a>
                    <c:if test="${not empty sessionScope.loggedInUser}">
                        <div class="d-flex">
                            <a href="<c:url value='/user/inform' />" class="btn btn-outline-primary">Xin chào, ${sessionScope.loggedInUser.fullName}</a>
                            <a href="<c:url value='/logout' />" class="btn btn-outline-secondary ms-3">Đăng xuất</a>
                        </div>
                    </c:if>
                    <c:if test="${empty sessionScope.loggedInUser}">
                        <a href="<c:url value='/login' />" class="btn btn-outline-primary"><i class="fas fa-user fa-2x"></i>ㅤĐăng nhập</a>
                    </c:if>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Navbar End -->

<!-- Modal Search Start -->
<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body d-flex align-items-center">
                <div class="input-group w-75 mx-auto d-flex">
                    <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                    <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal Search End -->


<!-- Single Page Header start -->
<div class="container-fluid page-header py-5" style="background-image: url(/template/user/img/banner.jpg)">
    <h1 class="text-center text-white display-6" style="color: deeppink">Tushen Crochet Shop</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="<c:url value="/home"/>">Home</a></li>
        <li class="breadcrumb-item active text-white">Detail</li>
        <li class="breadcrumb-item"><a href="<c:url value="/about"/>">About</a></li>
    </ol>
</div>
<!-- Single Page Header End -->


<!-- Single Product Start -->
<div class="container-fluid py-5 mt-5">
    <div class="container py-5">
        <div class="row g-4 mb-5">
            <div class="col-lg-8 col-xl-9">
                <div class="row g-4">
                    <div class="col-lg-6">
                        <div class="border rounded">
                            <a href="#">
                                <img src="<c:url value='/template/admin/product/image/${product.image}'/>" class="img-fluid rounded" alt="Image">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <h5 class="fw-bold mb-3" style="color: deeppink">${product.productName}</h5>
                        <p class="mb-3">Loại sản phẩm: ${product.category.categoryName}</p>
                        <h5 class="fw-bold mb-3">${product.price} VND</h5>
                        <div class="d-flex mb-4">
                            <i class="fa fa-star text-secondary"></i>
                            <i class="fa fa-star text-secondary"></i>
                            <i class="fa fa-star text-secondary"></i>
                            <i class="fa fa-star text-secondary"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <h4 class="mb-4">${product.description}</h4>
                        <h5 class="mb-4">☆ Sản phẩm có thể dùng để:</h5>
                        <p class="mb-4">- Đồ chơi cho trẻ em: Thú bông là một lựa chọn tuyệt vời cho đồ chơi của trẻ em. Chúng được làm từ chất liệu an toàn, mềm mại, không gây kích ứng cho da, giúp trẻ có thêm bạn đồng hành trong các hoạt động chơi và giả trí.</p>
                        <p class="mb-4">- Gối ôm: Gấu bông Len có thể được sử dụng như một chiếc gối ôm để giúp bạn thư giãn và giảm căng thẳng sau một ngày làm việc căng thẳng.</p>
                        <p class="mb-4">- Trang trí nội thất: Những chiếc thú bông có thiết kế độc đáo và dễ thương có thể được sử dụng làm đồ trang trí cho phòng khách, phòng ngủ hoặc một góc ở nơi làm việc - học tập của bạn.</p>
                        <p class="mb-4">- Quà tặng: Thú bông bằng len là một món quà ý nghĩa và độc đáo cho bạn bè, người thân trong các dịp đặc biệt như sinh nhật, kỷ niệm hay ngày lễ.</p>
                        <c:choose>
                            <c:when test="${not empty sessionScope.loggedInUser}">
                                <form action="<c:url value='/user/add-to-cart' />" method="post">
                                    <div class="input-group quantity mb-5" style="width: 100px;">
                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-sm btn-minus rounded-circle bg-light border" >
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <input type="number" name="quantity" class="form-control form-control-sm text-center border-0" value="1" min="1">
                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <input type="hidden" name="productId" value="${product.productId}" />
                                    <button type="submit" class="btn btn-primary">Thêm vào giỏ hàng</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value='/login' />" class="btn btn-primary">Đăng nhập để thêm vào giỏ hàng</a>
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="col-lg-12">
                        <nav>
                            <div class="nav nav-tabs mb-3">
                                <button class="nav-link active border-white border-bottom-0" type="button" role="tab"
                                        id="nav-about-tab" data-bs-toggle="tab" data-bs-target="#nav-about"
                                        aria-controls="nav-about" aria-selected="true">Mô tả sản phẩm</button>
                            </div>
                        </nav>
                        <div class="tab-content mb-5">
                            <div class="tab-pane active" id="nav-about" role="tabpanel" aria-labelledby="nav-about-tab">
                                <h5>Cách bảo quản:</h5>
                                <p>✔️ Bảo quản trong môi trường khô ráo và thoáng mát: Tránh để gấu bông len ở nơi ẩm ướt hoặc gần nguồn nước, vì điều này có thể làm cho len mốc và làm hỏng sản phẩm. Tránh tiếp xúc với bụi bẩn và bề mặt bẩn.</p>
                                <p>❌ Tránh giặt máy: Thú bông bằng len thường không thích hợp để giặt máy vì có thể làm hỏng cấu trúc và hình dáng của chúng. Thay vào đó, bạn nên giặt thủ công bằng nước lạnh hoặc nước ấm với một ít xà phòng nhẹ. Sau đó, hãy lau khô bằng cách vắt nhẹ hoặc để tự nhiên khô.</p>
                                <p>❌ Tránh sử dụng hóa chất mạnh: Hãy tránh sử dụng chất tẩy rửa mạnh hoặc chất tẩy uế cho thú bông bằng len vì chúng có thể làm hỏng len và làm mất màu sản phẩm.</p>
                                <h5>Shop cam kết:</h5>
                                <p>
                                <p>✔️ Chất liệu phụ kiện tốt, đảm bảo an toàn, thân thiện với môi trường.</p>
                                <p>✔️ Sản phẩm giống với mô tả, màu sắc có thể chênh lệch 3-5% do ánh sáng, điều kiện chụp.</p>
                                <p>✔️ Sản phẩm được kiểm tra kỹ, đóng gói cẩn thận, tránh trường hợp giao sai, giao thiếu phụ kiện.</p>
                                <p>✔️ Thời gian giao hàng nhanh. Miễn phí vận chuyển cho đơn hàng trên 200k.</p>
                                <div class="px-2">
                                    <div class="row g-4">
                                        <div class="col-6">
                                            <div class="row bg-light align-items-center text-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Kích cỡ</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">${product.size}</p>
                                                </div>
                                            </div>
                                            <div class="row text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Chất lượng</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">${product.quality}</p>
                                                </div>
                                            </div>
                                            <div class="row bg-light text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Chất liệu</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">${product.material}</p>
                                                </div>
                                            </div>
                                            <div class="row text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Màu sắc</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">${product.color}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xl-3">
                <div class="row g-4 fruite">
                    <div class="col-lg-12">
                        <div class="position-relative">
                            <img src="<c:url value='/template/user/img/tushen.jpeg' />" class="img-fluid w-100 rounded" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Single Product End -->


<!-- Footer Start -->
<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
    <div class="container py-5">
        <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
            <div class="row g-4">
                <div class="col-lg-3">
                    <a href="#">
                        <h1 class="text-primary mb-0">Tushen</h1>
                        <p class="text-secondary mb-0">Crochet Shop</p>
                    </a>
                </div>
                <div class="col-lg-6">
                    <div class="position-relative mx-auto">
                        <input class="form-control border-0 w-100 py-3 px-4 rounded-pill" type="number" placeholder="Your Email">
                        <button type="submit" class="btn btn-primary border-0 border-secondary py-3 px-4 position-absolute rounded-pill text-white" style="top: 0; right: 0;">Subscribe Now</button>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="d-flex justify-content-end pt-3">
                        <a class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-secondary btn-md-square rounded-circle" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row g-5">
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Why People Like us!</h4>
                    <p class="mb-4">typesetting, remaining essentially unchanged. It was
                        popularised in the 1960s with the like Aldus PageMaker including of Lorem Ipsum.</p>
                    <a href="" class="btn border-secondary py-2 px-4 rounded-pill text-primary">Read More</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="d-flex flex-column text-start footer-item">
                    <h4 class="text-light mb-3">Shop Info</h4>
                    <a class="btn-link" href="">About Us</a>
                    <a class="btn-link" href="">Contact Us</a>
                    <a class="btn-link" href="">Privacy Policy</a>
                    <a class="btn-link" href="">Terms & Condition</a>
                    <a class="btn-link" href="">Return Policy</a>
                    <a class="btn-link" href="">FAQs & Help</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="d-flex flex-column text-start footer-item">
                    <h4 class="text-light mb-3">Account</h4>
                    <a class="btn-link" href="">My Account</a>
                    <a class="btn-link" href="">Shop details</a>
                    <a class="btn-link" href="">Shopping Cart</a>
                    <a class="btn-link" href="">Wishlist</a>
                    <a class="btn-link" href="">Order History</a>
                    <a class="btn-link" href="">International Orders</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Contact</h4>
                    <p>Address: 1429 Netus Rd, NY 48247</p>
                    <p>Email: Example@gmail.com</p>
                    <p>Phone: +0123 4567 8910</p>
                    <p>Payment Accepted</p>
                    <img src="<c:url value='/template/user/img/payment.png' />" class="img-fluid" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->

<!-- Copyright Start -->
<div class="container-fluid copyright bg-dark py-4">
    <div class="container">
        <div class="row">
            <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Your Site Name</a>, All right reserved.</span>
            </div>
            <div class="col-md-6 my-auto text-center text-md-end text-white">
                <!--/*** This template is free as long as you keep the below author’s credit link/attribution link/backlink. ***/-->
                <!--/*** If you'd like to use the template without the below author’s credit link/attribution link/backlink, ***/-->
                <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
                Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a> Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
            </div>
        </div>
    </div>
</div>
<!-- Copyright End -->



<!-- Back to Top -->
<a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<c:url value='/template/user/lib/easing/easing.min.js' />"></script>
<script src="<c:url value='/template/user/lib/waypoints/waypoints.min.js' />"></script>
<script src="<c:url value='/template/user/lib/lightbox/js/lightbox.min.js' />"></script>
<script src="<c:url value='/template/user/lib/owlcarousel/owl.carousel.min.js' />"></script>


<!-- Template Javascript -->
<script src="<c:url value='/template/user/js/main.js' />"></script>
</body>

</html>