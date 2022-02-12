package events;

import com.Square.RetronixFreeze.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    static Main plugin;
    public LeaveEvent(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String pl = player.getDisplayName();
        if (plugin.frozen_list.contains(player)) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.hasPermission("retronixfreeze.freeze")) {
                    p.sendMessage("\n\n\n\n\n\n\n§c§l(!) §c§l(!) §c " + pl + " logged out whilst §lfrozen.\n\n\n\n\n\n\n");
                }
            }
        }
    }}