package com.gnet.bottomsheet;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import com.cocosw.bottomsheet.BottomSheet;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class RNBottomSheet extends ReactContextBaseJavaModule {

    Activity activity;

    public RNBottomSheet(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        this.activity = activity;
    }

    @Override
    public String getName() {
        return "RNBottomSheet";
    }

    @ReactMethod
    public void showBotttomSheetWithOptions(ReadableMap options, final Callback onSelect) {
        ReadableArray optionArray = options.getArray("options");
        final Integer cancelButtonIndex = options.getInt("cancelButtonIndex");

        BottomSheet.Builder builder = new BottomSheet.Builder(this.activity);

        // create options
        Integer size = optionArray.size();
        for (int i = 0; i < size; i++) {
            builder.sheet(i, optionArray.getString(i));
        }

        builder.listener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == cancelButtonIndex) {
                    dialog.dismiss();
                } else {
                    onSelect.invoke(which);
                }
            }
        });

        builder.build().show();
    }

    @ReactMethod
    public void showShareBottomSheetWithOptions(ReadableMap options, Callback failureCallback, Callback successCallback) {
        String url = options.getString("url");
        String message = options.getString("message");

        BottomSheet.Builder builder = new BottomSheet.Builder(this.activity);

        Uri uri = Uri.parse(url);

        final Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, url);
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);
        shareIntent.setType("*/*");

        failureCallback.invoke("not support this method");
    }

}
