package com.github.truereassembly.chattools.commands;

import com.github.truereassembly.chattools.ChatTools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MuteChat implements CommandExecutor {

    Player player;
    ChatTools plugin;
    String prefix;
    public MuteChat(ChatTools instance) {
        plugin = instance;
        prefix = ChatColor.translateAlternateColorCodes('&', plugin.getPrefix());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
        } else {
            sender.sendMessage("Only a player can run this command");
        }
        if (!plugin.getChatMuted()) {
            plugin.setChatMuted(true);
            String template = ChatColor.translateAlternateColorCodes('&', "%s &6%s &7muted the chat");
            String result = String.format(template, prefix, player.getDisplayName());
            Bukkit.broadcastMessage(result);
        } else {
            plugin.setChatMuted(false);
            String template = ChatColor.translateAlternateColorCodes('&', "%s &6%s &7unmuted the chat");
            String result = String.format(template, prefix, player.getDisplayName());
            Bukkit.broadcastMessage(result);
        }
        return true;
    }

}

