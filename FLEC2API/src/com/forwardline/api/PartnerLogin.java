package com.forwardline.api;

import com.forwardline.api.persistence.PartnerDAO;
import com.forwardline.api.pojo.Partner;
import com.forwardline.exception.DataAccessException;
import com.forwardline.exception.QueryException;

public class PartnerLogin {

	public PartnerLogin() {
	}

	public boolean isPartnerAuthorized(Partner p) throws DataAccessException {
		try {
			PartnerDAO dao = new PartnerDAO();
			Partner partner = dao.getPartner(p);
			if (partner != null)
				return true;
		} catch (QueryException e) {
			throw new DataAccessException(e.getMessage());
		}
		return false;
	}
}
