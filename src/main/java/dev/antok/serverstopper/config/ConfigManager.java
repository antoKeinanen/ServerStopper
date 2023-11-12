package dev.antok.serverstopper.config;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import dev.antok.serverstopper.ServerStopper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ConfigManager {

    public Config config;

    public ConfigManager(ServerStopper main) {
        final Logger logger = main.getLogger();
        final File configFile = Paths.get(main.getDataFolder().getPath(), "config.toml").toFile();

        if (!configFile.exists()) {
            logger.info("No configuration found. Creating...");

            TomlWriter tomlWriter = new TomlWriter.Builder().build();

            main.getDataFolder().mkdirs();

            try {
                tomlWriter.write(createNewConfig(), configFile);
                logger.info("Configuration created successfully!");
            } catch (IOException e) {
                logger.severe(e.getMessage());
                return;
            }
        }

        logger.info("Loading configuration...");
        this.config = new Toml().read(configFile).to(Config.class);

        if (this.config == null) {
            logger.severe("Failed to load configuration!");
        }
    }


    Config createNewConfig() {
        return new Config(6000);
    }
}
