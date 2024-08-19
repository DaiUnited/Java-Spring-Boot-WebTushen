<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ admin</title>
    <script type='text/javascript' src='<c:url value="/template/admin/js/2.1.4/jquery.min.js" />'></script>

    <link rel="stylesheet" href="<c:url value='/template/admin/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body class="no-skin">

<!-- Header -->
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="<c:url value='/admin/home'/>" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang chủ
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a href="#" class="dropdown-toggle">
                        Xin chào, [fullName]
                    </a>
                <li class="light-blue dropdown-modal">
                    <a href="#">
                        <i class="ace-icon fa fa-power-off"></i>
                        Thoát
                    </a>
                </li>
                </li>
            </ul>
        </div>
    </div>
    <!-- /.navbar-container -->
</div>
<!-- End Header -->

<div class="main-container ace-save-state" id="main-container">

    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <!-- Begin menu -->
    <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>
        <div class="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>

                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>

                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>

                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>
            <div class="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div>
        <ul class="nav nav-list">
            <li>
                <a href="<c:url value='/admin/accounts'/>">
                    <i class="menu-icon fa fa-user"></i>
                    <span class="menu-text"> Accounts </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li>
                <a href="<c:url value='/admin/products'/>">
                    <i class="menu-icon fa fa-shopping-cart"></i>
                    <span class="menu-text"> Products </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li>
                <a href="<c:url value='/admin/categories'/>">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Categories </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li>
                <a href="<c:url value='/admin/orders'/>">
                    <i class="menu-icon fa fa-file-text"></i>
                    <span class="menu-text"> Orders </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li>
                <a href="<c:url value='/admin/order-details'/>">
                    <i class="menu-icon fa fa-info-circle"></i>
                    <span class="menu-text"> Order Details </span>
                </a>
                <b class="arrow"></b>
            </li>
        </ul>

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
               data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'collapsed')
            } catch (e) {
            }
        </script>
    </div>
    <!-- End menu -->


    <!-- Begin body -->
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="/admin/home">Trang chủ</a>
                    </li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row" >
                    <div class="col-xs-12">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Create User</h1>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-md-6 mx-auto">
                                            <form action="<c:url value='/admin/user/save'/>" method="post">
                                                <div class="form-group">
                                                    <label for="username">Username</label>
                                                    <input type="text" id="username" name="username" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="password">Password</label>
                                                    <input type="password" id="password" name="password" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="email">Email</label>
                                                    <input type="email" id="email" name="email" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="fullName">Full Name</label>
                                                    <input type="text" id="fullName" name="fullName" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label for="phoneNumber">Phone Number</label>
                                                    <input type="text" id="phoneNumber" name="phoneNumber" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label for="address">Address</label>
                                                    <textarea id="address" name="address" class="form-control"></textarea>
                                                </div>
                                                <div class="form-group">
                                                    <label for="role">Role</label>
                                                    <select id="role" name="role" class="form-control">
                                                        <option value="Admin">Admin</option>
                                                        <option value="User">User</option>
                                                    </select>
                                                </div>
                                                <div class="form-group mt-3">
                                                    <button type="submit" class="btn btn-primary">Save</button>
                                                    <a href="<c:url value='/admin/user/show'/>" class="btn btn-secondary">Cancel</a>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- /.main-content -->

    <!-- End body -->

    <!-- Begin footer -->
    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Spring Boot</span>
						</span>
            </div>
        </div>
    </div>
    <!-- end footer -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>

</div>

<script src="<c:url value='/template/admin/js/global_javascript.js' />"></script>
<script src="<c:url value='/template/admin/js/ace-extra.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery-ui.custom.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery.easypiechart.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery.sparkline.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery.flot.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery.flot.pie.min.js' />"></script>
<script src="<c:url value='/template/admin/js/jquery.flot.resize.min.js' />"></script>
<script src="<c:url value='/template/admin/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/template/admin/js/ace-elements.min.js' />"></script>
<script src="<c:url value='/template/admin/js/ace.min.js' />"></script>
</body>
</html>