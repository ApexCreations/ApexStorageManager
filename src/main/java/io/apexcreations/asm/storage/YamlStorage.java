package io.apexcreations.asm.storage;

import io.apexcreations.asm.ApexStorage;
import io.apexcreations.asm.annotations.Config;
import io.apexcreations.asm.annotations.ConfigValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class YamlStorage extends ApexStorage {

    private Plugin plugin;

    public YamlStorage(/*Plugin plugin*/) {
        this.plugin = plugin;
    }

    @Override
    public void load(Object object) throws FileNotFoundException {
        Class<?> clazz = object.getClass();
        Config configAnnotation = clazz.getAnnotation(Config.class);

        String path = configAnnotation.path();

        path = this.applyPlaceholders(path + ((path.endsWith(".yml")) ? "" : ".yml"));
        File file = this.generateFile(path);
        if (file == null) {
            throw new FileNotFoundException
                    ("Could not find proper configuration file in path \"" + path + "\"");
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        this.loadData(object, clazz, config);
    }

    private void loadData(Object object, Class<?> clazz, FileConfiguration fileConfiguration) {
        for (Field field : clazz.getDeclaredFields()) {
            ConfigValue configValue = field.getAnnotation(ConfigValue.class);
            if (configValue == null) {
                continue;
            }
            boolean isAccessible = field.isAccessible();
            if (!isAccessible) {
                field.setAccessible(true);
            }
            try {
                field.set(object, fileConfiguration.get(configValue.path()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (!isAccessible) {
                field.setAccessible(false);
            }
        }
    }

    @Override
    public void save(Object object) {

    }

    private String applyPlaceholders(String s) {
        return s;//.replace("%dataFolder%", plugin.getDataFolder().toString());
    }

    private File generateFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }
}
