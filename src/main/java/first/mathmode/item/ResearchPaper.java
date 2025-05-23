package first.mathmode.item;

import net.minecraft.item.Item;

public class ResearchPaper extends Item {
    private final int tier;
    public ResearchPaper(int tier, Item.Settings settings) {
        super(settings);
        this.tier = tier;
    }

    public int getTier() {return this.tier;}



}
