package com.acoutts.qrgenerator;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RCTQRGenerator extends ReactContextBaseJavaModule {
  public RCTQRGenerator(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RCTQRGenerator";
  }

  @ReactMethod
  public void test() {
    return "pong"
  }
}
