package com.forwardline.api.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.forwardline.api.pojo.Partner;
import com.forwardline.exception.QueryException;

public class PartnerDAO {

	public PartnerDAO() {
		// TODO Auto-generated constructor stub
	}

	public Partner getPartner(Partner p) throws QueryException {
		Partner partner = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ConnectionManager cm = null;
		try {
			cm = ConnectionManager.getInstance();
			Connection conn = cm.getConnection();
			pStmt = conn.prepareStatement("select Partner_Name, Partner_Id from Forwardline_Partner where Partner_Id = ? and User_Name = ? and Password = ?");
			pStmt.setString(1, p.getPartnerId());
			pStmt.setString(2, p.getUserName());
			pStmt.setString(3, p.getPassword());
			rs = pStmt.executeQuery();
			if (rs.next()) {
				partner = new Partner();
				partner.setPartnerName(rs.getString(1));
				partner.setPartnerId(rs.getString(2));
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
		return partner;
	}
}
