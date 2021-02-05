package com.github.truereassembly.chattools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SlowChat implements CommandExecutor {

    public int slowCount;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) { return false; }
        try {
            Integer.parseInt(args[0]);
        } catch(NumberFormatException numberFormatException) {
            sender.sendMessage(ChatColor.RED + "You need to supply a whole number in seconds.");
            return false;
        }
        slowCount = Integer.parseInt(args[0]) * 1000;
        String template = ChatColor.translateAlternateColorCodes('&', "&7[ChatTools] &6%s &7set the slowmode to &6%s &7seconds!");
        String result = String.format(template, player.getDisplayName(), args[0]);
        Bukkit.broadcastMessage(result);
        return true;

    }
}
