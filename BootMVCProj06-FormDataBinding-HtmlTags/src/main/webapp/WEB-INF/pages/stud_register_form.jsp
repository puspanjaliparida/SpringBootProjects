<%@ page isELIgnored="false"%>

<h1 style="color:red;text-align:center">Student Registration Page</h1>

<form action="register" method="POST">
    <table bgcolor="yellow" align="center">
       <tr>
           <td>Student Number::</td>
           <td><input type="text" name="sno"></td>
       </tr>
       <tr>
           <td>Student Name::</td>
           <td><input type="text" name="sname"></td>
       </tr>
       <tr>
           <td>Student Address::</td>
           <td><input type="text" name="sadd"></td>
       </tr>
       <tr>
           <td>Student Avg::</td>
           <td><input type="text" name="avg"></td>
       </tr>
       <tr>
           <td colspan="2"><input type="submit" value="register student"></td>
       </tr>
    </table>
</form>