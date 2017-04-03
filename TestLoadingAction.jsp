<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application</title>
</head>

<body>
	<h2>Struts 2 - TEst LOading </h2>

	<s:actionerror />
	
	<s:form action="testloading.action" method="post">

		<s:textfield name="email1" key="label.username" size="20" />
		<s:password name="password" key="label.password" value="rr" size="20" />

		<s:submit method="execute" key="label.login" align="center" />
	</s:form>

	
	<s:actionerror />


<s:bean name="test.testbean" var="hello">
 
</s:bean>

The HelloBean's msg property value : <s:property value="#hello.driver"/>

</body>
</html>

