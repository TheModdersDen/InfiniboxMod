package com.monsterspawned.infinibox.misc;

/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import cpw.mods.fml.common.eventhandler.EventPriority;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.gui.GuiIngame;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
/*    */ import org.lwjgl.opengl.GL11;

import com.monsterspawned.infinibox.Infinibox;
import com.monsterspawned.infinibox.entities.aggressive.Slendy;
/*    */ 
/*    */ @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT)
/*    */ public class ClientStaticEffect extends net.minecraft.client.gui.Gui
/*    */ {
/*    */   private Item helmet;
/*    */   private RenderGameOverlayEvent event;
/*    */   public ClientStaticEffect(Minecraft mc) {}
/*    */   
/*    */   @SubscribeEvent(priority=EventPriority.NORMAL)
/*    */   public void renderGameOverlay(RenderGameOverlayEvent.Post event)
/*    */   {
/* 33 */     if ((event.isCancelable()) || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE || (Minecraft.getMinecraft().currentScreen != null)) {
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     Minecraft minecraft = FMLClientHandler.instance().getClient();
/* 38 */     net.minecraft.entity.player.EntityPlayer player = Minecraft.getMinecraft().thePlayer;
/*    */     
/* 40 */     if ((player == null) || (Minecraft.getMinecraft().gameSettings.keyBindPlayerList.getIsKeyPressed()))
/*    */     {
/* 42 */       Slendy.opacity = 0.0F;
/* 43 */       return;
/*    */     }
/* 45 */     GL11.glPushAttrib(1048575);
/*    */     
/* 47 */     if ((Minecraft.getMinecraft().thePlayer != null) && (Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3) != null)) {
/* 48 */       helmet = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3).getItem();
/*    */     } else {
/* 50 */       helmet = null;
/*    */     }
/* 52 */     if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)
/*    */     {
/*    */       
/* 58 */       Tessellator t = Tessellator.instance;
/*    */       
/* 60 */       ScaledResolution scale = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
/* 61 */       int width = scale.getScaledWidth();
/* 62 */       int height = scale.getScaledHeight();
/*    */       
/*    */ 
/* 65 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, Slendy.opacity);
/* 66 */       GL11.glEnable(3042);
/* 67 */       GL11.glDisable(2929);
/* 68 */       GL11.glDepthMask(false);
/* 69 */       GL11.glBlendFunc(770, 771);
/* 70 */       GL11.glDisable(3008);
/*    */       
/* 72 */       if (Minecraft.getMinecraft().ingameGUI.getUpdateCounter() % 20 < 3) {
/* 73 */         Minecraft.getMinecraft().renderEngine.bindTexture(Infinibox.static1);
/*    */       } else {
/* 75 */         Minecraft.getMinecraft().renderEngine.bindTexture(Infinibox.static2);
/*    */       }
/* 77 */       t.startDrawingQuads();
/* 78 */       t.addVertexWithUV(0.0D, height, 90.0D, 0.0D, 1.0D);
/* 79 */       t.addVertexWithUV(width, height, 90.0D, 1.0D, 1.0D);
/* 80 */       t.addVertexWithUV(width, 0.0D, 90.0D, 1.0D, 0.0D);
/* 81 */       t.addVertexWithUV(0.0D, 0.0D, 90.0D, 0.0D, 0.0D);
/* 82 */       t.draw();
/*    */       
/* 84 */       GL11.glPopAttrib();
/*    */     }
/*    */   }
/*    */ }

/* Location:           F:\MCP\InfiniboxMod\libs\SlenderMan-3.3_1.7.10-deobf.jar
 * Qualified Name:     net.dudgames.slender.client.ClientStaticEffect
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */