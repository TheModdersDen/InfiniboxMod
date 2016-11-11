package com.monsterspawned.infinibox.block;

import com.monsterspawned.infinibox.Infinibox;
import com.monsterspawned.infinibox.creativetab.InfiniboxTab;
import com.monsterspawned.infinibox.entities.CustomTNTPrimed;
import com.monsterspawned.infinibox.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CustomExplosive extends BlockTNT{
	
	private ExplosiveType type = ExplosiveType.NONE;
	
	private IIcon topIcon;
	private IIcon bottomIcon;

	public CustomExplosive(float hardness, ExplosiveType type)
	{
	    this.setHardness(hardness);
		this.setStepSound(Block.soundTypeGrass);
	    this.setCreativeTab(InfiniboxTab.InfiniboxTab);
	    this.SetType(type);
	}
	
	private ExplosiveType SetType(ExplosiveType newType)
	{
		return type = newType;
	}
	
	public ExplosiveType GetType()
	{
		return type;
	}
	
	public CustomExplosive(float hardness, ExplosiveType type, float explosionSize)
	{
	    this.setHardness(hardness);
		this.setStepSound(Block.soundTypeGrass);
	    this.setCreativeTab(InfiniboxTab.InfiniboxTab);
	}

	@Override
	public IIcon getIcon(int i, int j)
	{
		if(i == 0)
		{
			return bottomIcon;
		}
		if(i == 1)
		{
			return topIcon;
		} else
		{
			return blockIcon;
		}
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		if (!world.isRemote)
	    {
			EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), explosion.getExplosivePlacedBy());
	        entitytntprimed.fuse = world.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
	        world.spawnEntityInWorld(entitytntprimed);
	    }
	}
	

	public void func_150114_a(World world, int x, int y, int z, int p_150114_5_, EntityLivingBase p_150114_6_)
	{
	    if (!world.isRemote)
	    {
	        if ((p_150114_5_ & 1) == 1)
	        {
	            CustomTNTPrimed entitytntprimed = new CustomTNTPrimed(world, type);
	            world.spawnEntityInWorld(entitytntprimed);
	            if(type == ExplosiveType.EVIL)
	            {
	            	 //world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            } else if(type == ExplosiveType.BASS_CANNON) {
	            	 //world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            } else if(type == ExplosiveType.HAPPY) {
	            	 //world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            } else if(type == ExplosiveType.PLEASE_NO) {
	            	 //world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            } else if(type == ExplosiveType.FIREWORK) {
	            	 //world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            } else {
	            	 world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            }
	        }
	    }
	}

	/**
	  * Called upon block activation (right click on the block.)
	  */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hit_x, float hit_y, float hit_z)
	{
	    if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.flint_and_steel)
	    {
	        this.func_150114_a(world, x, y, z, 1, player);
	        world.setBlockToAir(x, y, z);
	        player.getCurrentEquippedItem().damageItem(1, player);
	        return true;
	    }
	    else
	    {
	        return super.onBlockActivated(world, x, y, z, player, side, hit_x, hit_y, hit_z);
	    }
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon_registrar)
	{
	    blockIcon = icon_registrar.registerIcon(Reference.MOD_ID + ":" + type.toString().toLowerCase());
	    topIcon = icon_registrar.registerIcon(Reference.MOD_ID + ":" + type.toString().toLowerCase() + "_top");
	    bottomIcon = icon_registrar.registerIcon(Reference.MOD_ID + ":" + type.toString().toLowerCase() + "_bottom");
	}
}