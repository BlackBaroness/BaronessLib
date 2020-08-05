package ru.sapphirelife;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


/**
 * Class for effective freezing and defrosting of players
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
