
<%@ page import="ru.mm2.operations.Operations" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'operations.label', default: 'Operations')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#list-operations" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: sandybrown">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create" style="color: black"><g:message code="default.newoperation.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-operations" class="content scaffold-list" role="main">
			<h1><g:message code="default.listoperation.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>

                        <g:sortableColumn property="name" title="${message(code: 'operations.name.label', default: 'Название')}" />


					
					</tr>
				</thead>
				<tbody>
				<g:each in="${operationsInstanceList}" status="i" var="operationsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${operationsInstance.id}">${fieldValue(bean: operationsInstance, field: "name")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${operationsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
