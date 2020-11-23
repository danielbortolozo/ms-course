package br.com.sisdb.hrpayroll.services;

import br.com.sisdb.hrpayroll.entities.Payment;
import br.com.sisdb.hrpayroll.entities.Worker;
import br.com.sisdb.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workId, int days) {

        Worker worker = workerFeignClient.findById(workId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}










