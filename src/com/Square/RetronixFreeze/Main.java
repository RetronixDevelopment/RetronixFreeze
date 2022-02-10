package com.Square.RetronixFreeze;

import commands.FreezeCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public ArrayList<Player> frozen_list = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[RetronixFreeze] has been enabled");
        getCommand("freeze").setExecutor(new FreezeCommand(this));

    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[RetronixFreeze] has been disabled");


    }
}
