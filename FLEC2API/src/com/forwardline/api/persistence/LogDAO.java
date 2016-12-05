package com.forwardline.api.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.forwardline.api.pojo.Partner;
import com.forwardline.exception.QueryException;

public class LogDAO {

	public LogDAO() {
	}

	public Boolean createLog(Partner p, Long transactionId, String request, String responseString, Date requestDate) throws QueryException {
		PreparedStatement pStmt = null;
		Boolean response = false;
		ConnectionManager cm = null;
		try {
			cm = new ConnectionManager();
			Connection conn = cm.getConnection();
			pStmt = conn.prepareStatement("insert into Forwardline_Partner_API_Log (Partner_Name, Transaction_Id, Request, Response, Request_Date) values (?, ?, ?, ?, ?)");
			pStmt.setString(1, p.getPartnerName());
			pStmt.setLong(2, transactionId);
			pStmt.setString(3, request);
			pStmt.setString(4, responseString);
			java.sql.Timestamp timestamp = new java.sql.Timestamp(requestDate.getTime());
			pStmt.setTimestamp(5, timestamp);
			response = pStmt.execute();
			pStmt.close();
		} catch (SQLException sqlExp) {
			throw new QueryException(sqlExp.getMessage());
		} catch (Exception exp) {
			throw new QueryException(exp.getMessage());
		} finally {
			try {
				if (pStmt != null)
					pStmt.close();
			} catch (SQLException sqe) {
				throw new QueryException(sqe.getMessage());
			}

			try {
				if (cm != null)
					cm.close();
			} catch (SQLException sqe) {
				throw new QueryException(sqe.getMessage());
			}
		}
		return response;
	}
}
