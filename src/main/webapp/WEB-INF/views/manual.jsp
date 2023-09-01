<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Home</title>


</head>
<body>

<h1 style="display: none;">
        ${seq}
</h1>



<div class="container">
    <!--

    <p>
        ${member.userid}
    </p>

    <p>
        ${member.roleuser}
    </p>
    -->

    <c:if test="${member.roleuser eq 'manager'}">
        <h3>매장관리자 메뉴</h3>
        <br/>
        <p> <a href="/store" class="route-link">매장등록</a></p>
        <p> <a href="/storeList/roleuser=manager&sort=" class="route-link">매장리스트</a></p>


        <p> <a href="/frMngBkList/${seq}" class="route-link">예약정보리스트</a></p>
        <p> <a href="/frMngBkConfirmList/${seq}" class="route-link">매장도착정보리스트</a></p>

        <p> <a href="/reviewList" class="route-link">리뷰리스트</a></p>
    </c:if>

    <c:if test="${member.roleuser eq 'client'}">
        <h3>매장이용자 메뉴</h3>
        <br/>
        <p> <a href="/storeList/roleuser=client&sort=" class="route-link">매장리스트(예약)</a></p>
        <p> <a href="/reviewList" class="route-link">리뷰리스트(리뷰)</a></p>
    </c:if>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>