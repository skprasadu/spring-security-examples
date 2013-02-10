<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
        <title>myCalendar: <c:out value="${pageTitle}"/> </title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />
        <c:url var="cssUrl" value="/resources/css/bootstrap.css"/>
        <link href="${cssUrl}" rel="stylesheet"/>
        <style>
          body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
          }
        </style>

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
      <div id="nav-bar" class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <c:url var="welcomeUrl" value="/" />
                <a class="brand" href="${welcomeUrl}">myCalendar</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li><a id="navWelcomeLink" href="${welcomeUrl}">Welcome</a></li>
                        <c:url var="eventsUrl" value="/events/" />
                        <sec:authorize url="${eventsUrl}">
                            <li><a id="navEventsLink" href="${eventsUrl}">All Events</a></li>
                        </sec:authorize>
                        <sec:authorize access="authenticated">
                            <c:url var="myEventsUrl" value="/events/my" />
                            <li><a id="navMyEventsLink" href="${myEventsUrl}">My Events</a></li>
                        </sec:authorize>
                        <c:url var="createEventUrl" value="/events/form" />
                        <li><a id="navCreateEventLink" href="${createEventUrl}">Create Event</a></li>
                        <c:url var="h2ConsoleUrl" value="/admin/h2" />
                        <li><a id="navH2Link" href="${h2ConsoleUrl}">H2</a></li>
                    </ul>
                </div>
                <div id="nav-account" class="nav-collapse pull-right">
                    <ul class="nav">
                        <sec:authorize access="authenticated" var="authenticated"/>
                        <c:choose>
                            <c:when test="${authenticated}">
                                <li id="greeting"><div>Welcome <sec:authentication property="principal.name" /></div></li>
                                <c:url var="logoutUrl" value="/logout"/>
                                <li><a id="navLogoutLink" href="${logoutUrl}">Logout</a></li>
                            </c:when>
                            <c:otherwise>
                                <c:url var="signupUrl" value="/signup/form"/>
                                <li><a id="navSignupLink" href="${signupUrl}">Signup</a></li>
                                <c:url var="loginUrl" value="/login/form"/>
                                <li><a id="navLoginLink" href="${loginUrl}">Login</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>

    </div>

    <div class="container">
        <c:if test="${message != null}">
            <div class="alert alert-success" id="message"><c:out value="${message}"/></div>
        </c:if>
        <h1 id="title"><c:out value="${pageTitle}"/></h1>
