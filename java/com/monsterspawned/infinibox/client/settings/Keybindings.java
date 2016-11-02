package com.monsterspawned.infinibox.client.settings;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import com.monsterspawned.infinibox.reference.Names;

public class Keybindings
{
    public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_R, Names.Keys.CATEGORY);
}