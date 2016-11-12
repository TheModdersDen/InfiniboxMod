package com.monsterspawned.infinibox.entities.model;

import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class ModelSlendy extends ModelBase
/*     */ {
/*     */   ModelRenderer FootLeft;
/*     */   ModelRenderer LegLeft1;
/*     */   ModelRenderer LeftLeg2;
/*     */   ModelRenderer FootRight;
/*     */   ModelRenderer LegRight1;
/*     */   ModelRenderer LegRight2;
/*     */   ModelRenderer Torso;
/*     */   ModelRenderer Chest;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer LA1;
/*     */   ModelRenderer LA2;
/*     */   ModelRenderer H1;
/*     */   ModelRenderer h2;
/*     */   ModelRenderer h3;
/*     */   ModelRenderer h4;
/*     */   ModelRenderer h5;
/*     */   ModelRenderer h6;
/*     */   ModelRenderer RA1;
/*     */   ModelRenderer RA2;
/*     */   ModelRenderer h7;
/*     */   ModelRenderer h8;
/*     */   ModelRenderer h9;
/*     */   ModelRenderer j1;
/*     */   ModelRenderer j2;
/*     */   ModelRenderer j3;
/*     */   float var7;
/*     */   float var8;
/*     */   
			

/*     */   public ModelSlendy()
/*     */   {
/*  39 */     textureWidth = 64;
/*  40 */     textureHeight = 32;
/*     */     
/*  42 */     FootLeft = new ModelRenderer(this, 50, 26);
/*  43 */     FootLeft.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 4);
/*  44 */     FootLeft.setRotationPoint(-1.5F, 23.0F, -4.0F);
/*  45 */     FootLeft.setTextureSize(64, 32);
/*  46 */     FootLeft.mirror = true;
/*  47 */     setRotation(FootLeft, 0.0F, 0.0F, 0.0F);
/*  48 */     LegLeft1 = new ModelRenderer(this, 56, 13);
/*  49 */     LegLeft1.addBox(-1.0F, 0.0F, -1.5F, 2, 10, 2);
/*  50 */     LegLeft1.setRotationPoint(-1.5F, 13.0F, -4.0F);
/*  51 */     LegLeft1.setTextureSize(64, 32);
/*  52 */     LegLeft1.mirror = true;
/*  53 */     setRotation(LegLeft1, 0.0F, 0.0F, 0.0F);
/*  54 */     LeftLeg2 = new ModelRenderer(this, 47, 5);
/*  55 */     LeftLeg2.addBox(-1.0F, 0.0F, -2.0F, 2, 13, 2);
/*  56 */     LeftLeg2.setRotationPoint(-1.5F, 0.4F, -2.0F);
/*  57 */     LeftLeg2.setTextureSize(64, 32);
/*  58 */     LeftLeg2.mirror = true;
/*  59 */     setRotation(LeftLeg2, -0.1115358F, 0.0F, 0.0F);
/*  60 */     FootRight = new ModelRenderer(this, 50, 26);
/*  61 */     FootRight.addBox(-1.0F, 0.0F, -3.0F, 2, 2, 4);
/*  62 */     FootRight.setRotationPoint(1.5F, 22.0F, -4.0F);
/*  63 */     FootRight.setTextureSize(64, 32);
/*  64 */     FootRight.mirror = true;
/*  65 */     setRotation(FootRight, 0.0F, 0.0F, 0.0F);
/*  66 */     LegRight1 = new ModelRenderer(this, 56, 13);
/*  67 */     LegRight1.addBox(-1.0F, 0.0F, -1.5F, 2, 10, 2);
/*  68 */     LegRight1.setRotationPoint(1.5F, 13.0F, -4.0F);
/*  69 */     LegRight1.setTextureSize(64, 32);
/*  70 */     LegRight1.mirror = true;
/*  71 */     setRotation(LegRight1, 0.0F, 0.0F, 0.0F);
/*  72 */     LegRight2 = new ModelRenderer(this, 47, 6);
/*  73 */     LegRight2.addBox(-1.0F, 0.0F, -2.0F, 2, 12, 2);
/*  74 */     LegRight2.setRotationPoint(1.5F, 1.0F, -2.0F);
/*  75 */     LegRight2.setTextureSize(64, 32);
/*  76 */     LegRight2.mirror = true;
/*  77 */     setRotation(LegRight2, -0.1116138F, 0.0F, 0.0F);
/*  78 */     Torso = new ModelRenderer(this, 25, 19);
/*  79 */     Torso.addBox(-3.0F, -7.0F, -2.0F, 6, 8, 4);
/*  80 */     Torso.setRotationPoint(0.0F, 0.0F, -3.0F);
/*  81 */     Torso.setTextureSize(64, 32);
/*  82 */     Torso.mirror = true;
/*  83 */     setRotation(Torso, 0.0743572F, 0.0F, 0.0F);
/*  84 */     Chest = new ModelRenderer(this, 2, 17);
/*  85 */     Chest.addBox(-3.0F, -8.0F, -2.0F, 6, 10, 4);
/*  86 */     Chest.setRotationPoint(0.0F, -8.0F, -4.0F);
/*  87 */     Chest.setTextureSize(64, 32);
/*  88 */     Chest.mirror = true;
/*  89 */     setRotation(Chest, 0.2602503F, 0.0F, 0.0F);
/*  90 */     Head = new ModelRenderer(this, 7, 3);
/*  91 */     Head.addBox(-2.0F, -2.0F, -2.0F, 4, 5, 4);
/*  92 */     Head.setRotationPoint(0.0F, -19.0F, -8.0F);
/*  93 */     Head.setTextureSize(64, 32);
/*  94 */     Head.mirror = true;
/*  95 */     setRotation(Head, 0.2974289F, 0.0F, 0.0F);
/*  96 */     LA1 = new ModelRenderer(this, 36, 0);
/*  97 */     LA1.addBox(0.0F, -1.0F, -1.0F, 2, 12, 2);
/*  98 */     LA1.setRotationPoint(3.0F, -15.0F, -5.0F);
/*  99 */     LA1.setTextureSize(64, 32);
/* 100 */     LA1.mirror = true;
/* 101 */     setRotation(LA1, 0.0850557F, 0.185895F, -0.1069887F);
/* 102 */     LA2 = new ModelRenderer(this, 27, 0);
/* 103 */     LA2.addBox(1.0F, 10.0F, 0.0F, 2, 12, 2);
/* 104 */     LA2.setRotationPoint(3.0F, -15.0F, -5.0F);
/* 105 */     LA2.setTextureSize(64, 32);
/* 106 */     LA2.mirror = true;
/* 107 */     setRotation(LA2, 0.0326377F, 0.4332256F, 0.0151844F);
/* 108 */     H1 = new ModelRenderer(this, 0, 0);
/* 109 */     H1.addBox(0.0F, 0.0F, -1.0F, 1, 5, 1);
/* 110 */     H1.setRotationPoint(5.0F, 6.0F, -4.0F);
/* 111 */     H1.setTextureSize(64, 32);
/* 112 */     H1.mirror = true;
/* 113 */     setRotation(H1, -0.1115358F, -0.1487144F, -0.1858931F);
/* 114 */     h2 = new ModelRenderer(this, 0, 0);
/* 115 */     h2.addBox(0.75F, 4.0F, -2.0F, 1, 4, 1);
/* 116 */     h2.setRotationPoint(5.0F, 6.0F, -4.0F);
/* 117 */     h2.setTextureSize(64, 32);
/* 118 */     h2.mirror = true;
/* 119 */     setRotation(h2, 0.0743572F, -0.1487144F, -0.0371786F);
/* 120 */     h3 = new ModelRenderer(this, 0, 0);
/* 121 */     h3.addBox(-1.0F, 0.0F, -1.0F, 1, 5, 1);
/* 122 */     h3.setRotationPoint(5.0F, 6.0F, -4.0F);
/* 123 */     h3.setTextureSize(64, 32);
/* 124 */     h3.mirror = true;
/* 125 */     setRotation(h3, 0.2230717F, -1.449966F, 0.0371786F);
/* 126 */     h4 = new ModelRenderer(this, 0, 0);
/* 127 */     h4.addBox(-1.0F, 4.0F, -1.0F, 1, 4, 1);
/* 128 */     h4.setRotationPoint(5.0F, 6.0F, -4.0F);
/* 129 */     h4.setTextureSize(64, 32);
/* 130 */     h4.mirror = true;
/* 131 */     setRotation(h4, 0.0F, -0.1858931F, 0.0371786F);
/* 132 */     h5 = new ModelRenderer(this, 0, 0);
/* 133 */     h5.addBox(0.0F, 4.0F, 0.0F, 1, 4, 1);
/* 134 */     h5.setRotationPoint(5.0F, 6.0F, -4.0F);
/* 135 */     h5.setTextureSize(64, 32);
/* 136 */     h5.mirror = true;
/* 137 */     setRotation(h5, 0.0F, 0.0F, 0.0F);
/* 138 */     h6 = new ModelRenderer(this, 0, 0);
/* 139 */     h6.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
/* 140 */     h6.setRotationPoint(5.0F, 6.0F, -4.0F);
/* 141 */     h6.setTextureSize(64, 32);
/* 142 */     h6.mirror = true;
/* 143 */     setRotation(h6, 0.0F, 0.0F, 0.0F);
/* 144 */     RA1 = new ModelRenderer(this, 36, 0);
/* 145 */     RA1.addBox(-2.0F, -1.0F, -1.0F, 2, 12, 2);
/* 146 */     RA1.setRotationPoint(-3.0F, -15.0F, -5.0F);
/* 147 */     RA1.setTextureSize(64, 32);
/* 148 */     RA1.mirror = true;
/* 149 */     setRotation(RA1, 0.0743572F, -0.1858931F, 0.1069918F);
/* 150 */     RA2 = new ModelRenderer(this, 27, 0);
/* 151 */     RA2.addBox(-3.0F, 10.0F, 0.0F, 2, 12, 2);
/* 152 */     RA2.setRotationPoint(-3.0F, -15.0F, -5.0F);
/* 153 */     RA2.setTextureSize(64, 32);
/* 154 */     RA2.mirror = true;
/* 155 */     setRotation(RA2, 0.0326346F, -0.4332341F, -0.0151813F);
/* 156 */     h7 = new ModelRenderer(this, 0, 0);
/* 157 */     h7.addBox(1.0F, 0.0F, -1.0F, 1, 5, 1);
/* 158 */     h7.setRotationPoint(-6.0F, 6.0F, -4.0F);
/* 159 */     h7.setTextureSize(64, 32);
/* 160 */     h7.mirror = true;
/* 161 */     setRotation(h7, -0.0371786F, -0.3717861F, -0.0743572F);
/* 162 */     h8 = new ModelRenderer(this, 0, 0);
/* 163 */     h8.addBox(0.0F, 3.0F, 0.0F, 1, 4, 1);
/* 164 */     h8.setRotationPoint(-6.0F, 6.0F, -4.0F);
/* 165 */     h8.setTextureSize(64, 32);
/* 166 */     h8.mirror = true;
/* 167 */     setRotation(h8, 0.0F, 0.0F, 0.0F);
/* 168 */     h9 = new ModelRenderer(this, 0, 0);
/* 169 */     h9.addBox(0.0F, 0.0F, -0.7333333F, 1, 5, 1);
/* 170 */     h9.setRotationPoint(-6.0F, 6.0F, -4.0F);
/* 171 */     h9.setTextureSize(64, 32);
/* 172 */     h9.mirror = true;
/* 173 */     setRotation(h9, -0.3346075F, 0.2602503F, 0.1115358F);
/* 174 */     j1 = new ModelRenderer(this, 0, 0);
/* 175 */     j1.addBox(-1.5F, 4.0F, -2.0F, 1, 4, 1);
/* 176 */     j1.setRotationPoint(-6.0F, 6.0F, -4.0F);
/* 177 */     j1.setTextureSize(64, 32);
/* 178 */     j1.mirror = true;
/* 179 */     setRotation(j1, -0.1115358F, 0.2230717F, -0.1858931F);
/* 180 */     j2 = new ModelRenderer(this, 0, 0);
/* 181 */     j2.addBox(1.5F, 4.0F, -1.5F, 1, 4, 1);
/* 182 */     j2.setRotationPoint(-6.0F, 6.0F, -4.0F);
/* 183 */     j2.setTextureSize(64, 32);
/* 184 */     j2.mirror = true;
/* 185 */     setRotation(j2, 0.0743572F, -0.4833219F, 0.0743572F);
/* 186 */     j3 = new ModelRenderer(this, 0, 0);
/* 187 */     j3.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
/* 188 */     j3.setRotationPoint(-6.0F, 6.0F, -4.0F);
/* 189 */     j3.setTextureSize(64, 32);
/* 190 */     j3.mirror = true;
/* 191 */     setRotation(j3, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 198 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 199 */     setRotationAngles(f, f1, f2, f3, f4, f5);
/* 200 */     FootLeft.render(f5);
/* 201 */     LegLeft1.render(f5);
/* 202 */     LeftLeg2.render(f5);
/* 203 */     FootRight.render(f5);
/* 204 */     LegRight1.render(f5);
/* 205 */     LegRight2.render(f5);
/* 206 */     Torso.render(f5);
/* 207 */     Chest.render(f5);
/* 208 */     Head.render(f5);
/* 209 */     LA1.render(f5);
/* 210 */     LA2.render(f5);
/* 211 */     H1.render(f5);
/* 212 */     h2.render(f5);
/* 213 */     h3.render(f5);
/* 214 */     h4.render(f5);
/* 215 */     h5.render(f5);
/* 216 */     h6.render(f5);
/* 217 */     RA1.render(f5);
/* 218 */     RA2.render(f5);
/* 219 */     h7.render(f5);
/* 220 */     h8.render(f5);
/* 221 */     h9.render(f5);
/* 222 */     j1.render(f5);
/* 223 */     j2.render(f5);
/* 224 */     j3.render(f5);
/*     */   }
/*     */   
/*     */ 
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z)
/*     */   {
/* 230 */     model.rotateAngleX = x;
/* 231 */     model.rotateAngleY = y;
/* 232 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
/*     */   {
/* 240 */     super.setRotationAngles(var1, var2, var3, var4, var5, var6, null);
/* 241 */     Head.rotateAngleY = (var4 / 57.295776F);
/* 242 */     Head.rotateAngleX = (var5 / 57.295776F);
/*     */   }
/*     */ }

/* Location:           F:\MCP\InfiniboxMod\libs\SlenderMan-3.3_1.7.10-deobf.jar
 * Qualified Name:     net.dudgames.slender.model.ModelSlenderman
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
