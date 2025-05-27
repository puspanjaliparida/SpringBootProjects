<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color:blue;text-align:center"><sp:message code="home.title"/></h1>
<br><br>
 <a href="register"><h2 style="color:red;text-align:center"><sp:message code="home.link"/></h2></a>
 <br><br>
 <h1 style="text-align: center;">Current Active Locale Is::${pageContext.response.locale}</h1>
 <fmt:setLocale value="${pageContext.response.locale}"/>
 
 <center>
 <jsp:useBean id="dt" class="java.util.Date"/>
 <fmt:formatDate var="fdt" value="${dt}" type="date" dateStyle="SHORT" />
 <b>formatted date::${fdt}</b><br>
 
 <fmt:formatDate var="ftime" value="${dt}" type="time" dateStyle="FULL" /><br>
 <b>formatted date::${ftime}</b>
 
 <fmt:formatNumber var="fnumber" value="1000000" type="number" /><br>
 <b>formatted date::${fnumber}</b>
 
 <fmt:formatNumber var="fcurrency" value="1000000" type="currency" /><br>
 <b>formatted date::${fcurrency}</b>
 
 <fmt:formatNumber var="fpercentage" value="0.211" type="PERCENT" /><br>
 <b>formatted date::${fpercentage}</b>
 </center>
 <p align="center">
     <a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;
     <a href="?lang=de_DE">German</a> &nbsp;&nbsp;&nbsp;
     <a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;
     <a href="?lang=en_US">English</a> 
 </p>