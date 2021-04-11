package br.com.rtrancoso.notification.worker.channel;

import br.com.rtrancoso.notification.commons.model.Notification;

public interface ChannelNotifier {

    Notification.Channel getChannel();

    void dispatchEvent(String notificationId);

}
