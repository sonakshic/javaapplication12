package com.example.javaservice;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.javaresponse.AccessTokenResponseDTO;

@Service
public class PaypalServiceImpl implements PaypalService{

	@Override
	public AccessTokenResponseDTO getToken() throws IOException {

		PayPalClient client = new PayPalClient();

		return client.getToken();
	}
}
