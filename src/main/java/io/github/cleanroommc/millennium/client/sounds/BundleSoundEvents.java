package io.github.cleanroommc.millennium.client.sounds;

import io.github.cleanroommc.assetmover.AssetMoverAPI;
import io.github.cleanroommc.millennium.Millennium;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Map;

public class BundleSoundEvents {

    public static SoundEvent REMOVE_ONE, DROP_CONTENTS, INSERT;

    @SideOnly(Side.CLIENT)
    public static void initAssets() {
        Map<String, String> sounds = new Object2ObjectOpenHashMap<>();
        sounds.put("assets/minecraft/sounds/item/bundle/drop_contents1.ogg", "assets/millennium/sounds/item/bundle/drop_contents1.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/drop_contents2.ogg", "assets/millennium/sounds/item/bundle/drop_contents2.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/drop_contents3.ogg", "assets/millennium/sounds/item/bundle/drop_contents3.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/insert1.ogg", "assets/millennium/sounds/item/bundle/insert1.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/insert2.ogg", "assets/millennium/sounds/item/bundle/insert2.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/insert3.ogg", "assets/millennium/sounds/item/bundle/insert3.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/remove_one1.ogg", "assets/millennium/sounds/item/bundle/remove_one1.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/remove_one2.ogg", "assets/millennium/sounds/item/bundle/remove_one2.ogg");
        sounds.put("assets/minecraft/sounds/item/bundle/remove_one3.ogg", "assets/millennium/sounds/item/bundle/remove_one3.ogg");
        sounds.put("assets/minecraft/textures/item/bundle.png", "assets/millennium/textures/item/bundle.png");
        sounds.put("assets/minecraft/textures/item/bundle_filled.png", "assets/millennium/textures/item/bundle_filled.png");
        AssetMoverAPI.fromMinecraft("1.18.1", sounds);
    }

    public static void init(IForgeRegistry<SoundEvent> registry) {
        REMOVE_ONE = new SoundEvent(new ResourceLocation(Millennium.MODID, "item.bundle.remove_one"));
        REMOVE_ONE.setRegistryName(REMOVE_ONE.getSoundName());
        DROP_CONTENTS = new SoundEvent(new ResourceLocation(Millennium.MODID, "item.bundle.drop_contents"));
        DROP_CONTENTS.setRegistryName(DROP_CONTENTS.getSoundName());
        INSERT = new SoundEvent(new ResourceLocation(Millennium.MODID, "item.bundle.insert"));
        INSERT.setRegistryName(INSERT.getSoundName());
        registry.registerAll(REMOVE_ONE, DROP_CONTENTS, INSERT);
    }

}
