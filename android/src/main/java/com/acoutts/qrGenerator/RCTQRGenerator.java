package com.acoutts.qrGenerator;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import android.graphics.Bitmap;
import android.graphics.Color;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class RCTQRGenerator extends ReactContextBaseJavaModule {
  private static ReactApplicationContext reactContext;

  public RCTQRGenerator(ReactApplicationContext context) {
    super(context);
    reactContext = context;
  }

  @Override
  public String getName() {
    return "RCTQRGenerator";
  }

  @ReactMethod
  public void test(Callback callback) {
    callback.invoke("pong", null);
  }

  @ReactMethod
  public void generate(String qrData, Callback callback) {
    QRCodeWriter writer = new QRCodeWriter();
    try {
      BitMatrix bitMatrix = writer.encode(qrData, BarcodeFormat.QR_CODE, 512, 512);
      int width = bitMatrix.getWidth();
      int height = bitMatrix.getHeight();
      Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
        }
      }

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      bmp.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
      byte[] byteArray = byteArrayOutputStream.toByteArray();

      String encoded = Base64.getEncoder().encodeToString(byteArray);
      callback.invoke(encoded, null);

    } catch (Exception e) {
      callback.invoke(null, e);
    }
  }
}
