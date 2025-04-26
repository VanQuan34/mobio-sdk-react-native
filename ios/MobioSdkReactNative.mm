#import <React/RCTBridgeModule.h>
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>

@interface RCT_EXTERN_MODULE(MobioSdkReactNative, NSObject)

// Phương thức test_sdk trả về String
RCT_EXTERN_METHOD(test_sdk)

// Phương thức multiply với promise
RCT_EXTERN_METHOD(multiply:(float)a
                  withB:(float)b
                  withResolver:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)

// Khởi tạo SDK với các tham số
RCT_EXTERN_METHOD(initWithLaunchOptions:(NSString *)merchantId
                  connectorId:(NSString *)connectorId
                  apiUrl:(NSString *)apiUrl)

// Đặt device token
RCT_EXTERN_METHOD(setToken:(NSString *)deviceToken)

// // Theo dõi scroll
// RCT_EXTERN_METHOD(scrollTracking:(UIScrollView *)scrollView
//                   screenName:(NSString *)screenName)

// Gửi sự kiện track
RCT_EXTERN_METHOD(track:(NSString *)eventKey
                  properties:(NSDictionary *)properties)

//identity
RCT_EXTERN_METHOD(identity:(NSDictionary *)properties)

// Xem màn hình
// RCT_EXTERN_METHOD(viewScreen:(NSString *)screenName)

// Đăng ký callback sự kiện
// RCT_EXTERN_METHOD(eventCallback:(RCTResponseSenderBlock)callback)

// Xử lý thông báo nhận được
RCT_EXTERN_METHOD(handleReceivedNotification:(NSDictionary *)userInfo)

// Xử lý thông báo rich
// RCT_EXTERN_METHOD(handleReceivedRichNotification:(UNNotification *)notificationInfo)

// Xử lý click thông báo
// RCT_EXTERN_METHOD(handleOnClickNotification:(UNNotificationResponse *)response)

+ (BOOL)requiresMainQueueSetup {
    return NO;
}

@end