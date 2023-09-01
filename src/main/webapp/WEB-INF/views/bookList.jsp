<%--
  Created by IntelliJ IDEA.
  User: hye
  Date: 2023-08-21
  Time: 오후 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>예약정보목록</h2>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">예약자ID</th>
                <th scope="col">예약자전화번호</th>
                <th scope="col">예약시간</th>
                <th scope="col">매장명</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bk" items="${bkList}">
                <tr>
                    <td><c:out value="${bk.uniqId}"/></td>
                    <td><c:out value="${bk.userid}"/></td>
                    <td><c:out value="${bk.userPhone}"/></td>
                    <td><c:out value="${bk.bookDate}"/></td>
                    <td><c:out value="${bk.storeName}"/></td>
                </tr>
            </c:forEach>
    </table>

</div>

</body>
</html>
