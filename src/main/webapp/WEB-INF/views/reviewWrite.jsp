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


    <style>
        #myform fieldset{
            display: inline-block;
            direction: rtl;
            border:0;
        }
        #myform fieldset legend{
            text-align: right;
        }
        #myform input[type=radio]{
            display: none;
        }
        #myform label{
            font-size: 3em;
            color: transparent;
            text-shadow: 0 0 0 #f0f0f0;
        }
        #myform label:hover{
            text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
        }
        #myform label:hover ~ label{
            text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
        }
        #myform input[type=radio]:checked ~ label{
            text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
        }
    </style>
    <title>Title</title>
</head>
<%
    String userSeq = null;
    String userid = null;
    Cookie[] cs = request.getCookies();

    for(Cookie c : cs){
        if(c.getName().equals("seq")){
            userSeq =  c.getValue();
        }
        if(c.getName().equals("userid")){
            userid =  c.getValue();
        }
    }
%>
<body>
<div class="container">
    <h2>리뷰 쓰기</h2>
    <form name="myform" id="myform" action="/review"  method="post">
        <div class="mb-3 row">
            <label for="userId" class="col-sm-2 col-form-label" style="font-size: 1em;color: black;">작성자</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="userid" id="userid" value="<% out.println(userid); %>" readonly>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="storeName" class="col-sm-2 col-form-label" style="font-size: 1em;color: black;">방문상점명</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="storeName" id="storeName" value="${storeName}" readonly>
            </div>
        </div>

        <fieldset>
            <span class="text-bold">별점을 선택해주세요</span>
            <input type="radio" name="star" value="5" id="rate1"><label
                for="rate1">★</label>
            <input type="radio" name="star" value="4" id="rate2"><label
                for="rate2">★</label>
            <input type="radio" name="star" value="3" id="rate3"><label
                for="rate3">★</label>
            <input type="radio" name="star" value="2" id="rate4"><label
                for="rate4">★</label>
            <input type="radio" name="star" value="1" id="rate5"><label
                for="rate5">★</label>
        </fieldset>
        <div class="mb-3">
            <input type="text" class="form-control" name="title" id="title" placeholder="제목">
        </div>
        <div class="mb-3">
            <textarea class="col-auto form-control" type="text" id="article" name="article"
                      placeholder="리뷰를 남겨주세요!"></textarea>
        </div>

        <input type="hidden" class="form-control" name="storeId" id="storeId" value="${bkId}">
        <input type="hidden" class="form-control" name="visitConfirm" id="visitConfirm" value="${bkConfirmId}">


        <button type="submit" class="btn btn-outline-primary">저장</button>
    </form>
</div>

</body>
</html>
