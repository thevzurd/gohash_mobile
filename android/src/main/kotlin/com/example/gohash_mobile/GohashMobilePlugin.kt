package com.example.gohash_mobile

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

import gonative.DataProcessor

class GohashMobilePlugin: MethodCallHandler {
  var goNativeDataProcessor = DataProcessor()
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "gohash_mobile")
      channel.setMethodCallHandler(GohashMobilePlugin())
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "Increment") {
      val args = call.argument<Int>("count")
      args?.let {
        // not null do something
        result.success( goNativeDataProcessor.increment(args.toLong()))
      }
    } else {
      result.notImplemented()
    }
  }
}
