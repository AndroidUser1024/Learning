package com.qinshou.commonmodule.background;

public enum State {
    ENABLED(android.R.attr.state_enabled),
    NOT_ENABLED(-android.R.attr.state_enabled),
    CHECKED(android.R.attr.state_checked),
    NOT_CHECKED(-android.R.attr.state_checked),
    FOCUSED(android.R.attr.state_focused),
    NOT_FOCUSED(-android.R.attr.state_focused),
    PRESSED(android.R.attr.state_pressed),
    NOT_PRESSED(-android.R.attr.state_pressed),
    SELECTED(android.R.attr.state_selected),
    NOT_SELECTED(-android.R.attr.state_selected);

    State(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}