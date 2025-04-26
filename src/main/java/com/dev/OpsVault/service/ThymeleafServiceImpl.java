package com.dev.OpsVault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class ThymeleafServiceImpl implements ThymeleafService  {

    @Autowired
    TemplateEngine templateEngine;

    @Value("${directory}")
    String path;

    /**
     * This method puts data into templateName.html and generates a fileName.pdf
     *
     * @param templateName PDF file name without extension
     * @param data Map of data to be put in PDF
     * @param fileName Name of the PDF file to be generated (without extension)
     */
    @Override
    public void generatePdf(
            String templateName,
            Map<String, Object> data,
            String fileName
    ) {
        Context context = new Context();
        context.setVariables(data);

        String htmlPage  = templateEngine.process(
                templateName,
                context
        );

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path+fileName);
            ITextRenderer renderer  = new ITextRenderer();
            renderer.setDocumentFromString(htmlPage);
            renderer.layout();
            renderer.createPDF(
                    fileOutputStream,
                    false
            );
            renderer.finishPDF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
