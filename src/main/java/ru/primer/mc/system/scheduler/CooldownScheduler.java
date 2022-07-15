package ru.primer.mc.system.scheduler;

import net.md_5.bungee.api.ProxyServer;
import ru.primer.mc.Main;

import java.util.concurrent.TimeUnit;

import static ru.primer.mc.Main.instance;

public class CooldownScheduler {

    public static void startScheduler() {
        ProxyServer.getInstance().getScheduler().schedule(instance, new Runnable() {
            @Override
            public void run() {
                Main.playerObject.forEach((PlayerUUID, PlayerObject) -> {
                    if(PlayerObject.getCooldown() > 0) {
                        PlayerObject.takeCooldown(1);
                    }
                });
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
