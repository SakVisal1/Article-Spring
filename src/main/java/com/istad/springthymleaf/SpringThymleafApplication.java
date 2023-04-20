package com.istad.springthymleaf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@SpringBootApplication
public class SpringThymleafApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale locale2 = LocaleContextHolder.getLocale();
        String countryName = locale2.getDisplayCountry();
        System.out.println("Country name is : " + countryName);

        String languageCode = locale2.getLanguage();
        System.out.println("Language Code is : " + languageCode);

        // write code to show all language code
        String[] languages = Locale.getISOLanguages();
        for (String lang : languages){
            Locale locale = new Locale(lang);
            System.out.println(locale.getLanguage()+ "->" + locale.getDisplayLanguage());
        }

    }
}
