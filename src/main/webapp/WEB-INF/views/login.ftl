<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/login" method="post">
        <label>username</label>
        <input type="text" name="username">
        <br>
        <label>password</label>
        <input type="password" name="password">
        <br>
        <label>Remember me</label>
        <input type="checkbox" name="rememberMe">
        <br>
        <input type="submit">
        <br>
        <#if shiroLoginFailure?exists>
            ${shiroLoginFailure}
        </#if>
    </form>
</body>
</html>