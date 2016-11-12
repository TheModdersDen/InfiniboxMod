package com.monsterspawned.infinibox.proxy;

import com.jadarstudios.developercapes.DevCapes;
import com.monsterspawned.infinibox.client.settings.Keybindings;
import com.monsterspawned.infinibox.entities.aggressive.Slendy;
import com.monsterspawned.infinibox.entities.model.ModelSlendy;
import com.monsterspawned.infinibox.entities.render.RenderSlendy;
import com.monsterspawned.infinibox.handler.ClientTickHandler;
import com.monsterspawned.infinibox.misc.ClientStaticEffect;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	
	
	DevCapes devCapes = DevCapes.getInstance();
    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }

	@Override
	public void registerRenderers() {
		 RenderingRegistry.registerEntityRenderingHandler(Slendy.class, new RenderSlendy(new ModelSlendy(), 0.5F));
		
	}

	@Override
	public void registerDevThings() {
		devCapes.registerConfig("");
		// TODO Add dev stuff...
		
	}

	@Override
	public void AddEvents() {
		// TODO Add event processing here...
		
	}

	@Override
	public void load() {
		 MinecraftForge.EVENT_BUS.register(new ClientStaticEffect(Minecraft.getMinecraft()));
		 MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
	}
}
