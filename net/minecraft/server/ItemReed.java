package net.minecraft.server;

public class ItemReed extends Item {

    private int a;

    public ItemReed(int i, Block block) {
        super(i);
        this.a = block.id;
    }

    public boolean a(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l) {
        if (world.getTypeId(i, j, k) == Block.SNOW.id) {
            l = 0;
        } else {
            if (l == 0) {
                --j;
            }

            if (l == 1) {
                ++j;
            }

            if (l == 2) {
                --k;
            }

            if (l == 3) {
                ++k;
            }

            if (l == 4) {
                --i;
            }

            if (l == 5) {
                ++i;
            }
        }

        if (itemstack.count == 0) {
            return false;
        } else {
            if (world.a(this.a, i, j, k, false)) {
                Block block = Block.byId[this.a];

                if (world.e(i, j, k, this.a)) {
                    Block.byId[this.a].d(world, i, j, k, l);
                    Block.byId[this.a].a(world, i, j, k, (EntityLiving) entityhuman);
                    world.a((double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), block.stepSound.c(), (block.stepSound.a() + 1.0F) / 2.0F, block.stepSound.b() * 0.8F);
                    --itemstack.count;
                }
            }

            return true;
        }
    }
}
