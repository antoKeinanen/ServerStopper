package dev.antok.serverstopper.listener;

import dev.antok.serverstopper.ServerStopper;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class JoinListener implements Listener {
    private ServerStopper main;
    private Server server;
    private Logger logger;
    LeaveListener leaveListener;

    public JoinListener(ServerStopper main, LeaveListener leaveListener) {
        this.main = main;
        this.server = main.getServer();
        this.logger = main.getLogger();
        this.leaveListener = leaveListener;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (this.leaveListener.taskId != null) {
            this.logger.info("Server shutdown cancelled!");
            this.server.getScheduler().cancelTask(this.leaveListener.taskId);
            this.leaveListener.taskId = null;
        }
    }

}
