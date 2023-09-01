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
    <h2>상점 목록</h2>

    <form name="formSearch" id="formSearch" action="/storeDetail" method="post">
        <input type="hidden" id="roleuser" name="roleuser" value=${roleuser} />
        <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="매장명" id="schStrName" name="schStrName" >
                <button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
        </div>
    </form>



    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">매장명</th>
                <th scope="col">상점위치</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="st" items="${list}">
                <tr>
                    <td><c:out value="${st.id}"/></td>
                    <td><a href='/storeDetail/id=${st.id}&roleuser=${roleuser}'><c:out value="${st.name}"/></a></td>
                    <td><c:out value="${st.place}"/></td>

                </tr>
            </c:forEach>
    </table>

</div>

</body>
</html>
