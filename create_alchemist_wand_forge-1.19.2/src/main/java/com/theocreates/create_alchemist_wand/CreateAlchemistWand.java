package com.theocreates.create_alchemist_wand;

import com.theocreates.create_alchemist_wand.groups.GroupCreateAlchemistWand;
import com.theocreates.create_alchemist_wand.init.ItemInit;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("create_alchemist_wand")
public class CreateAlchemistWand
{

    public static final String modid = "create_alchemist_wand";
	public static final Logger logger = LogManager.getLogger(modid);

	public static final CreativeModeTab create_alchemist_wand = new GroupCreateAlchemistWand();

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(modid, path);
    }

    public CreateAlchemistWand()
    {
    	ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::registerRecipeSerializers);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerRecipeSerializers(RegisterEvent event) {
        event.register(Registry.RECIPE_SERIALIZER_REGISTRY, helper -> {
        });
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        logger.info("CreateAlchemistWand common setup");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
    	logger.info("CreateAlchemistWand client setup");
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("create_alchemist_wand", "hello world", () -> { logger.info("Hello world from CreateAlchemistWand"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
    	logger.info("CreateAlchemistWand IMC setup {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    	logger.info("CreateAlchemistWand server setup");
    }
}
