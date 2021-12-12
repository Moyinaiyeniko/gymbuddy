package management.gymbuddy.service;

import management.gymbuddy.dto.MakePaymentRequestDTO;
import management.gymbuddy.dto.PaymentResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface PaymentTransactionService {

    PaymentResponseDTO initializeTransaction(MakePaymentRequestDTO makePaymentRequestDTO);
}
