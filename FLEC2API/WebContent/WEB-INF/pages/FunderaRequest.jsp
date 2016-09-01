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
				            <td><form:label path="company.uuid">Unique Id (String)</form:label></td>
				            <td><form:input path="company.uuid"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.loan_amount">Loan Amount (Numeric)</form:label></td>
				            <td><form:input path="company.loan_amount"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.loan_purpose">Loan Purpose (String)</form:label></td>
				            <td><form:input path="company.loan_purpose"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.industry">Industry Id (String)</form:label></td>
				            <td><form:input path="company.industry"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_name">Business Name (String)</form:label></td>
				            <td><form:input path="company.business_name"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_dba">DBA (String)</form:label></td>
				            <td><form:input path="company.business_dba"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.entity_type">Entity Type (String)</form:label></td>
				            <td><form:input path="company.entity_type"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.street_line1">Street Line 1 (String)</form:label></td>
				            <td><form:input path="company.street_line1"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.street_line2">Street Line 2 (String)</form:label></td>
				            <td><form:input path="company.street_line2"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.city">City (String)</form:label></td>
				            <td><form:input path="company.city"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.state">State (String)</form:label></td>
				            <td><form:input path="company.state"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.zip">Postal Code (String)</form:label></td>
				            <td><form:input path="company.zip"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.phone_number">Phone (String)</form:label></td>
				            <td><form:input path="company.phone_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.ein">EIN (String)</form:label></td>
				            <td><form:input path="company.ein"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.number_of_employees"># of Employees (Integer)</form:label></td>
				            <td><form:input path="company.number_of_employees"/></td>
				        </tr>
					</table>
				</td>
				<td style="vertical-align: top;">	
					<table>
						<th>Business Information cont'd</th>
						<tr>
				            <td><form:label path="company.annual_revenue">Annual Revenue (Numeric)</form:label></td>
				            <td><form:input path="company.annual_revenue"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.average_bank_balance">Avg. Bank Balance (Numeric)</form:label></td>
				            <td><form:input path="company.average_bank_balance"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.accounts_receivable">Accounts Receivable (Numeric)</form:label></td>
				            <td><form:input path="company.accounts_receivable"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_inception">Date Ownership Began (mm/dd/yyyy)</form:label></td>
				            <td><form:input path="company.business_inception" /></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.outstanding_tax_lien"># outstanding Tax Lien (Integer)</form:label></td>
				            <td><form:input path="company.outstanding_tax_lien"/></td>
				        </tr>
				        
				        <tr>
				            <td><form:label path="company.credit_card_volume_per_month">CC Volume/Month (Numeric)</form:label></td>
				            <td><form:input path="company.credit_card_volume_per_month"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_location_type">Business Loc. Type (String)</form:label></td>
				            <td><form:input path="company.business_location_type"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.monthly_business_location_payment">Monthly Loc. Rent (Numeric)</form:label></td>
				            <td><form:input path="company.monthly_business_location_payment"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.business_location_rent_or_own">Rent or Own? (String)</form:label></td>
				            <td><form:input path="company.business_location_rent_or_own"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="company.officer_in_lawsuit">Offic In Lawsuit (String)</form:label></td>
				            <td><form:input path="company.officer_in_lawsuit"/></td>
				        </tr>
					</table>
				</td>
				<td style="vertical-align: top;">
					<table>
						<th>Owner Information</th>
						<tr>
				            <td><form:label path="owners[0].uuid">Unique Id (String)</form:label></td>
				            <td><form:input path="owners[0].uuid"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].email">Email (String)</form:label></td>
				            <td><form:input path="owners[0].email"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].phone_number">Phone (String)</form:label></td>
				            <td><form:input path="owners[0].phone_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].first_name">First Name (String)</form:label></td>
				            <td><form:input path="owners[0].first_name"/></td>
				        </tr> 
				        <tr>
				            <td><form:label path="owners[0].last_name">Last Name (String)</form:label></td>
				            <td><form:input path="owners[0].last_name"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].ownership_percentage">Ownership % (Numeric)</form:label></td>
				            <td><form:input path="owners[0].ownership_percentage"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].date_of_birth">DOB (mm/dd/yyyy)</form:label></td>
				            <td><form:input path="owners[0].date_of_birth"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].street_line1">Street Line 1 (String)</form:label></td>
				            <td><form:input path="owners[0].street_line1"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].street_line2">Street Line 2 (String)</form:label></td>
				            <td><form:input path="owners[0].street_line2"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].city">City (String)</form:label></td>
				            <td><form:input path="owners[0].city"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].state">State (String)</form:label></td>
				            <td><form:input path="owners[0].state"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].zip">Postal Code (String)</form:label></td>
				            <td><form:input path="owners[0].zip"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].ssn">SSN (String)</form:label></td>
				            <td><form:input path="owners[0].ssn"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].credit_score">Credit Score (Integer)</form:label></td>
				            <td><form:input path="owners[0].credit_score"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].last_bankruptcy">Last Bankruptcy (String)</form:label></td>
				            <td><form:input path="owners[0].last_bankruptcy"/></td>
				        </tr>
					</table>
				</td>
				<td style="vertical-align: top;">
					<table>
						<th>Owner Information cont'd</th>
						<tr>
				            <td><form:label path="owners[0].drivers_license_number">DL Number (String)</form:label></td>
				            <td><form:input path="owners[0].drivers_license_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].drivers_license_state">DL State (String)</form:label></td>
				            <td><form:input path="owners[0].drivers_license_state"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].drivers_license_expiration">DL Expiration (mm/dd/yyyy)</form:label></td>
				            <td><form:input path="owners[0].drivers_license_expiration"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].passport_number">Passport # (String)</form:label></td>
				            <td><form:input path="owners[0].passport_number"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].passport_country">Passport Country (String)</form:label></td>
				            <td><form:input path="owners[0].passport_country"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].passport_expiration">Passport Expiration (mm/dd/yyyy)</form:label></td>
				            <td><form:input path="owners[0].passport_expiration"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].monthly_residential_payment">Monthly Home Rent (Numeric)</form:label></td>
				            <td><form:input path="owners[0].monthly_residential_payment"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].residence_rent_or_own">Home Rent/Own (String)</form:label></td>
				            <td><form:input path="owners[0].residence_rent_or_own"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].personal_annual_income">Annual Income (Numeric)</form:label></td>
				            <td><form:input path="owners[0].personal_annual_income"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].value_of_liquid_assets">Value of Liquid Assets (Numeric)</form:label></td>
				            <td><form:input path="owners[0].value_of_liquid_assets"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].value_of_nonretirement_assets">Value of Non-Retirement Assets (Numeric)</form:label></td>
				            <td><form:input path="owners[0].value_of_nonretirement_assets"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].value_of_retirement_assets">Value of Retirement Assets (Numeric)</form:label></td>
				            <td><form:input path="owners[0].value_of_retirement_assets"/></td>
				        </tr>
				        <tr>
				            <td><form:label path="owners[0].citizenship">Citizenship (String)</form:label></td>
				            <td><form:input path="owners[0].citizenship"/></td>
				        </tr>
				        <tr>
				            <td></td>
				            <td></td>
				        </tr>
				        <tr>
				            <td></td>
				            <td><input type="submit" value="Submit"/></td>
				        </tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>