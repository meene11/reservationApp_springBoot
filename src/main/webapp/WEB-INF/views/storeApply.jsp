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
<%
    String userSeq = null;
    Cookie[] cs = request.getCookies();

    for(Cookie c : cs){
        if(c.getName().equals("seq")){
            userSeq =  c.getValue();
        }
    }
%>
<body>
<div class="container">
    <h2>상점 등록</h2>
    <form name="form" id="form1" action="/store"  method="post">
        <div class="mb-3">
            <label for="name" class="form-label">매장명</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="매장명">
        </div>
        <div class="mb-3">
            <label for="place" class="form-label">상점위치</label>
            <input type="text" class="form-control" name="place" id="place" placeholder="상점위치">
        </div>
        <div class="mb-3">
            <label for="detail" class="form-label">상점설명</label>
            <textarea class="form-control" name="detail" id="detail" rows="3"></textarea>
        </div>


        <input type="hidden" class="form-control" name="userSeq" id="userSeq" value="<% out.println(userSeq); %>">

        <button type="submit" class="btn btn-outline-primary">저장</button>
    </form>
</div>

</body>
</html>
