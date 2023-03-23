<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-03-10
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register user</title>
</head>
<body>
<script>
    function validateForm() {
        // Get the form elements
        var username = document.forms["myForm"]["username"].value;
        var password = document.forms["myForm"]["password"].value;
        var email = document.forms["myForm"]["email"].value;
        var birthdate = document.forms["myForm"]["birthdate"].value;

        // Validate the username
        if (username == "") {
            alert("Username is required");
            return false;
        }

        // Validate the password
        if (password == "") {
            alert("Password is required");
            return false;
        } else if (password.length < 8) {
            alert("Password must be at least 8 characters long");
            return false;
        }

        // Validate the email
        var emailRegex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
        if (email == "") {
            alert("Email is required");
            return false;
        } else if (!emailRegex.test(email)) {
            alert("Invalid email address");
            return false;
        }

        // Validate the birthdate
        var birthdateRegex = /^\d{4}-\d{2}-\d{2}$/;
        if (birthdate == "") {
            alert("Birthdate is required");
            return false;
        } else if (!birthdateRegex.test(birthdate)) {
            alert("Birthdate must be in the yyyy-dd-mm format");
            return false;
        }

        // If all validation passes, return true
        return true;
    }
</script>

<form method="post" name="myForm" action="register" onsubmit="return validateForm()">
    <label>Username:</label><input type="text" name="username"/><br>
    Password:<input type="password" name="password"/><br>
    Email:<input type="text" name="email"/><br>
    <div class="radio-group">
        <input type="radio" id="male" name="gender" value="Male">
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female">
        <label for="female">Female</label>
    </div>
    Birthday:<input type="text" name="birthdate"/><br>
    <input type="submit" value="Login"/><br>


</form>
<style>
    /* Reset default browser styles */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: "Open Sans", sans-serif; /* 设置字体 */

    }
    label{
        font-family: "Open Sans", sans-serif; /* 设置字体 */

    }
    .radio-group {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }

    .radio-group input[type="radio"] {
        display: none;
    }

    .radio-group label {
        display: inline-block;
        font-size: 16px;
        color: #444;
        cursor: pointer;
        margin-right: 20px;
    }

    .radio-group label:before {
        content: "";
        display: inline-block;
        width: 20px;
        height: 20px;
        border-radius: 50%;
        border: 2px solid #ccc;
        margin-right: 10px;
        position: relative;
        top: 4px;
    }

    .radio-group input[type="radio"]:checked + label:before {
        border-color: #4CAF50;
    }

    .radio-group label:after {
        content: "";
        display: inline-block;
        width: 8px;
        height: 8px;
        border-radius: 50%;
        background-color: #4CAF50;
        position: absolute;
        top: 9px;
        left: 11px;
        transform: scale(0);
        transition: all 0.3s ease-in-out;
    }

    .radio-group input[type="radio"]:checked + label:after {
        transform: scale(1);
    }


    /* Set a nice background color */
    body {
        background-color: #F2F2F2;
    }

    /* Style the form container */
    form {
        margin: 50px auto;
        padding: 20px;
        width: 400px;
        background-color: #FFFFFF;
        border-radius: 5px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.2);
    }

    /* Style the form inputs */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    /* Style the radio buttons */
    input[type=radio] {
        margin: 8px 4px 8px 0;
    }

    /* Style the submit button */
    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    /* Add some hover effects */
    input[type=submit]:hover {
        background-color: #3e8e41;
    }
</style>
</body>
</html>
