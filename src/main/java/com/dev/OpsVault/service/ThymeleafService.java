package com.dev.OpsVault.service;

import java.util.Map;

public interface ThymeleafService {

    void generatePdf(
            String template,
            Map<String,  Object> data,
            String fileName
    );

}
