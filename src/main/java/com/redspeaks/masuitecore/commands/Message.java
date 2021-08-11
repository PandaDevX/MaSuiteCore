package com.redspeaks.masuitecore.commands;

import com.redspeaks.masuitecore.MaSuiteCore;
import com.redspeaks.masuitecore.utils.Util;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Message extends Command {

    public Message() {
        super("message", "msc.message", "msg");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!hasPermission(sender)) {
            Util.sendMessage(sender, "&cYou have no permission to do that!");
            return;
        }

        if(args.length < 2) {
            Util.sendMessage(sender, "&b/message <player> <message>");
            return;
        }
        ProxiedPlayer target = MaSuiteCore.getInstance().getProxy().getPlayer(args[0]);
        if(target == null) {
            Util.sendMessage(sender, "&cPlayer not found!");
            return;
        }

        StringBuilder message = new StringBuilder();
        for(int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }
        String finalMessage = message.toString().trim();


        Util.sendMessage(target, finalMessage);
        Util.sendMessage(sender, finalMessage);
    }
}
