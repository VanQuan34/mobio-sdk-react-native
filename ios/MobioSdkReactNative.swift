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
  
  @objc
  func initWithLaunchOptions(merchantId: String, connectorId: String, apiUrl: String) {
    mobio.initWithLaunchOptions(merchantId: merchantId, connectorId: connectorId, apiUrl: apiUrl)
  }

  @objc
  func setToken(token: String) {
    mobio.setDeviceToken(deviceToken: token)
  }

  func screenSetting(title: String, controllerName: String, timeVisit: [Int]) {
    mobio.screenSetting(title: title, controllerName: controllerName, timeVisit: timeVisit)
  }
  
  @objc
  func scrollTracking(_ scrollView: UIScrollView, screenName: String) {
    mobio.scrollTracking(scrollView, screenName: screenName)
  }

  @objc
  func track(eventKey: String, properties: [String : Any]) {
    mobio.track(eventKey: eventKey, properties: properties)
  }

  @objc
  func viewScreen(screenName: String) {
    mobio.viewScreen(screenName: screenName)
  }
  
  func identity(properties: [String : Any]) {
    mobio.identity(properties: properties)
  }
  
  @objc
  func eventCallback(_ callback: @escaping ([String: Any]) -> Void) {
    mobio.eventCallback(callback)
  }

  @objc
  public func handleReceivedNotification(_ userInfo: [AnyHashable: Any]){
    mobio.handleReceivedNotification(userInfo)
  }

  @objc
  public func handleReceivedRichNotification(_ notificationInfo: UNNotification){
    mobio.handleReceivedRichNotification(notificationInfo)
  }

  @objc
  func handleOnClickNotification(_ response: UNNotificationResponse){
    mobio.handleOnClickNotification(response)
  }

}