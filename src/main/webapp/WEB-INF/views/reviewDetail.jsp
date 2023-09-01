<%--
  Created by IntelliJ IDEA.
  User: hye
  Date: 2023-08-21
  Time: 오후 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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
    <h2>리뷰 상세</h2>
    <table class="table table-bordered">
        <tr>
            <th scope="col" style="width:10%;">작성자</th>
            <td>${rv.userid}</td>
        </tr>

        <tr>
            <th scope="col" style="width:10%;">상점명</th>
            <td>${rv.storeName}</td>
        </tr>

        <tr>
            <th scope="col" style="width:10%;">별점</th>
            <td>${rv.star}</td>
        </tr>

        <tr>
            <th scope="col" style="width:10%;">제목</th>
            <td>${rv.title}</td>
        </tr>

        <tr>
            <th scope="col" style="width:10%;">내용</th>
            <td>${rv.article}</td>
        </tr>

    </table>

    <div style="margin-top: 10px;">
        <div>
            <button type="button" class="btn btn-secondary btn-sm" onclick="location.href='/reviewList'">
                리뷰목록
            </button>

        </div>
    </div>


</div>

</body>
</html>
