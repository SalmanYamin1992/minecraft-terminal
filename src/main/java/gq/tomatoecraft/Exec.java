package gq.tomatoecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class Exec implements CommandExecutor {
    @Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean returnValue = false;
        if(args.length>0 && sender instanceof ConsoleCommandSender){
            String cmd = "";
            //Split the arguements into executable commands
            for(int i = 0 ; i < args.length ; i++){
                cmd = String.valueOf(cmd) + args[i];
                cmd = String.valueOf(cmd) + " ";
            }
            
            //Show the console what is being executed
            Bukkit.getServer().getConsoleSender().sendMessage(cmd);
            
            //Initializes the thread
            new RunnableDemo(cmd);

            returnValue = true;
        }
        return returnValue;
	}
}

    