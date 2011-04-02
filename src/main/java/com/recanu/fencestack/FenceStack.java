package com.recanu.fencestack;

import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class FenceStack extends JavaPlugin
{
	public static Logger log = Logger.getLogger("Minecraft");
	public static PluginDescriptionFile pluginDesc = null;
	public final tBlockListener blockListener = new tBlockListener(this);
	
	public void onDisable() 
	{
		pluginDesc = getDescription();
		log.info(pluginDesc.getName() + " version "
				+ pluginDesc.getVersion() + " unloaded.");
	}

	public void onEnable() 
	{
		registerEvents();
		pluginDesc = getDescription();
		log.info(pluginDesc.getName() + " version "
				+ pluginDesc.getVersion() + " loaded.");
		
	}
	
	public void log(String s)
	{
		log.info(pluginDesc.getName() + ":" + s);
	}
	
	private void registerEvents()
	{
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_CANBUILD, blockListener,
				Event.Priority.Normal, this);
	}

}
