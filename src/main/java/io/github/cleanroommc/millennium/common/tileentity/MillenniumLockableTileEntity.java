package io.github.cleanroommc.millennium.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.LockCode;

public abstract class MillenniumLockableTileEntity extends MillenniumTileEntity
    implements ILockableContainer {
  private LockCode code = LockCode.EMPTY_CODE;

  public void readFromNBT(NBTTagCompound compound) {
    super.readFromNBT(compound);
    code = LockCode.fromNBT(compound);
  }

  public NBTTagCompound writeToNBT(NBTTagCompound compound) {
    super.writeToNBT(compound);

    if (code != null) code.toNBT(compound);

    return compound;
  }

  public boolean isLocked() {
    return code != null && !code.isEmpty();
  }

  public LockCode getLockCode() {
    return code;
  }

  public void setLockCode(LockCode code) {
    this.code = code;
  }

  public ITextComponent getDisplayName() {
    return hasCustomName()
        ? new TextComponentString(getName())
        : new TextComponentTranslation(getName());
  }

  private net.minecraftforge.items.IItemHandler itemHandler;

  protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
    return new net.minecraftforge.items.wrapper.InvWrapper(this);
  }

  @SuppressWarnings("unchecked")
  @Override
  @javax.annotation.Nullable
  public <T> T getCapability(
      net.minecraftforge.common.capabilities.Capability<T> capability,
      @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
    if (capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
      return (T) (itemHandler == null ? (itemHandler = createUnSidedHandler()) : itemHandler);
    return super.getCapability(capability, facing);
  }

  @Override
  public boolean hasCapability(
      net.minecraftforge.common.capabilities.Capability<?> capability,
      @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
    return capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
        || super.hasCapability(capability, facing);
  }
}
