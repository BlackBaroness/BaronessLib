package ru.sapphirelife;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


/**
 * Class for effective freezing and defreezing of players
 */
public class Freezer {

    private final JavaPlugin plugin;
    private final List<FreezePlayer> freezedList = new ArrayList<>();

    /**
     * Instantiates a new Freezer.
     *
     * @param plugin the JavaPlugin
     */
    public Freezer(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    /**
     * Freeze player.
     *
     * @param player the player
     */
    public void freezePlayer(Player player) {
        freezedList.add(new FreezePlayer(plugin, player));
    }

    /**
     * Unfreeze player.
     *
     * @param player the player
     */
    public void unfreezePlayer(Player player) {
        for (FreezePlayer freezePlayer : freezedList) {
            if (freezePlayer.getPlayer().equals(player))
                freezedList.remove(freezePlayer.unregister());
        }
    }
}

class FreezePlayer implements Listener {

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