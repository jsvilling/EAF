package ch.fhnw.eaf.springioc.renderer;

import ch.fhnw.eaf.springioc.api.MessageProvider;
import ch.fhnw.eaf.springioc.api.MessageRenderer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class StandardOutRenderer implements MessageRenderer {

    private final MessageProvider messageProvider;

    public StandardOutRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}
