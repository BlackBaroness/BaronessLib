package ru.sapphirelife;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MessageSender {

    /*
    Класс для удобного "общения" с игроками
    Можете забыть о создании отдельных методов с префиксами и так далее
     */

    private String prefix;
    private ChatColor color;

    public MessageSender() {
        prefix = null;
        color = null;
    }

    public void say(Player p, String message) {
        // отправка одного сообщения
        StringBuilder builder = new StringBuilder();

        if (prefix != null) builder.append(prefix).append(" ");
        if (color != null) {
            builder.append(color);
        } else {
            builder.append(ChatColor.WHITE);
        }
        builder.append(message);

        p.sendMessage(builder.toString());
    }

    public void say(Player p, String... messages) {
        // отправка множества сообщений
        for (String message : messages) {
            say(p, message);
        }
    }

    public void saylater(Player p, String message, int ticks, JavaPlugin plugin) {
        // отправка сообщения через указанное время
        new BukkitRunnable() {
            @Override
            public void run() {
                say(p, message);
            }
        }.runTaskLater(plugin, ticks);
    }

    public void setPrefix(String prefix) {
        // имейте ввиду, что пробел после префикса устанавливается автоматически
        this.prefix = prefix;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }
}
