package ru.primer.mc.system;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class PlayerObject {

    private UUID uuid;
    private int cooldown;
    private ProxiedPlayer player;
    private String name;

    public PlayerObject(UUID uuid) {
        this.uuid = uuid;
    }

    public ProxiedPlayer getPlayer() {
        return this.player;
    }

    public void setPlayer(ProxiedPlayer value) {
        this.player = value;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(int value) {
        this.cooldown = value;
    }

    public void takeCooldown(int value) {
        this.cooldown = getCooldown() - value;
    }

    public String getName() {
        return ProxyServer.getInstance().getPlayer(this.uuid).getName();
    }
}
