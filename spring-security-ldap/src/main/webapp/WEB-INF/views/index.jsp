<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Welcome to myCalendar!" scope="request"/>
<jsp:include page="./includes/header.jsp"/>
<p>Below you can find some highlights about myCalendar. Each sample will have a slightly different summary depending on what has been done.</p>
<h2>Chapter 6 - Remember Me</h2>
<ul>
 <li>This chapter discusses Spring Security's remember me feature. You may be interested in using a plugin like <a href="https://addons.mozilla.org/en-US/firefox/addon/firecookie/reviews/">Firecookie</a> for removing your JSESSIONID (to simulate closing the browser / session timing out).</li>
    <li><a id="eventsLink" href="events/">All Events</a> - shows all events for all users, but only allows administrators to access the page.</li>
    <li><a id="myEventsLink" href="events/my">My Events</a> - shows all events that the current user is owner or attendee.</li>
    <li><a id="createEventLink" href="events/form">Create Event</a> - will allow creating a new Event with current user as the owner.</li>
    <li><a id="logoutLink" href="logout">Logout</a> - allows the user to logout</li>
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
</ul>
<jsp:include page="./includes/footer.jsp"/>
