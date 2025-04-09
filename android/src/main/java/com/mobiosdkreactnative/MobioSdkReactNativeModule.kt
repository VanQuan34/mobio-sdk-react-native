package com.mobiosdkreactnative

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
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
  // fun scrollTracking(_ scrollView: UIScrollView, screenName: String) {
  // }

  // @ReactMethod
  // fun track(eventKey: String, properties: [String : Any]) {
    
  // }

  // @ReactMethod
  // fun viewScreen(screenName: String) {
    
  // }
  
  // @ReactMethod
  // fun identity(properties: [String : Any]) {
  // }
  
  // @ReactMethod
  // fun eventCallback(callback: @escaping ([String: Any]) -> Void) {
    
  // }

  // @ReactMethod
  // fun handleReceivedNotification(userInfo: [AnyHashable: Any]){
    
  // }

  // @ReactMethod
  // fun handleReceivedRichNotification(notificationInfo: UNNotification){
    
  // }

  // @ReactMethod
  // fun handleOnClickNotification(response: UNNotificationResponse){

  // }

  // /// Background task
  // /// Đăng ký một processing task
  // /// - Parameters:
  // ///   - identifier: Định danh task
  // ///   - workItem: Công việc cần thực hiện
  // @ReactMethod
  // fun registerProcessingTask(identifier: String, promise: Promise) {
  //   try {
  //     // MobioSDK.getInstance().registerProcessingTask(identifier) {
  //     //     promise.resolve("Task $identifier completed")
  //     // }
  //   } catch (e: Exception) {
  //     promise.reject("TASK_ERROR", e)
  //   }
  // }

  // /// Đăng ký một app refresh task
  // /// - Parameters:
  // ///   - identifier: Định danh task
  // ///   - workItem: Công việc cần thực hiện
  // @ReactMethod
  // fun registerAppRefreshTask(identifier: String, workItem: Promise) {
  // }

  // /// Lên lịch cho một task
  // /// - Parameters:
  // ///   - identifier: Định danh task
  // ///   - config: Cấu hình (nếu nil sẽ dùng cấu hình mặc định)
  // @ReactMethod
  // fun scheduleTask(identifier: String, config: MoTaskConfig? = nil) {
    
  // }
    
  // /// Lên lịch cho tất cả các task đã đăng ký
  // @ReactMethod
  // fun scheduleAllTasks() {
    
  // }
    
  // /// Lên lịch task vào một thời điểm cụ thể trong ngày
  // /// - Parameters:
  // ///   - identifier: Định danh task
  // ///   - hour: Giờ (0-23)
  // ///   - minute: Phút (0-59)
  // @ReactMethod
  // fun scheduleTaskAt(identifier: String, hour: Int, minute: Int) {
    
  // }

  companion object {
    const val NAME = "MobioSdkReactNative"
  }
}