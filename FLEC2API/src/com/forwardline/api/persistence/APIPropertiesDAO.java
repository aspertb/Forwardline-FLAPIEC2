package com.forwardline.api.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.forwardline.exception.QueryException;
import com.forwardline.util.IFLAPIConstants;

public class APIPropertiesDAO {
	private String partnerName;

	public APIPropertiesDAO(String partnerName) {
		this.partnerName = partnerName;
	}

	public Map<String, String> getAPIProperties() throws QueryException {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ConnectionManager cm = null;
		try {
			cm = new ConnectionManager();
			Connection conn = cm.getConnection();
			pStmt = conn.prepareStatement("select Login_Endpoint, Username, Password, Client_Id, Client_Secret, Token from API_Salesforce_Properties where Partner_Name = ?");
			pStmt.setString(1, partnerName);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				propertiesMap.put(IFLAPIConstants.SF_LOGIN_ENDPOINT, rs.getString(1));
				propertiesMap.put(IFLAPIConstants.SF_USER_NAME, rs.getString(2));
				propertiesMap.put(IFLAPIConstants.SF_PASSWORD, rs.getString(3));
				propertiesMap.put(IFLAPIConstants.SF_OAUTH_CLIENT_ID, rs.getString(4));
				propertiesMap.put(IFLAPIConstants.SF_OAUTH_CLIENT_SECRET_ID, rs.getString(5));
				propertiesMap.put(IFLAPIConstants.SF_TOKEN, rs.getString(6));
			}
			rs.close();
			pStmt.close();
		} catch (SQLException sqlExp) {
			throw new QueryException(sqlExp.getMessage());
		} catch (Exception exp) {
			throw new QueryException(exp.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException sqe) {
				throw new QueryException(sqe.getMessage());
			}

			try {
				if (pStmt != null)
					pStmt.close();
			} catch (SQLException sqe) {
				throw new QueryException(sqe.getMessage());
			}

			try {
				cm.close();
			} catch (SQLException sqe) {
				throw new QueryException(sqe.getMessage());
			}
		}
		return propertiesMap;
	}
}
