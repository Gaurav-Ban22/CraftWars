package me.gaurav.craftwars;

import me.gaurav.craftwars.listeners.ClickListener;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CraftWars extends JavaPlugin implements Listener {

    public static Inventory xpmenu;

    @Override
    public void onEnable() {
        Bukkit.addRecipe(getRecipe());
        Bukkit.addRecipe(getPickaxeRecipe());
        Bukkit.addRecipe(getChestSmelt());
        Bukkit.addRecipe(getSwordRecipe());
        Bukkit.addRecipe(getStickRecipe());
        Bukkit.addRecipe(getLogRecipe());
        Bukkit.addRecipe(getSugarRecipe());
        Bukkit.addRecipe(getBadRecipe());
        Bukkit.addRecipe(getWoodenRecipe());
        Bukkit.addRecipe(getSpellRecipe());
        Bukkit.addRecipe(getSpicedArrowRecipe());
        Bukkit.addRecipe(getLavaLegsRecipe());
        Bukkit.addRecipe(getSALMONBOOTSRecipe());


        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player online: Bukkit.getOnlinePlayers())
                createBoard(online);
        createInventory();

    }

    @Override
    public void onDisable() {

    }

    private void createInventory() {

        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "XP Menu");
        ItemStack item = new ItemStack(Material.CACTUS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Deal half a heart of damage - 1 level");
        item.setItemMeta(meta);
        inv.setItem(0, item);

        ItemStack itemtwo = new ItemStack(Material.CREEPER_HEAD);
        ItemMeta metatwo = itemtwo.getItemMeta();
        metatwo.setDisplayName("Spawn a Creeper - 20 levels");
        itemtwo.setItemMeta(metatwo);
        inv.setItem(1, itemtwo);

        ItemStack lightningrod = new ItemStack(Material.IRON_BARS);
        ItemMeta lightningmeta = lightningrod.getItemMeta();
        lightningmeta.setDisplayName("Spawn Lightning - 10 levels");
        lightningrod.setItemMeta(lightningmeta);
        inv.setItem(2, lightningrod);

        ItemStack clear = new ItemStack(Material.BARRIER);
        ItemMeta clearmeta = clear.getItemMeta();
        clearmeta.setDisplayName("Clear Inventory of Everyone Else - 50 levels");
        clear.setItemMeta(clearmeta);
        inv.setItem(3, clear);

        ItemStack armor = new ItemStack(Material.ANVIL);
        ItemMeta armormeta = armor.getItemMeta();
        armormeta.setDisplayName("Clear Armor of Everyone Else - 30 levels");
        armor.setItemMeta(armormeta);
        inv.setItem(4, armor);

        ItemStack zombie = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta zombiemeta = zombie.getItemMeta();
        zombiemeta.setDisplayName("Spawn Zombie Hoard - 35 levels");
        zombie.setItemMeta(zombiemeta);
        inv.setItem(5, zombie);


        xpmenu = inv;


    }

    public void damageHalf(Player originalPlayer) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(originalPlayer)) {
                player.damage(1);
                player.sendMessage("You got damaged by " + "" + originalPlayer.getName() + "!");
            }
        }
    }

    public void creeperSpawn(Player originalPlayer) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(originalPlayer)) {
                player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
                player.sendMessage("You got creepertrolled by " + "" + originalPlayer.getName() + "!");
            }
        }
    }

    public void lightning(Player originalPlayer) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(originalPlayer)) {
                player.getWorld().strikeLightning(player.getLocation());
                player.sendMessage("You got struck by " + "" + originalPlayer.getName() + "!");
            }
        }
    }

    public void clearinv(Player originalPlayer) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(originalPlayer)) {

                player.getInventory().setStorageContents(null);
                player.getInventory().setItemInOffHand(null);

                player.sendMessage("You got your inventory cleared by " + "" + originalPlayer.getName() + "! :(");
            }
        }
    }

    public void zombiespawn(Player originalPlayer) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(originalPlayer)) {
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                player.sendMessage("You got zombietrolled by " + "" + originalPlayer.getName() + "!");
            }
        }
    }

    public void killarmor(Player originalPlayer) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(originalPlayer)) {
                player.getEquipment().setHelmet(new ItemStack(Material.AIR));
                player.getEquipment().setChestplate(new ItemStack(Material.AIR));
                player.getEquipment().setLeggings(new ItemStack(Material.AIR));
                player.getEquipment().setBoots(new ItemStack(Material.AIR));
                player.sendMessage("You got your armor broken by " + "" + originalPlayer.getName() + "!");
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 1);
            }
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().contains("XP Menu"))
            return;
        if (event.getCurrentItem() == null)
            return;
        if (event.getCurrentItem().getItemMeta() == null)
            return;

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        if (event.getClickedInventory().getType() == InventoryType.PLAYER)
            return;
        if (event.getSlot() == 0) {
            player.setLevel(player.getLevel() - 1);
            damageHalf(player);
            player.closeInventory();
            player.updateInventory();
            return;
        }
        if (event.getSlot() == 1) {
            player.setLevel(player.getLevel() - 20);
            creeperSpawn(player);
            player.closeInventory();
            player.updateInventory();
            return;
        }
        if (event.getSlot() == 2) {

            player.setLevel(player.getLevel() - 10);
            lightning(player);
            player.closeInventory();
            player.updateInventory();
            return;

        }
        if (event.getSlot() == 3) {

            player.setLevel(player.getLevel() - 50);
            clearinv(player);
            player.closeInventory();
            player.updateInventory();
            return;

        }
        if (event.getSlot() == 4) {

            player.setLevel(player.getLevel() - 30);
            killarmor(player);
            player.closeInventory();
            player.updateInventory();

        }
        if (event.getSlot() == 5) {

            player.setLevel(player.getLevel() - 35);
            zombiespawn(player);
            player.closeInventory();
            player.updateInventory();


        }


    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("xpmenu")) {

            if (!(sender instanceof Player)) {

                sender.sendMessage("Console");
                return true;

            }

            Player player = (Player) sender;
            player.openInventory(xpmenu);
            return true;

        }
        return false;
    }

    public ShapedRecipe getRecipe() {

        ItemStack item = new ItemStack(Material.NETHER_STAR);

        NamespacedKey key = new NamespacedKey(this, "nether_star");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" T ", "TET", " T ");

        recipe.setIngredient('T', Material.GHAST_TEAR);
        recipe.setIngredient('E', Material.EMERALD_BLOCK);

        return recipe;

    }

    public ShapedRecipe getPickaxeRecipe() {

        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Emerald Pick!");
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "emerald_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("EEE", " B ", " B ");

        recipe.setIngredient('B', Material.IRON_BARS);
        recipe.setIngredient('E', Material.EMERALD_BLOCK);

        return recipe;

    }

    public ShapedRecipe getChestSmelt() {

        ItemStack item = new ItemStack(Material.IRON_INGOT, 8);

        NamespacedKey key = new NamespacedKey(this, "chest_iron");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" T ", " C ", " T ");

        recipe.setIngredient('T', Material.TORCH);
        recipe.setIngredient('C', Material.IRON_CHESTPLATE);

        return recipe;

    }

    public ShapedRecipe getSwordRecipe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "The Destined Sword");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "destined_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("GGG", "GDG", "GGG");

        recipe.setIngredient('G', Material.GOLDEN_SWORD);
        recipe.setIngredient('D', Material.DIAMOND_SWORD);

        return recipe;

    }

    public ShapedRecipe getStickRecipe() {

        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Stick's for The Whacking");
        meta.addEnchant(Enchantment.KNOCKBACK, 3, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "knock_stick");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("SSS", "IWI", "SSS");

        recipe.setIngredient('S', Material.STONE);
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('W', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getLogRecipe() {

        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.BLACK);

        meta.setDisplayName(ChatColor.BLACK + " Oak Log Chestplate");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "wood_plate");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("O O", "OOO", "OOO");

        recipe.setIngredient('O', Material.OAK_LOG);


        return recipe;
    }

    public ShapedRecipe getSugarRecipe() {

        AttributeModifier modifier = new AttributeModifier(new UUID(20L, 10L), "player_speed", 0.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);


        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);

        meta.setDisplayName(ChatColor.GRAY + "Sugar Sword");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "sugar_blade");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" S ", " S ", " B ");

        recipe.setIngredient('S', Material.SUGAR);
        recipe.setIngredient('B', Material.IRON_BLOCK);


        return recipe;
    }

    public ShapedRecipe getBadRecipe() {

        AttributeModifier modifier = new AttributeModifier(new UUID(20L, 10L), "player_health", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);


        ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);

        meta.setDisplayName(ChatColor.RED + "Bad Sword with Healing Properties");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "bad_blade");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" H ", " H ", " B ");

        recipe.setIngredient('H', Material.APPLE);
        recipe.setIngredient('B', Material.IRON_BLOCK);


        return recipe;

    }

    public ShapedRecipe getWoodenRecipe() {

        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Wooden Singularity");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("Throw to gain wooden tools!");

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "wood_ball");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" L ", " P ", " L ");

        recipe.setIngredient('L', Material.OAK_LOG);
        recipe.setIngredient('P', Material.OAK_PLANKS);

        return recipe;

    }

    public ShapedRecipe getSpellRecipe() {

        ItemStack potion = new ItemStack(Material.POTION, 1);
        PotionMeta potionmeta = (PotionMeta) potion.getItemMeta();
        PotionEffect fire = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 2);
        PotionEffect heal = new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000, 2);
        potionmeta.addCustomEffect(heal, true);
        potionmeta.addCustomEffect(fire, true);
        potionmeta.setDisplayName(ChatColor.YELLOW + "Spicy Soup");
        potionmeta.setColor(Color.YELLOW);
        potion.setItemMeta(potionmeta);


        NamespacedKey key = new NamespacedKey(this, "spicy_soup");

        ShapedRecipe recipe = new ShapedRecipe(key, potion);

        recipe.shape("RRR", "RBR", "RRR");

        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('B', Material.GLASS_BOTTLE);

        return recipe;
    }

    public ShapedRecipe getSpicedArrowRecipe() {

        ItemStack potion = new ItemStack(Material.TIPPED_ARROW, 5);
        PotionMeta potionmeta = (PotionMeta) potion.getItemMeta();
        PotionEffect weakness = new PotionEffect(PotionEffectType.WEAKNESS, 750, 1);
        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, 750, 1);
        potionmeta.addCustomEffect(slowness, true);
        potionmeta.addCustomEffect(weakness, true);
        potionmeta.setDisplayName(ChatColor.DARK_GRAY + "Spiced Arrow");
        potionmeta.setColor(Color.OLIVE);
        potion.setItemMeta(potionmeta);


        NamespacedKey key = new NamespacedKey(this, "spice_arrow");

        ShapedRecipe recipe = new ShapedRecipe(key, potion);

        recipe.shape(" R ", " A ", " D ");

        recipe.setIngredient('R', Material.REDSTONE_BLOCK);
        recipe.setIngredient('A', Material.ARROW);
        recipe.setIngredient('D', Material.REDSTONE);

        return recipe;
    }

    public ShapedRecipe getLavaLegsRecipe() {

        AttributeModifier modifier = new AttributeModifier(new UUID(20L, 10L), "fire_res", 0.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.ORANGE);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);

        meta.setDisplayName(ChatColor.BLACK + "Fired Leggings");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "lava_legs");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("LLL", "C C", "L L");

        recipe.setIngredient('C', Material.COAL);
        recipe.setIngredient('L', Material.LAVA_BUCKET);


        return recipe;
    }

    public ShapedRecipe getSALMONBOOTSRecipe() {


        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.RED);

        meta.setDisplayName(ChatColor.GOLD + "SalmonSkin Boots");
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "salmon_shoes");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" S ", "S S", "S S");

        recipe.setIngredient('S', Material.SALMON);


        return recipe;
    }

    @EventHandler
    public void playerClicked(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (player.getInventory().getItemInMainHand().getType().equals(Material.SNOWBALL)) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                if (action == Action.RIGHT_CLICK_AIR) {
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_PICKAXE, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_HOE, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_SHOVEL, 1));
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        createBoard(event.getPlayer());

    }

    public void createBoard(Player player) {

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("craftwars-1","dummy",ChatColor.RED + "Craftwars");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore(ChatColor.YELLOW + "_________________");
        score.setScore(3);
        Score score2 = obj.getScore(ChatColor.AQUA + "Online Players: " + Bukkit.getOnlinePlayers().size());
        score2.setScore(2);
        Score score3 = obj.getScore(ChatColor.DARK_RED + "Player Kills: " + player.getStatistic(Statistic.PLAYER_KILLS));
        score3.setScore(1);

        player.setScoreboard(board);


    }
}



