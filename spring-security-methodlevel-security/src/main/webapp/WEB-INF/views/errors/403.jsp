<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Access Denied" scope="request"/>
<jsp:include page="../includes/header.jsp"/>
<p>You are not allowed to access this page. Try logging in as admin1@example.com / admin1</p>
<jsp:include page="../includes/footer.jsp"/>