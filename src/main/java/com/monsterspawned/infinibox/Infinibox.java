package com.monsterspawned.infinibox;

import com.monsterspawned.infinibox.client.handler.KeyInputEventHandler;
import com.monsterspawned.infinibox.cmds.Conjure;
import com.monsterspawned.infinibox.entities.aggressive.Slendy;
import com.monsterspawned.infinibox.handler.ConfigurationHandler;
import com.monsterspawned.infinibox.init.ModBlocks;
import com.monsterspawned.infinibox.init.ModItems;
import com.monsterspawned.infinibox.init.Recipes;
import com.monsterspawned.infinibox.proxy.IProxy;
import com.monsterspawned.infinibox.reference.Reference;
import com.monsterspawned.infinibox.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.util.ResourceLocation;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS, acceptedMinecraftVersions="1.7.10", canBeDeactivated=true, modLanguage="java", useMetadata=true)
public class Infinibox
{
	public static final ResourceLocation static1 = new ResourceLocation(Reference.MOD_ID, "textures/misc/static.png");
	public static final ResourceLocation static2 = new ResourceLocation(Reference.MOD_ID, "textures/misc/static2.png");
	
    @Mod.Instance(Reference.MOD_ID)
    public static Infinibox instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

	public static boolean slendySpawned = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        proxy.registerKeyBindings();

        ModItems.init();

        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        Recipes.init();
        proxy.registerRenderers();
        proxy.registerDevThings();
        proxy.load();
        EntityRegistry.registerGlobalEntityID(Slendy.class, "Slendy", ConfigurationHandler.SlendyID, 16260, 11020932);
        EntityRegistry.registerModEntity(Slendy.class, "Slendy", ConfigurationHandler.SlendyID, this, 1000, 1, false);
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
    
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	event.registerServerCommand(new Conjure());
    	
    }
}
