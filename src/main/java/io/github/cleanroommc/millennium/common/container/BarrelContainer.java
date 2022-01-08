package io.github.cleanroommc.millennium.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BarrelContainer extends Container {
  private final IInventory inventory;

  public BarrelContainer(EntityPlayer player, IInventory inventory) {
    this.inventory = inventory;
    inventory.openInventory(player);

    for (int k = 0; k < 3; ++k)
      for (int l = 0; l < 9; ++l)
        this.addSlotToContainer(new Slot(inventory, l + k * 9, 8 + l * 18, 18 + k * 18));

    for (int i1 = 0; i1 < 3; ++i1)
      for (int k1 = 0; k1 < 9; ++k1)
        this.addSlotToContainer(new Slot(player.inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));

    for (int j1 = 0; j1 < 9; ++j1)
      this.addSlotToContainer(new Slot(player.inventory, j1, 8 + j1 * 18, 142));
  }

  @Override
  public boolean canInteractWith(EntityPlayer playerIn) {
    return inventory.isUsableByPlayer(playerIn);
  }

  @Override
  public void onContainerClosed(EntityPlayer playerIn) {
    super.onContainerClosed(playerIn);
    inventory.closeInventory(playerIn);
  }

  @Override
  public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
    ItemStack itemstack = ItemStack.EMPTY;
    Slot slot = inventorySlots.get(index);

    if (slot != null && slot.getHasStack()) {
      ItemStack itemstack1 = slot.getStack();
      itemstack = itemstack1.copy();

      if (index < inventory.getSizeInventory()) {
        if (!mergeItemStack(
            itemstack1, inventory.getSizeInventory(), inventorySlots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!mergeItemStack(itemstack1, 0, inventory.getSizeInventory(), false)) {
        return ItemStack.EMPTY;
      }

      if (itemstack1.isEmpty()) slot.putStack(ItemStack.EMPTY);
      else slot.onSlotChanged();
    }

    return itemstack;
  }
}
