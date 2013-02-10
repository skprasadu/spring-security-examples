<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" value="All Events" scope="request"/>
<jsp:include page="../includes/header.jsp"/>

<p>This shows all events for all users. Once security is applied it will only be viewable to administrators.</p>
<c:url var="createUrl" value="/events/form"/>
<div id="create" class="pull-right"><a href="${createUrl}">Create Event</a></div>
<table class="table table-bordered table-striped table-condensed">
    <thead>
        <tr>
            <th>Date/Time</th>
            <th>Owner</th>
            <th>Attendee</th>
            <th>Summary</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${empty events}">
            <tr>
                <td colspan="2" class="msg">No events.</td>
            </tr>
        </c:if>
         <c:forEach items="${events}" var="event">
            <tr>
                <fmt:formatDate value="${event.when.time}" type="both" pattern="yyyy-MM-dd HH:mm" var="when"/>
                <td><c:out value="${when}"/></td>
                <td><c:out value="${event.owner.name}" /></td>
                <td><c:out value="${event.attendee.name}" /></td>
                <c:url var="eventUrl" value="${event.id}"/>
                <td><a href="${eventUrl}"><c:out value="${event.summary}" /></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="../includes/footer.jsp"/>