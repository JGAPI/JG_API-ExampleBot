/*
    Credit to Bo$$#9004 for this Manager.
 */
package dev.JGAPI.ExampleBot.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class ConfigManager {
    private static final ConfigManager instance;

    static {
        instance = new ConfigManager();
    }

    private final Properties props;

    private ConfigManager() {
        final File file = new File("config.properties");
        if (!file.exists()) {
            throw new RuntimeException("config.properties file missing");
        }

        this.props = new Properties();
        try (final BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            this.props.load(reader);
        } catch (final IOException err) {
            throw new RuntimeException("An error occurred while loading config file.");
        }
    }

    public String getProperty(String key) {
        return this.props.getProperty(key);
    }

    public static ConfigManager getInstance() {
        return instance;
    }
}
