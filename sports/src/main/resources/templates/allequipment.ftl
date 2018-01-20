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
  <div class="layui-body" id="main">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	<div class="layui-btn-group demoTable">
    		<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
    		<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
    		<button class="layui-btn" data-type="isAll">验证是否全选</button>
    	</div>
    	
    	<table class="layui-table" lay-data="{width: 892, height:332, url:'/demo/table/user/', page:true, id:'idTest'}" lay-filter="demo">
    		<thead>
    			<tr>
    				<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
    				<!--<th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>-->
    				<th lay-data="{field:'maname', width:80}">器材名</th>
    				<th lay-data="{field:'matype', width:100, sort: true}">器材类型</th>
    				<th lay-data="{field:'manum', width:100}">器材数量</th>
    				<th lay-data="{field:'sign', width:160}">器材说明</th>
    				<th lay-data="{field:'renum', width:100}">外借数量</th>
    				<th lay-data="{field:'dsnum', width:100}">损坏数量</th>
    				<!--<th lay-data="{field:'wealth', width:135, sort: true}">财富</th>
    				<th lay-data="{field:'score', width:80, sort: true, fixed: 'right'}">评分</th>-->
    				<th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    			</tr>
    		</thead>
    	</table>
    	
    	<ul class="layui-fixbar" style="right: 50px; bottom: 100px;">
    		<li class="layui-icon" lay-type="bar1" style="background-color:#393D49"></li>
    		<li class="layui-icon" lay-type="bar2" style="background-color:#393D49"></li>
    		<li class="layui-icon layui-fixbar-top" lay-type="top" style="background-color:#393D49"></li>
    	</ul>
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
<script type="text/html" id="barDemo">
    		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    	</script>
    	
    	<script>
    		layui.use('table', function() {
    			var table = layui.table;
    			//监听表格复选框选择
    			table.on('checkbox(demo)', function(obj) {
    				console.log(obj)
    			});
    			//监听工具条
    			table.on('tool(demo)', function(obj) {
    				var data = obj.data;
    				if(obj.event === 'detail') {
    					layer.msg('ID：' + data.id + ' 的查看操作');
    				} else if(obj.event === 'del') {
    					layer.confirm('真的删除行么', function(index) {
    						obj.del();
    						layer.close(index);
    					});
    				} else if(obj.event === 'edit') {
    					layer.alert('编辑行：<br>' + JSON.stringify(data))
    				}
    			});
    	
    			var $ = layui.$,
    				active = {
    					getCheckData: function() { //获取选中数据
    						var checkStatus = table.checkStatus('idTest'),
    							data = checkStatus.data;
    						layer.alert(JSON.stringify(data));
    					},
    					getCheckLength: function() { //获取选中数目
    						var checkStatus = table.checkStatus('idTest'),
    							data = checkStatus.data;
    						layer.msg('选中了：' + data.length + ' 个');
    					},
    					isAll: function() { //验证是否全选
    						var checkStatus = table.checkStatus('idTest');
    						layer.msg(checkStatus.isAll ? '全选' : '未全选')
    					}
    				};
    	
    			$('.demoTable .layui-btn').on('click', function() {
    				var type = $(this).data('type');
    				active[type] ? active[type].call(this) : '';
    			});
    		});
    	</script>
    	<script>
			layui.use(['util', 'laydate', 'layer'], function(){
			  var util = layui.util
			  ,laydate = layui.laydate
			  ,layer = layui.layer;
			  //固定块
			  util.fixbar({
			    bar1: true
			    ,bar2: true
			    ,css: {right: 50, bottom: 100}
			    ,bgcolor: '#393D49'
			    ,click: function(type){
			      if(type === 'bar1'){
			        layer.msg('icon是可以随便换的')
			      } else if(type === 'bar2') {
			        layer.msg('两个bar都可以设定是否开启')
			      }
			    }
			  });
			  
			  //倒计时
			  var thisTimer, setCountdown = function(y, M, d, H, m, s){
			    var endTime = new Date(y, M||0, d||1, H||0, m||0, s||0) //结束日期
			    ,serverTime = new Date(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的
			     
			    clearTimeout(thisTimer);
			    util.countdown(endTime, serverTime, function(date, serverTime, timer){
			      var str = date[0] + '天' + date[1] + '时' +  date[2] + '分' + date[3] + '秒';
			      lay('#test2').html(str);
			      thisTimer = timer;
			    });
			  };
			  setCountdown(2099,1,1);
			  
			  laydate.render({
			    elem: '#test1'
			    ,type: 'datetime'
			    ,done: function(value, date){
			      setCountdown(date.year, date.month - 1, date.date, date.hours, date.minutes, date.seconds);
			    }
			  });
			  
			  
			  //某个时间在当前时间的多久前
			  var setTimeAgo = function(y, M, d, H, m, s){
			    var str = util.timeAgo(new Date(y, M||0, d||1, H||0, m||0, s||0));
			    lay('#test4').html(str);
			  };
			  
			  laydate.render({
			    elem: '#test3'
			    ,type: 'datetime'
			    ,done: function(value, date){
			      setTimeAgo(date.year, date.month - 1, date.date, date.hours, date.minutes, date.seconds);
			    }
			  });
			  
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
