#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/inc-taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="inc/inc-meta.jsp"%>
<title>Bootstrap 101 Template</title>
<%@ include file="inc/inc-link.jsp"%>
</head>
<body>
  <h1>你好，世界！</h1>
  <h2>List of Users:</h2>
  <div>
    <c:if test="${symbol_dollar}{USERS != null }">
      <c:forEach items="${symbol_dollar}{USERS}" var="user">
        <p>${symbol_dollar}{user.userId}-${symbol_dollar}{user.userName}</p>
      </c:forEach>
    </c:if>
  </div>
  <%@ include file="inc/inc-script.jsp"%>
</body>
</html>