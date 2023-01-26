<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <div class="box">
            <div class="a">
                <h1>로그인 페이지</h1>
            </div>
        </div>

        <hr />

        <div class="c">
            <a href="/loginForm">로그인</a>
            <a href="/joinForm">회원가입</a>
        </div>

        <div class="d">
            <form action="/login" method="post">
                <table border="1">
                    <tr>
                        <th>유저네임</th>
                        <td><input type="text" name="username" placeholder="Enter username"
                                value="${cookie.remember.value}" required></td>
                    </tr>
                    <tr>
                        <th>패스워드</th>
                        <td><input type="password" name="password" placeholder="Enter password" required></td>
                    </tr>
                </table>
                <button type="submit">로그인</button>
            </form>
        </div>

        <%@ include file="../layout/footer.jsp" %>