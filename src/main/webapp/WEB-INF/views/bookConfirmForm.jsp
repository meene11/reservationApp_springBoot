<%--
  Created by IntelliJ IDEA.
  User: hye
  Date: 2023-08-21
  Time: 오후 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2>예약확인</h2>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">예약자ID</th>
            <th scope="col">예약자전화번호</th>
            <th scope="col">예약시간</th>
            <th scope="col">매장명</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${book.userid}</td>
            <td>${book.userPhone}</td>
            <td>${book.bookDate}</td>
            <td>${book.storeName}</td>
        </tr>

        </tbody>
    </table>

<!--
<h1>${book.uniqId}</h1>
<h1>매니저아이디 ${book.mngId}</h1>
-->
    <div class="card">
        <h5 class="card-header">예약확정하기</h5>
        <div class="card-body">
            <h5 class="card-title">${aftTemMin} 전까지!</h5>
            <p class="card-text">예약시간 10분전까지 방문 확정해주세요.</p>
            <div>
                <button type="button" class="btn btn-primary btn-lg"><a href='/bookVisit/uniqId=${book.uniqId}&mngId=${book.mngId}&aftTemMin=${aftTemMin}' style="color:#fff;">방문</a></button>

            </div>
        </div>
    </div>


</div>

</body>
</html>
