package com.forwardline.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.forwardline.api.persistence.LogDAO;
import com.forwardline.api.pojo.Partner;

public class Logger {
	private Partner partner;
	private Long transactionId;
	private String request;
	private String response;
	private Date requestDateTime;

	public Logger(Partner partner) {
		this.partner = partner;
		this.transactionId = new GregorianCalendar().getTimeInMillis();

		Calendar cal = Calendar.getInstance();
		requestDateTime = cal.getTime();
	}

	public void logRequest(String request) {
		this.request = request;
	}

	public void logResponse(String response) {
		this.response = response;
	}

	public void flush() {
		System.out.println("Partner >>>>>>>>>>>>>>>>>>>> " + partner);
		System.out.println("Logging enabled >>>>>>>>>>>>>>>>>>>> " + partner.getLoggingEnabled());
		if (partner.getLoggingEnabled()) {
			try {
				LogDAO dao = new LogDAO();
				dao.createLog(partner, transactionId, request, response, requestDateTime);
			} catch (Exception e) {
				e.printStackTrace();
				// Do not propogate
			}
		}
	}
}
