package gq.tomatoecraft;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin{
    @Override
    public void onEnable(){
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"Enabling Tomatoecraft");
        this.getCommand("exec").setExecutor(new Exec());
    }
    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED+"Disabling Tomatoecraft");
    }
}