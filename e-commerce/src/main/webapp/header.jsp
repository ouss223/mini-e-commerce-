<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
</head>

<div  class="d-flex justify-content-between px-4 align-items-center" style="height:75px ; border-bottom: 2px solid lightgray ; background-color : white">
    <div class="logo">
        <h2 class="text-primary fs-3 text-bolder" >E-commerce</h2>
    </div>

    <div class="user-actions">
        ${sessionScope.user != null ?
            '<form action="logout" method="get">  <button class="btn border border-2 text-secondary fw-bold " type="submit">Logout</button> </form>' :
            '<a class="btn border border-2 text-secondary fw-bold" href="login">Login</a>'
        }
    </div>
</div>
