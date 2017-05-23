<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forwardline :: Milo</title>
	
	<style>
		/* Absolute Center Spinner */
		.loading {
		  position: fixed;
		  z-index: 999;
		  height: 4em;
		  width: 4em;
		  overflow: show;
		  margin: auto;
		  top: 0;
		  left: 0;
		  bottom: 0;
		  right: 0; 
		}
		
		/* Transparent Overlay */
		.loading:before {
		  content: '';
		  display: block;
		  position: fixed;
		  top: 0;
		  left: 0;
		  width: 100%;
		  height: 100%;
		  background-color: rgba(255,255,255,0.5);
		}
		
		/* :not(:required) hides these rules from IE9 and below */
		.loading:not(:required) {
		  /* hide "loading..." text */
		  font: 0/0 a;
		  color: transparent;
		  text-shadow: none;
		  background-color: transparent;
		  border: 0;
		}
		
		.loading:not(:required):after {
		  content: '';
		  display: block;
		  font-size: 10px;
		  width: 1em;
		  height: 1em;
		  margin-top: -0.5em;
		  -webkit-animation: spinner 1500ms infinite linear;
		  -moz-animation: spinner 1500ms infinite linear;
		  -ms-animation: spinner 1500ms infinite linear;
		  -o-animation: spinner 1500ms infinite linear;
		  animation: spinner 1500ms infinite linear;
		  border-radius: 0.5em;
		  -webkit-box-shadow: rgba(0, 0, 0, 0.75) 1.5em 0 0 0, rgba(0, 0, 0, 0.75) 1.1em 1.1em 0 0, rgba(0, 0, 0, 0.75) 0 1.5em 0 0, rgba(0, 0, 0, 0.75) -1.1em 1.1em 0 0, rgba(0, 0, 0, 0.5) -1.5em 0 0 0, rgba(0, 0, 0, 0.5) -1.1em -1.1em 0 0, rgba(0, 0, 0, 0.75) 0 -1.5em 0 0, rgba(0, 0, 0, 0.75) 1.1em -1.1em 0 0;
		  box-shadow: rgba(0, 0, 0, 0.75) 1.5em 0 0 0, rgba(0, 0, 0, 0.75) 1.1em 1.1em 0 0, rgba(0, 0, 0, 0.75) 0 1.5em 0 0, rgba(0, 0, 0, 0.75) -1.1em 1.1em 0 0, rgba(0, 0, 0, 0.75) -1.5em 0 0 0, rgba(0, 0, 0, 0.75) -1.1em -1.1em 0 0, rgba(0, 0, 0, 0.75) 0 -1.5em 0 0, rgba(0, 0, 0, 0.75) 1.1em -1.1em 0 0;
		}
		
		/* Animation */
		
		@-webkit-keyframes spinner {
		  0% {
		    -webkit-transform: rotate(0deg);
		    -moz-transform: rotate(0deg);
		    -ms-transform: rotate(0deg);
		    -o-transform: rotate(0deg);
		    transform: rotate(0deg);
		  }
		  100% {
		    -webkit-transform: rotate(360deg);
		    -moz-transform: rotate(360deg);
		    -ms-transform: rotate(360deg);
		    -o-transform: rotate(360deg);
		    transform: rotate(360deg);
		  }
		}
		@-moz-keyframes spinner {
		  0% {
		    -webkit-transform: rotate(0deg);
		    -moz-transform: rotate(0deg);
		    -ms-transform: rotate(0deg);
		    -o-transform: rotate(0deg);
		    transform: rotate(0deg);
		  }
		  100% {
		    -webkit-transform: rotate(360deg);
		    -moz-transform: rotate(360deg);
		    -ms-transform: rotate(360deg);
		    -o-transform: rotate(360deg);
		    transform: rotate(360deg);
		  }
		}
		@-o-keyframes spinner {
		  0% {
		    -webkit-transform: rotate(0deg);
		    -moz-transform: rotate(0deg);
		    -ms-transform: rotate(0deg);
		    -o-transform: rotate(0deg);
		    transform: rotate(0deg);
		  }
		  100% {
		    -webkit-transform: rotate(360deg);
		    -moz-transform: rotate(360deg);
		    -ms-transform: rotate(360deg);
		    -o-transform: rotate(360deg);
		    transform: rotate(360deg);
		  }
		}
		@keyframes spinner {
		  0% {
		    -webkit-transform: rotate(0deg);
		    -moz-transform: rotate(0deg);
		    -ms-transform: rotate(0deg);
		    -o-transform: rotate(0deg);
		    transform: rotate(0deg);
		  }
		  100% {
		    -webkit-transform: rotate(360deg);
		    -moz-transform: rotate(360deg);
		    -ms-transform: rotate(360deg);
		    -o-transform: rotate(360deg);
		    transform: rotate(360deg);
		  }
		}
	</style>
	
	<link href="<c:url value='/resources/css/gsi-step-indicator.css' />" rel="stylesheet" />
	<link href="<c:url value='/resources/css/CustomerJourneyForwardLine.css' />" rel="stylesheet" />
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" />
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<script>
		$(document).ajaxStart(function () {
	        console.log("start");
	    });
	
	    //
	    $(document).ajaxStop(function () {
	        console.log('stop');
	        $('.loading').hide();
	    });
	    
    	$(document).ready(function() {                        
			var data = {};
			data["id"] = $("#id").val();
			
            $.ajax({url: "processApplication",
				contentType: "application/json",
				data: JSON.stringify(data), 
				type: "POST",
				success: function(data) { 
            		$("#errorMessageDiv").text(data);
					console.log('Success!! ');
					console.log('Data ' + data);
					window.location.replace(data); //to prevent back button
				},
				error: function(xhr, status, error) {
					//Exception is handled gracefully in the controller. This should never execute
					$("#errorMessageDiv").text(error);
					console.log('Error!!');
					//window.location.replace("");
				}
            });
    	});
	</script>
