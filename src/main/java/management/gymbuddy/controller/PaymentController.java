package management.gymbuddy.controller;

import management.gymbuddy.dto.MakePaymentRequestDTO;
import management.gymbuddy.dto.PaymentResponseDTO;
import management.gymbuddy.service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PaymentController {

    @Autowired
    private PaymentTransactionService paymentTransactionService;
    @RequestMapping(path = "/makepayment", method = RequestMethod.POST)
    public PaymentResponseDTO makePayment(
            @RequestBody MakePaymentRequestDTO makePaymentRequestDTO) {
        PaymentResponseDTO makePaymentRequest =
                paymentTransactionService.initializeTransaction(makePaymentRequestDTO);
        return makePaymentRequest;
    }
}
