package com.redspeaks.masuitecore;

import com.redspeaks.masuitecore.commands.Message;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public final class MaSuiteCore extends Plugin {

    private static MaSuiteCore instance = null;
    public static final String MAIN_CHANNEL = "MSC";

    @Override
    public void onEnable() {
        instance = this;

        registerCommand(new Message());

        getProxy().registerChannel(MAIN_CHANNEL);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MaSuiteCore getInstance() {
        return instance;
    }

    private void registerCommand(Command command) {
        getProxy().getPluginManager().registerCommand(this, command);
    }

    private void registerListener(Listener listener) {
        getProxy().getPluginManager().registerListener(this, listener);
    }
}
