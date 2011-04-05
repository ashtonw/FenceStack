package com.recanu.fencestack;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class FenceStack extends JavaPlugin {

    public static final Logger logger = Logger.getLogger("Minecraft");
    protected static PluginDescriptionFile pluginDesc = null;
    protected final tBlockListener blockListener = new tBlockListener();
    protected final tPlayerListener plListener = new tPlayerListener();
    static final File configFile = new File("plugins" + File.separatorChar + "FenceStack" + File.separatorChar + "config.yml");
    public static boolean noFenceStack = false;

    public void onDisable() {
        pluginDesc = getDescription();
        log(String.format("version %s unloaded", pluginDesc.getVersion()));
    }

    public void onEnable() {
        PluginManager p = getServer().getPluginManager();
        p.registerEvent(Event.Type.BLOCK_CANBUILD, blockListener, Event.Priority.Normal, this);
        //p.registerEvent(Event.Type.BLOCK_PHYSICS, blockListener, Event.Priority.Normal, this);
        //p.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
        //p.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
        p.registerEvent(Event.Type.PLAYER_INTERACT, plListener, Event.Priority.Normal, this);

        if (configFile.exists()) {
            try {
                Configuration config = new Configuration(configFile);
                config.load();
                noFenceStack = config.getBoolean("NoFenceStack", noFenceStack);
            } catch (Exception ex) {
                logger.severe("Failed to load configuration file");
            }
        }else{
            System.out.println("config (" + configFile.toString() + ") not found");
        }
        pluginDesc = getDescription();
        log(String.format("version %s loaded", pluginDesc.getVersion()));
    }

    public void log(String s) {
        logger.info(String.format("[%s] %s", pluginDesc.getName(), s));
    }
}
