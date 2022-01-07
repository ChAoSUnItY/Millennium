package io.github.cleanroommc.millennium.proxy;

import io.github.cleanroommc.millennium.client.resource.MillenniumSounds;
import io.github.cleanroommc.millennium.client.resource.MillenniumTextures;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
  @Override
  public void preInit(FMLPreInitializationEvent event) {
    super.preInit(event);
    MillenniumSounds.initSounds();
    MillenniumTextures.initTextures();
  }

  @Override
  public void registerItemRenderer(Item item, int meta, String id) {
    ModelLoader.setCustomModelResourceLocation(
        item, meta, new ModelResourceLocation(item.getRegistryName(), id));
  }
}
