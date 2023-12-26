package github.poscard8.vividitemnames.util;

import net.minecraft.network.chat.Component;
import net.minecraft.util.ByIdMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.IntFunction;

@OnlyIn(Dist.CLIENT)
public enum ThreeStateOption {
    DEFAULT(false),
    ON(true),
    OFF(false);

    private static final IntFunction<ThreeStateOption> BY_ID = ByIdMap.continuous(ThreeStateOption::ordinal, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    private final String translatable;
    private final boolean bool;

    ThreeStateOption(boolean bool) {
        this.bool = bool;
        this.translatable = "3_state_option.vin." + this;
    }

    public static ThreeStateOption byId(int i) {
        return BY_ID.apply(i);
    }

    public boolean getBoolean() { return bool; }

    public Component getTranslatable() { return Component.translatable(translatable); }

    @Override
    public String toString() { return super.toString().toLowerCase(); }

}
