package io.github.cleanroommc.millennium.client.resource;

import io.github.cleanroommc.assetmover.AssetMoverAPI;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MillenniumSounds {
    @SideOnly(Side.CLIENT)
    public static void initSounds() {
        AssetHashMap assets = new AssetHashMap("sounds");
        // Bundle
        assets.put("item/bundle/drop_contents1.ogg");
        assets.put("item/bundle/drop_contents2.ogg");
        assets.put("item/bundle/drop_contents2.ogg");
        assets.put("item/bundle/drop_contents3.ogg");
        assets.put("item/bundle/insert1.ogg");
        assets.put("item/bundle/insert2.ogg");
        assets.put("item/bundle/insert3.ogg");
        assets.put("item/bundle/remove_one1.ogg");
        assets.put("item/bundle/remove_one2.ogg");
        assets.put("item/bundle/remove_one3.ogg");
        // Barrel
        AssetMoverAPI.fromMinecraft("1.18.1", assets);
    }
}
