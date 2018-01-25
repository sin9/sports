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
            <dd><a href="/return">归还信息</a></dd>
            <dd><a href="/returnlog">归还记录</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="/site">场地管理</a></li>
      </ul>
    </div>
  </div>
  <div class="layui-body" id="main" >
    <!-- 内容主体区域 -->
   <form class="layui-form" action="/rentequipment" method="post" >
 <div class="layui-form-item" style="margin:20px">
    <label class="layui-form-label">租借人姓名</label>
    <div class="layui-input-block">
      <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>


    <label class="layui-form-label">器材名</label>
    <div class="layui-input-inline" style="margin-left:20px;margin-bottom:20px">
    
      <select name="quiz2" id="first" onchange="javascript:demo()">
        <option value="0">请选择器材</option>
         <#if eqnames?exists>
		<#list eqnames?sort_by("eqnid") as eq>
        
        <option value="${eq.eqnid}">${eq.name}</option>
       
        </#list>
        </#if>
      </select>
    </div>
    <div class="layui-input-inline" style="margin-bottom:20px">
      <select name="quiz3" id="second">
        <option value="">请选择数量</option>
        
      </select>
    </div>
   
    <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    	<#if error?exists>
		<span style="color:red;">${error}</span>
        </#if>
    </div>
  </div>
  
  </form>
    	
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
<script>  
	var first=document.getElementById('first');
	
    var val = first.value; 
    
    function demo(){
    <#if eqnames?exists>
	<#list eqnames as eq>
	alert(val);
     if(val ==  ${eq.eqnid}){  
         var sec = document.getElementById('second');  
         alert(sec);
         for (var i=0;i<${eq.count};i++)
         {
        	sec.innerHTML = "<option value='2'>2</option>";  
         	/* sec.options[i] = new Option('i+1',i+1);   */
         }
        } 
    </#list>
    </#if>
	 }
</script>  
</body>
</html>
<#else>
<script language="javascript" type="text/javascript"> 
// 以下方式直接跳转
window.location.href='/login';
</script>
</#if>
