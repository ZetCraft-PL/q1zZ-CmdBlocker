package pl.q1zz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.q1zz.bStats.Metrics;
import pl.q1zz.commandblocker.CommandBlocker;
import pl.q1zz.commands.ReloadCmd;

public class Main extends JavaPlugin {
    private static Main instance;
    public static Main getInstance() {return instance;}

	@Override
	public void onEnable() {
		instance = this;
        getConfig().options().copyDefaults(true);
        getServer().getPluginManager().registerEvents(new CommandBlocker(), this);
        saveConfig();  
        new ReloadCmd(this);
        
        int pluginId = 0000;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("q1zZ-CommandBlocker", () -> "q1zZ-CommandBlocker"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "\n\n###################################### \n q1zZ-CommandBlocker \n Plugin was launched successfully!\n######################################\n");
	}

}
