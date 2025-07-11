package com.plexprison.serverpersistence;

import com.plexprison.serverpersistence.game.EmptyGame;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
public class ServerPersistence extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Wait for all other plugins to be enabled
        new BukkitRunnable() {
            @Override
            public void run() {
                final PluginManager pluginManager = ServerPersistence.this.getServer().getPluginManager();
                boolean allPluginsEnabled = true;

                // Check if all plugins except this one are enabled
                for (final Plugin plugin : pluginManager.getPlugins()) {
                    if (!plugin.equals(ServerPersistence.this) && !plugin.isEnabled()) {
                        allPluginsEnabled = false;
                        break;
                    }
                }

                if (allPluginsEnabled) {
                    // All plugins are enabled, call setState
                    ServerPersistence.setState();
                    this.cancel();
                }
            }
        }.runTaskTimer(this, 1L, 1L); // Check every tick until all plugins are enabled
    }

    private static void setState() {
        new EmptyGame().setup();
    }

}