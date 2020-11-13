package com.github.truereassembly.chattools.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    // ArrayList<String> blacklistedCommands = new ArrayList<>();

    // public void addToBlacklist(String s) { blacklistedCommands.add(s); System.out.println("CommandListener: Recieved " + s + " as input and now is adding it to the blacklist");}
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().equalsIgnoreCase( "minecraft:me")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "This command is blocked!");
        }
    }
}
