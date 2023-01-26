<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <div class="box">
            <div class="a">
                <h1>회원수정 페이지</h1>
            </div>
        </div>
        <hr />
        <div class="c">
            <a href="/info">회원정보</a>
            <a href="/logout">로그아웃</a>
        </div>

        <div class="d">
            <form action="/update" method="post">
                <table border="1">
                    <tr>
                        <th>유저네임</th>
                        <td><input type="text" value="${principal.username}"></td>
                    </tr>
                    <tr>
                        <th>패스워드</th>
                        <td><input type="password" name="password" placeholder="Enter password" required></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="email" name="email" placeholder="Enter email" required></td>
                    </tr>
                </table>
                <button type="submit">회원수정완료</button>
            </form>
        </div>

        <%@ include file="../layout/footer.jsp" %>