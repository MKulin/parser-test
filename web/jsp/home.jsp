<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Parser-test</title>
</head>
<body>
    <table border="1" width="90%" align="center">
        <tr>
            <td align="center">
            <h4>Анализируемая страница</h4>
            </td>
        </tr>
        <tr>
            <td class="label" align="center">
                <form action="home" method="get">
                    <input type="text" name="url" size="100%">
                    <br><input type="submit" value="Анализировать">
                </form>
            </td>
        </tr>
    </table>

    <table border="1" width="90%" align="center" style="padding-top: 20px">
        <tr>
            <td align="center">
                <h4>Обнаруженные ссылки</h4>
            </td>
        </tr>
    </table>
    <table border="1" width="90%" align="center">
        <tr align="center">
            <td>№п/п</td>
            <td>Имя ссылки</td>
            <td>Адрес ссылки</td>
        </tr>
        <c:forEach items="${requestScope.list}" var="href">
            <tr>
                <td></td>
                <td></td>
                <td>${href}</td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td align="center"><input type="reset" value="Очистить"></td>
        </tr>
    </table>

    <div class="result"></div>
</body>
</html>
