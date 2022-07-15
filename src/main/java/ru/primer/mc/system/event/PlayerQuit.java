package ru.primer.mc.system.event;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import ru.primer.mc.Main;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerDisconnectEvent e) {
        ProxiedPlayer player = e.getPlayer();

        if(Main.playerObject.containsKey(player.getUniqueId())) {
            Main.playerObject.remove(player.getUniqueId());
        }
    }
}
