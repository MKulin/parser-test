<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Parser-test</title>
</head>
<body>
    <script>
        function waiting() {
            document.getElementById("waiting").removeAttribute("hidden");
        }
    </script>
    <table border="1" width="90%" align="center">
        <tr>
            <td align="center">
                <h4>Анализируемая страница</h4>
            </td>
        </tr>
        <tr>
            <td class="label" align="center">
                <form id="analyzing" action="home" method="get">
                    <% String s = (String)request.getAttribute("exception");
                    if (s == null) s = "";%>
                    <label for="inputField" style="color: red"><%=s%></label><br>
                    <input id="inputField" type="text" name="url" size="100%">
                    <br><input type="submit" value="Анализировать" onclick="waiting()">
                </form>
            </td>
        </tr>
    </table>
        <table id="waiting" hidden="hidden" width="50%" align="center" style="padding-top: 20px; padding-bottom: 20px; background-color: cadetblue">
            <tr>
                <td>
                    <img src="${pageContext.request.contextPath}/jsp/img/watches.png" alt="watches" border="0" width="100px" height="100px">
                </td>
                <td>
                    <h5>Идет обработка...</h5>
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
            <td width="5%">№п/п</td>
            <td>Имя ссылки</td>
            <td width="50%">Адрес ссылки</td>
        </tr>
        <c:forEach items="${requestScope.list}" var="tr">
            <tr>
                <td>${tr.number}</td>
                <td>${tr.name}</td>
                <td><a href="javascript:void(0)" onclick='document.forms["analyzing"].elements["inputField"].value ="${tr.href}"'>${tr.href}</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td align="center">
                <form method="get" action="home">
                    <input type="submit" value="Очистить">
                </form>
            </td>
        </tr>
    </table>

    <div class="result"></div>
</body>
</html>
