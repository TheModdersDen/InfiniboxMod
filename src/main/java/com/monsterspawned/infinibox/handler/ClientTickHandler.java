package com.monsterspawned.infinibox.handler;

/*     */ import cpw.mods.fml.common.eventhandler.EventPriority;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent.Phase;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.input.Keyboard;

import com.monsterspawned.infinibox.entities.aggressive.Slendy;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ClientTickHandler
/*     */ {
			private TickEvent event;
			private InventoryPlayer inventory;
/*  25 */   public static int musictimer = 2400;
/*  26 */   private boolean isTeleportKeyDown = false;
/*     */   
/*     */   private double randXonCircle;
/*     */   
/*     */   private double randZonCircle;
/*     */   
/*     */ 
/*     */   @SubscribeEvent(priority=EventPriority.NORMAL)
/*     */   public void tickStart(TickEvent event)
/*     */   {
/*  36 */     EntityClientPlayerMP var3 = Minecraft.getMinecraft().thePlayer;
/*  37 */     if ((event.phase == event.phase.START) && 
/*  38 */       (var3 != null)) {
/*  39 */       if (Slendy.musictimer < 2400)
/*     */       {
/*  41 */         Slendy.musictimer += 1;
/*     */       }
/*     */       
/*  49 */       isTeleportKeyDown = Keyboard.isKeyDown(19);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double randomXonCircle(int radius1, int radius2, double SlendyposX)
/*     */   {
/*  65 */     int radius = radius2 - radius1;
/*  66 */     double angle = Math.random() * 3.141592653589793D * 2.0D;
/*  67 */     randXonCircle = (SlendyposX + radius * Math.cos(angle));
/*  68 */     return randXonCircle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double randomZonCircle(int radius1, int radius2, double SlendyposZ)
/*     */   {
/*  82 */     int radius = radius2 - radius1;
/*  83 */     double angle = Math.random() * 3.141592653589793D * 2.0D;
/*  84 */     randZonCircle = (SlendyposZ + radius * Math.sin(angle));
/*  85 */     return randZonCircle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean teleportTo1(double var1, double var3, double var5)
/*     */   {
/*  92 */     Minecraft var22 = Minecraft.getMinecraft();
/*  93 */     EntityClientPlayerMP var130 = Minecraft.getMinecraft().thePlayer;
/*  94 */     WorldClient var40 = Minecraft.getMinecraft().theWorld;
/*     */     
/*  96 */     double var7 = var1;
/*  97 */     double var9 = var3;
/*  98 */     double var11 = var5;
/*  99 */     var1 = var1;
/* 100 */     var3 = var3;
/* 101 */     var5 = var5;
/* 102 */     boolean var13 = false;
/* 103 */     int var14 = MathHelper.floor_double(var1);
/* 104 */     int var15 = MathHelper.floor_double(var3);
/* 105 */     int var16 = MathHelper.floor_double(var5);
/*     */     
/*     */ 
/* 108 */     if (var40.blockExists(var14, var15, var16))
/*     */     {
/* 110 */       boolean var17 = false;
/*     */       
/* 112 */       while ((!var17) && (var15 > 0))
/*     */       {
/* 114 */         int var18 = Block.getIdFromBlock(var40.getBlock(var14, var15 - 1, var16));
/*     */         
/* 116 */         if ((var18 != 0) && (Block.getBlockById(var18).getMaterial().isSolid()))
/*     */         {
/* 118 */           var17 = true;
/*     */         }
/*     */         else
/*     */         {
/* 122 */           var3 -= 1.0D;
/* 123 */           var15--;
/*     */         }
/*     */       }
/*     */       
/* 127 */       if (var17)
/*     */       {
/* 129 */         var130.setPosition(var1, var3, var5);
/* 130 */         var13 = true;
/*     */       }
/*     */     }
/*     */     
/* 134 */     if (!var13)
/*     */     {
/* 136 */       var130.setPosition(var7, var9, var11);
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     boolean var17 = true;
/* 142 */     return true;
/*     */   }

			private void handlePlate(Item item)
/*     */   {
/* 148 */     Minecraft var2 = Minecraft.getMinecraft();
/* 149 */     EntityClientPlayerMP var3 = Minecraft.getMinecraft().thePlayer;
/* 153 */       if ((Keyboard.isKeyDown(19)) && (!isTeleportKeyDown))
/*     */       {
/* 155 */         int newX = (int)randomXonCircle(40, 100, var3.posX);
/* 156 */         int newZ = (int)randomZonCircle(40, 100, var3.posZ);
/*     */         
/* 158 */         teleportTo1(newX, var3.posY, newZ);
/*     */       }
/*     */   }
/*     */ }

/* Location:           F:\MCP\InfiniboxMod\libs\SlenderMan-3.3_1.7.10-deobf.jar
 * Qualified Name:     net.dudgames.slender.client.ClientTickHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
