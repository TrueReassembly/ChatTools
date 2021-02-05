package com.github.truereassembly.chattools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
        sender.sendMessage(ChatColor.GOLD + "ChatTools " + ChatColor.GRAY + "by Reassembly" + ChatColor.DARK_GRAY + " [RELEASE 1.2]");
        sender.sendMessage(ChatColor.GOLD + "/clearchat" + ChatColor.GRAY+ " - Clears the chat for all players!" + ChatColor.GOLD + " [chattools.clearchat]");
        sender.sendMessage(ChatColor.GOLD + "/mutechat" + ChatColor.GRAY+ " - Mutes the chat so no one can talk (Can be bypassed with the permission" + ChatColor.GOLD + " chattools.mutechat.bypass" + ChatColor.GRAY + ")" + ChatColor.GOLD + " [chattools.mutechat]");
//        sender.sendMessage(ChatColor.GOLD + "/reloadchattools" + ChatColor.GRAY + " - Reloads the config.yml");
        sender.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
        return true;
    }
}
