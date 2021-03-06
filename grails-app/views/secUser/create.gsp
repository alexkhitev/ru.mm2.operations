<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'secUser.label', default: 'SecUser')}" />
		<title><g:message code="default.createuser.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_4').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#create-secUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: darkred">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: white"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: white"><g:message code="default.listuser.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-secUser" class="content scaffold-create" role="main">
			<h1><g:message code="default.createuser.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${secUserInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${secUserInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:secUserInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
