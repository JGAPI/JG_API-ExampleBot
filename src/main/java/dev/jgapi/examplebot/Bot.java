package dev.jgapi.examplebot;

import dev.jgapi.examplebot.config.ConfigManager;
import dev.jgapi.examplebot.handlers.EventHandler;
import dev.jgapi.jg_api.JG_API;

public class Bot {
    static JG_API jg_api;

    public static void main(String[] args) {
        try {
            jg_api = new JG_API.ClientBuilder()
                    .setParentServerId(ConfigManager.getInstance().getProperty("GUILDED_SERVER_ID"))
                    .setToken(ConfigManager.getInstance().getProperty("GUILDED_TOKEN"))
                    .addListenerAdapter(new EventHandler())
                    .build();

            jg_api.login();
            jg_api.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
