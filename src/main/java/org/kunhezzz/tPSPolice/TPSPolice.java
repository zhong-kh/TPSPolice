package org.kunhezzz.tPSPolice;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;
import org.kunhezzz.tPSPolice.PluginCommands.MainCommand;

public final class TPSPolice extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        MainCommand.commandRegister();
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS,
                cmds -> {
                    cmds.registrar().register(MainCommand.buildCmd);
                }
        );

        this.getLogger().info("[TPSPolice] Plugin enabled.");



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        this.getLogger().info("[TPSPolice] Plugin disabled.");

    }
}
