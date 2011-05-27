package net.minecraft.server;

public class EntitySquid extends EntityWaterAnimal {

    public float a = 0.0F;
    public float b = 0.0F;
    public float c = 0.0F;
    public float f = 0.0F;
    public float g = 0.0F;
    public float h = 0.0F;
    public float i = 0.0F;
    public float j = 0.0F;
    private float k = 0.0F;
    private float l = 0.0F;
    private float m = 0.0F;
    private float n = 0.0F;
    private float o = 0.0F;
    private float p = 0.0F;

    public EntitySquid(World world) {
        super(world);
        this.texture = "/mob/squid.png";
        this.b(0.95F, 0.95F);
        this.l = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    protected String g() {
        return null;
    }

    protected String h() {
        return null;
    }

    protected String i() {
        return null;
    }

    protected float k() {
        return 0.4F;
    }

    protected int j() {
        return 0;
    }

    protected void r() {
        int i = this.random.nextInt(3) + 1;

        for (int j = 0; j < i; ++j) {
            this.a(new ItemStack(Item.INK_SACK, 1, 0), 0.0F);
        }
    }

    public boolean a(EntityHuman entityhuman) {
        return false;
    }

    public boolean Z() {
        return this.world.a(this.boundingBox.b(0.0D, -0.6000000238418579D, 0.0D), Material.WATER, this);
    }

    public void u() {
        super.u();
        this.b = this.a;
        this.f = this.c;
        this.h = this.g;
        this.j = this.i;
        this.g += this.l;
        if (this.g > 6.2831855F) {
            this.g -= 6.2831855F;
            if (this.random.nextInt(10) == 0) {
                this.l = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.Z()) {
            float f;

            if (this.g < 3.1415927F) {
                f = this.g / 3.1415927F;
                this.i = MathHelper.sin(f * f * 3.1415927F) * 3.1415927F * 0.25F;
                if ((double) f > 0.75D) {
                    this.k = 1.0F;
                    this.m = 1.0F;
                } else {
                    this.m *= 0.8F;
                }
            } else {
                this.i = 0.0F;
                this.k *= 0.9F;
                this.m *= 0.99F;
            }

            if (!this.U) {
                this.motX = (double) (this.n * this.k);
                this.motY = (double) (this.o * this.k);
                this.motZ = (double) (this.p * this.k);
            }

            f = MathHelper.a(this.motX * this.motX + this.motZ * this.motZ);
            this.G += (-((float) Math.atan2(this.motX, this.motZ)) * 180.0F / 3.1415927F - this.G) * 0.1F;
            this.yaw = this.G;
            this.c += 3.1415927F * this.m * 1.5F;
            this.a += (-((float) Math.atan2((double) f, this.motY)) * 180.0F / 3.1415927F - this.a) * 0.1F;
        } else {
            this.i = MathHelper.abs(MathHelper.sin(this.g)) * 3.1415927F * 0.25F;
            if (!this.U) {
                this.motX = 0.0D;
                this.motY -= 0.08D;
                this.motY *= 0.9800000190734863D;
                this.motZ = 0.0D;
            }

            this.a = (float) ((double) this.a + (double) (-90.0F - this.a) * 0.02D);
        }
    }

    public void a(float f, float f1) {
        this.move(this.motX, this.motY, this.motZ);
    }

    protected void c_() {
        if (this.random.nextInt(50) == 0 || !this.bw || this.n == 0.0F && this.o == 0.0F && this.p == 0.0F) {
            float f = this.random.nextFloat() * 3.1415927F * 2.0F;

            this.n = MathHelper.cos(f) * 0.2F;
            this.o = -0.1F + this.random.nextFloat() * 0.2F;
            this.p = MathHelper.sin(f) * 0.2F;
        }
    }
}
