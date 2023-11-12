package dev.antok.serverstopper;

import dev.antok.serverstopper.config.Config;
import dev.antok.serverstopper.config.ConfigManager;
import dev.antok.serverstopper.listener.JoinListener;
import dev.antok.serverstopper.listener.LeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStopper extends JavaPlugin {
    @Override
    public void onEnable() {
        Config config = new ConfigManager(this).config;

        LeaveListener leaveListener = new LeaveListener(this, config);
        JoinListener joinListener = new JoinListener(this, leaveListener);

        this.getServer().getPluginManager().registerEvents(leaveListener, this);
        this.getServer().getPluginManager().registerEvents(joinListener, this);
    }
}