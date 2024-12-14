package org.zhillerlab.copper_kit.register;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.zhillerlab.copper_kit.common.config.GlobalConfig;
import org.zhillerlab.copper_kit.entity.bomb.BombDefs;
import org.zhillerlab.copper_kit.item.CopperShearsItem;
import org.zhillerlab.copper_kit.item.define.ThrowableItem;
import org.zhillerlab.copper_kit.item.props.ArmorMaterialsProp;
import org.zhillerlab.copper_kit.item.props.ToolTiersProp;

public class ItemsReg {
  public static final DeferredRegister.Items ITEMS =
      DeferredRegister.createItems(GlobalConfig.MOD_ID);
  
  // Material 元材料注册
  public static final DeferredItem<Item> COPPER_NUGGET =
      ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
  public static final DeferredItem<Item> COPPER_FRAGMENT =
      ITEMS.register("copper_fragment", () -> new Item(new Item.Properties()));
  public static final DeferredItem<CopperShearsItem> COPPER_SHEARS =
      ITEMS.register("copper_shears", () -> new CopperShearsItem(new Item.Properties()));
  
  // Tool 工具注册
  public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
      () -> new SwordItem(ToolTiersProp.COPPER_TIER, new Item.Properties()
          .attributes(SwordItem.createAttributes(ToolTiersProp.COPPER_TIER, 4.5F, -2.2f))));
  public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
      () -> new PickaxeItem(ToolTiersProp.COPPER_TIER, new Item.Properties()
          .attributes(PickaxeItem.createAttributes(ToolTiersProp.COPPER_TIER, 1.0F, -3.0f))));
  public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
      () -> new ShovelItem(ToolTiersProp.COPPER_TIER, new Item.Properties()
          .attributes(ShovelItem.createAttributes(ToolTiersProp.COPPER_TIER, 1.0F, -3.0f))));
  public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
      () -> new AxeItem(ToolTiersProp.COPPER_TIER, new Item.Properties()
          .attributes(AxeItem.createAttributes(ToolTiersProp.COPPER_TIER, 5.5F, -3.2f))));
  public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
      () -> new HoeItem(ToolTiersProp.COPPER_TIER, new Item.Properties()
          .attributes(HoeItem.createAttributes(ToolTiersProp.COPPER_TIER, 0.5F, -2.5f))));
  
  // Armor 盔甲注册
  public static final DeferredItem<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
      () -> new ArmorItem(ArmorMaterialsProp.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
          new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(10))));
  public static final DeferredItem<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
      () -> new ArmorItem(ArmorMaterialsProp.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
          new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(10))));
  public static final DeferredItem<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
      () -> new ArmorItem(ArmorMaterialsProp.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
          new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(10))));
  public static final DeferredItem<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
      () -> new ArmorItem(ArmorMaterialsProp.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
          new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(10))));
  
  // Bomb 炸弹
  public static final DeferredItem<ThrowableItem> COPPER_FIRECRACKER = ITEMS.register("copper_firecracker",
      () -> new ThrowableItem(new Item.Properties(),
          EntitiesReg.COPPER_FIRECRACKER_ENTITY::get, BombDefs.COPPER_FIRECRACKER.cooldown(), BombDefs.COPPER_FIRECRACKER.zAxis(), BombDefs.COPPER_FIRECRACKER.velocity(), BombDefs.COPPER_FIRECRACKER.inaccuracy()));
  public static final DeferredItem<ThrowableItem> COPPER_GRENADE = ITEMS.register("copper_grenade",
      () -> new ThrowableItem(new Item.Properties(),
          EntitiesReg.COPPER_GRENADE_ENTITY::get, BombDefs.COPPER_GRENADE.cooldown(), BombDefs.COPPER_GRENADE.zAxis(), BombDefs.COPPER_GRENADE.velocity(), BombDefs.COPPER_GRENADE.inaccuracy()));
  
  public static void init(IEventBus modEventBus) {
    GlobalConfig.LOGGER.info("Registering Items for " + GlobalConfig.MOD_ID);
    ITEMS.register(modEventBus);
  }
}