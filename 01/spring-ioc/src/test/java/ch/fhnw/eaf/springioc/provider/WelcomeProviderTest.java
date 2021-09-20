package ch.fhnw.eaf.springioc.provider;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeProviderTest {

    private final WelcomeProvider welcomeProvider = new WelcomeProvider();

    @Test
    void tetWelcomeProvider() {
        // Given
        // When
        final String message = welcomeProvider.getMessage();

        // Then
        assertThat(message).isEqualTo(message);
    }

}
