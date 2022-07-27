<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src=" https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js "></script>
<script type="text/javascript">
const co = Cookies.get("myCookie")
	function popup(){
	alert(co)
		console.log( '${cook}' == '')
		console.log( '${cook}' == null)
		if('${cook}' == ''){
			window.open("popup","",
						"width=300, height=200")
		}
		/*
		if(co != undefined){
			alert("쿠키생성")
		}
		if(co != 'testCookie'){
			window.open("popup","",
						"width=300, height=200")
		}
		*/
	}
	popup()
</script>
cook : ${ cook }<br>
	cookie_quiz
</body>
</html>







