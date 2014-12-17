<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
input[type="submit"]{
height:30px !important;
}
</style>

<c:url value="/a/email/feedback/process" var="action" />
<form:form method="POST" action="${action}">
<section>

<div class="tableSection">
      
      <h1>FeedBack Form</h1>
    
          </div>
          <div class="roundBox">
          
          
          <font color="green">${message}</font>
            <table>
            
			<tr>
				<td>From :</td>
				<td><input type="text" id="from" name="from" class="isEmail"></td>
			</tr>
			<tr>
				<td>Subject :</td>
				<td><input type="text" id="subject" name="subject"></td>
			</tr>
			<tr>
				<td>Message :</td>
				<td><textarea rows="5" cols="30" name="message" id="message"></textarea></td>
			</tr>
			
			<tr>
                <td class="actionHolder left">&nbsp;</td>
                <td class="actionHolder right"><input type="submit" value="Send Feedback"></td>
              </tr>
			</table>
			</div></section>
			


  

</form:form>