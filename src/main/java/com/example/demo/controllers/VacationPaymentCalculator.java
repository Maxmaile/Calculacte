package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPaymentCalculator {

    @GetMapping("/calculacte")
    public double calculateVacationPayment(@RequestParam int vocation,
                                           @RequestParam double average) {
//        if (vocation == null || average == null) {
//            throw new IllegalArgumentException("Продолжительность отпуска или средий доход не могут быть незаполненными");
//        }
        if (vocation < 0 || average < 0) {
            throw new IllegalArgumentException("Продолжительность отпуска и средний доход не могут быть отрицательным");
        }
        if (average == 0) {
            throw new IllegalArgumentException("Средний доход не может быть нулевым");
        }
        return (((average / 12) / 22) * vocation);
    }
}