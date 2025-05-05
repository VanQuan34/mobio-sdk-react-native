import Foundation
import UIKit
import MobioSDK

@objc(MobioSdkReactNative)
class MobioSdkReactNative: NSObject {

  var mobio = Mobio.shared

  @objc(multiply:withB:withResolver:withRejecter:)
  func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    resolve(a*b)
  }

  @objc
  func test_sdk() -> String {
    return "\(mobio.helloSDK())...\("Oke baybe")"
  }
  
  @objc(initWithLaunchOptions:connectorId:apiUrl:)
  func initWithLaunchOptions(_ merchantId: String, connectorId: String, apiUrl: String) {
    do {
      try mobio.initWithLaunchOptions(merchantId: merchantId, connectorId: connectorId, apiUrl: apiUrl)
    } catch {
      print("Error initializing Mobio SDK: \(error)")
    }
  }

  @objc(setToken:)
  func setToken(_ deviceToken: String) {
    do {
      try mobio.setDeviceToken(deviceToken: deviceToken)
    } catch {
      print("Error setting device token: \(error)")
    }
  }

  // func screenSetting(title: String, controllerName: String, timeVisit: [Int]) {
  //   mobio.screenSetting(title: title, controllerName: controllerName, timeVisit: timeVisit)
  // }
  
  // @objc
  // func scrollTracking(_ scrollView: UIScrollView, screenName: String) {
  //   mobio.scrollTracking(scrollView, screenName: screenName)
  // }

  @objc(track:properties:)
  func track(_ eventKey: String, properties: [String: Any]) {
    do {
      try mobio.track(eventKey: eventKey, properties: properties)
    } catch {
      print("Error tracking event: \(error)")
    }
  }

  // @objc
  // func viewScreen(screenName: String) {
  //   mobio.viewScreen(screenName: screenName)
  // }
  
  @objc(identity:)
  func identity(_ properties: [String: Any]) {
    do {
      try mobio.identity(properties: properties)
    } catch {
      print("Error setting identity: \(error)")
    }
  }
  
  // @objc
  // func eventCallback(_ callback: @escaping ([String: Any]) -> Void) {
  //   mobio.eventCallback(callback)
  // }

  @objc
  public func handleReceivedNotification(_ userInfo: [AnyHashable: Any]){
    // mobio.handleReceivedNotification(userInfo)
  }

}