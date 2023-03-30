package com.att.tlv.training.java.answers.records;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.util.Objects.requireNonNull;

public class RecordsAnswer {
    /**
     * Make this class a record with two header components: URL baseUrl and Duration responseTimeout </br>
     * <ul>
     * <li>If a null baseUrl is passed into the c'tor, throw a NPE with the following message: "baseUrl must not be null".</li>
     * <li>If a null responseTimeout is passed into the c'tor, throw a NPE with the following message: "responseTimeout must not be null".</li>
     * <li>Add a non-canonical c'tor that accepts URL baseUrl and sets responseTimeout to 10s.</li>
     * <li>Add a static factory method of(String baseUrl) that creates an HttpClientProperties.</li>
     * <li>Add an instance method baseUrlProtocol() that returns the baseUrl protocol.</li>
     * <li>Remove methods that are not needed.</li>
     * </ul>
     */
    record HttpClientProperties(URL baseUrl, Duration responseTimeout) {
        public HttpClientProperties {
            requireNonNull(baseUrl, "baseUrl must not be null");
            requireNonNull(responseTimeout, "responseTimeout must not be null");
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
