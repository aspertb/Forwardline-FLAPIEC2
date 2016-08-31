package com.forwardline.api.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.forwardline.exception.QueryException;

public class APIPropertiesDAO {
	public Map<String, String> getAPIProperties() throws QueryException {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ConnectionManager cm = null;
		try {
			cm = ConnectionManager.getInstance();
			Connection conn = cm.getConnection();
			pStmt = conn.prepareStatement("select Property_Name, Property_Value from API_Properties");
			rs = pStmt.executeQuery();
			if (rs.next())
				propertiesMap.put(rs.getString(1), rs.getString(2));
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
