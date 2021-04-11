package br.com.rtrancoso.notification.worker.channel;

import br.com.rtrancoso.notification.commons.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChannelNotifierSupplier {

    private final Map<String, ChannelNotifier> channelsNotifier;

    public ChannelNotifier supplyChannelNotifier(Notification.Channel channel) {
        return channelsNotifier.entrySet().stream().filter(entry -> entry.getValue().getChannel() == channel).findFirst().orElseThrow(
            () -> new IllegalArgumentException(String.format("ChannelNotifier of channel '%s' not found", channel))).getValue();
    }

}
