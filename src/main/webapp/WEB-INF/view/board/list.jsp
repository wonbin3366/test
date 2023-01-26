<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <div class="box">
            <div class="a">
                <h1>게시글 목록 페이지</h1>
            </div>
        </div>
        <hr />
        <div class="c">
            <a href="/info">회원정보</a>
            <a href="/logout">로그아웃</a>
        </div>
        <div class="d">
            <table border="1">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성일</th>
                </tr>
                <c:forEach items="${boardList}" var="board">
                    <tr>
                        <td>${board.id}</td>
                        <td><a href="/list/${board.id}">${board.title}</a></td>
                        <td>${board.createdAt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%@ include file="../layout/footer.jsp" %>