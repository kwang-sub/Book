<%--
  Created by IntelliJ IDEA.
  User: kwang
  Date: 2022-06-09
  Time: 오후 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form action="step3" method="post">
        <p>
            <label>이메일:<br>
                <input type="text" name="email" id="email" value="${formData.email}"/>
            </label>
        </p>
        <p>
            <label>이름:<br>
                <input type="text" name="name" id="name" value="${formData.name}"/>
            </label>
        </p>
        <p>
            <label>비밀번호:<br>
                <input type="password" name="password" id="password"/>
            </label>
        </p>
        <p>
            <label>비밀번호 확인:<br>
                <input type="password" name="confirmPassword" id="confirmPassword"/>
            </label>
        </p>
        <p>
           <input type="submit" value="가입 완료">
        </p>
    </form>
</body>
</html>
