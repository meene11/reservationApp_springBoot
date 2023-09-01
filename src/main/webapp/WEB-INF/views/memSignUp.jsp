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
    <h2>회원가입</h2>


    <form name="formMem" id="formMem" action="/member"  method="post">
        <div class="mb-3 row">
            <label for="userid" class="col-sm-2 col-form-label">ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="userid" name="userid">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="pwd" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="pwd" name="pwd">
            </div>
        </div>
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">Role</label>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="flexRadioDefault1" value="manager">
                    <label class="form-check-label" for="flexRadioDefault1">
                        매장관리자
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="flexRadioDefault2" checked value="client">
                    <label class="form-check-label" for="flexRadioDefault2">
                        매장고객
                    </label>
                </div>







            </div>

        </div>

        <div style="margin-top: 15px;" >
            <button type="submit" class="btn btn-primary btn-sm" style="width:100px;">
                저장
            </button>
        </div>

    </form>




</div>

</body>
</html>
