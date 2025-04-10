package com.mobiosdkreactnative

import android.app.Application
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.Callback
import com.mobio.sdk.MobioSDK

class MobioSdkReactNativeModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  private val mobio = MobioSDK.getInstance()

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  @ReactMethod
  fun test_sdk(): String {
    mobio.track()
    return "test_sdk_from_ANDROID"
  }

  @ReactMethod
  fun initWithLaunchOptions(merchantID: String, connectorID: String, apiUrl: String) {
    val application = reactContext.applicationContext as Application
    mobio.initialize(application, merchantID, connectorID, null)
  }


  // @ReactMethod
  // fun initWithLaunchOptions(merchantId: String, connectorId: String, apiUrl: String) {
  // }

  // @ReactMethod
  // fun setDeviceToken(deviceToken: String) {
  // }

  // @ReactMethod
  // fun screenSetting(title: String, controllerName: String, timeVisit: [Int]) {
  // }

  // @ReactMethod
  // fun scrollTracking(screenName: String, scrollPosition: Int) {
  // }

  // @ReactMethod
  // fun track(eventKey: String, properties: ReadableMap) {
  //   val propertiesMap = properties.toHashMap()
  // }z
  // @ReactMethod
  // fun viewScreen(screenName: String) {

  // }

  // @ReactMethod
  // fun identity(properties: ReadableMap) {
  //     val propertiesMap = properties.toHashMap()
  // }

  // @ReactMethod
  // fun eventCallback(callback: Callback) {
  //     val event = mapOf("eventKey" to "sampleEvent", "value" to 123)
  //     callback.invoke(event)
  // }

  @ReactMethod
  fun onNewToken(token: String) {
    mobio.onNewToken(token)
  }

  @ReactMethod
  fun setToken(token: String) {
    mobio.setTokenFirebase(token)
  }

  @ReactMethod
  fun handleReceivedNotification(remoteMessage: RemoteMessage) {
    mobio.onMessageReceived(remoteMessage)
  }

  // @ReactMethod
  // fun handleReceivedRichNotification(notificationInfo: ReadableMap){

  // }

  // @ReactMethod
  // fun handleOnClickNotification(response: ReadableMap){

  // }

  companion object {
    const val NAME = "MobioSdkReactNative"
  }
}
