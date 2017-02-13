package com.cubic_control.hnm.Utils;

import java.util.Random;

import com.cubic_control.hnm.Events.MEventBinoculars;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModUtils {
	public static Random rand;
	
	public ModUtils(){
		ModUtils.rand = new Random();
	}
	
	public static void addLight(World world, MovingObjectPosition mop, Entity entity) {
    	world.setLightValue(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ, 15);
        world.markBlockRangeForRenderUpdate((int)mop.blockX, (int)mop.blockY, (int)mop.blockX, 12, 12, 12);
        world.markBlockForUpdate((int)mop.blockX, (int)mop.blockY, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY +1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY +1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY +1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY +1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY +1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY +1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY +1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY +1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY +1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY -1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY -1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY -1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY -1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY -1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY -1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY -1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY -1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY -1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ -1);
        
        if (entity.isDead) {
        	updateLight(world, mop);
        }
    }
	
	public static void updateLight(World world, MovingObjectPosition mop) {
		world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ);
	}
	
	public static void drawTexturedRect(double posX, double posY, double width, double height) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(posX + 0), (double)(posY + height), 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)(posX + width), (double)(posY + height), 0.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)(posX + width), (double)(posY + 0), 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV((double)(posX + 0), (double)(posY + 0), 0.0, 0.0, 0.0);
        tessellator.draw();
    }
	
	public static Block[] getBlocksAroundPoint(World world, int x, int y, int z){
		ForgeDirection[] directions = ForgeDirection.VALID_DIRECTIONS;
		Block[] blocks = new Block[directions.length];
		for(int i = 0; i < directions.length; i++){
			int xCoord = x + directions[i].offsetX;
			int yCoord = y + directions[i].offsetY;
			int zCoord = z + directions[i].offsetZ;

			blocks[i] = world.getBlock(xCoord, yCoord, zCoord);
		}
		return blocks;
	}

}
