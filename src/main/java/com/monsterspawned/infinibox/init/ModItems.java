package com.monsterspawned.infinibox.init;

import com.monsterspawned.infinibox.item.InfiniboxItem;
import com.monsterspawned.infinibox.item.ItemMapleLeaf;
import com.monsterspawned.infinibox.reference.Names;
import com.monsterspawned.infinibox.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final InfiniboxItem mapleLeaf = new ItemMapleLeaf();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, Names.Items.MAPLE_LEAF);
    }
}
