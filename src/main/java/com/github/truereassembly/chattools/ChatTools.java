package com.github.truereassembly.chattools;

import com.github.truereassembly.chattools.Commands.ClearChat;
import com.github.truereassembly.chattools.Commands.HelpCommand;
import com.github.truereassembly.chattools.Commands.MuteChat;
import com.github.truereassembly.chattools.Commands.SlowChat;
import com.github.truereassembly.chattools.Events.CommandListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public final class ChatTools extends JavaPlugin implements Listener {

    Logger logger = getLogger();

    MuteChat mc = new MuteChat();
    CommandListener cl = new CommandListener();
    // File file = new File(getDataFolder(), "blacklistedCommands.txt");
    // HashMap<Player, Integer> slowChatTimer= new HashMap<Player, Integer>();

    @Override
    public void onEnable() {
        this.getCommand("clearchat").setExecutor(new ClearChat());
        // this.getCommand("slowchat").setExecutor(new SlowChat());
        this.getCommand("mutechat").setExecutor(mc);
        //this.getCommand("debugcommand").setExecutor(new DebugCommand());
        this.getCommand("chattools").setExecutor(new HelpCommand());

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(cl, this);

        logger.info("ChatTools loaded!");
        /*while (true) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                slowChatTimer.put(p, slowChatTimer.get(p) - 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }*/
    }


        @Override
        public void onDisable () {

            logger.info("Task failed Successfully");
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

