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
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">场馆管理</a></li>
      <li class="layui-nav-item"><a href="">器材管理</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">用户管理</a>
        <dl class="layui-nav-child">
          <dd><a href="">权限管理</a></dd>
          <dd><a href="">用户信息管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
        sin
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">密码修改</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">所有器材</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">田径器材</a></dd>
            <dd><a href="javascript:;">球类器材</a></dd>
            <dd><a href="javascript:;">举重器材</a></dd>
            <dd><a href="javascript:;">冰雪器材</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">器材入库</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">新增器材</a></dd>
            <dd><a href="javascript:;">入库记录</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;">器材出库</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">器材租借</a></dd>
            <dd><a href="javascript:;">出库记录</a></dd>
          </dl>
        </li>
          <li class="layui-nav-item">
          <a href="javascript:;">器材归还</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">归还信息</a></dd>
            <dd><a href="javascript:;">归还记录</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">场地管理</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" id="main">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	<div class="layui-col-md4 col">
    		<div class="layui-card">
    			<div class="layui-card-header">今日</div>
    			<div class="layui-card-body">
    	
    				<div id="showYear"></div>
    				
    				<div id="showTime"></div>	
    	
    			</div>
    		</div>
    	</div>
    	
    	<div class="layui-col-md6 col">
    		<div class="layui-card">
    			<div class="layui-card-header">近期入库一览</div>
    			<div class="layui-card-body">
    	<table class="layui-table"  lay-even lay-skin="nob">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>编号</th>
      <th>名称</th>
      <th>分类</th>
    </tr> 
  </thead>
  <tbody>
    <tr>
      <td>10010</td>
      <td>羽毛球</td>
      <td>球类器材</td>
    </tr>
    <tr>
      <td>10011</td>
      <td>乒乓球</td>
      <td>球类器材</td>
    </tr>
  </tbody>
</table>
    				
    			</div>
    		</div>
    	</div>
    	
    	<div class="layui-col-md6 col">
    		<div class="layui-card">
    			<div class="layui-card-header">近期出库一览</div>
    			<div class="layui-card-body">
    	<table class="layui-table"  lay-even lay-skin="nob">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>编号</th>
      <th>名称</th>
      <th>分类</th>
    </tr> 
  </thead>
  <tbody>
    <tr>
      <td>10010</td>
      <td>羽毛球</td>
      <td>球类器材</td>
    </tr>
    <tr>
      <td>10011</td>
      <td>乒乓球</td>
      <td>球类器材</td>
    </tr>
  </tbody>
</table>
    				
    			</div>
    		</div>
    	</div>
    	
    	<div class="layui-col-md4 col">
    		<div class="layui-card">
    			<div class="layui-card-header">出入库数据</div>
    			<div class="layui-card-body">
    	<div id="somedata"></div>
    				
    			</div>
    		</div>
    	</div>
    	
    	
    	</div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
  <span class="foot">Copyright © 2018 高校体育器材管理系统  sinoutx.cn All Rights Reserved. 备案号：忘了</span>
  </div>
</div>
<script type="text/javascript" src="js/layui.all.js" ></script>
<script type="text/javascript" src="js/jquery-3.1.0.js" ></script>
<script type="text/javascript" src="js/echarts.simple.min.js" ></script>
<script>
	$(function(){ 
setInterval("getTime();",1000); //每隔一秒执行一次 
});
//取得系统当前时间 
function getTime(){ 
var myDate = new Date(); 
var date = myDate.toLocaleDateString(); 
var hours = myDate.getHours(); 
var minutes = myDate.getMinutes(); 
var seconds = myDate.getSeconds(); 
$("#showYear").html(date); //将值赋给div 
$("#showTime").html(hours+":"+minutes+":"+seconds); //将值赋给div 
} 
</script>
<script>
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
 <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('somedata'));

        // 指定图表的配置项和数据
        var option = {
    backgroundColor: '#2c343c',

    title: {
        text: 'Customized Pie',
        left: 'center',
        top: 20,
        textStyle: {
            color: '#ccc'
        }
    },

    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },

    visualMap: {
        show: false,
        min: 80,
        max: 600,
        inRange: {
            colorLightness: [0, 1]
        }
    },
    series : [
        {
            name:'访问来源',
            type:'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:274, name:'联盟广告'},
                {value:235, name:'视频广告'},
                {value:400, name:'搜索引擎'}
            ].sort(function (a, b) { return a.value - b.value; }),
            roseType: 'radius',
            label: {
                normal: {
                    textStyle: {
                        color: 'rgba(255, 255, 255, 0.3)'
                    }
                }
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: 'rgba(255, 255, 255, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            itemStyle: {
                normal: {
                    color: '#c23531',
                    shadowBlur: 200,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },

            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        }
    ]
};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>