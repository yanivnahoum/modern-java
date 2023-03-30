package com.att.tlv.training.java.exercises.records;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecordsTest {

    private static final URL BASE_URL = createURL();

    @Test
    void shouldBeARecord() {
        assertThat(HttpClientProperties.class.isRecord()).isTrue();
    }

    @Test
    void whenCreatedWithUrlAndResponseTimeout_thenBothAreCorrect() {
        var reponseTimeout = Duration.ofSeconds(42);
        var httpClientProperties = new HttpClientProperties(BASE_URL, reponseTimeout);
        assertThat(httpClientProperties.baseUrl()).isEqualTo(BASE_URL);
        assertThat(httpClientProperties.responseTimeout()).isEqualTo(reponseTimeout);
    }

    @Test
    void whenCreatedWithUrlOnly_thenResponseTimeoutIs10Seconds() {
        var httpClientProperties = new HttpClientProperties(BASE_URL);
        assertThat(httpClientProperties.responseTimeout()).isEqualTo(Duration.ofSeconds(10));
    }

    @Test
    void whenCreatedWithUrlAsString_thenBaseUrlIsCorrectAndResponseTimeoutIs10Seconds() throws MalformedURLException {
        var httpClientProperties = HttpClientProperties.of(BASE_URL.toString());
        assertThat(httpClientProperties.baseUrl()).isEqualTo(BASE_URL);
        assertThat(httpClientProperties.responseTimeout()).isEqualTo(Duration.ofSeconds(10));
    }

    @Test
    void baseUrlProtocol_shouldReturnProtocolCorrectly(@Mock URL url) throws MalformedURLException {
        var protocol = "protocol";
        when(url.getProtocol()).thenReturn(protocol);
        var httpClientProperties = new HttpClientProperties(url);
        assertThat(httpClientProperties.baseUrlProtocol()).isEqualTo(protocol);
    }

    @Test
    void givenBaseUrlNull_whenCreated_thenNPEisThrown() {
        assertThatNullPointerException().isThrownBy(
                () -> new HttpClientProperties(null, null)
        ).withMessage("baseUrl must not be null");
    }

    @Test
    void givenResponseTimeoutNull_whenCreated_thenNPEisThrown() throws MalformedURLException {
        assertThatNullPointerException().isThrownBy(
                () -> new HttpClientProperties(BASE_URL, null)
        ).withMessage("responseTimeout must not be null");
    }

    private static URL createURL() {
        try {
            return new URL("https://www.google.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}