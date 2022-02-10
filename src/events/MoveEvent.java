package events;

import com.Square.RetronixFreeze.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {


    static Main plugin;
    public MoveEvent(Main plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (plugin.frozen_list.contains(player)) {
            Location location = player.getLocation();
            player.teleport(location);
            player.sendMessage("\n\n§c§l(!) §cYou have been §lfrozen§r§c! Please await further instructions from staff.\n §lIf you log out from the server, you will be banned.\n\n");
        }
    }

}
