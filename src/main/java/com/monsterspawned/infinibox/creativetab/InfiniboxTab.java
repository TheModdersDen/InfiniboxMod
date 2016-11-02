package com.monsterspawned.infinibox.creativetab;

import com.monsterspawned.infinibox.init.ModItems;
import com.monsterspawned.infinibox.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class InfiniboxTab
{
    public static final CreativeTabs InfiniboxTab = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.mapleLeaf;
        }
    };
}
