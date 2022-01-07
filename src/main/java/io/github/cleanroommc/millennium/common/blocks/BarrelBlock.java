package io.github.cleanroommc.millennium.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BarrelBlock extends HorizontalBlock {
  public BarrelBlock() {
    super(
        new Settings(Material.WOOD)
            .strength(2.5F)
            .soundType(SoundType.WOOD)
            .translationKey("barrel"));
  }


}
