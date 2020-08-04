package ru.sapphirelife;

import org.bukkit.ChatColor;

public class Logger {

    /*
    Что-то вроде "улучшенного" логгера от баккит
     */

    private String prefix;
    private ChatColor color;

    public Logger() {
        prefix = null;
        color = null;
    }

    public void log(String message) {
        // обычное логирование с выводом префикса
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

    public void log(String... messages) {
        // логирование ввиде сразу нескольких строк
        for (String message : messages) {
            log(message);
        }
    }

    public void setPrefix(String prefix) {
        // имейте ввиду, что пробел после префикса устанавливается автоматически
        this.prefix = prefix;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }
}
