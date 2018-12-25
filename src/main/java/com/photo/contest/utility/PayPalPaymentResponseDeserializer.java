package com.photo.contest.utility;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.photo.contest.dto.PayPalPaymentResponseDTO;

public class PayPalPaymentResponseDeserializer /*extends StdDeserializer<PayPalPaymentResponseDTO>*/{

	/*protected PayPalPaymentResponseDeserializer(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PayPalPaymentResponseDTO deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		JsonNode node = jp.getCodec().readTree(jp);
		 
		String id = node.get("id").asText();
		
		System.out.println("PAYPAL id:"+id);
		
		return new PayPalPaymentResponseDTO(id);
	}*/

}
