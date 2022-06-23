package dev.jgapi.examplebot.handlers;

import dev.jgapi.examplebot.config.ConfigManager;
import dev.jgapi.jg_api.ListenerAdapter;
import dev.jgapi.jg_api.entities.chat.ChatMessage;
import dev.jgapi.jg_api.events.chat.ChatMessageCreatedEvent;
import dev.jgapi.jg_api.events.library.ReadyEvent;

import java.util.List;

public class EventHandler extends ListenerAdapter {
    @Override
    public void onReadyEvent(ReadyEvent event) {
        System.out.println(event.getJGAPI().getClientUser().getName() + " is now ready!");
    }

    @Override
    public void onChatMessageCreatedEvent(ChatMessageCreatedEvent event) {
        ChatMessage message = event.getMessage();
        String content = message.getContent();

        if (!content.startsWith(ConfigManager.getInstance().getProperty("PREFIX"))) return;

        content = content.substring(1);
        List<String> args = new java.util.ArrayList<>(List.of(content.split(" ")));
        String command = args.get(0);
        args.remove(0);

        if (command.equalsIgnoreCase("ping")) {
            message.getChannel().sendMessage("pong!").queue();
        }
    }
}
