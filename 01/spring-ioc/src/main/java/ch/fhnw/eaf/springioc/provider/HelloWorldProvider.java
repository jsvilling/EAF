package ch.fhnw.eaf.springioc.provider;

import ch.fhnw.eaf.springioc.api.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class HelloWorldProvider implements MessageProvider {

    final String message;

    public HelloWorldProvider(@Value(value = "${message.hello-world}") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
