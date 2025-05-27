<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color:green; text-align:center">Result page(result.jsp)</h1>

<b>Model Attribute Values Are</b>
         <b>List Of Model Class Objects:: ${custList}</b><br>
         <c:if test="${!empty custList}">
              <b>List Of Model Class Objects:: ${custList}</b>
         </c:if> 
         
         <br>
         <c:choose>
              <c:when test="${!empty custList}">
                    <table border="1" bgcolor="yellow"  align="center">
                         <tr>
                            <th>Cno</th> <th>Cname</th> <th>Caddrs</th> <th>BillAmt</th>
                         </tr>
                         <c:forEach var="cust" items="${custList}">
                            <tr>
                               <td>${cust.cno}</td>
                               <td>${cust.cname}</td>
                               <td>${cust.caddrs}</td>
                               <td>${cust.billAmt}</td>
                            </tr>
                         </c:forEach>
                    </table>
              </c:when>
              <c:otherwise>
                   <h3 style="color:red;text-align:center">No Records Are Found</h3>
              </c:otherwise>
         </c:choose>
<%--<br><br>
<b>Model Attribute Values Are</b>
   <b>Model Class Object Data :: ${custData}</b>
   <br>
   <c:if test="${!empty custData}">
          <b>Model Class Object Data:: ${custData}</b>
   </c:if>
   <br>
   <c:if test="${!empty custData}">
          <b>Model Class Object Data:: ${custData.cno} &nbsp; ${custData.cname} &nbsp; ${custData.caddrs} &nbsp; ${custData.billAmt}</b>
   </c:if>  --%>
   
<%-- <i>Nick names :: </i><br>
      <c:if test="${! empty nickNames}">
            <c:forEach var="name" items="${nickNames}">
                  <br> ${name} <br>
            </c:forEach>
      </c:if>

     <br><br>
     
     <i>Friends :: </i><br>
      <c:if test="${! empty friends}">
            <c:forEach var="fr" items="${friends}">
                  <br> ${fr} <br>
            </c:forEach>
      </c:if>
      
      <br><br>
      
      <i>PhoneNumbers :: </i><br>
      <c:if test="${! empty phones}">
            <c:forEach var="ph" items="${phones}">
                  <br> ${ph} <br>
            </c:forEach>
      </c:if>
      
      <br><br>
      
      <i>IdDetails :: </i><br>
      <c:if test="${! empty idDetails}">
            <c:forEach var="id" items="${idDetails}">
                  <br> ${id.key} &nbsp; &nbsp; ${id.value} <br>
            </c:forEach>
      </c:if>
      
      <br><br>--%>
<%--<%@ page isELIgnored="false"  import="java.util.*"%>

<h1 style="color:green; text-align:center">Result page(result.jsp)</h1>

<br><br>
<b>Model Attribute Values Are</b>

<i>nick names::<%=Arrays.toString(((String[])request.getAttribute("nickNames"))) %></i><br>
<i> Friends:: ${friends}</i> <br>
<i> Phones:: ${phones}</i> <br>
<i> IdDetails:: ${idDetails}</i> <br> --%>