package com.dev.OpsVault.controller;

import com.dev.OpsVault.service.ThymeleafServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//Just to test PDF generation
@RestController
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    ThymeleafServiceImpl thymeleafService;

    @Value("${directory}")
    String path;

    //Call this request to generate test.pdf
    @GetMapping
    public ResponseEntity<String> generatePdf() {

        //Data to be put in PDF
        Map<String,Object> testData = new HashMap<>();
        testData.put("testString", "Working!!!");

        thymeleafService.generatePdf(
                "test",
                testData,
                "testPdf"
        );

        // Replacing any "\\" with "\"
        String directory = path.replaceAll("\\\\\\\\","\\\\");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Check path: " + directory + "testPdf.pdf");
    }

}
