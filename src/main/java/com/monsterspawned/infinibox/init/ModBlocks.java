package com.monsterspawned.infinibox.init;

import com.monsterspawned.infinibox.block.BlockFlag;
import com.monsterspawned.infinibox.block.InfiniboxBlock;
import com.monsterspawned.infinibox.reference.Names;
import com.monsterspawned.infinibox.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final InfiniboxBlock flag = new BlockFlag();

    public static void init()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
    }
}
