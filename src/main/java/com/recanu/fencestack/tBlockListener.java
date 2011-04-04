package com.recanu.fencestack;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class tBlockListener extends BlockListener
{
	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) {
		// TODO Auto-generated method stub
		if (event.getBlock().getType() == Material.TORCH) {
			FenceStack.log.info("FenceStack : Torch PHYSICS");
		}
	}

	@Override
	public void onBlockPlace(BlockPlaceEvent event) {
		// TODO Auto-generated method stub
		if (event.getBlock().getType() == Material.TORCH) {
			FenceStack.log.info("FenceStack : " + event.getBlock().getType().toString());
		
			//event.getBlockPlaced().setData((byte) 5);
			Location loc = event.getBlockPlaced().getLocation();
			//loc.getBlock().setData((byte) 5);
			//loc.getBlock().setType(Material.TORCH);
		}
		
	}

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
		if ( mat == Material.FENCE || mat == Material.TORCH )
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
