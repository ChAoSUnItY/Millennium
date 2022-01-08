package io.github.cleanroommc.millennium.common.tileentity;

import io.github.cleanroommc.millennium.common.container.BarrelContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.NonNullList;

public class BarrelBlockTileEntity extends TileEntityLockableLoot {
    public NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);

    @Override
    protected NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.inventory)
            if (!itemstack.isEmpty())
                return false;

        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new BarrelContainer(playerInventory, this);
    }

    @Override
    public String getGuiID() {
        return "millennium:barrel";
    }

    @Override
    public String getName() {
        return "container.barrel";
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (!checkLootAndWrite(compound))
            ItemStackHelper.saveAllItems(compound, inventory);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        inventory = NonNullList.withSize(27, ItemStack.EMPTY);
        if (!checkLootAndRead(compound))
            ItemStackHelper.loadAllItems(compound, inventory);
    }
}
