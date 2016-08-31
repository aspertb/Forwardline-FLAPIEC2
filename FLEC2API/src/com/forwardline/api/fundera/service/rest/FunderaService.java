package com.forwardline.api.fundera.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.forwardline.api.PartnerLogin;
import com.forwardline.api.fundera.FunderaAPIHelper;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.pojo.Partner;
import com.forwardline.exception.DataAccessException;
import com.forwardline.exception.InternalServerException;
import com.forwardline.exception.UnauthorizedException;
import com.forwardline.util.APIUtil;

@Path("/fundera/")
public class FunderaService {
	@POST
	@Path("/getOffer/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public FunderaResponse getOffer(@Context HttpHeaders headers, FunderaRequest fndRequest) throws UnauthorizedException, InternalServerException {
		if (headers.getRequestHeaders().containsKey("Authorization")) {
			String basicHeader = headers.getRequestHeader("Authorization").get(0);
			Partner p = getUserNameAndPasswordFromBasicHeader(basicHeader);
			p.setPartnerId("FUNDERA");
			try {
				if (new PartnerLogin().isPartnerAuthorized(p)) {
					FunderaAPIHelper fndHelper = new FunderaAPIHelper();
					return fndHelper.getOffers(fndRequest);
				} else
					throw new UnauthorizedException("Unauthorized.");
			} catch (DataAccessException dae) {
				dae.printStackTrace();
				throw new InternalServerException(dae.getMessage());
			}
		} else
			throw new UnauthorizedException("Authorization header not found. Authorization required.");
	}

	private Partner getUserNameAndPasswordFromBasicHeader(String basicHeader) throws UnauthorizedException {
		if (basicHeader != null) {
			String[] parts = basicHeader.split(" ");
			if (parts.length == 2) {
				String decodedHeaderValue = APIUtil.decode(parts[1]);
				parts = decodedHeaderValue.split(":");
				if (parts.length == 2) {
					Partner p = new Partner();
					p.setUserName(parts[0]);
					p.setPassword(parts[1]);
					return p;
				} else
					throw new UnauthorizedException("Malformed authorization header.");
			} else
				throw new UnauthorizedException("Malformed authorization header.");
		} else
			throw new UnauthorizedException("Invalid authorization header. Authorization header cannot be NULL.");
	}
}
