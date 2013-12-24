package evilcraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import evilcraft.blocks.BloodInfuser;
import evilcraft.blocks.DarkBlock;
import evilcraft.fluids.Blood;
import evilcraft.items.BloodPearlOfTeleportation;
import evilcraft.items.ContainedFlux;
import evilcraft.items.DarkGem;
import evilcraft.items.DarkGemConfig;
import evilcraft.items.WeatherContainer;

/**
 * Holder class of all the recipes.
 */
public class Recipes {
    public static void registerRecipes() {
        // 9 DarkGems -> 1 DarkBlock
        GameRegistry.addRecipe(new ShapedOreRecipe(DarkBlock.getInstance(), true,
                new Object[]{
                "GGG",
                "GGG",
                "GGG",
                Character.valueOf('G'), DarkGemConfig._instance.getOreDictionaryId()})
        );
        // 1 DarkBlock -> 9 DarkGems
        GameRegistry.addShapelessRecipe(new ItemStack(DarkGem.getInstance(), 9),
                new ItemStack(DarkBlock.getInstance())
        );
        // Weather Container
        GameRegistry.addRecipe(new ItemStack(WeatherContainer.getInstance()),
                " G ",
                " P ",
                " S ",
                'G', new ItemStack(ContainedFlux.getInstance()),
                'P', new ItemStack(Item.glassBottle),
                'S', new ItemStack(Item.sugar)
        );
        // Blood Pearl of Teleportation
        GameRegistry.addRecipe(new ItemStack(BloodPearlOfTeleportation.getInstance()),
                "EGE",
                "GEG",
                "EGE",
                'G', new ItemStack(ContainedFlux.getInstance()),
                'E', new ItemStack(Item.enderPearl)
        );
        
        registerCustomRecipes();
    }
    
    public static void registerCustomRecipes() {
        CustomRecipeRegistry.put(new CustomRecipe(
                        new ItemStack(DarkGem.getInstance()),
                        new FluidStack(Blood.getInstance(), FluidContainerRegistry.BUCKET_VOLUME / 4),
                        BloodInfuser.getInstance(),
                        20
                    ),
                new ItemStack(ContainedFlux.getInstance()
        ));
    }
}
