import ru.mm2.operations.ConsultationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_consultationRecordindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/consultationRecord/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'consultationRecord.label', default: 'ConsultationRecord'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',15,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.home.label")],-1)
printHtmlPart(7)
for( i in ((0..<120)) ) {
printHtmlPart(8)
if(true && (ru.mm2.operations.ConsultationRecordController.isSanday(new Date()+i))) {
printHtmlPart(9)
invokeTag('formatDate','g',28,['format':("EEE dd.MM.yy"),'date':(new Date()+i)],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
createTagBody(4, {->
invokeTag('formatDate','g',31,['format':("EEE dd.MM.yy"),'date':(new Date()+i)],-1)
})
invokeTag('link','g',31,['class':("create"),'action':("create"),'params':([date_time: "${new Date()+i}"])],4)
printHtmlPart(10)
}
printHtmlPart(12)
}
printHtmlPart(13)
for( i in ((0..<120)) ) {
printHtmlPart(14)
for( v in (ru.mm2.operations.ConsultationRecordController.collectLessTreeYears(new Date()+i)) ) {
printHtmlPart(15)
expressionOut.print(resource(dir: 'images', file: 'type1.png'))
printHtmlPart(16)
}
printHtmlPart(17)
for( v in (ru.mm2.operations.ConsultationRecordController.collectOthers(new Date()+i)) ) {
printHtmlPart(15)
expressionOut.print(resource(dir: 'images', file: 'type3.png'))
printHtmlPart(16)
}
printHtmlPart(18)
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389197431000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
