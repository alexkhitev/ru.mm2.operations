
<%@ page import="ru.mm2.operations.ComOperationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comOperationRecord.label', default: 'ComOperationRecord')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_2').checked = true;
        }
    </script>
</head>
<body>
<a href="#list-comOperationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: yellowgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <h3 style="text-align: center" style="color: black">Запись на госпитализацию</h3>
    </ul>
</div>
<div style="width: 950px; height: 300px; overflow-y: scroll;">
    <table>
        <thead>
        <tr>
            <g:each var="i" in="${ (0..<120) }">
                <g:form>
                    <g:if test="${ru.mm2.operations.ComOperationRecordController.isSanday(new Date()+i)}">
                        <td style="color: red"><g:formatDate format="EEE dd.MM.yy" date="${new Date()+i}"/></td>
                    </g:if>
                    <g:else>
                        <td><g:link class="create" action="create" params='[date_time: "${new Date()+i}"]'><g:formatDate format="EEE dd.MM.yy" date="${new Date()+i}"/></g:link></td>
                    </g:else>
                </g:form>
            </g:each>
        </tr>
        </thead>
        <tbody>
        <tr>
            <g:each var="i" in="${ (0..<120) }">
                <td>
                    <g:each in="${ru.mm2.operations.ComOperationRecordController.collectPatologies(new Date()+i)}" var="v">
                        <img src="${resource(dir: 'images', file: 'type2.png')}" alt="Патология"/><br>
                    </g:each>
                    <g:each in="${ru.mm2.operations.ComOperationRecordController.collectLessTreeYears(new Date()+i)}" var="v">
                        <img src="${resource(dir: 'images', file: 'type1.png')}" alt="До 3 лет"/><br>
                    </g:each>
                    <g:each in="${ru.mm2.operations.ComOperationRecordController.collectOthers(new Date()+i)}" var="v">
                        <img src="${resource(dir: 'images', file: 'type3.png')}" alt="До 3 лет"/><br>
                    </g:each>
                </td>
            </g:each>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
