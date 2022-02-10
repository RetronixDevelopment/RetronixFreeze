package commands;

import com.Square.RetronixFreeze.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class FreezeCommand implements CommandExecutor {
    Main plugin;
    public FreezeCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("freeze")) {
            if(sender.hasPermission("retronixfreeze.freeze")) {
                if (args.length < 1) {
                    sender.sendMessage("§c§l(!) §fUsage: /freeze Username");
                    return true;
                }
                Player player = (Player) Bukkit.getPlayer(args[0]);
                String p = args[0];
                if (player == null) {
                    sender.sendMessage("§c§l(!) §fUsage: /freeze Username");
                    return true;
                }

                if (!plugin.frozen_list.contains(player)) {
                    plugin.frozen_list.add(player);
                    sender.sendMessage("§eRetr§6onix §e►§6► §cYou froze " + p + ", remember that this command is not to be abused\n §f§oAll freeze sessions are logged, so abuse of this command will lead to a demotion.");




                } else {
                    plugin.frozen_list.remove(player);
                    sender.sendMessage("§eRetr§6onix §e►§6► §aYou unfroze " + p + "\n§f§oRemember to upload the screenshare recording to the team screenshare channel.");
                    player.sendMessage("§eRetr§6onix §e►§6► §aYou have been §lunfrozen§r§a\n§f§oYou can now safely log out of the server.");
                }

            }
            else{
                sender.sendMessage("§c§l(!) You do not have permissions to use this command");
            }
            return true;
        }
        return true;
    }}






