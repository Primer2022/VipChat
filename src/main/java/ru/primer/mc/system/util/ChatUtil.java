package ru.primer.mc.system.util;

import net.md_5.bungee.api.ChatColor;

public class ChatUtil {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
