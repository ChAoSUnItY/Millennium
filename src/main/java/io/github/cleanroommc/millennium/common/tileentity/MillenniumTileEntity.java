package io.github.cleanroommc.millennium.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public abstract class MillenniumTileEntity extends TileEntity {
  @Override
  public SPacketUpdateTileEntity getUpdatePacket() {
    NBTTagCompound nbt = new NBTTagCompound();
    writeToNBT(nbt);
    int metadata = getBlockMetadata();
    return new SPacketUpdateTileEntity(pos, metadata, nbt);
  }

  @Override
  public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
    readFromNBT(pkt.getNbtCompound());
  }

  @Override
  public NBTTagCompound getUpdateTag() {
    NBTTagCompound nbt = new NBTTagCompound();
    writeToNBT(nbt);
    return nbt;
  }

  @Override
  public void handleUpdateTag(NBTTagCompound tag) {
    readFromNBT(tag);
  }

  @Override
  public NBTTagCompound getTileData() {
    NBTTagCompound nbt = new NBTTagCompound();
    writeToNBT(nbt);
    return nbt;
  }
}
