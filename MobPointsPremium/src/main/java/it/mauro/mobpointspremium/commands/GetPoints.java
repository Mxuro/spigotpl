package it.mauro.mobpointspremium.commands;

import it.mauro.mobpointspremium.MobPointsPremium;
import it.mauro.mobpointspremium.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class GetPoints implements CommandExecutor {

    private final MobPointsPremium pl;

    public GetPoints(MobPointsPremium pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        try{
            if (args.length == 0 && sender instanceof Player){

                Player p = (Player) sender;

                int points = pl.getPointsDatabase().getPlayerPoints(p);
                sender.sendMessage(CC.color(pl.getConfig().getString("messages.points.show_points").replaceAll("%points%", String.valueOf(points))));

                return true;
            }else{

                String playerName = args[0];
                Player player = Bukkit.getServer().getPlayer(playerName);

                if (player == null){
                    sender.sendMessage(CC.color(pl.getConfig().getString("")));
                    return true;
                }

                int amount = pl.getPointsDatabase().getPlayerPoints(player);
                sender.sendMessage(CC.color(pl.getConfig().getString("messages.points.show_points_other").replace("%player%", playerName).replaceAll("%points%", formatNumero(amount))));
            }
        }catch (SQLException e){
            e.printStackTrace();
            sender.sendMessage(ChatColor.RED + "An error occurred while getting your points. Try again later.");
            return true;
        }

        return true;
    }
    private String formatNumero(int n) {
        if (n >= 1_000_000_000) {
            double billionTaglia = (double) n / 1_000_000_000;
            return billionTaglia + "B";
        } else if (n >= 1_000_000) {
            double millionTaglia = (double) n / 1_000_000;
            return millionTaglia + "M";
        } else if (n >= 1_000) {
            double thousandTaglia = (double) n / 1_000;
            return thousandTaglia + "K";
        } else {
            return String.valueOf(n);
        }
    }
}
