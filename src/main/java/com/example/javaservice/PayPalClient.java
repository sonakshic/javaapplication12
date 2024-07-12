package com.example.javaservice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.javadomain.Constant;
import com.example.javaresponse.AccessTokenResponseDTO;

@Component
public class PayPalClient {

	private static final Logger LOG = LoggerFactory.getLogger(PayPalClient.class);

	public AccessTokenResponseDTO getToken() throws IOException {

		String baseurl = "https://api.sandbox.paypal.com";

		StringBuilder data = new StringBuilder();

		byte[] byteArray = data.toString().getBytes("UTF-8");

		String createOrdersUrl = UriComponentsBuilder.fromUriString(baseurl).path(Constant.GET_ACCESS_TOKEN).build()
				.toUriString();

		URL obj = new URL(createOrdersUrl);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Content-Length", "" + byteArray.length);

		RestTemplate restTemplate = new RestTemplate();

		// Specify the http headers that we want to attach to the request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization",
				createAuthHeaderString(
						"AU01KwYGSwsMS1gHX9CfYr4QWB4dfrRp_3Dk9DKY9_prihIK0LsOs-BGEvNUk5z07m24Kg8g2Md4qy7X",
						"EHj-7iVcqXIZMdZTpUxuY1uFSxwUjZpo5KhepVt_8mo09OfWYxoqOdaDRJRPThHvdXF_Ewv_zJPtFge1"));

		// Create a map of the key/value pairs that we want to supply in the body of the
		// request
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "client_credentials");

		// Create an HttpEntity object, wrapping the body and headers of the request
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		// Execute the request, as a POSt, and expecting a TokenResponse object in
		// return
		ResponseEntity<AccessTokenResponseDTO> response = restTemplate.exchange(createOrdersUrl, HttpMethod.POST,
				entity, AccessTokenResponseDTO.class);

		return response.getBody();
	}

	// Just a helper metod to create the basic auth header
	private String createAuthHeaderString(String username, String password) {
		String auth = username + ":" + password;
//	        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
		String authHeader = "Basic " + new String(encodedAuth);
		return authHeader;
	}

}
