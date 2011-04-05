package com.recanu.fencestack;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;

public class tBlockListener extends BlockListener {

    @Override
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        //if (!event.isBuildable() && (event.getMaterial() == Material.FENCE ||  event.getMaterial() == Material.TORCH)) {
        if (event.getMaterial() == Material.FENCE){
            if(FenceStack.noFenceStack){
                event.setBuildable(
                        event.getBlock().getRelative(BlockFace.UP).getType() != Material.FENCE
                        && event.getBlock().getRelative(BlockFace.DOWN).getType() != Material.FENCE);
            }else{
                event.setBuildable(true);
            }
        }
    }

}
