package github.poscard8.vividitemnames.screen;

import github.poscard8.vividitemnames.VividItemNames;
import github.poscard8.vividitemnames.util.Enclosure;
import github.poscard8.vividitemnames.util.NameColor;
import github.poscard8.vividitemnames.util.ThreeStateOption;
import github.poscard8.vividitemnames.util.VividItemNamesUtils;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.ByIdMap;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
@OnlyIn(Dist.CLIENT)
public class VividItemNamesOptionsScreen extends OptionsSubScreen {

    private static final List<Component> TOOLTIPS = List.of(Component.translatable("tooltip.vin.other_items.line_0"), Component.translatable("tooltip.vin.other_items.line_1"));

    private OptionsList list;
    private RarityMenu selectedMenu;

    public VividItemNamesOptionsScreen(Screen screen, Options options) {
        super(screen, options, Component.translatable("options.vin.title"));
    }

    @Override
    protected void init() {
        this.selectedMenu = RarityMenu.COMMON;
        this.list = this.refreshList();

        Button prevButton = Button.builder(Component.literal("<"), press -> {
            this.selectedMenu = this.selectedMenu.prev();
            this.refreshList();
        }).bounds(this.width / 2 - 90, 36, 20, 20).build();
        Button nextButton = Button.builder(Component.literal(">"), press -> {
            this.selectedMenu = this.selectedMenu.next();
            this.refreshList();
        }).bounds(this.width / 2 + 70, 36, 20, 20).build();
        Button resetButton = Button.builder(Component.translatable("options.vin.item_reset"), press ->
                        this.reset())
                .bounds(this.width / 2 - 100, 164, 200, 20).build();

        this.addRenderableWidget(prevButton);
        this.addRenderableWidget(nextButton);
        this.addRenderableWidget(resetButton);

        assert this.minecraft != null;
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, press -> {
            this.minecraft.options.save();
            this.minecraft.setScreen(this.lastScreen);
        }).bounds(this.width / 2 - 100, this.height - 27, 200, 20).build());

    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float colorCode) {
        this.renderDirtBackground(guiGraphics);
        this.basicListRender(guiGraphics, this.list, mouseX, mouseY, colorCode);
        guiGraphics.drawString(this.font, this.selectedMenu.getComponent(), (this.width - font.width(this.selectedMenu.getComponent())) / 2,
                42, Objects.requireNonNull(this.selectedMenu.getStyle().getColor()).getValue());

        if (this.selectedMenu == RarityMenu.OTHER) {
            if (Math.abs(mouseX * 2 - this.width) <= font.width(this.selectedMenu.getComponent()) && Math.abs(mouseY - 46) <= 4) {
                guiGraphics.renderTooltip(this.font, TOOLTIPS, Optional.empty(), mouseX, mouseY);
            }
        }

    }

    protected OptionsList refreshList() {
        if (this.list != null) {
            this.removeWidget(this.list);
        }

        assert this.minecraft != null;
        this.list = new OptionsList(this.minecraft, this.width, this.height, 60, 164, 25);
        this.list.addSmall(this.selectedMenu.options);

        this.addWidget(this.list);
        return this.list;
    }

    protected void reset() {
        for (OptionInstance<?> optionInstance : this.selectedMenu.options) {
            if (optionInstance.get() instanceof NameColor) {
                ((OptionInstance<NameColor>) optionInstance).set(this.selectedMenu.getDefaultNameColor());
            } else if (optionInstance.get() instanceof Enclosure) {
                ((OptionInstance<Enclosure>) optionInstance).set(Enclosure.NONE);
            } else if (optionInstance.get() instanceof ThreeStateOption) {
                ((OptionInstance<ThreeStateOption>) optionInstance).set(ThreeStateOption.DEFAULT);
            } else {
                ((OptionInstance<Boolean>) optionInstance).set(false);
            }
        }

        this.refreshList();
    }

    @OnlyIn(Dist.CLIENT)
    protected enum RarityMenu {
        COMMON(VividItemNamesUtils.Rarities.COMMON, VividItemNames.OPTIONS.commonItemOptions(), VividItemNamesUtils::getCommonStyle),
        UNCOMMON(VividItemNamesUtils.Rarities.UNCOMMON, VividItemNames.OPTIONS.uncommonItemOptions(), VividItemNamesUtils::getUncommonStyle),
        RARE(VividItemNamesUtils.Rarities.RARE, VividItemNames.OPTIONS.rareItemOptions(), VividItemNamesUtils::getRareStyle),
        EPIC(VividItemNamesUtils.Rarities.EPIC, VividItemNames.OPTIONS.epicItemOptions(), VividItemNamesUtils::getEpicStyle),
        OTHER(VividItemNamesUtils.Rarities.PLACEHOLDER, VividItemNames.OPTIONS.otherItemOptions(), VividItemNamesUtils::getOtherStyle);

        public final OptionInstance<?>[] options;

        private static final IntFunction<RarityMenu> BY_ID = ByIdMap.continuous(RarityMenu::ordinal, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        private final Rarity rarity;
        private final Supplier<Style> style;

        RarityMenu(Rarity rarity, OptionInstance<?>[] options, Supplier<Style> style) {
            this.rarity = rarity;
            this.options = options;
            this.style = style;
        }

        public Style getStyle() {
            return style.get();
        }

        public Component getComponent() {
            return VividItemNamesUtils.wrapInEnclosure(Component.translatable("options.vin." + this.toString().toLowerCase() + "_items").withStyle(this.getStyle()), this.rarity);
        }

        public NameColor getDefaultNameColor() {
            return NameColor.fromRarity(this.rarity);
        }

        public RarityMenu next() { return BY_ID.apply(this.ordinal() + 1); }

        public RarityMenu prev() { return BY_ID.apply(this.ordinal() - 1); }

    }

}
