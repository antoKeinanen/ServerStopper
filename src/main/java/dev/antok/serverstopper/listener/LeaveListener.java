package dev.antok.serverstopper.listener;

import dev.antok.serverstopper.ServerStopper;
import dev.antok.serverstopper.config.Config;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.logging.Logger;

public class LeaveListener implements Listener {
    private final ServerStopper main;
    private final Server server;
    private final Logger logger;
    private final Config config;
    Integer taskId = null;

    public LeaveListener(ServerStopper main, Config config) {
        this.main = main;
        this.server = main.getServer();
        this.logger = main.getLogger();
        this.config = config;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (this.server.getOnlinePlayers().size() == 1) {
            this.logger.info(String.format("Server shutting down in %d ticks...", this.config.delay));
            this.taskId = this.server.getScheduler().scheduleSyncDelayedTask(this.main, this.server::shutdown, this.config.delay);
        }
    }
}
