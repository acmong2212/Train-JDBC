<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Products</title>
</head>
<body>
<form action="/edit" method="post">
    <label><input name="id" value="${indexEdit}" hidden/></label>
    <table>
        <tr>
            <th><label><input type="text" placeholder="Enter a name" name="editName" value="${editProducts.name}"/></label></th>
            <th><label><input type="text" placeholder="Enter a price" name="editPrice" value="${editProducts.price}"/></label></th>
            <th><label><input type="text" placeholder="Enter a image" name="editImage" value="${editProducts.img}"/></label></th>
        </tr>
    </table>
    <button type="submit">Submit</button>
</form>
</body>
</html>
