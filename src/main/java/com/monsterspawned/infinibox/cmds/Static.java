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

public class Static implements ICommand{
	
	private final List aliases;
	  
    protected String fullEntityName; 
    protected Entity conjuredEntity; 
  
    public Static() 
    { 
        aliases = new ArrayList(); 
        aliases.add("static"); 
        aliases.add("stj"); 
    } 
  
    @Override 
    public int compareTo(Object o)
    { 
        return 0; 
    } 

    @Override 
    public String getCommandName() 
    { 
        return "static"; 
    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    { 
        return "static <player>"; 
    } 

    @Override 
    public List getCommandAliases() 
    { 
        return this.aliases;
    } 

    @Override 
    public void processCommand(ICommandSender sender, String[] argString)
    { 
        //TODO Add code to send static effect to player...
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
        return false; //for now...
    } 
}

