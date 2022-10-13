package com.github.onlyafter.deathborder

import com.github.onlyafter.deathborder.listener.EntityDeathListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class DeathBorder : JavaPlugin() {

    override fun onLoad() {
        saveDefaultConfig()
    }

    override fun onEnable() {
        for (world in Bukkit.getWorlds()) {
            world.worldBorder.setSize(config.getDouble("default-border-size"))
        }

        server.pluginManager.registerEvents(EntityDeathListener(this), this)
    }

}