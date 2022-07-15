package ru.primer.mc;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import ru.primer.mc.system.PlayerObject;
import ru.primer.mc.system.command.CommandVipchat;
import ru.primer.mc.system.event.PlayerJoin;
import ru.primer.mc.system.event.PlayerQuit;
import ru.primer.mc.system.scheduler.CooldownScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends Plugin {

    public static Main instance;
    public static Map<UUID, PlayerObject> playerObject = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        CooldownScheduler.startScheduler();
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PlayerJoin());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PlayerQuit());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandVipchat());
    }
}
