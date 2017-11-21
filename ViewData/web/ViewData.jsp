<%-- 
    Document   : ViewData
    Created on : 04-Nov-2017, 08:56:30
    Author     : ngmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <td>Product Id</td>
                <td>Product Name</td>
                <td>Product Price</td>
                <td>Delete</td>
                <td>Update</td>
            </tr>
            <s:iterator var="p" value="items"> 
                <tr>
                    <td><s:property value="#p.id"/></td><br/>
                    <td><s:property value="#p.name"/></td><br/>
                    <td><s:property value="#p.price"/></td><br/>
                    <td><a href="delete=?id=<s:property value="#p.id"/>"  />DELETE</td>
                    <td><a href="update=?id=<s:property value="#p.id"/>"  />UPDATE</td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
