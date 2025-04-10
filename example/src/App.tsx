import { multiply, test_sdk } from 'mobio-sdk-react-native';
import { Text, View, StyleSheet } from 'react-native';
import { useState, useEffect } from 'react';
// import firebase from '@react-native-firebase/app';
// import messaging from '@react-native-firebase/messaging';

export default function App() {
  const [result, setResult] = useState<number | undefined>();
  // console.log('Firebase initialized?', firebase.apps.length > 0);

  useEffect(() => {
    // getFirebaseToken();
    multiply(3, 7).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
      <Text>Result: {test_sdk()}</Text>
    </View>
  );
}

// async function getFirebaseToken() {
//   const authStatus = await messaging().requestPermission();
//   const enabled =
//     authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
//     authStatus === messaging.AuthorizationStatus.PROVISIONAL;

//   if (enabled) {
//     const fcmToken = await messaging().getToken();
//     console.log('FCM Token:', fcmToken);
//     // Gửi token này lên server để gửi push về sau
//   } else {
//     console.log('Permission not granted');
//   }
// }

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
