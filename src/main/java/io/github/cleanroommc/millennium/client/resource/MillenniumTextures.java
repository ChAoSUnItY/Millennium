package io.github.cleanroommc.millennium.client.resource;

import io.github.cleanroommc.assetmover.AssetMoverAPI;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MillenniumTextures {
  @SideOnly(Side.CLIENT)
  public static void initTextures() {
    AssetHashMap textures = new AssetHashMap("textures");
    // Bundle
    textures.put("item/bundle.png");
    textures.put("item/bundle_filled.png");
    // Barrel

    AssetMoverAPI.fromMinecraft("1.18.1", textures);
  }
}
