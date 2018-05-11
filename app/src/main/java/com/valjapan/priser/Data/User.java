package com.valjapan.priser.Data;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.github.bassaer.chatmessageview.model.IChatUser;

import org.jetbrains.annotations.NotNull;

public class User  implements IChatUser {
    Integer id;
    String name;
    Bitmap icon;

    public User(int id, String name, Bitmap icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    @NotNull
    @Override
    public String getId() {
        return this.id.toString();
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public String getName() {
        return this.name;
    }

    @Nullable
    @Override
    public Bitmap getIcon() {
        return this.icon;
    }

    @Override
    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}
