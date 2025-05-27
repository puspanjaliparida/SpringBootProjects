<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color:red;text-align:center">Employee Report Page(Pagination)</h1>
<c:choose>
        <c:when test="${!empty empsData}">
           <table border="1" align="center" bgcolor="yellow">
               <tr bgcolor="green">
                   <th>EmpNo</th>
                   <th>Ename</th>
                   <th>Job</th>
                   <th>Sal</th>
                   <th>Deptno</th>
               </tr>
            <c:forEach var="emp" items="${empsData.getContent()}">
                <tr>
                    <td> ${emp.empno} </td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.deptno}</td>
                </tr>
           </c:forEach>
           </table>
           <center><b>Page no :: ${empsData.getNumber()+1} / ${empsData.getTotalPages()}</b></center><br>
           <center>
               <c:if test="${!empsData.isFirst()}">
                   <a href="emp_report?page=0">first</a>
               </c:if>
               &nbsp; &nbsp;&nbsp;
               <c:if test="${!empsData.isLast()}">
                   <a href="emp_report?page=${empsData.getNumber()+1}">next</a>
               </c:if>
                  <c:forEach var="i" begin="1" end="${empsData.getTotalPages()}" step="1">
                         [<a href="emp_report?page=${i-1}">${i} </a> ] &nbsp; &nbsp;
                  </c:forEach>
                  &nbsp; &nbsp;&nbsp;
                  <c:if test="${!empsData.isFirst()}">
                   <a href="emp_report?page=${empsData.getNumber()-1}">previous</a>
               </c:if>
                <c:if test="${!empsData.isLast()}">
                   <a href="emp_report?page=${empsData.getTotalPages()-1}">last</a>
               </c:if>
           </center>
    </c:when>
    <c:otherwise>
         <h1 style="color:red;text-align:center">Record Not Found</h1>
    </c:otherwise>
</c:choose>

<br>
<h1 style="text-align:center"><a href="./">
     <img src="images/home.png" width="100" height="100"/>Home</a>
</h1>



