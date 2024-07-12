package com.example.javaregistercontroller;

import java.io.IOException;

import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaresponse.AccessTokenResponseDTO;
import com.example.javaresposity.IResponse;
import com.example.javaservice.ExcelHelper;
import com.example.javaservice.PaypalService;
import com.example.javaservice.UserDetailsService;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaypalService paypalService;

	@Autowired
	UserDetailsService userdetailsservice;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<AccessTokenResponseDTO> genratetoken() throws IOException {

		String access_token = null;
		String scope = null;

		AccessTokenResponseDTO orderResp = null;

		try {
			orderResp = paypalService.getToken();
			if (Objects.nonNull(orderResp)) {
				access_token = orderResp.getAccessToken();
				scope = orderResp.getScope();

			}
		} catch (Exception e) {
			LOG.error("Invilaed access token", e);
			return new ResponseEntity<>(orderResp, HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(orderResp, HttpStatus.OK);

	}

//	@GetMapping("/download")
	@RequestMapping(value = "/download", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource> getFile() {
		String filename = "tutorials.xlsx";
		InputStreamResource file = new InputStreamResource(userdetailsservice.load());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}
}
