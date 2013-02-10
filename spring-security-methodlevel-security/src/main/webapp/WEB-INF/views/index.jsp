<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Welcome to myCalendar!" scope="request"/>
<jsp:include page="./includes/header.jsp"/>
<p>Below you can find some highlights about myCalendar. Each sample will have a slightly different summary depending on what has been done.</p>
<h2>Chapter 10</h2>
<ul>
    <li>This chapter demonstrates fine grained access control</li>
    <li><a id="eventsLink" href="events/">All Events</a> - shows all events for all users, but only allows administrators to access the page.</li>
    <li><a id="myEventsLink" href="events/my">My Events</a> - shows all events for the current user's events.</li>
    <li><a id="myEventsUser0Link" href="events/my?userId=0">My Events (userId=0)</a> - shows all events that are associated to user1@example.com.</li>
    <li><a id="myEventsUser1Link" href="events/my?userId=1">My Events (userId=1)</a> - shows all events that are associated to admin1@exmple.com.</li>
    <li><a id="myEventsUser1Link" href="events/102">Lunch Event</a></li>
    <c:if test="${showCreateLink}">
	    <li><a id="createEventLink" href="events/form">Create Event</a> - Allows creating an Event with the current user.</li>
    </c:if>
    <li><a id="logoutLink" href="j_spring_security_logout">Logout</a> - we haven't discussed it yet, but you can logout using j_spring_security_logout. Later in in this chapter we will discuss how to customize logout and provide a logout link.</li>
    <c:if test="${showAdminLink}">
	    <li>
	        <a id="h2Link" href="admin/h2/">H2 Database Console</a> - Allows you to interact with the database using a web console. To use it:
	        <ul>
	            <li>Click the link above.</li>
	            <li>Ensure that Generic H2 (Embedded) is selected</li>
	            <li>Ensure that org.h2.Driver is the Driver Class</li>
	            <li>Enter <strong>jdbc:h2:mem:dataSource</strong> as the JDBC URL</li>
	            <li>Ensure that the username is sa</li>
	            <li>Ensure the password is left empty</li>
	            <li>Click Connect</li>
	        </ul>
	    </li>
    </c:if>
</ul>
<jsp:include page="./includes/footer.jsp"/>