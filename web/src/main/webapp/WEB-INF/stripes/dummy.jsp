<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
Hello: ${actionBean.hello}


<s:form method="get" beanclass="everything.stripes.DummyActionBean">
    <s:text name="dummyvarde"/>
    <input type="submit" name="posta"/>
</s:form>
