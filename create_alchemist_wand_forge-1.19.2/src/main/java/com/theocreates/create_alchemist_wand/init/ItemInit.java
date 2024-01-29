package com.theocreates.create_alchemist_wand.init;

import com.theocreates.create_alchemist_wand.CreateAlchemistWand;
import com.theocreates.create_alchemist_wand.items.crafting.WandAlchemist;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateAlchemistWand.modid);

	public static final RegistryObject<Item> WAND_ALCHEMIST = ITEMS.register("wand_alchemist", () -> new WandAlchemist(new Item.Properties().durability(2200).tab(CreateAlchemistWand.create_alchemist_wand)));
	public static final RegistryObject<Item> ALCHEMY_DUST = ITEMS.register("alchemy_dust", () -> new Item(new Item.Properties().tab(CreateAlchemistWand.create_alchemist_wand)));
}
