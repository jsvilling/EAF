package ch.fhnw.eaf.springioc.renderer;

import ch.fhnw.eaf.springioc.api.MessageProvider;
import ch.fhnw.eaf.springioc.api.MessageRenderer;
import org.springframework.stereotype.Service;

@Service
public class StandardErrorRenderer implements MessageRenderer {

    private final MessageProvider messageProvider;

    public StandardErrorRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        System.err.println(messageProvider.getMessage());
    }
}
