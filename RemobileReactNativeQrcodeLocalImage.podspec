Pod::Spec.new do |s|
  s.name         = "RemobileReactNativeQrcodeLocalImage"
  s.version      = "1.0.4"
  s.summary      = "A local qrcode image parse for react-native, support for ios and android"
  s.homepage     = "https://github.com/remobile/react-native-qrcode-local-image"
  s.license      = { :type => "MIT" }
  s.authors      = { "YunJiang.Fang" => "42550564@qq.com" }
  s.platform     = :ios, "8.0"
  s.source         = { :git => 'https://github.com/acoutts/react-native-qrcode-local-image.git', :tag => "#{s.version}"}
  s.source_files = "ios", "ios/**/*.{h,m}"
  s.dependency 'React'
end