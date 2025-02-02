package io.github.cleanroommc.millennium.proxy;

import io.github.cleanroommc.millennium.Millennium;
import io.github.cleanroommc.millennium.client.gui.GuiHandler;
import io.github.cleanroommc.millennium.client.resource.MillenniumSounds;
import io.github.cleanroommc.millennium.client.resource.MillenniumTextures;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
  @Override
  public void preInit(FMLPreInitializationEvent event) {
    super.preInit(event);
    NetworkRegistry.INSTANCE.registerGuiHandler(Millennium.INSTANCE, new GuiHandler());
    MillenniumSounds.initSounds();
    MillenniumTextures.initTextures();
  }

  @Override
  public void registerItemRenderer(Item item, int meta, String id) {
    ModelLoader.setCustomModelResourceLocation(
        item, meta, new ModelResourceLocation(item.getRegistryName(), id));
  }
}
