import 'dart:async';

import 'package:flutter/services.dart';

class GohashMobile {
  static const MethodChannel _channel = const MethodChannel('gohash_mobile');

  static Future<int> increment(int count) async {
    try {
      return await _channel.invokeMethod(
        'Increment',
        <String, dynamic>{
          'count': count,
        },
      );
    } on PlatformException catch (e) {
      print("PlatformException: ${e.message}");
      return count;
    }
  }
}
