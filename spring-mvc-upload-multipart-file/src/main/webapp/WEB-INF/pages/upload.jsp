<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring-mvc-upload</title>
</head>
<body>
	${msg}
	<fieldset>
		<form action="upload" method="post" enctype="multipart/form-data">
			文件的提交:<input type="file" name="upload"><br />
			<input type="submit" value="上传">
		</form>
	</fieldset>
</body>
</html>