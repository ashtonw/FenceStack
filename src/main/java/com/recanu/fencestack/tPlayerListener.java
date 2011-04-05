package com.recanu.fencestack;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class tPlayerListener extends PlayerListener {

    public tPlayerListener() {
    } // end default constructor

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK
                && event.getClickedBlock().getType() == Material.FENCE
                && event.getPlayer().getItemInHand().getType() == Material.TORCH) {
            Block torchBlock = event.getClickedBlock().getRelative(event.getBlockFace());
            if(torchBlock.getType()!=Material.AIR){
                return;
            }
            //torchBlock.setTypeId(50);
            //torchBlock.setData(d);
            // 1 == SOUTH
            // 2 == NORTH
            // 3 == WEST
            // 4 == EAST
            // 5 == UP
            
            switch (event.getBlockFace()) {
                case SOUTH:
                    torchBlock.setTypeIdAndData(50, (byte) 1, false);
                    break;
                case NORTH:
                    torchBlock.setTypeIdAndData(50, (byte) 2, false);
                    break;
                case WEST:
                    torchBlock.setTypeIdAndData(50, (byte) 3, false);
                    break;
                case EAST:
                    torchBlock.setTypeIdAndData(50, (byte) 4, false);
                    break;
                case UP:
                    torchBlock.setTypeIdAndData(50, (byte) 5, false);
                    break;
                default:
                    return;
            }
            int a = event.getPlayer().getItemInHand().getAmount();
            if (a > 1) {
                event.getPlayer().getItemInHand().setAmount(a - 1);
            } else {
                event.getPlayer().setItemInHand(null);
            }
            
        }
    }
} // end class tPlayerListener

