<%--
  Created by IntelliJ IDEA.
  User: Taban
  Date: 2021-08-12
  Time: 5:51 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<h1>Add</h1>

<div class="container">


    <form method="POST">
        <div class="form-group">
            <label for="ccode">Customer Number:</label>
            <input type="text" name="catcode" class="form-control" id="ccode" value="${id}">
        </div>
        <div class="form-group">
            <label for="cdesc">Customer Name:</label>
            <input type="text" name="catdesc" class="form-control" id="cdesc" value="${name}">
        </div>
        <div class="form-group">
            <label for="cdesc1">Customer Deposit:</label>
            <input type="text" name="catdesc1" class="form-control" id="cdesc1" value="${deposit}">
        </div>
        <div class="form-group">
            <label for="cdesc2">Number of years:</label>
            <input type="text" name="catdesc2" class="form-control" id="cdesc2" value="${years}">
        </div>
       <%-- <div class="form-group">
            <label for="cdesc3">Saving type:</label>
            <input type="text" name="catdesc3" class="form-control" id="cdesc3" value="${savingType}">
        </div>--%>
        <div class ="form-group">
            <label for="cdesc3">Saving type:</label>
            <select name="cdesc3" , id ="cdesc3">
                    <option value="Regular">Regular</option>
                    <option value="Credit">Credit</option>
                    <option value="Card">Card</option>
            </select>
        </div>

        <input class="btn btn-success" type="submit" value="Submit" />


    </form>



</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>

