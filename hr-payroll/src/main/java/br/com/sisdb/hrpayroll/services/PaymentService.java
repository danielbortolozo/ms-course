package br.com.sisdb.hrpayroll.services;

import br.com.sisdb.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workId, int days) {
         return new Payment("Bob", 200.0, days);
    }
}









