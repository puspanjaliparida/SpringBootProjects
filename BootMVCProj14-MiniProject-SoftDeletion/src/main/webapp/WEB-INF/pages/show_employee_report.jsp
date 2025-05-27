<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<body style="background-color: beige;">
    <c:choose>
        <c:when test="${!empty empsList}">
           <h1 style="color:orange;text-align:center;font-size: 40px">
                <img src="images/report.png" height="60px"/>
                <i>Employees Report</i>
           </h1>
           <table border="1" align="center" bgcolor="gray">
               <tr style="color:black">
                   <th style="font-size: 25px"><i>EmpNo</i></th>
                   <th style="font-size: 25px"><i>Ename</i></th>
                   <th style="font-size: 25px"><i>Job</i></th>
                   <th style="font-size: 25px"><i>Sal</i></th>
                   <th style="font-size: 25px"><i>Deptno</i></th>
               <tr>
            <c:forEach var="emp" items="${empsList}">
                <tr style="color:navy;">
                    <td style="font-size: 20px">
                          <i>
                              <b>${emp.empno}</b>
                          </i>
                    </td>
                    <td style="font-size: 20px">
                          <i> 
                              <b>${emp.ename}</b>
                          </i>
                    </td>
                    <td style="font-size: 20px">
                          <i>
                              <b>${emp.job}</b>
                          </i>
                    </td>
                    <td style="font-size: 20px">
                          <i>
                              <b>${emp.sal}</b>
                          </i>
                    </td>
                    <td style="font-size: 20px">
                          <i>
                              <b>${emp.deptno}</b>
                          </i>
                    </td>
                    <td>
                            <a href="emp_edit?no=${emp.empno}">
                                 <img src="images/edit.png" width="50px"  height="50px"/>
                            </a>
                            <a href="emp_delete?no=${emp.empno}" onclick="return confirm('Are U Sure That U Want To Delete Record?')">
                                 <img src="images/delete.png" width="50px"  height="50px"/>
                            </a>
                     </td>
                </tr>
           </c:forEach>
           </table>
    </c:when>
    <c:otherwise>
         <h1 style="color:red;text-align:center">Employees Not Found</h1>
    </c:otherwise>
</c:choose>

<h2 style="color:green;text-align:center">${resultMsg}</h2>

<center>
    <a href="emp_add" style="font-size: 30px">
         <img src="images/add.png" width="100px" height="100px" />
         <b><i>Add Employee</i></b>
    </a>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <a href="./" style="font-size: 30px">
        <img src="images/home.png" width="100px" height="100px" />
        <b><i>Home</i></b>
     </a>
</center>
</body>
