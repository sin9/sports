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
    	<table class="layui-table" lay-data="{width: 880, height:400, page:true, id:'idTest'}" lay-filter="demo" >
    		<thead>
    			<tr>
    				
    				<th lay-data="{field:'id', width:130, sort: true, fixed: true}">出库记录ID</th>
    				<th lay-data="{field:'maname', width:130}">器材名</th>
    				<th lay-data="{field:'matype', width:150, sort: true}">出库时间</th>
    				
    				<th lay-data="{field:'wealth', width:100}">出库数量</th>
    				
    				<th lay-data="{field:'sign', width:100}">操作人</th>
    				
    				<th lay-data="{field:'renter', width:100}">租借人</th>
    		
    				
    			</tr>
    		</thead>
    		<tbody>
    		 <#if outlogs?exists>

                <#list outlogs?sort_by("outid") as out>

                   <tr>

                             <td>${out.outid}</td>
                           <td>${out.eqnid.name}</td>
                           <td>${out.outdate}</td>
                           <td>${out.outnum}</td>
                        
                           <td>${out.usid.uname}</td>
                           <td>${out.outname}</td>
							<td></td>
                   </tr>

                </#list>

            </#if>
    		</tbody>
    	</table>
    	</div>
    	
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
