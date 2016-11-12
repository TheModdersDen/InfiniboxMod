package com.monsterspawned.infinibox.cmds;

import java.util.ArrayList;
import java.util.List;

import com.monsterspawned.infinibox.reference.Reference;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Conjure implements ICommand{
	
	private final List aliases;
	  
    protected String fullEntityName; 
    protected Entity conjuredEntity; 
  
    public Conjure() 
    { 
        aliases = new ArrayList(); 
        aliases.add("conjure"); 
        aliases.add("conj"); 
    } 
  
    @Override 
    public int compareTo(Object o)
    { 
        return 0; 
    } 

    @Override 
    public String getCommandName() 
    { 
        return "conjure"; 
    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    { 
        return "conjure <text>"; 
    } 

    @Override 
    public List getCommandAliases() 
    { 
        return this.aliases;
    } 

    @Override 
    public void processCommand(ICommandSender sender, String[] argString)
    { 
        World world = sender.getEntityWorld(); 
    
        if (world.isRemote) 
        { 
            System.out.println("Not processing on Client side"); 
        } 
        else 
        { 
            System.out.println("Processing on Server side"); 
            if(argString.length == 0) 
            { 
                sender.addChatMessage(new ChatComponentText("Invalid argument")); 
                return; 
            } 
    
            sender.addChatMessage(new ChatComponentText("Conjuring: [" + argString[0]  
                  + "]")); 
     
            fullEntityName = Reference.MOD_ID+"."+argString[0]; 
            if (EntityList.stringToClassMapping.containsKey(fullEntityName))
            { 
                conjuredEntity = EntityList.createEntityByName(fullEntityName, world);  
                conjuredEntity.setPosition(sender.getPlayerCoordinates().posX,       
                sender.getPlayerCoordinates().posY, 
                sender.getPlayerCoordinates().posZ); 
                world.spawnEntityInWorld(conjuredEntity); 
            } 
            else 
            { 
                sender.addChatMessage(new ChatComponentText("Entity not found")); 
            } 
        } 
    } 

    @Override 
    public boolean canCommandSenderUseCommand(ICommandSender var1) 
    { 
        return true;
    } 

    @Override  
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
    { 
        return null; 
    } 

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    { 
        return false;
    } 
}
