import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'mobio-sdk-react-native' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const MobioSdkReactNative = NativeModules.MobioSdkReactNative
  ? NativeModules.MobioSdkReactNative
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return MobioSdkReactNative.multiply(a, b);
}

export function test_sdk(): String {
  return MobioSdkReactNative.test_sdk();
}

export function initWithLaunchOptions(merchantId: String,connectorId: String,apiUrl: String) {
  MobioSdkReactNative.initWithLaunchOptions(merchantId, connectorId, apiUrl);
}

export function setToken(deviceToken: String) {
  MobioSdkReactNative.setToken(deviceToken);
}

export function screenSetting(
  title: String,
  controllerName: String,
  timeVisit: Array<number>
) {
  MobioSdkReactNative.screenSetting(title, controllerName, timeVisit);
}

// export function scrollTracking(scrollView: UIScrollView, screenName: String) {
//   MobioSdkReactNative.scrollTracking(scrollView, screenName)
// }

export function track(eventKey: String, properties: any) {
  MobioSdkReactNative.track(eventKey, properties);
}

export function viewScreen(screenName: String) {
  MobioSdkReactNative.viewScreen(screenName);
}

export function identity(properties: any) {
  MobioSdkReactNative.identity(properties);
}

export function eventCallback(callback: (event: Record<string, any>) => void) {
  MobioSdkReactNative.eventCallback(callback);
}

export function handleReceivedNotification(message: any) {
  console.log("handleReceivedNotification", message);
  MobioSdkReactNative.handleReceivedNotification(message);
}

export function handleReceivedRichNotification(notificationInfo: any) {
  MobioSdkReactNative.handleReceivedRichNotification(notificationInfo);
}

export function handleOnClickNotification(response: any) {
  MobioSdkReactNative.handleOnClickNotification(response);
}
