<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test upload</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
  <input type="file" name="file"/>
  <input type="submit"/>
</form>

</body>
</html>
