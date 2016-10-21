# react-native-bottom-sheet
React Native Bottom Sheet module for android

# Demo
![demo](https://github.com/WhatAKitty/react-native-bottom-sheet/demo.gif, "demo")

[Go to example ->](https://github.com/WhatAKitty/ReactNativeBottomSheetTest)

## 如何安装(How to install)

### 首先安装npm包(Install package from npm first)

```bash
npm install react-native-bottom-sheet --save
```

### link(current may not support)
```bash
rnpm link
```

Edit `android/settings.gradle` to look like this (without the +):

```diff
rootProject.name = 'MyApp'

include ':app'

+ include ':react-native-bottom-sheet'
+ project(':react-native-bottom-sheet').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-bottom-sheet/android')
```
Edit `android/app/build.gradle` (note: **app** folder) to look like this: 

```diff
apply plugin: 'com.android.application'

android {
...
}

dependencies {
compile fileTree(dir: 'libs', include: ['*.jar'])
compile "com.android.support:appcompat-v7:23.0.1"
compile "com.facebook.react:react-native:+"  // From node_modules
+ compile project(':react-native-bottom-sheet')
}
```

Edit your `MainActivity.java` (deep in `android/app/src/main/java/...`) to look like this (note **two** places to edit):

```diff
package com.myapp;

+ import com.gnet.bottomsheet.RNBottomSheetPackage;

....

@Override
protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
    new MainReactPackage()
+   , new RNBottomSheetPackage()
    );
}

}
```
  
#### Note:
* rnpm requires node version 4.1 or higher
* Android SDK Build-tools 23.0.1 or higher

## 如何使用(How to use)

### 引入包(import package)

```
import BottomSheet from 'react-native-bottom-sheet';

BottomSheet.showBottomSheetWithOptions(options: Object, callback: Function)
BottomSheet.showShareBottomSheetWithOptions(options: Object, failureCallback: Function, successCallback: Function)
```
