package com.monsterspawned.infinibox.entities.render;

import com.monsterspawned.infinibox.entities.aggressive.Slendy;
import com.monsterspawned.infinibox.reference.Reference;

/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSlendy extends RenderLiving
/*    */ {
/*    */   public RenderSlendy(ModelBase var1, float var2)
/*    */   {
/* 18 */     super(var1, var2);
/*    */   }
/*    */   
/*    */   public void renderSlenderman(Slendy var1, double var2, double var4, double var6, float var8, float var9)
/*    */   {
/* 23 */     super.doRender(var1, var2, var4, var6, var8, var9);
/*    */   }
/*    */   
/*    */   public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
/*    */   {
/* 28 */     renderSlenderman((Slendy)var1, var2, var4, var6, var8, var9);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
/*    */   {
/* 40 */     renderSlenderman((Slendy)var1, var2, var4, var6, var8, var9);
/*    */   }
/*    */   
/*    */ 
/*    */   protected ResourceLocation getEntityTexture(Entity entity)
/*    */   {
/* 46 */     return new ResourceLocation(Reference.MOD_ID, ":textures.misc.Slender");
/*    */   }
/*    */ }

/* Location:           F:\MCP\InfiniboxMod\libs\SlenderMan-3.3_1.7.10-deobf.jar
 * Qualified Name:     net.dudgames.slender.render.RenderSlenderman
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */