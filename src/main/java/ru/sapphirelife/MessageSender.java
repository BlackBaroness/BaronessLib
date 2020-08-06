package ru.sapphirelife;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Convenient class for sending messages to players.
 */
public class MessageSender {

    private String prefix;
    private ChatColor color;

    /**
     * Instantiates a new MessageSender.
     */
    public MessageSender() {
        prefix = null;
        color = ChatColor.WHITE;
    }

    /**
     * Sends a message with prefix and color.
     *
     * @param player  the player
     * @param message the message
     */
    public void say(Player player, String message) {
        StringBuilder builder = new StringBuilder();

        if (prefix != null) builder.append(prefix).append(" ");
        builder.append(color);
        builder.append(message);

        player.sendMessage(builder.toString());
    }

    /**
     * Sends a lot of messages.
     *
     * @param player   the player
     * @param messages the messages
     */
    public void say(Player player, String... messages) {
        for (String message : messages) {
            say(player, message);
        }
    }

    /**
     * Sends message later.
     *
     * @param p       the p
     * @param message the message
     * @param ticks   the ticks
     * @param plugin  the plugin
     */
    public void saylater(Player p, String message, int ticks, JavaPlugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                say(p, message);
            }
        }.runTaskLater(plugin, ticks);
    }

    /**
     * Sets prefix for MessageSender.
     *
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Sets color for MessageSender.
     *
     * @param color the color
     */
    public void setColor(ChatColor color) {
        this.color = color;
    }
}
