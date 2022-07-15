package ru.primer.mc.system.event;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import ru.primer.mc.Main;
import ru.primer.mc.system.PlayerObject;

import java.util.UUID;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(LoginEvent e) {
        UUID uuid = e.getConnection().getUniqueId();

        PlayerObject playerObject = new PlayerObject(uuid);
        playerObject.setPlayer(ProxyServer.getInstance().getPlayer(uuid));
        Main.playerObject.put(uuid, playerObject);
    }
}
