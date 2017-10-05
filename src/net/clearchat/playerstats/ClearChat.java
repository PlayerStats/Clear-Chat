package me.playerstatscc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ClearChat extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("clearchat")) {
			
			if(args.length == 0) { 
				if(sender.hasPermission("cc.clearchat")) {
					sender.sendMessage(ChatColor.RED + "Usage: /clearchat [player name] | all | me");
					return true;
				}
				sender.sendMessage(ChatColor.RED + "No permission.");
				return true;
			}
			if(args.length == 1) {
				switch(args[0].toLowerCase()) {
				case "all":
					if(!sender.hasPermission("cc.clearchat.all")) {
						sender.sendMessage(ChatColor.RED + "No permission.");
						break;
					}
					for(int i = 0; i < 250; i++) getServer().broadcastMessage("");
					getServer().broadcastMessage(ChatColor.RED + "Chat cleared by " + ChatColor.BOLD + sender.getName() + ChatColor.RESET + "" + ChatColor.RED + "!");
					break;
				case "me":
					if(!sender.hasPermission("cc.clearchat.me")) {
						sender.sendMessage(ChatColor.RED + "No permission.");
						break;
					}
					for(int i = 0; i < 250; i++) sender.sendMessage("");
					sender.sendMessage(ChatColor.RED + "Your chat has been cleared.");
					break;
				default:
					if(!sender.hasPermission("cc.clearchat.player")) {
						sender.sendMessage(ChatColor.RED + "No permission.");
						break;
					}
					Player target = Bukkit.getPlayer(args[0]);
					if(target == null) {
						sender.sendMessage(ChatColor.RED + "Player is offline.");
						break;
					}
					for(int i = 0; i < 250; i++) target.sendMessage("");
					sender.sendMessage(ChatColor.RED + "Your chat has been cleared.");
					break;
				}
				return true;
			}
			return true;
		}
		
		return true;
	}
}
