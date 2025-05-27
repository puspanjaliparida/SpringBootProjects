<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<body style="background-color: beige">
     <h1 style="color:green;text-align:center;text-decoration: underline;">
           <i>Register Employee</i>
     </h1>

     <frm:form modelAttribute="emp">
         <table align="center" bgcolor="cyan">
             <tr>
                <td style="font-size: 20px"><i><b>Employee Name::</b></i></td>
                <td><frm:input path="ename"/></td>
             </tr>
    
             <tr>
                 <td style="font-size: 20px"><i><b>Employee Designation::</b></i></td>
                 <td><frm:input path="job"/></td>
             </tr>
    
             <tr>
                 <td style="font-size: 20px"><i><b>Employee Salary::</b></i></td>
                 <td><frm:input path="sal"/></td>
             </tr>
    
             <tr>
                 <td style="font-size: 20px"><i><b>Employee Deptno::</b></i></td>
                 <td><frm:input path="deptno"/></td>
             </tr>
    
            <tr>
                 <td align="center">
                     <input type="submit" value="Submit" style="color:black;background-color: white;font-style:italic;">
                 </td>
                 <td align="center">
                     <input type="reset" value="Cancel" style="color:red;background-color: white;font-style:italic;">
                </td>
            </tr>
        </table>
     </frm:form>
</body>