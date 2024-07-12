package com.example.javaservice;

import java.io.IOException;

import com.example.javaresponse.AccessTokenResponseDTO;

public interface PaypalService {
	AccessTokenResponseDTO getToken() throws IOException;

}
