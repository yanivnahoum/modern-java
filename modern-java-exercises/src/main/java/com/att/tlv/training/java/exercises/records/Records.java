package com.att.tlv.training.java.exercises.records;


import com.att.tlv.training.java.exercises.Exercises;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Records {}

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
class HttpClientProperties {
    private URL baseUrl;

    private Duration responseTimeout;

    public HttpClientProperties(URL baseUrl, Duration reponseTimeout) {
        Exercises.replaceThisWithSolution();
    }

    public HttpClientProperties(URL baseUrl) {
        Exercises.replaceThisWithSolution();
    }

    public static HttpClientProperties of(String baseUrl) throws MalformedURLException {
        return Exercises.replaceThisWithSolution();
    }

    public String baseUrlProtocol() throws MalformedURLException {
        return Exercises.replaceThisWithSolution();
    }

    public URL baseUrl() {
        return Exercises.replaceThisWithSolution();
    }

    public Duration responseTimeout() {
        return Exercises.replaceThisWithSolution();
    }
}
