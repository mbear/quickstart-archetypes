<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/inc-taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<%@ include file="inc/inc-meta.jsp"%>
<%@ include file="inc/inc-link.jsp"%>
<SCRIPT type="text/javascript">
  $(document).ready(function() {
    $("body>[data-role='panel']").panel();
    
    $("a[href='#userDetial']").click(function() {
      alert(this.id);
    });
  });
</SCRIPT>
</head>
<body>
  <div data-role="panel" id="menuPanel">
    <p>panel goes here.</p>
    <P>${currUser.userName}</P>
    <P>${currUser.wxUserId}</P>
    <a href="#userList">会员列表</a>
  </div>
  <!-- /panel -->

  <div id="userList" data-role="page">

    <div data-role="header" data-position="fixed" class="ui-nodisc-icon ui-alt-icon">
      <a href="#menuPanel" class="ui-btn ui-corner-all ui-btn-inline ui-btn-icon-left ui-icon-bars ui-btn-icon-notext">menu</a>
      <h1>会员列表</h1>
    </div>
    <!-- /header -->

    <div role="main" class="ui-content">
      <p>Page content goes here.</p>
      <ul data-role="listview" data-inset="true">
        <c:if test="${USERS != null }">
          <c:forEach items="${USERS}" var="user">
            <li><a id="${user.userId}" href="#userDetial">
                <h2>${user.userId}-${user.userName}</h2>
            </a></li>
          </c:forEach>
        </c:if>
      </ul>
    </div>
    <!-- /content -->

    <div data-role="footer">
      <h4>Page Footer</h4>
    </div>
    <!-- /footer -->
  </div>
  <!-- /page -->

  <div id="userDetial" data-role="page">
    <div data-role="header" data-position="fixed" class="ui-nodisc-icon ui-alt-icon">
      <a href="#menuPanel" class="ui-btn ui-corner-all ui-btn-inline ui-btn-icon-left ui-icon-bars ui-btn-icon-notext">menu</a>
      <h1>会员查询</h1>
      <a class="ui-btn-right ui-btn ui-icon-carat-l ui-btn-icon-notext ui-corner-all" data-rel="back">Back</a>
    </div>
    <!-- /header -->

    <div role="main" class="ui-content">
      <p>Page content goes here.</p>

    </div>
    <!-- /content -->

    <div data-role="footer">
      <h4>Page Footer</h4>
    </div>
    <!-- /footer -->
  </div>

</body>
</html>