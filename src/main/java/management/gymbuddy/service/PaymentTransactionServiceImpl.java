package management.gymbuddy.service;

import management.gymbuddy.dto.MakePaymentRequestDTO;
import management.gymbuddy.dto.PaymentResponseDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PaymentTransactionServiceImpl implements PaymentTransactionService{

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public PaymentResponseDTO initializeTransaction(MakePaymentRequestDTO makePaymentRequestDTO)  {
        String reference = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        String key = "sk_test_b2ffbedf2d7b2cf10229235415ba2dac551c684e";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + key);
        makePaymentRequestDTO.setReference(reference);
        HttpEntity<MakePaymentRequestDTO> entity = new
                HttpEntity<MakePaymentRequestDTO>(makePaymentRequestDTO, headers);

        ResponseEntity<PaymentResponseDTO> response =
                restTemplate.postForEntity(url, entity, PaymentResponseDTO.class);

        return response.getBody();

    }
}
