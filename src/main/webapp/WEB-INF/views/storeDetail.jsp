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
    <h2>상점 상세</h2>
    <table class="table table-bordered">
        <tr>
            <th scope="col" style="width:10%;">상점명</th>
            <td>${store.name}</td>
        </tr>

        <tr>
            <th scope="col" style="width:10%;">위치</th>
            <td>${store.place}</td>
        </tr>

        <tr>
            <th scope="col" style="width:10%;">설명</th>
            <td>${store.detail}</td>
        </tr>

    </table>

    <div style="margin-top: 10px;">
        <div>
            <c:if test="${roleuser eq 'client'}">
                <button type="button" class="btn btn-primary btn-sm" onclick="location.href='/book/storeName=${store.name}&storeId=${store.id}&storeSeq=${store.storeSeq}'">
                    예약
                </button>

                <button type="button" class="btn btn-secondary btn-sm" onclick="location.href='/storeList/${roleuser}'">
                    목록
                </button>
            </c:if>


            <c:if test="${roleuser ne 'client'}">
                <button type="button" class="btn btn-secondary btn-sm" onclick="location.href='/storeList'">
                    목록
                </button>
            </c:if>

        </div>
    </div>


</div>

</body>
</html>
