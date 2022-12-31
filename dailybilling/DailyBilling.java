package br.com.charles.challenge.dailybilling;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class DailyBilling {

    public int day;
    public BigDecimal value;

    public DailyBilling() {
    }

    public boolean invoicing(String path) throws IOException {
        DailyBilling[] dailyBillings = openFile(path);
        BigDecimal largerValue = BigDecimal.ZERO;
        BigDecimal lowerValue = BigDecimal.ZERO;
        BigDecimal average = BigDecimal.ZERO;
        byte count = 0;

        for (DailyBilling invoicing : dailyBillings) {
            average = average.add(invoicing.value);

            if (count == 0 || invoicing.value.compareTo(BigDecimal.ZERO) > 0 && invoicing.value.compareTo(lowerValue) < 0) {
                lowerValue = invoicing.value;
            }

            if (invoicing.value.compareTo(largerValue) > 0) {
                largerValue = invoicing.value;
            }

            if (invoicing.day > 0) {
                count++;
            }
        }

        average = average.divide(BigDecimal.valueOf(count), 4, RoundingMode.HALF_UP);
        count = 0;

        for (DailyBilling invoicing : dailyBillings) {
            if (invoicing.value.compareTo(average) > 0) {
                count++;
            }
        }

        Map<String, BigDecimal> invoicingResult = new HashMap<>();
        invoicingResult.put("Menor Valor", lowerValue);
        invoicingResult.put("Maior Valor", largerValue);
        invoicingResult.put("Média do mês", average);
        invoicingResult.put("Dias com vendas acima da média", BigDecimal.valueOf(count));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/resources/invoicingResult.json"), invoicingResult);
        return true;
    }

    private DailyBilling[] openFile(String path) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DailyBilling[] dailyBillings = objectMapper.readValue(new File(path), DailyBilling[].class);
            return dailyBillings;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo não encontrado");
        } catch (NullPointerException e) {
            throw new NullPointerException("O caminho do arquivo é nulo");
        }
    }
}
