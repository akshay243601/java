<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="<spring:theme code='styleSheet'></spring:theme>" type="text/css"/>
<a href="/FirstSpringMVCProject/studentFormwithModel.html?siteLanguage=en">English</a> | <a href="/FirstSpringMVCProject/studentFormwithModel.html?siteLanguage=fr">French</a>
<a href="/FirstSpringMVCProject/studentFormwithModel.html?siteTheme=red">Red</a> | <a href="/FirstSpringMVCProject/studentFormwithModel.html?siteTheme=green">Green</a>

	<H3>${companuName };</H3>

<form:errors path="student.*"></form:errors>

<form method="post" action="studentFormWithModelSubmission.html">
	<table>
		<tr>
			<td>
				<label> <spring:message  code="label.Name"/></label>
			</td>
			<td>
				<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.Hobby"/></label>
			</td>
			<td>
				<input type="text" name="hobby"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.Mobile"/></label>
			</td>
			<td>
				<input type="text" name="mobile"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.DOB"/></label>
			</td>
			<td>
				<input type="text" name="dob"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.Skill"/></label>
			</td>
			<td>
				<select name="skills" multiple="multiple">
					<option value="Coding">Coding</option>
					<option value="Designing">Designing</option>
					<option value="Cricket">Cricket</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.Country"/></label>
			</td>
			<td>
				<input type="text" name="studentsAddress.country"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.City"/></label>
			</td>
			<td>
				<input type="text" name="studentsAddress.city"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.State"/></label>
			</td>
			<td>
				<input type="text" name="studentsAddress.pincode"/>
			</td>
		</tr>
		<tr>
			<td>
				<label> <spring:message  code="label.Pincode"/></label>
			</td>
			<td>
				<input type="text" name="studentsAddress.state"/>
			</td>
		</tr>
		<tr>
			<td>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="submit"/>
			</td>
		</tr>
	</table>
</form>
	
		