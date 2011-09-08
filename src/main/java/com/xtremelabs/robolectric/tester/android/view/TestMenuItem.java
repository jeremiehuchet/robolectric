package com.xtremelabs.robolectric.tester.android.view;

import com.xtremelabs.robolectric.Robolectric;

import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;

public class TestMenuItem implements MenuItem {

    private int itemId;
    private CharSequence title;
    private boolean enabled = true;
    private OnMenuItemClickListener menuItemClickListener;
    public int iconRes;
    private Intent intent;

    public TestMenuItem() {
        super();
    }

    public TestMenuItem(int itemId) {
        super();
        this.itemId = itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override public int getItemId() {
        return itemId;
    }

    @Override public int getGroupId() {
        return 0;
    }

    @Override public int getOrder() {
        return 0;
    }

    @Override public MenuItem setTitle(CharSequence title) {
        this.title = title;
        return this;
    }

    @Override public MenuItem setTitle(int title) {
        return null;
    }

    @Override public CharSequence getTitle() {
        return title;
    }

    @Override public MenuItem setTitleCondensed(CharSequence title) {
        return null;
    }

    @Override public CharSequence getTitleCondensed() {
        return null;
    }

    @Override public MenuItem setIcon(Drawable icon) {
        return null;
    }

    @Override public MenuItem setIcon(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    @Override public Drawable getIcon() {
        return null;
    }

    @Override public MenuItem setIntent(Intent intent) {
        this.intent = intent;
        return this;
    }

    @Override public Intent getIntent() {
        return this.intent;
    }

    @Override public MenuItem setShortcut(char numericChar, char alphaChar) {
        return null;
    }

    @Override public MenuItem setNumericShortcut(char numericChar) {
        return null;
    }

    @Override public char getNumericShortcut() {
        return 0;
    }

    @Override public MenuItem setAlphabeticShortcut(char alphaChar) {
        return null;
    }

    @Override public char getAlphabeticShortcut() {
        return 0;
    }

    @Override public MenuItem setCheckable(boolean checkable) {
        return null;
    }

    @Override public boolean isCheckable() {
        return false;
    }

    @Override public MenuItem setChecked(boolean checked) {
        return null;
    }

    @Override public boolean isChecked() {
        return false;
    }

    @Override public MenuItem setVisible(boolean visible) {
        return null;
    }

    @Override public boolean isVisible() {
        return false;
    }

    @Override public MenuItem setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override public boolean isEnabled() {
        return enabled;
    }

    @Override public boolean hasSubMenu() {
        return false;
    }

    @Override public SubMenu getSubMenu() {
        return null;
    }

    @Override public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        this.menuItemClickListener = menuItemClickListener;
        return this;
    }

    @Override public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public void click() {
        if (enabled && menuItemClickListener != null) {
            menuItemClickListener.onMenuItemClick(this);
        } else if (enabled && intent != null) {
        	Robolectric.application.startActivity(intent);
        }
    }
}