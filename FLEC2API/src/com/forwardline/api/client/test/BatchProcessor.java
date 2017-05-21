package com.forwardline.api.client.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.exception.QueryException;
import com.forwardline.util.APIUtil;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class BatchProcessor {

	private Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// String url = "jdbc:mysql://" + host + ":" + port + "/" + db +
			// "?user=" + userName + "&password=" + password;
			// String url = System.getProperty("JDBC_CONNECTION_STRING");
			// Dev
			// String url =
			// "jdbc:mysql://aaof84atcb0bk1.c3jldtex5t6b.us-west-2.rds.amazonaws.com:3306/flapimysqldb?user=fladmin&password=!#FlFiN16app--$";
			// Production
			String url = "jdbc:mysql://aa1l1i5iv3j4ye3.cjq0nqtekxcq.us-west-2.rds.amazonaws.com:3306/apollo?user=awsdbadmin&password=5huaerHWgh";
			System.out.println(url);
			return DriverManager.getConnection(url);
		} catch (Exception e) {
			throw e;
		}
	}

	private List<String> getRequestsToProcess() throws QueryException {
		List<String> requests = new ArrayList<String>();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = getConnection();
			//pStmt = conn.prepareStatement("SELECT Request FROM apollo.Forwardline_Partner_API_Log where Log_Id >= 746 and Log_Id <= 756 and Response like '%java.lang.%' order by Log_Id asc");
			pStmt = conn.prepareStatement("SELECT Request FROM apollo.Forwardline_Partner_API_Log where Log_Id >= 721 and Log_Id <= 732 order by Log_Id asc");
			rs = pStmt.executeQuery();
			while (rs.next())
				requests.add(rs.getString(1));
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
				conn.close();
			} catch (SQLException sqe) {
				throw new QueryException(sqe.getMessage());
			}
		}
		return requests;
	}

	public void process(String endPoint) {
		try {
			List<String> requests = getRequestsToProcess();
			System.out.println("Number of requests to process " + requests.size());

			for (String requestJSON : requests) {
				System.out.println(requestJSON);
				/*
				FunderaRequest request = new FunderaRequest();
				ClientConfig clientConfig = new DefaultClientConfig();
				clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				Client client = Client.create(clientConfig);
				WebResource webResource = client.resource(endPoint);

				Gson gson = new Gson();
				request = gson.fromJson(requestJSON, FunderaRequest.class);

				System.out.println("Request >> " + requestJSON);
				String s = "FunderAPIUser:1472676134675";
				ClientResponse response = webResource.accept("application/json").type("application/json").header("Authorization", "Basic " + APIUtil.encode(s)).post(ClientResponse.class, request);
				System.out.println(response.toString());
				System.out.println(response.getEntity(String.class));
				*/
			}
			
			System.out.println("**** Process Completed ****");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BatchProcessor bp = new BatchProcessor();
		bp.process("https://api.forwardline.com/partner/fundera/getOffer");
	}
}
