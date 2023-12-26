package github.poscard8.vividitemnames.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ByIdMap;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.function.IntFunction;

@OnlyIn(Dist.CLIENT)
public enum NameColor {
    DEFAULT(ChatFormatting.WHITE),
    WHITE(ChatFormatting.WHITE),
    YELLOW(ChatFormatting.YELLOW),
    MAGENTA(ChatFormatting.LIGHT_PURPLE),
    RED(ChatFormatting.RED),
    AQUA(ChatFormatting.AQUA),
    GREEN(ChatFormatting.GREEN),
    BLUE(ChatFormatting.BLUE),
    GRAY(ChatFormatting.GRAY),
    DARK_GRAY(ChatFormatting.DARK_GRAY),
    GOLD(ChatFormatting.GOLD),
    PURPLE(ChatFormatting.DARK_PURPLE),
    DARK_RED(ChatFormatting.DARK_RED),
    DARK_AQUA(ChatFormatting.DARK_AQUA),
    DARK_GREEN(ChatFormatting.DARK_GREEN),
    DARK_BLUE(ChatFormatting.DARK_BLUE),
    BLACK(ChatFormatting.BLACK);

    private static final IntFunction<NameColor> BY_ID = ByIdMap.sparse(Enum::ordinal, nonDefaultValues(), DEFAULT);
    private static final IntFunction<NameColor> BY_ID_WITH_DEFAULT = ByIdMap.continuous(NameColor::ordinal, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    private final String translatable;
    private final ChatFormatting color;

    NameColor(ChatFormatting color) {
        this.translatable = "name_color.vin." + this;
        this.color = color;
    }

    public static NameColor byId(int i) {
        return BY_ID.apply(i);
    }

    public static NameColor byIdWithDefault(int i) {
        return BY_ID_WITH_DEFAULT.apply(i);
    }

    public static NameColor fromRarity(Rarity rarity) {
        switch (rarity) {
            default -> { return DEFAULT; }
            case COMMON -> { return WHITE; }
            case UNCOMMON -> { return YELLOW; }
            case RARE -> { return AQUA; }
            case EPIC -> { return MAGENTA; }
        }
    }

    public static NameColor[] nonDefaultValues() {
        return Arrays.copyOfRange(values(), 1, values().length, NameColor[].class);
    }

    public ChatFormatting get() {
        return this.color;
    }

    public Component getTranslatable() { return Component.translatable(translatable); }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
