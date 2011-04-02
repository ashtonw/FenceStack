package com.recanu.fencestack;

import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;

public class tBlockListener extends BlockListener
{
	FenceStack plugin;
	
	public tBlockListener(FenceStack instance)
	{
		this.plugin = instance;
	}
	
	public void onBlockCanBuild(BlockCanBuildEvent event)
	{
		if (event.isBuildable() == false) {
			//FenceStack.log.info("FENCESTACK: CHECKING REPLACE");
			if (canReplace(event.getMaterial())) {
				event.setBuildable(true);
				//FenceStack.log.info("FENCESTACK: SET TO BUILDABLE");
			}
		}
		//FenceStack.log.info("FENCESTACK : " + event.getBlock().getFace(BlockFace.DOWN).getType());

	}
	
	private boolean canReplace(Material mat)
	{
		//FenceStack.log.info("FENCESTACK: " + mat.toString());
		if ( mat == Material.FENCE)
			return true;
		else
			return false;
		/*
		if ( mat == Material.AIR ||
			 mat == Material.WATER ||
			 mat == Material.LAVA ||
			 mat == Material.FIRE )
			return true;
		else
			return false;*/
	}
	
}
