<#if Session.user?exists>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>高校体育器材管理系统</title>
<link rel="stylesheet" href="css/layui.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">高校体育器材管理系统</div>
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="/sport">控制台</a></li>
      <li class="layui-nav-item"><a href="/site">场馆管理</a></li>
      <li class="layui-nav-item"><a href="/allequipment">器材管理</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">用户管理</a>
        <dl class="layui-nav-child">
          <dd><a href="/role">权限管理</a></dd>
          <dd><a href="/usermanage">用户信息管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
     ${Session.user.uname}   
     
        </a>
        <dl class="layui-nav-child">
          <dd><a href="/userinformation">基本资料</a></dd>
          <dd><a href="/changepassword">密码修改</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="/logout">注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">器材</a>
          <dl class="layui-nav-child">
          <dd><a href="/allequipment">所有器材</a></dd>
            <dd><a href="/tianjing">田径器材</a></dd>
            <dd><a href="/ball">球类器材</a></dd>
            <dd><a href="/juzhong">举重器材</a></dd>
            <dd><a href="/snow">冰雪器材</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">器材入库</a>
          <dl class="layui-nav-child">
            <dd><a href="/addequipment">新增器材</a></dd>
            <dd><a href="/intolog">入库记录</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;">器材出库</a>
          <dl class="layui-nav-child">
            <dd><a href="/rentequipment">器材租借</a></dd>
            <dd><a href="/outlog">出库记录</a></dd>
          </dl>
        </li>
          <li class="layui-nav-item">
          <a href="javascript:;">器材归还</a>
          <dl class="layui-nav-child">
            <dd><a href="/returnall">归还信息</a></dd>
            <dd><a href="/returnlog">归还记录</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="/site">场地管理</a></li>
      </ul>
    </div>
  </div>
  <div class="layui-body" id="main" >
    <!-- 内容主体区域 -->
   
    	<div style="margin-left:20px">
    	<table class="layui-table" lay-data="{height:400, page:true, id:'test2', skin: 'row', even: true}">
    		<thead>
    			<tr>
    				
    				<th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
    				<th lay-data="{field:'maname', width:80}">器材名</th>
    				<th lay-data="{field:'matype', width:130, sort: true}">器材类型</th>
    				
    				<th lay-data="{field:'count', width:80}">数量</th>
    				<th lay-data="{field:'sign', width:400}">器材说明</th>
    				<th lay-data="{field:'right', width:178}">操作</th>
    			</tr>
    		</thead>
    		<tbody>
    		 <#if eqinfo?exists>

                <#list eqinfo as key>

                   <tr>
                             <td>${key.eqnid}</td>
                           <td>${key.name}</td>
                           <td>${key.eqtid.eqtname}</td>
                        	<td>${key.getCount()}</td>
                           <td>${key.detail}</td>
                           <td>
    		<a class="layui-btn layui-btn-xs" href="/edit/${key.eqnid}">编辑</a>
    		
							
                   </tr>

                </#list>

            </#if>
    		</tbody>
    	</table>
    	<#if error?exists>
		<span style="color:red;">${error}</span>
        </#if>
  </div>
 
  <div class="layui-footer">
    <!-- 底部固定区域 -->
  <span class="foot">Copyright © 2018 高校体育器材管理系统  sinoutx.cn All Rights Reserved. 备案号：忘了</span>
  </div>
</div>
<script type="text/javascript" src="js/layui.all.js" ></script>
<script type="text/javascript" src="js/jquery-3.1.0.js" ></script>

<script>
layui.use('element', function(){
  var element = layui.element;
  
});
</script>


</body>
</html>
<#else>
<script language="javascript" type="text/javascript"> 
// 以下方式直接跳转
window.location.href='/login';
</script>
</#if>
