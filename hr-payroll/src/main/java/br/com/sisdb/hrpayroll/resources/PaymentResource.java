package br.com.sisdb.hrpayroll.resources;

import br.com.sisdb.hrpayroll.entities.Payment;
import br.com.sisdb.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = service.getPayment(workerId, days);

        return ResponseEntity.ok(payment);
    }
    public ResponseEntity<Payment> getPaymentAlternative( Long workerId,  Integer days) {
         Payment payment = new Payment("Brannn", 400.09, days);
         return ResponseEntity.ok(payment);
    }
}











