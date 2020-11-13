package com.github.truereassembly.chattools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SlowChat implements CommandExecutor {

    public int slowCount;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*Player player = (Player) sender;
        if (args.length == 0) { return false; }
        slowCount = Integer.parseInt(args[0]);
        String template = ChatColor.translateAlternateColorCodes('&', "&7[ChatTools] &6%s &7set the slowmode to &6%s &7seconds!");
        String result = String.format(template, player.getDisplayName(), slowCount);
        Bukkit.broadcastMessage(result);*/

        sender.sendMessage("This command is in development");
        return true;

    }
}
