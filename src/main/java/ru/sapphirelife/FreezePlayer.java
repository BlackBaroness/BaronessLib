package ru.sapphirelife;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * No more than a service listener for the Freezer class.
 */
public class FreezePlayer implements Listener {

    private final Player player;

    /**
     * Instantiates a new FreezePlayer.
     *
     * @param core   the JavaPlugin
     * @param player the player
     */
    protected FreezePlayer(JavaPlugin core, Player player) {
        Bukkit.getPluginManager().registerEvents(this, core);
        this.player = player;
    }

    @EventHandler(ignoreCancelled = true)
    private void onPlayerMove(PlayerMoveEvent event) {
        if (event.getPlayer().equals(player)) event.setCancelled(true);
    }


    /**
     * Unregister this listener.
     *
     * @return this (for quick removing from list)
     */
    public FreezePlayer unregister() {
        HandlerList.unregisterAll(this);
        return this;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
}
