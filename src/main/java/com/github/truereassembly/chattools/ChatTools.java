// Rename events to listeners

package com.github.truereassembly.chattools;

import com.github.truereassembly.chattools.commands.ClearChat;
import com.github.truereassembly.chattools.commands.HelpCommand;
import com.github.truereassembly.chattools.commands.MuteChat;
import com.github.truereassembly.chattools.listeners.CommandListener;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatTools extends JavaPlugin implements Listener {

    MuteChat mc = new MuteChat();
    CommandListener cl = new CommandListener();
    // File file = new File(getDataFolder(), "blacklistedCommands.txt");
    // HashMap<Player, Integer> slowChatTimer= new HashMap<Player, Integer>();

    @Override
    public void onEnable() {
        this.getCommand("clearchat").setExecutor(new ClearChat());
        this.getCommand("mutechat").setExecutor(mc);
        this.getCommand("chattools").setExecutor(new HelpCommand());

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(cl, this);

    }


        @Override
        public void onDisable () {
        }

        // Chat Listener Class moved to here
        @EventHandler
        public void onChat (AsyncPlayerChatEvent event) {
            if (mc.chatMuted) {
                if (!event.getPlayer().hasPermission("chatttols.mutechat.bypass")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ChatColor.RED + "The chat is currently muted!");
                }
            } else {
                /*if (slowChatTimer.get(event.getPlayer()) > 0) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ChatColor.RED + "The chat is currently in slowmode. You need to wait " + slowChatTimer.get(event.getPlayer()) + " seconds!");
                }*/
            }
        }
    }

