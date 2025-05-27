<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Student Registration Page</h1>

<frm:form action="register" method="POST"  modelAttribute="stud">
    <table bgcolor="yellow" align="center">
       <tr>
           <td>Student Number::</td>
           <td><frm:input path="sno" title="Enter Student No"/></td>
       </tr>
       <tr>
           <td>Student Name::</td>
           <td><frm:input path="sname"/></td>
       </tr>
       <tr>
           <td>Student Address::</td>
           <td><frm:input path="sadd"/></td>
       </tr>
       <tr>
           <td>Student Avg::</td>
           <td><frm:input path="avg"/></td>
       </tr>
       <tr>
           <td>
                 <input type="submit" value="register student"/>
                 <input type="reset" value="cancel"/>
           </td>
       </tr>
    </table>
</frm:form>