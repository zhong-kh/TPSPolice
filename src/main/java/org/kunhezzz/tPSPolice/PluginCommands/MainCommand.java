package org.kunhezzz.tPSPolice.PluginCommands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.kunhezzz.tPSPolice.TPSPolice;

public class MainCommand {

    public static LiteralCommandNode<CommandSourceStack> buildCmd;

    public static void commandRegister() {

        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal("ptps");

        root.executes(ctx -> {

            @NotNull double[] tps = Bukkit.getTPS();
            ctx.getSource().getSender().sendMessage("[TPSPolice] Current TPS is " + "1m: " + tps[0] + "; 5m:" + tps[1] + " 15m: " + tps[2]);

            double min = Math.min(Math.min(tps[0], tps[1]), tps[2]);
            if (min >= 19.9) {
                ctx.getSource().getSender().sendMessage("[TPSPolice] Don't worry! It is healthy!");
            } else {
                ctx.getSource().getSender().sendMessage("[TPSPolice] The Server load is too high! Please turn off high frequency redstone machines and stop flying too fast");
                Bukkit.getServer().broadcastMessage("[TPSPolice] The Server load is too high! Please turn off high frequency redstone machines and stop flying too fast");
            }

            return Command.SINGLE_SUCCESS;

        });

        buildCmd = root.build();

    }


}
