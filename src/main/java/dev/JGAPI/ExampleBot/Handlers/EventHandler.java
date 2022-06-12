package dev.JGAPI.ExampleBot.Handlers;

import dev.JGAPI.JG_API.Events.Library.ReadyEvent;
import dev.JGAPI.JG_API.ListenerAdapter;

public class EventHandler extends ListenerAdapter {
    @Override
    public void onReadyEvent(ReadyEvent event) {
        System.out.println(event.getJGAPI().getClientUser().getName() + " is now ready!");
    }
}
