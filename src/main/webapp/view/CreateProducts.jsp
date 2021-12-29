<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<form method="post" action="/create">
    <table>
        <tr>
            <th><label><input type="text" placeholder="Enter a name" name="addName"/></label></th>
            <th><label><input type="text" placeholder="Enter a price" name="addPrice"/></label></th>
            <th><label><input type="text" placeholder="Enter a image" name="addImage"/></label></th>
        </tr>
    </table>
    <button type="submit">Submit</button>
</form>
</body>
</html>
