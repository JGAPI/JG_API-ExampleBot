package dev.JGAPI.ExampleBot;

import dev.JGAPI.ExampleBot.Config.ConfigManager;
import dev.JGAPI.JG_API.Exceptions.ClientBuildException;
import dev.JGAPI.JG_API.JG_API;

public class Bot {

    public static void main(String[] args) throws ClientBuildException {
        JG_API jg_api = new JG_API.ClientBuilder()
                .setParentServerId(ConfigManager.getInstance().getProperty("GUILDED_SERVER_ID"))
                .setToken(ConfigManager.getInstance().getProperty("GUILDED_TOKEN"))
                .build();

        jg_api.login();
        jg_api.start();
    }
}
