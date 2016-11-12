package com.monsterspawned.infinibox.entities.aggressive;

import java.util.Random;

import com.monsterspawned.infinibox.Infinibox;
import com.monsterspawned.infinibox.entities.InfiniboxMob;
import com.monsterspawned.infinibox.handler.ConfigurationHandler;

/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Slendy extends InfiniboxMob
/*     */ {
/*     */   private int breakLight;
/*     */   private int breakNextLight;
/*     */   public static int musictimer;
/*     */   private boolean destroyPerGo;
/*     */   private boolean canSeeSkyAndDay;
/*     */   private int petrifyTimer;
/*     */   private boolean timeLocked;
/*  33 */   private int timeTillNextTeleport = 0;
/*  34 */   private int Teleport200 = 0;
/*  35 */   private int Teleport100 = 0;
/*  36 */   private int[] seeThrough = { 20, 8, 9, 10, 11, 18, 27, 28, 30, 31, 32, 37, 38, 39, 40, 44, 50, 51, 52, 59, 64, 65, 66, 67, 69, 70, 71, 72, 75, 76, 77, 78, 83, 85, 90, 92, 96, 101, 102, 106, 107, 108, 109, 111, 113, 114, 114, 117 };
/*  37 */   private int ScaryTimer = 0;
/*  38 */   private int directlookscare = 0;
/*  39 */   private int potiontimer = 0;
/*     */   private double randZonCircle;
/*     */   private double randXonCircle;
/*  42 */   public static float opacity = 0.0F;
/*     */   private static InventoryPlayer inventory;

/*  44 */   private int staticsoundtimer = 20;
/*     */   
/*     */   public Slendy(World var1)
/*     */   {
/*  48 */     super(var1);
/*  49 */     stepHeight = 5.0F;
/*  50 */     setSize(0.8F, 2.5F);
/*  51 */     isImmuneToFire = true;
/*  52 */     breakNextLight = rand.nextInt(100);
/*  53 */     if ((!ConfigurationHandler.canSlendySpawn) && (!worldObj.isRemote)) {
/*  54 */       setDead();
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
/*     */   protected void dropFewItems(boolean var1, int var2)
/*     */   {
/*  73 */     Item var3 = getDropItem();
/*  74 */     int var4 = rand.nextInt(2 + var2);
/*     */     
/*  76 */     for (int var5 = 0; var5 < var4; var5++)
/*     */     {
/*  78 */       dropItem(var3, 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void applyEntityAttributes()
/*     */   {
/*  85 */     super.applyEntityAttributes();
/*  86 */     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0D);
/*  87 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
/*  88 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
/*  89 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected Entity findPlayerToAttack()
/*     */   {
/* 101 */     EntityPlayer var1 = worldObj.getClosestPlayerToEntity(this, 200.0D);
/* 102 */     return (var1 != null) && (canSlendermanBeSeen(var1)) ? var1 : null;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean teleportRandomly()
/*     */   {
/* 108 */     double var1 = posX + (rand.nextDouble() - 0.5D) * 12.0D;
/* 109 */     double var3 = posY + (rand.nextInt(64) - 32);
/* 110 */     double var5 = posZ + (rand.nextDouble() - 0.5D) * 12.0D;
/* 111 */     return teleportTo1(var1, var3, var5);
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
/*     */   public double randomXonCircle(int radius1, int radius2, double SlendyposX)
/*     */   {
/* 125 */     int radius = radius2 - radius1;
/* 126 */     double angle = Math.random() * 3.141592653589793D * 2.0D;
/* 127 */     randXonCircle = (SlendyposX + radius * Math.cos(angle));
/* 128 */     return randXonCircle;
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
/* 142 */     int radius = radius2 - radius1;
/* 143 */     double angle = Math.random() * 3.141592653589793D * 2.0D;
/* 144 */     randZonCircle = (SlendyposZ + radius * Math.sin(angle));
/* 145 */     return randZonCircle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onUpdate()
/*     */   {
/* 155 */     super.onUpdate();
/*     */     
/* 157 */     if (!worldObj.isRemote)
/*     */     {
/* 159 */       worldObj.spawnParticle("depthsuspend", posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height - 0.25D, posZ + (rand.nextDouble() - 0.5D) * width, 1.0D + rand.nextDouble(), 1.0D + rand.nextDouble(), 1.0D + rand.nextDouble());
/* 160 */       EntityPlayer var3 = worldObj.getClosestPlayerToEntity(this, 200.0D);
/* 161 */       destroyPerGo = false;
/* 162 */       isJumping = false;
/*     */       
/*     */ 
/* 165 */       if (timeTillNextTeleport < 100) timeTillNextTeleport += 1;
/* 166 */       if (Teleport200 < 800) Teleport200 += 1;
/* 167 */       if (Teleport100 < 400) Teleport100 += 1;
/* 168 */       if (directlookscare < 60) directlookscare += 1;
/* 169 */       if (potiontimer < 200) potiontimer += 1;
/* 170 */       if (ScaryTimer < 300) ScaryTimer += 1;
/* 171 */       if (staticsoundtimer < 20) { staticsoundtimer += 1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 176 */       if ((getDistancetoEntityToAttack() >= 100.0D) && (getDistancetoEntityToAttack() <= 250.0D) && (getDistancetoEntityToAttack() <= 200.0D) && (Teleport200 == 800))
/*     */       {
/* 178 */         double newRandX = randomXonCircle(60, 120, posX);
/* 179 */         double newRandZ = randomZonCircle(60, 120, posZ);
/* 180 */         teleportTo1(newRandX, posY, newRandZ);
/* 181 */         Teleport200 = 0;
/*     */       }
/*     */       
/* 184 */       if ((getDistancetoEntityToAttack() >= 65.0D) && (getDistancetoEntityToAttack() <= 99.0D) && (getDistancetoEntityToAttack() <= 200.0D) && (Teleport100 == 400))
/*     */       {
/* 186 */         double newRandX = randomXonCircle(40, 75, posX);
/* 187 */         double newRandZ = randomZonCircle(40, 75, posZ);
/* 188 */         teleportTo1(newRandX, posY, newRandZ);
/* 189 */         Teleport100 = 0;
/* 190 */         Random randomer = new Random();
/* 191 */         int playscarynoise = randomer.nextInt(5);
/* 192 */         if ((ScaryTimer == 300) && (playscarynoise == 5))
/*     */         {
/* 194 */           worldObj.playSoundAtEntity(var3, "infinibox:scare", getSoundVolume(), 1.0F);
/* 195 */           ScaryTimer = 0;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 200 */       if ((getDistancetoEntityToAttack() <= 64.0D) && (musictimer == 2400))
/*     */       {
/* 202 */         worldObj.playSoundAtEntity(this, "infinibox:close", getSoundVolume() + 10.0F, 1.0F);
/* 203 */         musictimer = 0;
/*     */       }
/*     */       
/*     */ 
/* 207 */       if ((entityToAttack != null) && ((entityToAttack instanceof EntityPlayer)))
/*     */       {
/* 209 */         if ((canSlendermanBeSeen((EntityPlayer)entityToAttack)) && (getDistancetoEntityToAttack() <= 100.0D))
/*     */         {
/* 211 */           float level = (float)getDistancetoEntityToAttack();
/* 212 */           opacity = 1.5F / level;
/* 213 */           if (staticsoundtimer == 20)
/*     */           {
/* 215 */             worldObj.playSoundAtEntity(this, "infinibox:static", getSoundVolume() + opacity * 4.0F, 1.0F);
/* 216 */             staticsoundtimer = 0;
/*     */           }
/*     */         }
/* 219 */         else if (!canSlendermanBeSeen((EntityPlayer)entityToAttack))
/*     */         {
/* 221 */           opacity = 0.0F;
/*     */         }
/*     */         
/* 224 */         if (!canSlendermanBeSeen((EntityPlayer)entityToAttack))
/*     */         {
/* 226 */           if ((getDistancetoEntityToAttack() <= 64.0D) && (getDistancetoEntityToAttack() >= 16.0D) && (timeTillNextTeleport == 100))
/*     */           {
/* 228 */             double newRandX = randomXonCircle(10, 40, posX);
/* 229 */             double newRandZ = randomZonCircle(10, 40, posZ);
/*     */             
/* 231 */             teleportTo1(newRandX, posY, newRandZ);
/* 232 */             timeTillNextTeleport = 0;
/*     */           }
/*     */           
/* 235 */           if ((getDistancetoEntityToAttack() <= 15.0D) && (timeTillNextTeleport == 100))
/*     */           {
/* 237 */             double newRandX = randomXonCircle(3, 10, posX);
/* 238 */             double newRandZ = randomZonCircle(3, 10, posZ);
/*     */             
/* 240 */             teleportTo1(newRandX, posY, newRandZ);
/* 241 */             if (ScaryTimer == 300)
/*     */             {
/* 243 */               worldObj.playSoundAtEntity(var3, "infinibox:scare", getSoundVolume(), 1.0F);
/* 244 */               ScaryTimer = 0;
/*     */             }
/* 246 */             timeTillNextTeleport = 0;
/*     */           }
/*     */         }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 266 */         if (isPlayerLooking(var3))
/*     */         {
/* 268 */           petrifyTimer = 20;
/*     */         }
/*     */         
/*     */ 
/* 272 */         if ((worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1) && (worldObj.getFullBlockLightValue(MathHelper.floor_double(entityToAttack.posX), MathHelper.floor_double(entityToAttack.posY), MathHelper.floor_double(entityToAttack.posZ)) < 1))
/*     */         {
/* 274 */           worldObj.playSoundAtEntity(this, "infinibox:attack", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
/*     */         }
/*     */         
/* 277 */         if ((petrifyTimer <= 20) && (petrifyTimer >= 15) && (potiontimer == 200))
/*     */         {
/*     */ 
/* 280 */           motionX *= 0.01D;
/* 281 */           motionZ *= 0.01D;
/*     */           
/* 283 */           ((EntityLivingBase)entityToAttack).addPotionEffect(new net.minecraft.potion.PotionEffect(2, 100, 2));
/* 284 */           ((EntityLivingBase)entityToAttack).addPotionEffect(new net.minecraft.potion.PotionEffect(15, 100, 2));
/*     */           
/* 286 */           moveStrafing = (moveForward = 5.0F);
/* 287 */           teleportToEntity(var3);
/*     */           
/* 289 */           petrifyTimer -= 1;
/* 290 */           potiontimer -= 1;
/* 291 */           potiontimer -= 1;
/* 292 */           potiontimer -= 1;
/*     */           
/* 294 */           if (directlookscare == 60)
/*     */           {
/* 296 */             worldObj.playSoundAtEntity(var3, "infinibox:lights", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
/* 297 */             directlookscare = 0;
/*     */           }
/*     */         }
/*     */         
/* 301 */         if (((entityToAttack instanceof EntityPlayer)) && ((canSlendermanBeSeen((EntityPlayer)entityToAttack)) || (timeLocked)))
/*     */         {
/* 303 */           slendermanDirectLook((EntityPlayer)entityToAttack);
/* 304 */           moveStrafing = (moveForward = 0.0F);
/* 305 */           breakLight += 1;
/*     */           
/* 307 */           if ((breakLight >= breakNextLight) && (!canSeeSkyAndDay))
/*     */           {
/* 309 */             breakLight = 0;
/* 310 */             breakNextLight = rand.nextInt(100);
/* 311 */             findNearestTorch();
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 316 */           faceEntity(entityToAttack, 100.0F, 100.0F);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void updateAITasks()
/*     */   {
/* 329 */     super.updateAITasks();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canBePushed()
/*     */   {
/* 335 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isPlayerLooking(EntityPlayer par1EntityPlayer)
/*     */   {
/* 340 */     if (par1EntityPlayer != null)
/*     */     {
/*     */ 
/*     */ 
/* 351 */       Vec3 var3 = par1EntityPlayer.getLook(1.0F).normalize();
/* 352 */       Vec3 var4 = Vec3.createVectorHelper(posX - posX, boundingBox.minY + height / 2.0F - (posY + par1EntityPlayer.getEyeHeight()), posZ - posZ);
/* 353 */       double var5 = var4.lengthVector();
/* 354 */       var4 = var4.normalize();
/* 355 */       double var7 = var3.dotProduct(var4);
/* 356 */       return var7 > 1.0D - 0.025D / var5 ? par1EntityPlayer.canEntityBeSeen(this) : false;
/*     */     }
/*     */     
/* 359 */     return false;
/*     */   }
/*     */   
/*     */   private boolean slendermanDirectLook(EntityPlayer var1)
/*     */   {
/* 364 */     if (worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1)
/*     */     {
/* 366 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 370 */     Vec3 var2 = var1.getLook(1.0F).normalize();
/* 371 */     Vec3 var3 = Vec3.createVectorHelper(posX - posX, boundingBox.minY + height - posY + var1.getEyeHeight(), posZ - posZ);
/* 372 */     double var4 = var3.lengthVector();
/* 373 */     var3 = var3.normalize();
/* 374 */     double var6 = var2.dotProduct(var3);
/*     */     
/* 376 */     if (var6 > 1.0D - 0.025D / var4)
/*     */     {
/*     */ 
/* 379 */       if (var1.canEntityBeSeen(this))
/*     */       {
/* 381 */         petrifyTimer = rand.nextInt(100);
/*     */       }
/*     */       
/* 384 */       return var1.canEntityBeSeen(this);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 389 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean canSlendermanBeSeen(EntityPlayer var1)
/*     */   {
/* 396 */     return (!var1.canEntityBeSeen(this)) && (!LineOfSightCheck(var1)) ? false : isInFieldOfVision(this, var1, 65.0F, 65.0F);
/*     */   }
/*     */   
/*     */   private boolean LineOfSightCheck(EntityPlayer var1)
/*     */   {
/* 401 */     return (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + getEyeHeight(), posZ), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + height, posZ), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + height * 0.1D, posZ), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX + 0.7D, posY + getEyeHeight(), posZ), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX - 0.7D, posY + getEyeHeight(), posZ), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + getEyeHeight(), posZ + 0.7D), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + getEyeHeight(), posZ - 0.7D), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + height * 1.2D, posZ - 0.7D), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null) || (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + height * 1.2D + 1.0D, posZ), Vec3.createVectorHelper(posX, posY + var1.getEyeHeight(), posZ)) == null);
/*     */   }
/*     */   
/*     */   private MovingObjectPosition rayTraceBlocks(Vec3 var1, Vec3 var2)
/*     */   {
/* 406 */     boolean var3 = false;
/* 407 */     boolean var4 = false;
/*     */     
/* 409 */     if ((!Double.isNaN(this.posX)) && (!Double.isNaN(this.posY)) && (!Double.isNaN(this.posZ)))
/*     */     {
/* 411 */       if ((!Double.isNaN(this.posX)) && (!Double.isNaN(this.posY)) && (!Double.isNaN(this.posZ)))
/*     */       {
/* 413 */         int var5 = MathHelper.floor_double(this.posX);
/* 414 */         int var6 = MathHelper.floor_double(this.posY);
/* 415 */         int var7 = MathHelper.floor_double(this.posZ);
/* 416 */         int var8 = MathHelper.floor_double(this.posX);
/* 417 */         int var9 = MathHelper.floor_double(this.posY);
/* 418 */         int var10 = MathHelper.floor_double(this.posZ);
/* 419 */         int var11 = Block.getIdFromBlock(worldObj.getBlock(var8, var9, var10));
/* 420 */         int var12 = worldObj.getBlockMetadata(var8, var9, var10);
/* 421 */         Block var13 = Block.getBlockById(var11);
/*     */         
/* 423 */         if (((!var4) || (var13 == null) || (var13.getCollisionBoundingBoxFromPool(worldObj, var8, var9, var10) != null)) && (var11 > 0) && (var13.canCollideCheck(var12, var3)))
/*     */         {
/* 425 */           MovingObjectPosition var14 = var13.collisionRayTrace(worldObj, var8, var9, var10, var1, var2);
/*     */           
/* 427 */           if (var14 != null)
/*     */           {
/* 429 */             return var14;
/*     */           }
/*     */         }
/*     */         
/* 433 */         int var42 = 200;
/*     */         
/* 435 */         while (var42-- >= 0)
/*     */         {
/* 437 */           if ((Double.isNaN(this.posX)) || (Double.isNaN(this.posY)) || (Double.isNaN(this.posZ)))
/*     */           {
/* 439 */             return null;
/*     */           }
/*     */           
/* 442 */           if ((var8 == var5) && (var9 == var6) && (var10 == var7))
/*     */           {
/* 444 */             return null;
/*     */           }
/*     */           
/* 447 */           boolean var15 = true;
/* 448 */           boolean var16 = true;
/* 449 */           boolean var17 = true;
/* 450 */           double var18 = 999.0D;
/* 451 */           double var20 = 999.0D;
/* 452 */           double var22 = 999.0D;
/*     */           
/* 454 */           if (var5 > var8)
/*     */           {
/* 456 */             var18 = var8 + 1.0D;
/*     */           }
/* 458 */           else if (var5 < var8)
/*     */           {
/* 460 */             var18 = var8 + 0.0D;
/*     */           }
/*     */           else
/*     */           {
/* 464 */             var15 = false;
/*     */           }
/*     */           
/* 467 */           if (var6 > var9)
/*     */           {
/* 469 */             var20 = var9 + 1.0D;
/*     */           }
/* 471 */           else if (var6 < var9)
/*     */           {
/* 473 */             var20 = var9 + 0.0D;
/*     */           }
/*     */           else
/*     */           {
/* 477 */             var16 = false;
/*     */           }
/*     */           
/* 480 */           if (var7 > var10)
/*     */           {
/* 482 */             var22 = var10 + 1.0D;
/*     */           }
/* 484 */           else if (var7 < var10)
/*     */           {
/* 486 */             var22 = var10 + 0.0D;
/*     */           }
/*     */           else
/*     */           {
/* 490 */             var17 = false;
/*     */           }
/*     */           
/* 493 */           double var24 = 999.0D;
/* 494 */           double var26 = 999.0D;
/* 495 */           double var28 = 999.0D;
/* 496 */           double var30 = this.posX - this.posX;
/* 497 */           double var32 = this.posY - this.posY;
/* 498 */           double var34 = this.posZ - this.posZ;
/*     */           
/* 500 */           if (var15)
/*     */           {
/* 502 */             var24 = (var18 - this.posX) / var30;
/*     */           }
/*     */           
/* 505 */           if (var16)
/*     */           {
/* 507 */             var26 = (var20 - this.posY) / var32;
/*     */           }
/*     */           
/* 510 */           if (var17)
/*     */           {
/* 512 */             var28 = (var22 - this.posZ) / var34;
/*     */           }
/*     */           
/*     */           byte var43;
/*     */           
/* 517 */           if ((var24 < var26) && (var24 < var28)) {
/* 519 */             if (var5 > var8)
/*     */             {
/* 521 */               var43 = 4;
/*     */             }
/*     */             else
/*     */             {
/* 525 */               var43 = 5;
/*     */             }
/*     */             
/* 528 */             this.posX = var18;
/* 529 */             this.posY += var32 * var24;
/* 530 */             this.posZ += var34 * var24;
/*     */           }
/* 532 */           else if (var26 < var28) {
/* 534 */             if (var6 > var9)
/*     */             {
/* 536 */               var43 = 0;
/*     */             }
/*     */             else
/*     */             {
/* 540 */               var43 = 1;
/*     */             }
/*     */             
/* 543 */             this.posX += var30 * var26;
/* 544 */             this.posY = var20;
/* 545 */             this.posZ += var34 * var26;
/*     */           }
/*     */           else {
/* 549 */             if (var7 > var10)
/*     */             {
/* 551 */               var43 = 2;
/*     */             }
/*     */             else
/*     */             {
/* 555 */               var43 = 3;
/*     */             }
/*     */             
/* 558 */             this.posX += var30 * var28;
/* 559 */             this.posY += var32 * var28;
/* 560 */             this.posZ = var22;
/*     */           }
/*     */           
/* 563 */           Vec3 var37 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 564 */           var8 = (int)(this.posX = MathHelper.floor_double(this.posX));
/*     */           
/* 566 */           if (var43 == 5)
/*     */           {
/* 568 */             var8--;
/* 569 */             this.posX += 1.0D;
/*     */           }
/*     */           
/* 572 */           var9 = (int)(this.posY = MathHelper.floor_double(this.posY));
/*     */           
/* 574 */           if (var43 == 1)
/*     */           {
/* 576 */             var9--;
/* 577 */             this.posY += 1.0D;
/*     */           }
/*     */           
/* 580 */           var10 = (int)(this.posZ = MathHelper.floor_double(this.posZ));
/*     */           
/* 582 */           if (var43 == 3)
/*     */           {
/* 584 */             var10--;
/* 585 */             this.posZ += 1.0D;
/*     */           }
/*     */           
/* 588 */           int var38 = Block.getIdFromBlock(worldObj.getBlock(var8, var9, var10));
/* 589 */           int var39 = worldObj.getBlockMetadata(var8, var9, var10);
/* 590 */           Block var40 = Block.getBlockById(var38);
/*     */           
/* 592 */           if (((!var4) || (var40 == null) || (var40.getCollisionBoundingBoxFromPool(worldObj, var8, var9, var10) != null)) && (var38 > 0) && (var40.canCollideCheck(var39, var3)) && (!isBlockTransparent(var38)))
/*     */           {
/* 594 */             MovingObjectPosition var41 = var40.collisionRayTrace(worldObj, var8, var9, var10, var1, var2);
/*     */             
/* 596 */             if (var41 != null)
/*     */             {
/* 598 */               return var41;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 603 */         return null;
/*     */       }
/*     */       
/*     */ 
/* 607 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 612 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isBlockTransparent(int var1)
/*     */   {
/* 618 */     for (int var2 = 0; var2 < seeThrough.length; var2++)
/*     */     {
/* 620 */       if (var1 == seeThrough[var2])
/*     */       {
/* 622 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 626 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean canDespawn()
/*     */   {
/* 632 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean teleportTo1(double var1, double var3, double var5)
/*     */   {
/* 637 */     double var7 = posX;
/* 638 */     double var9 = posY;
/* 639 */     double var11 = posZ;
/* 640 */     posX = var1;
/* 641 */     posY = var3;
/* 642 */     posZ = var5;
/* 643 */     boolean var13 = false;
/* 644 */     int var14 = MathHelper.floor_double(posX);
/* 645 */     int var15 = MathHelper.floor_double(posY);
/* 646 */     int var16 = MathHelper.floor_double(posZ);
/*     */     
/*     */ 
/* 649 */     if (worldObj.blockExists(var14, var15, var16))
/*     */     {
/* 651 */       boolean var17 = false;
/*     */       
/* 653 */       while ((!var17) && (var15 > 0))
/*     */       {
/* 655 */         int var18 = Block.getIdFromBlock(worldObj.getBlock(var14, var15 - 1, var16));
/*     */         
/* 657 */         if ((var18 != 0) && (Block.getBlockById(var18).getMaterial().isSolid()))
/*     */         {
/* 659 */           var17 = true;
/*     */         }
/*     */         else
/*     */         {
/* 663 */           posY -= 1.0D;
/* 664 */           var15--;
/*     */         }
/*     */       }
/*     */       
/* 668 */       if (var17)
/*     */       {
/* 670 */         setPosition(posX, posY, posZ);
/* 671 */         if ((worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0) && (!worldObj.isAnyLiquid(boundingBox)))
/*     */         {
/* 673 */           var13 = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 678 */     if (!var13)
/*     */     {
/* 680 */       setPosition(var7, var9, var11);
/* 681 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 685 */     boolean var17 = true;
/* 686 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean teleportToEntity(Entity var1)
/*     */   {
/* 692 */     Vec3 var2 = Vec3.createVectorHelper(posX - posX, boundingBox.minY + height / 2.0F - posY + var1.getEyeHeight(), posZ - posZ);
/* 693 */     var2 = var2.normalize();
/* 694 */     double var3 = 6.0D;
/* 695 */     double var5 = posX + (rand.nextDouble() - 0.5D) * 8.0D - this.posX * var3;
/* 696 */     double var7 = posY + (rand.nextInt(16) - 8) - this.posY * var3;
/* 697 */     double var9 = posZ + (rand.nextDouble() - 0.5D) * 8.0D - this.posZ * var3;
/* 698 */     return teleportTo1(var5, var7, var9);
/*     */   }
/*     */   
/*     */   private boolean isInFieldOfVision(Slendy var1, EntityPlayer var17, float var3, float var4)
/*     */   {
/* 703 */     float var5 = rotationYaw;
/* 704 */     float var6 = rotationPitch;
/* 705 */     faceEntity(var1, 360.0F, 360.0F, var17);
/* 706 */     float var7 = rotationYaw;
/* 707 */     float var8 = rotationPitch;
/* 708 */     rotationYaw = var5;
/* 709 */     rotationPitch = var6;
/* 710 */     float var11 = rotationYaw - var3;
/* 711 */     float var12 = rotationYaw + var3;
/* 712 */     float var13 = rotationPitch - var4;
/* 713 */     float var14 = rotationPitch + var4;
/* 714 */     boolean var15 = GetFlag(var11, var12, var7, 0.0F, 360.0F);
/* 715 */     boolean var16 = GetFlag(var13, var14, var8, -180.0F, 180.0F);
/* 716 */     return (var15) && (var16) && ((var17.canEntityBeSeen(var1)) || (LineOfSightCheck(var17)));
/*     */   }
/*     */   
/*     */ 
/*     */   public void faceEntity(Entity par1Entity, float par2, float par3, EntityPlayer var4)
/*     */   {
/* 722 */     double d0 = posX - posX;
/* 723 */     double d1 = posZ - posZ;
/*     */     double d2;
/*     */     double d3;
/* 726 */     if ((par1Entity instanceof EntityLivingBase))
/*     */     {
/* 728 */       EntityLivingBase entitylivingbase = (EntityLivingBase)par1Entity;
/* 729 */       d2 = posY + entitylivingbase.getEyeHeight() - (posY + var4.getEyeHeight());
/*     */     }
/*     */     else
/*     */     {
/* 733 */       d2 = (boundingBox.minY + boundingBox.maxY) / 2.0D - (posY + var4.getEyeHeight());
/*     */     }
/*     */     
/* 736 */     double d4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
/* 737 */     float f2 = (float)(Math.atan2(d1, d0) * 180.0D / 3.141592653589793D) - 90.0F;
/* 738 */     float f3 = (float)-(Math.atan2(d2, d4) * 180.0D / 3.141592653589793D);
/* 739 */     rotationPitch = updateRotation(rotationPitch, f3, par3);
/* 740 */     rotationYaw = updateRotation(rotationYaw, f2, par2);
/*     */   }
/*     */   
/*     */   private float updateRotation(float par1, float par2, float par3)
/*     */   {
/* 745 */     float f3 = MathHelper.wrapAngleTo180_float(par2 - par1);
/*     */     
/* 747 */     if (f3 > par3)
/*     */     {
/* 749 */       f3 = par3;
/*     */     }
/*     */     
/* 752 */     if (f3 < -par3)
/*     */     {
/* 754 */       f3 = -par3;
/*     */     }
/*     */     
/* 757 */     return par1 + f3;
/*     */   }
/*     */   
/*     */   public boolean GetFlag(float var1, float var2, float var3, float var4, float var5)
/*     */   {
/* 762 */     if (var1 < var4)
/*     */     {
/* 764 */       if (var3 >= var1 + var5)
/*     */       {
/* 766 */         return true;
/*     */       }
/*     */       
/* 769 */       if (var3 <= var2)
/*     */       {
/* 771 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 775 */     if (var2 >= var5)
/*     */     {
/* 777 */       if (var3 <= var2 - var5)
/*     */       {
/* 779 */         return true;
/*     */       }
/*     */       
/* 782 */       if (var3 >= var1)
/*     */       {
/* 784 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 788 */     return (var3 <= var2) && (var3 > var1);
/*     */   }
/*     */   
/*     */   public double getDistancetoEntityToAttack()
/*     */   {
/* 793 */     if ((entityToAttack instanceof EntityPlayer))
/*     */     {
/* 795 */       double var8 = entityToAttack.posX - posX;
/* 796 */       double var3 = entityToAttack.posY - posY;
/* 797 */       double var5 = entityToAttack.posZ - posZ;
/*     */       
/* 799 */       return MathHelper.sqrt_double(var8 * var8 + var3 * var3 + var5 * var5);
/*     */     }
/*     */     
/*     */ 
/* 803 */     EntityPlayer var1 = worldObj.getClosestPlayerToEntity(this, 200.0D);
/*     */     
/* 805 */     if (var1 != null)
/*     */     {
/* 807 */       double var2 = posX - posX;
/* 808 */       double var4 = posY - posY;
/* 809 */       double var6 = posZ - posZ;
/* 810 */       return MathHelper.sqrt_double(var2 * var2 + var4 * var4 + var6 * var6);
/*     */     }
/*     */     
/*     */ 
/* 814 */     return 10.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getDistance(int var1, int var2, int var3, int var4, int var5, int var6)
/*     */   {
/* 821 */     int var7 = var4 - var1;
/* 822 */     int var8 = var5 - var2;
/* 823 */     int var9 = var6 - var3;
/* 824 */     return Math.sqrt(var7 * var7 + var8 * var8 + var9 * var9);
/*     */   }
/*     */   
/*     */   private void findNearestTorch()
/*     */   {
/* 829 */     int var1 = (int)posX;
/* 830 */     int var2 = (int)posY;
/* 831 */     int var3 = (int)posZ;
/* 832 */     int var4 = var1 + 10;
/* 833 */     int var5 = var2 + 10;
/* 834 */     int var6 = var3 + 10;
/* 835 */     int var7 = var1 - 10;
/* 836 */     int var8 = var2 - 10;
/* 837 */     int var9 = var3 - 10;
/* 838 */     byte var10 = 100;
/*     */     
/* 840 */     for (int var11 = var7; var11 < var4; var11++)
/*     */     {
/* 842 */       int var12 = var8;
/*     */       
/* 844 */       while (var12 < var5)
/*     */       {
/* 846 */         int var13 = var9;
/*     */         
/*     */ 
/*     */ 
/* 850 */         while (var13 < var6)
/*     */         {
/*     */ 
/*     */ 
/* 854 */           if (getDistance(var1, var2, var3, var11, var12, var13) <= var10)
/*     */           {
/* 856 */             int var14 = Block.getIdFromBlock(worldObj.getBlock(var11, var12, var13));
/* 857 */             Block var15 = var14 <= 0 ? null : Block.getBlockById(var14);
/*     */             
/* 859 */             if ((var15 != null) && ((var15 == Blocks.torch) || (var15 == Blocks.redstone_torch) || (var15 == Blocks.planks) || (var15 == Blocks.brick_block) || (var15 == Blocks.wooden_door) || (var15 == Blocks.glass) || (var15 == Blocks.iron_door) || (var15 == Blocks.trapdoor) || (var15 == Blocks.redstone_lamp) || (var15 == Blocks.redstone_block) || (var15 == Blocks.glowstone)) && (rayTraceBlocks(Vec3.createVectorHelper(posX, posY + getEyeHeight(), posZ), Vec3.createVectorHelper(var11, var12, var13)) == null) && (rayTraceBlocks(Vec3.createVectorHelper(entityToAttack.posX, entityToAttack.posY + entityToAttack.getEyeHeight(), entityToAttack.posZ), Vec3.createVectorHelper(var11, var12, var13)) == null))
/*     */             {
/* 861 */               if (destroyPerGo)
/*     */                 break;
/* 863 */               if (var15 == Blocks.glass)
/*     */               {
/* 865 */                 worldObj.playSoundAtEntity(this, "random.glass", getSoundVolume() + 10.0F, 1.0F);
/*     */               }
/*     */               
/* 868 */               if ((var15 == Blocks.wooden_door) || (var15 == Blocks.iron_door))
/*     */               {
/* 870 */                 worldObj.playSoundAtEntity(this, "mob.zombie.woodbreak", getSoundVolume() + 10.0F, 1.0F);
/*     */               }
/* 872 */               var15.dropBlockAsItem(worldObj, var11, var12, var13, 1, 1);
/* 873 */               worldObj.setBlockMetadataWithNotify(var11, var12, var13, 0, 10);
/* 874 */               worldObj.setBlockToAir(var11, var12, var13);
/* 875 */               destroyPerGo = true; break;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 882 */           var13++;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 887 */         var12++;
/*     */       }
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
/*     */   public boolean attackEntityFrom(DamageSource var1, int var2)
/*     */   {
/* 904 */     if (var1 == null)
/*     */     {
/* 906 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 910 */     if ((var1.getSourceOfDamage() instanceof EntityPlayer))
/*     */     {
/* 912 */       EntityPlayer var3 = (EntityPlayer)var1.getSourceOfDamage();
/* 913 */       ItemStack var4 = inventory.getCurrentItem();
/*     */       
/* 915 */       if (worldObj.difficultySetting.getDifficultyId() > 2)
/*     */       {
/* 917 */         if ((var4 != null) && ((var4.getItem() == Items.diamond_sword)))
/*     */         {
/* 919 */           super.attackEntityFrom(var1, var2);
/* 920 */           double newRandX = randomXonCircle(10, 40, posX);
/* 921 */           double newRandZ = randomZonCircle(10, 40, posZ);
/* 922 */           teleportTo1(newRandX, posY, newRandZ);
/*     */         }
/*     */         
/*     */       }
/* 926 */       else if ((var4 != null) && ((var4.getItem() == Items.diamond_sword) || (var4.getItem() == Items.wooden_sword) || (var4.getItem() == Items.stone_sword)))
/*     */       {
/* 928 */         super.attackEntityFrom(var1, var2);
/* 929 */         double newRandX = randomXonCircle(10, 40, posX);
/* 930 */         double newRandZ = randomZonCircle(10, 40, posZ);
/* 931 */         teleportTo1(newRandX, posY, newRandZ);
/*     */       }
/*     */     }
/*     */     
/* 935 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String getDeathSound()
/*     */   {
/* 945 */     return "dg_slender:death";
/*     */   }
/*     */   
/*     */ 
/*     */   public void setDead()
/*     */   {
/* 951 */     Infinibox.slendySpawned = true;
/* 952 */     isDead = true;
/* 953 */     opacity = 0.0F;
/*     */   }
/*     */ }