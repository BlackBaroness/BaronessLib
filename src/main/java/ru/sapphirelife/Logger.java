package ru.sapphirelife;

import org.bukkit.ChatColor;

/**
 * Logger with support for multiple messages, color, and prefix.
 * An excellent replacement for the standard logger from Bukkit.
 */
public class Logger {

    private String prefix;
    private ChatColor color;

    /**
     * Instantiates a new Logger.
     */
    public Logger() {
        prefix = null;
        color = null;
    }

    /**
     * Log with prefix and color.
     *
     * @param message the message
     */
    public void log(String message) {
        StringBuilder builder = new StringBuilder();

        if (prefix != null) builder.append(prefix).append(" ");
        if (color != null) {
            builder.append(color);
        } else {
            builder.append(ChatColor.WHITE);
        }
        builder.append(message);

        System.out.println(builder.toString());
    }

    /**
     * Logging multiple rows at once.
     *
     * @param messages the messages
     */
    public void log(String... messages) {
        for (String message : messages) {
            log(message);
        }
    }

    /**
     * Sets prefix.
     *
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(ChatColor color) {
        this.color = color;
    }
}
