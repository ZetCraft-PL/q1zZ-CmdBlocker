package pl.q1zz.commandblocker;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import pl.q1zz.Main;

public class CommandBlocker implements Listener {
	
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCmdPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String[] tmp = event.getMessage().split(" ");
        List<String> list = Main.getInstance().getConfig().getStringList(".commands");
        boolean valid = false;
        for(String cmd : list) {
            if (tmp[0].equalsIgnoreCase("/" + cmd)) {
                valid = true;
                break;
            }
        }
        if(valid && !event.getPlayer().hasPermission(".settings.bypass-permission")) {
            event.setCancelled(true);
			String command = Main.getInstance().getConfig().getString(".messages.deny-message");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',command.replace("%command%", event.getMessage())));
        }
    }
}
