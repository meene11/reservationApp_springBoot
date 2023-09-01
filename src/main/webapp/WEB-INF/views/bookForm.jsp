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

    <%
        String clienId = null;
        Cookie[] cs = request.getCookies();

        for(Cookie c : cs){
            if(c.getName().equals("userid")){
                clienId =  c.getValue();
            }
        }
    %>

<div class="container">
<!--
    <h1><% out.println( clienId); %></h1>
 -->
    <h2>예약하기</h2>
    <form name="form" id="form1" action="/book"  method="post">
        <div class="mb-3">
            <label for="userid" class="form-label">예약자 ID</label>
            <input type="text" class="form-control" name="userid" id="userid" placeholder="USER ID" value="<% out.println( clienId); %>"  readonly>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">예약자 전화번호</label>
            <input type="text" class="form-control" name="phone" id="phone" placeholder="PHONE NUMBER">
        </div>

        <div class="mb-3">
            <label for="bookDate" class="form-label">예약시간</label>
            <input type="text" class="form-control" name="bookDate" id="bookDate" placeholder="YYYY-MM-DD HH:DD">
        </div>

        <div class="mb-3">
            <label for="storeName" class="form-label">매장명</label>
            <input type="text" class="form-control" name="storeName" id="storeName" placeholder="Store" value="${storeName}"  readonly>
        </div>


            <input type="hidden" class="form-control" name="storeId" id="storeId" value="${id}">

            <input type="hidden" class="form-control" name="mngId" id="mngId" value="${storeSeq}">

        <button type="submit" class="btn btn-outline-primary">예약</button>
    </form>
</div>

</body>
</html>