</head>
<body>
	<nav class="navbar">
		<div class="container-fluid">
			<br/>
			<div class="navigation-bar">
				<div class="row">
                 	<div class="col-md-6 col-xs-12">
                    	<div class="logo">
                        	<img src="<c:url value='/resources/images/FLLogo.png' />"/> 
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-12 text-right">
                    	<h4> HAVE A QUESTION? CALL US 866.777.5876 </h4>
                    </div>
                </div>
			</div>
		</div>
	</nav>
	
	<div style="width: 100%; height:500px;">
		<div id="errorMessageDiv"></div>
		<div class="loading">Loading</div>
	</div>
	<form:form id="form1" modelAttribute="application">
		<form:hidden path="id" />
	</form:form>
	
	<section  class="third-row">
        <div class="container">
            <div class="row ">      
            </div>
        </div>
    </section>

    <section class="first-row">
    	<div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
               		<div id="footer-second-row"><p>© 2017 ForwardLine Financial, LLC. All rights reserved.</p></div>
                		<p class="footFont">In certain states small business loans are provided by ForwardLine Financial, LLC, 

		                    a licensed California Finance Lender, license 46039614. In certain other states or because of certain loan attributes,
		
		                    your business loan may be issued by FinWise Bank, a Utah-chartered bank, Member FDIC.
		
		                    All business loans are subject to lender approval. All applicable legal notices, 
		
		                    agreements, and disclosures associated with your transaction will clearly identify the lender. 
		
		                    <br/><br/>
		
		                    If your application for business credit is denied, you have the right to a written statement of the specific reasons for 
		
		                    the denial. To obtain the statement, please contact Vice President Underwriting Decisions, ForwardLine Financial, LLC, 
		
		                    21700 Oxnard Street, Ste. 1450, Woodland Hills, CA 91367 or (866) 623-4900 within 60 days from the date you are notified 
		
		                    of the decision. We will send you a written statement of reasons for the denial within 30 days of receiving your request for the statement. 
		
		                    <br/><br/>
		
		                    Notice: The Federal Equal Credit Opportunity Act prohibits creditors form discrimination against credit applicants
		
		                    on the basis of race, color, religion, national origin, sex, marital status, age (provided the applicant has 
		
		                    the capacity to enter into a binding contract): because all or part of the applicants income derives from any public 
		
		                    assistance program; or because the applicant has in good faith exercised any right under the Consumer Credit Protection Act. 
		
		                    The federal agency that administers compliance with this law concerning ForwardLine Financial, LLC is the Federal 
		
		                    Trade Commission, Equal Credit Opportunity, Washington, D.C. 20580. The federal agency that administers compliance with this 
		
		                    law concerning FinWise Bank is the FDIC Consumer Response Center, 1100 Walnut Street, Box 411, Kansas City, MO 64106. 

                		</p>
                	</div>
            	</div>
        	</div>
        </section>
        <section class="second-row "></section>
</body>
</html>