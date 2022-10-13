package com.github.onlyafter.deathborder.listener

import com.github.onlyafter.deathborder.DeathBorder
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.PlayerDeathEvent

class EntityDeathListener(val deathBorder: DeathBorder) : Listener {

    @EventHandler
    fun onEntityDeath(event: EntityDeathEvent) {

        if(event.entity.killer is Player) {
            val player = event.entity.killer
            val border = player.world.worldBorder

            border.setSize(border.size * 2, 20 * 30)
            player.sendMessage(deathBorder.config.getString("messages.border-size-change"))

        }

    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {

        val player = event.entity.killer
        val border = player.world.worldBorder

        border.setSize(deathBorder.config.getDouble("default-border-size"))

        player.setBedSpawnLocation(Bukkit.getWorld("world").spawnLocation)
        player.sendMessage(deathBorder.config.getString("messages.border-reset"))

    }

}