package com.cubic_control.hnm.GUI;

import java.util.ArrayList;
import java.util.List;

import com.cubic_control.hnm.Configuration.ConfigTypes;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class GuiConfiguration extends GuiConfig{
	private static String par1String = "NeighborCraft Configuration File";

	public GuiConfiguration(GuiScreen parentScreen){
		super(parentScreen, getElements(), RefStrings.MODID, false, false, par1String);
		titleLine2 = GuiConfig.getAbridgedConfigPath(MConfig.config.toString());
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static List<IConfigElement> getElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new ConfigElement(MConfig.config.getCategory(ConfigTypes.BOOLEANS)));
		return list;
	}
}
