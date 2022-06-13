package dev.jgapi.examplebot.handlers;

import dev.jgapi.jg_api.events.library.ReadyEvent;
import dev.jgapi.jg_api.ListenerAdapter;

public class EventHandler extends ListenerAdapter {
    @Override
    public void onReadyEvent(ReadyEvent event) {
        System.out.println(event.getJGAPI().getClientUser().getName() + " is now ready!");
    }
}
