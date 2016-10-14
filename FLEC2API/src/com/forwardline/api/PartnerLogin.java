package com.forwardline.api;

import com.forwardline.api.persistence.PartnerDAO;
import com.forwardline.api.pojo.Partner;
import com.forwardline.exception.DataAccessException;
import com.forwardline.exception.QueryException;

public class PartnerLogin {
	private Partner partner;
	
	public PartnerLogin() {
	}

	public boolean isPartnerAuthorized(Partner p) throws DataAccessException {
		try {
			PartnerDAO dao = new PartnerDAO();
			this.partner = dao.getPartner(p);
			if (this.partner != null)
				return true;
		} catch (QueryException e) {
			throw new DataAccessException(e.getMessage());
		}
		return false;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}
}
