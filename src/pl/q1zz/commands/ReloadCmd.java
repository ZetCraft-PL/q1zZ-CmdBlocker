package pl.q1zz.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pl.q1zz.Main;

public class ReloadCmd implements CommandExecutor {
	public ReloadCmd(Main main) {
		main.getCommand("q1zzreload").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!sender.hasPermission(Main.getInstance().getConfig().getString(".settings.reload-permission"))) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString(".messages.noreload-permission")));
			return false;
		}
		Main.getInstance().reloadConfig();
		sender.sendMessage(ChatColor.GREEN + "Successfully reloaded config.yml!");
		return false;
	}
}
