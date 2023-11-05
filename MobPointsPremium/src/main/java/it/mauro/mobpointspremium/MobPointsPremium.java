package it.mauro.mobpointspremium;

import it.mauro.mobpointspremium.commands.GetPoints;
import it.mauro.mobpointspremium.commands.MobPointsStaff;
import it.mauro.mobpointspremium.database.PointsDatabase;
import it.mauro.mobpointspremium.events.MobKillListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class MobPointsPremium extends JavaPlugin {


    private PointsDatabase pointsDatabase;

    @Override
    public void onEnable() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            pointsDatabase = new PointsDatabase(getDataFolder().getAbsolutePath() + "/points.db");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database! " + e.getMessage());
            Bukkit.getPluginManager().disablePlugin(this);
        }
        saveDefaultConfig();
        getCommand("points").setExecutor(new GetPoints(this));
        getCommand("mobpoints").setExecutor(new MobPointsStaff(this));
        getServer().getPluginManager().registerEvents(new MobKillListener(this), this);

    }

    @Override
    public void onDisable() {
        try {
            pointsDatabase.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PointsDatabase getPointsDatabase() {
        return pointsDatabase;
    }
}
