package com.github.truereassembly.chattools.commands;

import com.github.truereassembly.chattools.ChatTools;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public class ReloadCommand implements CommandExecutor {

    ChatTools plugin;

    public ReloadCommand(ChatTools instance) { plugin = instance; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "Chattools reloaded!");
        return true;
    }
}
