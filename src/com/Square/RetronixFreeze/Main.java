package com.Square.RetronixFreeze;

import commands.FreezeCommand;
import events.LeaveEvent;
import events.MoveEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public ArrayList<Player> frozen_list = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[RetronixFreeze] has been enabled");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[RF] Debug mode has been enabled.");
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getServer().getPluginManager().registerEvents(new MoveEvent(this), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(this), this);
    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[RetronixFreeze] has been disabled");


    }
}
