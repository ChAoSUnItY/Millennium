package io.github.cleanroommc.millennium.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class BarrelBlock extends DirectionalBlock {
  public static final PropertyBool OPEN = PropertyBool.create("open");

  public BarrelBlock() {
    super(
        new Settings(Material.WOOD)
            .strength(2.5F)
            .soundType(SoundType.WOOD)
            .translationKey("barrel"));
    setDefaultState(getBlockState().getBaseState().withProperty(OPEN, false));
  }

  @Override
  public int getMetaFromState(IBlockState state) {
    int meta = super.getMetaFromState(state);

    if (state.getValue(OPEN)) meta |= 8;

    return meta;
  }

  @Override
  public IBlockState getStateFromMeta(int meta) {
    return getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta & 7));
  }

  @Override
  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, FACING, OPEN);
  }
}
