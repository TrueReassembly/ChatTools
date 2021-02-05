// Rename events to listeners
// Add reload command to plugin.yml
package com.github.truereassembly.chattools;

import com.github.truereassembly.chattools.commands.*;
import com.github.truereassembly.chattools.listeners.CommandListener;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class ChatTools extends JavaPlugin implements Listener {
    CommandListener cl = new CommandListener();
    String prefix;
    private boolean chatMuted;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig().addDefault("options.prefix", "&7[ChatTools]");
        this.getConfig().addDefault("options.ChatMuted", false);
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        chatMuted = getConfig().getBoolean("options.ChatMuted");

        this.getCommand("clearchat").setExecutor(new ClearChat(this));
        this.getCommand("mutechat").setExecutor(new MuteChat(this));
        this.getCommand("chattools").setExecutor(new HelpCommand());
//        this.getCommand("slowchat").setExecutor(new SlowChat());
//        this.getCommand("reloadchattools").setExecutor(new ReloadCommand(this));

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(cl, this);

    }


    @Override
    public void onDisable() {

        this.getConfig().set("options.ChatMuted", chatMuted);
        this.saveConfig();
    }


    // Chat Listener Class moved to here
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (chatMuted) {
            if (!player.hasPermission("chattools.mutechat.bypass")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "The chat is currently muted!");
            }
        } else {
        }
    }

//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event) {
//        Player player = event.getPlayer();
//        slowChatTimer.put(player, 0L);
//    }
//
//    @EventHandler
//    public void onPlayerDisconnect(PlayerQuitEvent event) {
//        Player player = event.getPlayer();
//        slowChatTimer.remove(player);
//    }

    public String getPrefix() {
        prefix = this.getConfig().getString("options.prefix");
        if (prefix == null) {
            prefix = "&7[ChatTools]";
            getLogger().severe("Options.prefix could not be found in the config, reverting to default until this is fixed");
        }
        return prefix;
    }

    public boolean getChatMuted() {
        return chatMuted;
    }

    public void setChatMuted(Boolean ans) { chatMuted = ans; }

}