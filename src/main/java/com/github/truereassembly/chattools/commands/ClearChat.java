package com.github.truereassembly.chattools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ClearChat implements CommandExecutor {
    int i = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        for (Player p : Bukkit.getOnlinePlayers()) {
            for (i = 0; i < 150; i++) {
                p.sendMessage("");
            }
        }
        String template = ChatColor.translateAlternateColorCodes('&', "&7[ChatTools] &6%s &7cleared the chat");
        String result = String.format(template, player.getDisplayName());
        Bukkit.broadcastMessage(result);
        return true;
    }
}
