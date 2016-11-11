package com.monsterspawned.infinibox.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class DevStuff {
	
	private EntityPlayer player = Minecraft.getMinecraft().thePlayer;
	
	public void AddDevSpecialties()
	{
		if(player.getDisplayName() == "TheModdersDen")
		{
			//TODO Do something special here...
		} else if(player.getDisplayName() == "colesboys") {
			//TODO Do something special here...
		} else if(player.getDisplayName() == "thecreator12345") {
			//TODO Do something special here...
		}		
	}

}
