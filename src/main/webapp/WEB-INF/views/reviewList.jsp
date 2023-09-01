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
    <h2>리뷰 리스트</h2>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">작성자ID</th>
                <th scope="col">제목</th>
                <th scope="col">가게명</th>
                <th scope="col">별점</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rv" items="${rvList}">
                <tr>
                    <td><c:out value="${rv.reviewId}"/></td>
                    <td><c:out value="${rv.userid}"/></td>
                    <td>
                        <a href='/reviewDetail/id=${rv.reviewId}'>
                            <c:out value="${rv.title}"/>
                        </a>
                    </td>
                    <td><c:out value="${rv.storeName}"/></td>
                    <td><c:out value="${rv.star}"/></td>
                </tr>
            </c:forEach>
    </table>

</div>

</body>
</html>
