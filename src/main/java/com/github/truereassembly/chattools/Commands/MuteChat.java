package com.github.truereassembly.chattools.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;


public class MuteChat implements CommandExecutor {


    public boolean chatMuted;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!chatMuted) {
            chatMuted = true;
            String template = ChatColor.translateAlternateColorCodes('&', "&7[ChatTools] &6%s &7muted the chat");
            String result = String.format(template, player.getDisplayName());
            Bukkit.broadcastMessage(result);
        } else {
            chatMuted = false;
            String template = ChatColor.translateAlternateColorCodes('&', "&7[ChatTools] &6%s &7unmuted the chat");
            String result = String.format(template, player.getDisplayName());
            Bukkit.broadcastMessage(result);
        }
        return true;
    }

}
