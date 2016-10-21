package com.gnet.bottomsheet;

import android.content.Intent;
import android.os.Parcelable;
import android.net.Uri;

/**
 * Created by xuq on 2016/10/20.
 */

public enum RNBottomShareType {

    IMAGE("image", "image/*", Intent.EXTRA_STREAM),
    FILE("file", "*/*", Intent.EXTRA_STREAM),
    TEXT("text", "text/plain", Intent.EXTRA_TEXT);

    private String key;
    private String type;
    private String extra;
    private RNBottomShareType(String key, String type, String extra) {
        this.key = key;
        this.type = type;
        this.extra = extra;
    }

    public String getType() {
        return this.type;
    }

    public String getExtra() {
        return this.extra;
    }

    public void getExtraValue(Intent intent, String value) {
        switch(this.key) {
            case "image":
                intent.putExtra(this.extra, Uri.parse(value));
            case "text":
                intent.putExtra(this.extra, value);
            case "file":
                intent.putExtra(this.extra, Uri.parse(value));

        }
    }

}
