package dev.JGAPI.ExampleBot;

import dev.JGAPI.ExampleBot.Config.ConfigManager;
import dev.JGAPI.JG_API.JG_API;

public class Bot {
    static JG_API jg_api;

    public static void main(String[] args) {
        try {
            jg_api = new JG_API.ClientBuilder()
                    .setParentServerId(ConfigManager.getInstance().getProperty("GUILDED_SERVER_ID"))
                    .setToken(ConfigManager.getInstance().getProperty("GUILDED_TOKEN"))
                    .build();

            jg_api.login();
            jg_api.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
