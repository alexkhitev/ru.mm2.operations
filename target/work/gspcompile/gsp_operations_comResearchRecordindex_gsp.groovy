import ru.mm2.operations.ComResearchRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comResearchRecordindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comResearchRecord/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'comResearchRecord.label', default: 'ComResearchRecord'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(8)
for( i in ((0..<120)) ) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
if(true && (ru.mm2.operations.ComResearchRecordController.isSanday(new Date()+i))) {
printHtmlPart(11)
invokeTag('formatDate','g',30,['format':("EEE dd.MM.yy"),'date':(new Date()+i)],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
createTagBody(5, {->
invokeTag('formatDate','g',33,['format':("EEE dd.MM.yy"),'date':(new Date()+i)],-1)
})
invokeTag('link','g',33,['class':("create"),'action':("create"),'params':([date_time: "${new Date()+i}"])],5)
printHtmlPart(12)
}
printHtmlPart(9)
})
invokeTag('form','g',35,[:],3)
printHtmlPart(14)
}
printHtmlPart(15)
for( i in ((0..<120)) ) {
printHtmlPart(16)
for( v in (ru.mm2.operations.ComResearchRecordController.collectOthers(new Date()+i)) ) {
printHtmlPart(17)
expressionOut.print(resource(dir: 'images', file: 'type3.png'))
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389197270000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
