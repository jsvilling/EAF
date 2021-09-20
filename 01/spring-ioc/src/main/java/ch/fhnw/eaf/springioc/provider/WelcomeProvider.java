package ch.fhnw.eaf.springioc.provider;

import ch.fhnw.eaf.springioc.api.MessageProvider;
import org.springframework.stereotype.Service;

@Service
public class WelcomeProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Welcome";
    }
}
