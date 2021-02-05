package com.github.truereassembly.chattools.commands;

import com.github.truereassembly.chattools.ChatTools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayer;


public class ClearChat implements CommandExecutor {

    Player player;
    String prefix;
    ChatTools plugin;
    public ClearChat(ChatTools instance) {
        plugin = instance;
        prefix = ChatColor.translateAlternateColorCodes('&', plugin.getPrefix());
    }

    int i = 0;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
        } else {
            sender.sendMessage("Only a player can run this command");
        }
        if (args.length > 2) {
            return false;
        } else {
            if (args.length == 0) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    for (i = 0; i < 150; i++) {
                        p.sendMessage("");
                    }
                }
                String template = ChatColor.translateAlternateColorCodes('&', "%s &6%s &7cleared the chat");
                String result = String.format(template, prefix, player.getDisplayName());
                Bukkit.broadcastMessage(result);
            } else if (args.length == 1) {
                String selectedPlayerString = getPlayer(args[0]).getDisplayName();
                Player selectedPlayer = Bukkit.getPlayer(args[0]);
                sender.sendMessage(ChatColor.GRAY + "Cleared chat for " + ChatColor.GOLD + selectedPlayerString);
                for (i = 0; i < 150; i++) {
                    assert selectedPlayer != null;
                    selectedPlayer.sendMessage("");
                }
                String template = ChatColor.translateAlternateColorCodes('&', "%s &6%s &7cleared your chat (Only for you)");
                String result = String.format(template, prefix, player.getDisplayName());
                selectedPlayer.sendMessage(result);
            }
        }


        return true;
    }
}
