package com.theocreates.create_alchemist_wand.groups;

import com.theocreates.create_alchemist_wand.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class GroupCreateAlchemistWand extends CreativeModeTab
{
	public GroupCreateAlchemistWand() 
	{
		super("create_alchemist_wand");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return new ItemStack(ItemInit.WAND_ALCHEMIST.get());
	}	
}
