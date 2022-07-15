package ru.primer.mc.system.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import ru.primer.mc.Main;
import ru.primer.mc.system.PlayerObject;

import static ru.primer.mc.system.util.ChatUtil.format;

public class CommandVipchat extends Command {
    public CommandVipchat() {
        super("vc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (!player.hasPermission("vipchat.use")) {
            player.sendMessage(format("&cУ вас недостаточно прав!"));
            return;
        }

        PlayerObject playerObject = Main.playerObject.get(player.getUniqueId());

        if (playerObject.getCooldown() > 0) {
            player.sendMessage(format("&cПодождите еще " + playerObject.getCooldown() + "с. до отправки сообщения!"));
            return;
        }
        String senderName = player.getName();

        if(args.length == 0) {
            player.sendMessage(format("&cИспользуйте: /vc [сообщение]"));
            return;
        }

        Main.playerObject.forEach((playerUUID, playerObj) -> {
            ProxiedPlayer proxiedPlayer = ProxyServer.getInstance().getPlayer(playerUUID);
            proxiedPlayer.sendMessage(format("&b&lVC &8&l|&r " + senderName + " &f» " + String.join(" ", args)));
            playerObj.setCooldown(5);
        });
    }
}
