<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.suoluomei.com/common/js/jquery-2.1.4.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>

    <title>西华大学 新闻发布系统 </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/production/index" class="site_title"><i class="fa fa-paw"></i> <span>新闻发布系统</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile">
                    <div class="profile_pic">
                        <img src="${pageContext.request.contextPath}/production/images/imges.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>欢迎,</span>
                        <h2>${sessionScope.user.username}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>主菜单</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> 首页 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/production/index">控制台</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> 新闻管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <c:if test="${user.usertype eq 0}">
                                    <li><a href="/newsDetail/toNewsForm">新闻发布</a></li>
                                    </c:if>
                                    <li><a href="/newsDetail/findNewsList">新闻列表</a></li>
                                </ul>
                            </li>

                            <c:if test="${user.usertype eq 0}">
                            <li><a><i class="fa fa-edit"></i> 主题管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/category/toCategoryForm">主题新增</a></li>
                                    <li><a href="/category/findCategoryList">主题列表</a></li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-edit"></i> 评论管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/comment/findCommentList">评论列表</a></li>
                                </ul>
                            </li>
                            <li>
                                    <a><i class="fa fa-edit"></i> 用户管理 <span class="fa fa-chevron-down"></span></a>

                                <ul class="nav child_menu">
                                    <li><a href="/production/toUserForm">用户新增</a></li>
                                    <li><a href="/production/findUserList">用户列表</a></li>
                                </ul>
                                </c:if>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/production/images/imges.jpg" alt="">
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">

                                <li><a href="/production/logout"><i class="fa fa-sign-out pull-right"></i> 注销</a></li>
                            </ul>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                <li>
                                    <a>
                                        <span class="image"><img src="${pageContext.request.contextPath}/production/images/imges.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>${sessionScope.user.username}</span>
                          <span class="time">99999 mins ago</span>
                        </span>
                                        <span class="message">
                          大家笑一笑就好...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="${pageContext.request.contextPath}/production/images/imges.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>${sessionScope.user.username}</span>
                          <span class="time">99999 mins ago</span>
                        </span>
                                        <span class="message">
                          大家笑一笑就好...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="${pageContext.request.contextPath}/production/images/imges.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>${sessionScope.user.username}</span>
                          <span class="time">99999 mins ago</span>
                        </span>
                                        <span class="message">
                          大家笑一笑就好...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="${pageContext.request.contextPath}/production/images/imges.jpg" alt="Profile Image" /></span>
                                        <span>
                          <span>${sessionScope.user.username}</span>
                          <span class="time">99999 mins ago</span>
                        </span>
                                        <span class="message">
                          大家笑一笑就好...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="text-center">
                                        <a>
<%--                                            <strong>点击查看更多消息</strong>--%>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
