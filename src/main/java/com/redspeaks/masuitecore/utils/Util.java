package com.redspeaks.masuitecore.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

public class Util {

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(
                new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)))
        );
    }
}
