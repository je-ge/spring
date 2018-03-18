<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#btn1").click(function() {
			var data = {
				"id" : 100,
				"name" : "je_ge"
			};
			$.ajax({
				type : "POST",
				url : "jsonRequest3",
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(data),
				success : function(data) {
				}
			});
		});

		$("#btn2").click(function() {
			var saveDataAry = [];
			var data1 = {
				"id" : 100,
				"name" : "je_ge1"
			};
			var data2 = {
				"id" : 200,
				"name" : "je_ge2"
			};
			saveDataAry.push(data1);
			saveDataAry.push(data2);
			$.ajax({
				type : "POST",
				url : "jsonRequest4",
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(saveDataAry),
				success : function(data) {
				}
			});
		});

		$("#btn3").click(function() {
			// 			$.post("/jsonRequest5?id=1&id=2",function(){
			// 			});
			// 			$.post("/jsonRequest6",{ids:"1,2"},function(){
			// 			});
			// 			var ids = [];
			// 			ids[0]=1;
			// 			ids[1]=2;
			// 			$.post("/jsonRequest7",{ids:ids},function(){
			// 			});
		});
	});
</script>
<title>提交测试</title>
</head>
<body>
	<fieldset>
		<form action="jsonRequest2" method="post">
			编号:<input type="text" name="id"><br /> 名称:<input type="text" name="name"><br /> <input
				type="submit" value="提交">
		</form>
	</fieldset>
	<hr />
	<fieldset>
		<input id="btn1" type="button" value="ajax提交对象">
	</fieldset>
	<hr />
	<fieldset>
		<input id="btn2" type="button" value="ajax提交集合">
	</fieldset>
	<fieldset>
		<input id="btn3" type="button" value="ajax提交数组">
	</fieldset>
</body>
</html>