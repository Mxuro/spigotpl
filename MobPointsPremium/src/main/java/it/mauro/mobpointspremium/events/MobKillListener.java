package it.mauro.mobpointspremium.events;

import it.mauro.mobpointspremium.MobPointsPremium;
import it.mauro.mobpointspremium.utils.CC;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.sql.SQLException;

public class MobKillListener implements Listener {

    private final MobPointsPremium pl;

    public MobKillListener(MobPointsPremium pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent e) throws SQLException {

        if (e.getEntity().getKiller() == null) return;

        Player killer = e.getEntity().getKiller();

        int points = pl.getPointsDatabase().getPlayerPoints(killer);

        if(e.getEntity().getType() == EntityType.ENDER_DRAGON) {
            int n = 100;
            int newpoints = n += (int) (Math.random()* 100);
            Bukkit.broadcastMessage(CC.color(pl.getConfig().getString("messages.plugin.enderdragon_killed").replaceAll("%killer%", killer.getName())));
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.WARDEN) {
            int n = 200;
            int newpoints = n += (int) (Math.random()* 300);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.ENDERMAN) {
            int n = 10;
            int newpoints = n += (int) (Math.random()* 50);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.SHEEP) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 5);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.PIG) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 5);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.BAT) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 1);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.COW) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 5);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        } else if (e.getEntity().getType() == EntityType.MUSHROOM_COW) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 5);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        }  else if (e.getEntity().getType() == EntityType.CAT) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 5);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        }  else if (e.getEntity().getType() == EntityType.HORSE) {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 5);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        }  else {
            int n = 1;
            int newpoints = n += (int) (Math.random()* 10);
            pl.getPointsDatabase().updatePlayerPoints(killer, newpoints+points);
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.color(pl.getConfig().getString("messages.points.add_points").replaceAll("%points%", String.valueOf(newpoints)))));
        }
    }


}
