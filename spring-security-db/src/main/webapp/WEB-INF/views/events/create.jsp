<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Create Event" scope="request"/>
<jsp:include page="../includes/header.jsp"/>
<form:form action="./new" method="post" modelAttribute="createEventForm" cssClass="form-horizontal">
    <form:errors path="*" element="div" cssClass="alert alert-error"/>
    <fieldset>
        <legend>Event Information</legend>
        <div class="control-group">
            <label class="control-label" for="attendeeEmail">Attendee Email</label>
            <div class="controls">
                <form:input class="input-xlarge" path="attendeeEmail" id="attendeeEmail"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="when">Event Date/Time (yyyy-MM-dd HH:mm)</label>
            <div class="controls">
                <form:input class="input-xlarge" path="when" id="when"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="summary">Summary</label>
            <div class="controls">
                <form:input class="input-xlarge" path="summary" id="summary"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="description">Description</label>
            <div class="controls">
                <form:textarea class="input-xlarge" path="description" id="description" rows="5" cols="25"/>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input id="submit" type="submit" value="Create"/>
                <input id="auto" type="submit" name="auto" value="Auto Populate Form"/>
            </div>
        </div>
    </fieldset>
</form:form>
<jsp:include page="../includes/footer.jsp"/>