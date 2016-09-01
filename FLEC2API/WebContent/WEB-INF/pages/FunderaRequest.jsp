<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FLWEB :: Fundera Request Page</title>
</head>
<body>
	<form:form method="POST" action="getOffer" modelAttribute="request">
		<h2>Fundera Test Page.</h2>
		<p>All fields are required</p>
		<br/>
		<table>
			<tr>
				<td style="vertical-align: top;">
					<table>
						<th>Request Header</th>
				        <tr>
				            <td><form:label path="RequestHeader.ApiUserid">API User Id</form:label></td>
				            <td><form:input path="RequestHeader.ApiUserid"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="RequestHeader.ApiPassword">Password</form:label></td>
				            <td><form:input path="RequestHeader.ApiPassword"/></td>
				        </tr>
					</table>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">
					<table>
						<th>Business Information</th>
						<tr>
				            <td><form:label path="company.uuid">Unique Id</form:label></td>
				            <td><form:input path="company.uuid"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.loan_amount">Loan Amount</form:label></td>
				            <td><form:input path="company.loan_amount"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.loan_purpose">Loan Purpose</form:label></td>
				            <td><form:input path="company.loan_purpose"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.industry">Industry Id</form:label></td>
				            <td><form:input path="company.industry"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_name">Business Name</form:label></td>
				            <td><form:input path="company.business_name"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_dba">DBA</form:label></td>
				            <td><form:input path="company.business_dba"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.entity_type">Entity Type</form:label></td>
				            <td><form:input path="company.entity_type"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.street_line1">Street Line 1</form:label></td>
				            <td><form:input path="company.street_line1"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.street_line2">Street Line 2</form:label></td>
				            <td><form:input path="company.street_line2"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.city">City</form:label></td>
				            <td><form:input path="company.city"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.state">State</form:label></td>
				            <td><form:input path="company.state"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.zip">Postal Code</form:label></td>
				            <td><form:input path="company.zip"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.phone_number">Phone</form:label></td>
				            <td><form:input path="company.phone_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.ein">EIN</form:label></td>
				            <td><form:input path="company.ein"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.number_of_employees"># of Employees</form:label></td>
				            <td><form:input path="company.number_of_employees"/></td>
				        </tr>
					</table>
				</td>
				<td style="vertical-align: top;">	
					<table>
						<th>Business Information cont'd</th>
						<tr>
				            <td><form:label path="company.annual_revenue">Annual Revenue</form:label></td>
				            <td><form:input path="company.annual_revenue"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.average_bank_balance">Avg. Bank Balance</form:label></td>
				            <td><form:input path="company.average_bank_balance"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.accounts_receivable">Accounts Receivable</form:label></td>
				            <td><form:input path="company.accounts_receivable"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_inception">Date Ownership Began</form:label></td>
				            <td><form:input path="company.business_inception" /></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.outstanding_tax_lien"># outstanding Tax Lien</form:label></td>
				            <td><form:input path="company.outstanding_tax_lien"/></td>
				        </tr>
				        
				        <tr>
				            <td><form:label path="company.credit_card_volume_per_month">CC Volume/Month</form:label></td>
				            <td><form:input path="company.credit_card_volume_per_month"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_location_type">Business Loc. Type</form:label></td>
				            <td><form:input path="company.business_location_type"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.monthly_business_location_payment">Monthly Loc. Rent</form:label></td>
				            <td><form:input path="company.monthly_business_location_payment"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_location_rent_or_own">Rent or Own?</form:label></td>
				            <td><form:input path="company.business_location_rent_or_own"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.officer_in_lawsuit">Offic In Lawsuit</form:label></td>
				            <td><form:input path="company.officer_in_lawsuit"/></td>
				        </tr>
					</table>
				</td>
				<td style="vertical-align: top;">
					<table>
						<th>Owner Information</th>
						<tr>
				            <td><form:label path="owners[0].uuid">Unique Id</form:label></td>
				            <td><form:input path="owners[0].uuid"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].email">Email</form:label></td>
				            <td><form:input path="owners[0].email"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].phone_number">Phone</form:label></td>
				            <td><form:input path="owners[0].phone_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].first_name">First Name</form:label></td>
				            <td><form:input path="owners[0].first_name"/></td>
				        </tr> 
				        <tr>
				            <td><form:label path="owners[0].last_name">Last Name</form:label></td>
				            <td><form:input path="owners[0].last_name"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].ownership_percentage">Ownership Percent</form:label></td>
				            <td><form:input path="owners[0].ownership_percentage"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].date_of_birth">DOB</form:label></td>
				            <td><form:input path="owners[0].date_of_birth"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].street_line1">Street Line 1</form:label></td>
				            <td><form:input path="owners[0].street_line1"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].street_line2">Street Line 2</form:label></td>
				            <td><form:input path="owners[0].street_line2"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].city">City</form:label></td>
				            <td><form:input path="owners[0].city"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].state">State</form:label></td>
				            <td><form:input path="owners[0].state"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].zip">Postal Code</form:label></td>
				            <td><form:input path="owners[0].zip"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].ssn">SSN</form:label></td>
				            <td><form:input path="owners[0].ssn"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].credit_score">Credit Score</form:label></td>
				            <td><form:input path="owners[0].credit_score"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].last_bankruptcy">Last Bankruptcy</form:label></td>
				            <td><form:input path="owners[0].last_bankruptcy"/></td>
				        </tr>
					</table>
				</td>
				<td style="vertical-align: top;">
					<table>
						<th>Owner Information cont'd</th>
						<tr>
				            <td><form:label path="owners[0].drivers_license_number">DL Number</form:label></td>
				            <td><form:input path="owners[0].drivers_license_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].drivers_license_state">DL State</form:label></td>
				            <td><form:input path="owners[0].drivers_license_state"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].drivers_license_expiration">DL Expiration</form:label></td>
				            <td><form:input path="owners[0].drivers_license_expiration"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].passport_number">Passport #</form:label></td>
				            <td><form:input path="owners[0].passport_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].passport_country">Passport Country</form:label></td>
				            <td><form:input path="owners[0].passport_country"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].passport_expiration">Passport Expiration</form:label></td>
				            <td><form:input path="owners[0].passport_expiration"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].monthly_residential_payment">Monthly Home Rent</form:label></td>
				            <td><form:input path="owners[0].monthly_residential_payment"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].residence_rent_or_own">Home Rent/Own</form:label></td>
				            <td><form:input path="owners[0].residence_rent_or_own"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].personal_annual_income">Annual Income</form:label></td>
				            <td><form:input path="owners[0].personal_annual_income"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].value_of_liquid_assets">Value of Liquid Assets</form:label></td>
				            <td><form:input path="owners[0].value_of_liquid_assets"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].value_of_nonretirement_assets">Value of Non-Retirement Assets</form:label></td>
				            <td><form:input path="owners[0].value_of_nonretirement_assets"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].value_of_retirement_assets">Value of Retirement Assets</form:label></td>
				            <td><form:input path="owners[0].value_of_retirement_assets"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].citizenship">Citizenship</form:label></td>
				            <td><form:input path="owners[0].citizenship"/></td>
				        </tr>
					</table>
				</td>
			</tr>
			<tr>
	            <td><input type="submit" value="Submit"/></td>
	        </tr>
		</table>
	</form:form>
</body>
</html>