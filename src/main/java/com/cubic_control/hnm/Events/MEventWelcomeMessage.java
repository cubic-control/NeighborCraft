package com.cubic_control.hnm.Events;

import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class MEventWelcomeMessage {
	
	@SubscribeEvent
    public void onPlayerLogin(PlayerLoggedInEvent event) {
    	event.player.addChatComponentMessage(new ChatComponentText(
    		EnumChatFormatting.GOLD+"["+EnumChatFormatting.WHITE+RefStrings.NAME+EnumChatFormatting.GOLD+
    		"]:"+EnumChatFormatting.GREEN+" Welcome "+event.player.getDisplayName()+" to "+
    		EnumChatFormatting.WHITE+RefStrings.NAME+EnumChatFormatting.GOLD+":"+
    		EnumChatFormatting.GREEN+" The Hello Neighbor Mod!"+EnumChatFormatting.WHITE+
    		EnumChatFormatting.ITALIC+" This mod is © 2017 by cubic_control."));
    }

}
