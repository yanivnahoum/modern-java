package com.att.tlv.training.java.answers.records;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.util.Objects.requireNonNull;

public class RecordsAnswer {
    record HttpClientProperties(URL baseUrl, Duration reponseTimeout) {
        public HttpClientProperties {
            requireNonNull(baseUrl, "baseUrl must not be null");
            requireNonNull(reponseTimeout, "responseTimeout must not be null");
        }

        public HttpClientProperties(URL baseUrl) {
            this(baseUrl, Duration.ofSeconds(10));
        }

        public static HttpClientProperties of(String baseUrl) throws MalformedURLException {
            return new HttpClientProperties(new URL(baseUrl));
        }

        public String baseUrlProtocol() throws MalformedURLException {
            return baseUrl.getProtocol();
        }
    }
}
