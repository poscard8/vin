package github.poscard8.vividitemnames;

import net.minecraft.ChatFormatting;
import net.minecraft.util.ByIdMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.IntFunction;

@OnlyIn(Dist.CLIENT)
public enum NameColor {
    WHITE(ChatFormatting.WHITE, "White"),
    YELLOW(ChatFormatting.YELLOW, "Yellow"),
    MAGENTA(ChatFormatting.LIGHT_PURPLE, "Magenta"),
    RED(ChatFormatting.RED, "Red"),
    AQUA(ChatFormatting.AQUA, "Aqua"),
    GREEN(ChatFormatting.GREEN, "Green"),
    BLUE(ChatFormatting.BLUE, "Blue"),
    GRAY(ChatFormatting.GRAY, "Gray"),
    DARK_GRAY(ChatFormatting.DARK_GRAY, "Dark Gray"),
    GOLD(ChatFormatting.GOLD, "Gold"),
    PURPLE(ChatFormatting.DARK_PURPLE, "Purple"),
    DARK_RED(ChatFormatting.DARK_RED, "Dark Red"),
    DARK_AQUA(ChatFormatting.DARK_AQUA, "Dark Aqua"),
    DARK_GREEN(ChatFormatting.DARK_GREEN, "Dark Green"),
    DARK_BLUE(ChatFormatting.DARK_BLUE, "Dark Blue"),
    BLACK(ChatFormatting.BLACK, "Black");


    private static final IntFunction<NameColor> BY_ID = ByIdMap.continuous(NameColor::ordinal, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    private final ChatFormatting color;
    private final String name;

    NameColor(ChatFormatting color, String name) {
        this.color = color;
        this.name = name;
    }

    public ChatFormatting get() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static NameColor byId(int i) {
        return BY_ID.apply(i);
    }
}
