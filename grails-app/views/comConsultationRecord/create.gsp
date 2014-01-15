<!DOCTYPE html>
<%@ page import="ru.mm2.operations.ComConsultationRecord" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comConsultationRecord.label', default: 'ComConsultationRecord')}" />
    <title><g:message code="default.createrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_2').checked = true;
        }
    </script>
</head>
<body>
<a href="#create-comConsultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: lightgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center">Запись на консультацию</h3>
    </ul>
</div>
<div id="create-comConsultationRecord" class="content scaffold-create" role="main">
    <h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${comConsultationRecordInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${comConsultationRecordInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource:comConsultationRecordInstance, action:'save']" >
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
<div id="list-comConsultationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'comConsultationRecord.fio.label', default: 'ФИО пациента')}" />
            <th><g:message code="comConsultationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'comConsultationRecord.birthday.label', default: 'Дата рождения')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${comConsultationRecordInstanceList}" status="i" var="comConsultationRecordInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="show" id="${comConsultationRecordInstance.id}">${fieldValue(bean: comConsultationRecordInstance, field: "fio")}</g:link></td>
                <td>"${comConsultationRecordInstance?.doctor?.fio }"</td>
                <td><g:formatDate date="${comConsultationRecordInstance?.birthday}" /></td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${comConsultationRecordInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>
