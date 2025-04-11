package com.gabrielestudo.sistema_de_vendas.utils;

import org.springframework.stereotype.Component;

@Component("formatter")
public class FormatterUtils {
    public String formatCnpj(String cnpj) {
        if (cnpj == null || cnpj.length() != 14)
            return cnpj;

        return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }

    public String formatPhone(String phone) {
        if (phone == null)
            return phone;

        phone = phone.replaceAll("\\D", "");

        if (phone.length() == 11) { // phone: (11) 11111-1111
            return phone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        } else if (phone.length() == 10) { // phone: (11) 1111-1111
            return phone.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        }

        return phone;
    }
}
