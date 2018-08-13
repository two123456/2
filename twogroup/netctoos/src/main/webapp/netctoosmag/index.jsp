<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>电信实验室服务计费系统</title>
		<!--导入css,js-->
		<link rel="stylesheet" href="/netctoos/static/layui/css/layui.css">
		<script src="/netctoos/static/jQuery-2.2.2-min.js"></script>
		<script src="/netctoos/static/layui/layui.js"></script>
	</head>

	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<div class="layui-logo">服务计费系统</div>
				<!-- 头部区域（可配合layui已有的水平导航） ---------------------------------------------------------------------------->

				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a href="javascript:;">
							<!--用户头像,姓名------->
							<img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="">基本资料</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="">退出系统</a>
					</li>
				</ul>
			</div>

			<!--左侧导航栏---------------------------------------------------------------------------------------------------------->
			<div class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
						<!--用户自助服务系统--------------------------------------------->
						<li class="layui-nav-item layui-nav-itemed">
							<a href="javascript:;">
								<i class="layui-icon"></i>
								<span>公共服务</span>
							</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;">
										修改密码
									</a>

								</dd>
								<dd>
									<a href="javascript:;">
										查看个人信息</a>
								</dd>

							</dl>
						</li>
						<!--前台运营系统--------------------------------------------->
						<li class="layui-nav-item layui-nav-itemed">
							<a href="javascript:;">
								<i class="layui-icon"></i>
								<span>前台运营系统</span>
							</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;">
										<i class="layui-icon">&#xe62e;</i>用户管理系统</a>
									<dl class="layui-nav-child layui-nav-child">
										<dd>
											<a data-url="fdfd" data-id="11" data-title="权限管理" href="#" class="site-demo-active" data-type="tabAdd">账务账号管理</a>
										</dd>
										<dd>
											<a data-url="views/admin/admin" data-id="1" data-title="权限管理" href="#" class="site-demo-active" data-type="tabAdd">业务账号管理</a>
										</dd>

									</dl>
								</dd>
								<dd>
									<a href="javascript:;">
										<i class="layui-icon">&#xe62e;</i> 前台日志系统
									</a>
									<dl class="layui-nav-child layui-nav-child">
										<dd>
											<a href="javascript:;">登陆服务日志</a>

										</dd>
										<dd>
											<a href="javascript:;">操作服务日志</a>
										</dd>

									</dl>
								</dd>
								<dd>
									<a href="javascript:;">
										<i class="layui-icon">&#xe62e;</i> 权限管理系统
									</a>
									<dl class="layui-nav-child layui-nav-child ">
										<dd>
											<a href="javascript:;">角色管理</a>
										</dd>
										<dd>
											<a href="javascript:;">权限管理</a>
										</dd>

									</dl>
								</dd>
								<dd>
									<a href="">
										报表查询系统
									</a>
								</dd>
								<dd>
									<a href="">
										管理员管理系统
									</a>
								</dd>
								<dd>
									<a href="">
										账务查询系统
									</a>
								</dd>
								<dd>
									<a data-url="bills/Bill" data-id="9" data-title="账单查询" href="#" class="site-demo-active" data-type="tabAdd">
										账单查询系统
									</a>
								</dd>
								<dd>
									<a data-url="tariff/Rates" data-id="8" data-title="资费管理" href="#" class="site-demo-active" data-type="tabAdd">
										资费管理系统
									</a>
								</dd>
							</dl>
						</li>

					</ul>

				</div>

			</div>

			<!--主体页面------------------------------------------------------>
			<div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
				<!--tabel 选项卡-->
				<ul class="layui-tab-title">
				</ul>
				<!--子页面-->
				<div class="layui-tab-content">

				</div>
			</div>

		</div>
	</body>
	<!---->
	<script src="/netctoos/static/js/index.js"></script>

</html>