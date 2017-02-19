package com.qingcity.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2017020405516276";

	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;
	// 商户的私钥
	public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDAgEhFBJZTQIXTvW8QKIazeI/FxOAfKhj/xHu5HjpI2QCR0rj6PUvrNcF6fNbeLs5aeUA3rF9Btn+dtIeaegVQNtQPtCxsge3J4a7odld4udJalKVjcqMOTyN/JybE6Wfn7npqRHKL5Hd2e4zHbySjZ7AUG+uaHeTt8+4by2oRxpcTUnzix0saPvAij2rbigVp/ePbYXM0tfIh+fcU9hhlv9CeFYyH2EbgA3lrUFI4V3DbdYjwq1TQx/LvpxQM0jGwxCfjVr3AyhoPIlj3mj8zPeZf1bA9tYYnV17TqKsGyeCfrVyvcngUzHwpAheKajlfbd0hAYRPu6tf4Wmua0y/AgMBAAECggEARWA2K4GKt7hCQtw7oaQpX5bsocbhSvn+BneGa2HkeYqTdPpvpeffa4Z1EzLYsTxHLD4UkbvynJksBucgE+Ez9wO7i2lQtU5iJ2bJhYfY4G5/zBtUO7H959NHpLS0eTTxOJouzgubCKWvFClUxC9fEfD1eVnSoDlz3voRbzzxHjRGU7hnaHKqBx61Lmedh+de9XEBXO6cSaMRdx/3yP8u1SQx1BC614shnnlwzjZ1lgYxuaPFcBJ8PNYor3ac6t2LgpeJ7K1a2HkGtsdWvIoG2/0Vn2A2/T+cOweLvJUJnSpF0VOgr0aNmUO0vx3a5sxetFULDlBd4WDYCLXuDrw12QKBgQD0KwYCWq5kUT0Cs0HdGlA5tSWjySOGqK831YKh75nexbegQR7EdB5ldmzf+lcCWDAz2IFIyUw/j7yKm/Yq207q5uI74LKBT0FgwbXmBitmc47QjTeCJuH7o3vF8UubWdOEI3VcG3DssSjR+/UmE+9EsRnw3afvowCUh1UkGkicRQKBgQDJ1FCmcOFC2gm9Ky8IVdCjzN0edgYGuw062A2wPvCkRlSR3ZTHW9YipOs5pDo0p4BpSiBtrZwlI+JStS6lm9XzRlJK00Bn3YWRV5b8RWn/WGb6uI1w6m9rJA6CXuy3NSyFyP7ZeRoKmDQwMuWevtCm9avMk93EkCFhduyC6y2vMwKBgQDVmlHOe3A22I8MLq++8sceROfhyhOnOSjYKpP2gLrWlZeXvYBiEseIsbp7kvDNX0MECDLJ7zgiHuetRtVrFqKKg2OFSIRA9YnXUH+F9P3AyfU1Y2UdGlD2KEYem4IuLL4Kyk5gPq1ik3WHhekn36ahLGHqQq8oyCu4xE/qnofJFQKBgEO8gPDLU56nJLubQaavfl1rBQ8TF0StBGyqVDXBeev4OqvVzPf3h2+LH/LxfiNrz/oGScnliVEhsPSHIEeufGiwQjAgpC33t7smxWKXPVLYbX9Z7wZld81ihYgVqaZ3LyEbawS70xSZLnK6sjvL2KUgMG9xdO1iXgGi8w+hNGznAoGAV9R6hF6x4TrP21PBO1jA/Wx/F6X1fL2xW/nGQLadPFosyFKIAH5OfHbHp9R2QiYl26Z9SLJIQN57kzZ8+Izmi3rkHWl6jeeBOt683x+CMYQW6thE3PWeFfn3pUEhlXWXDhUZp0+NpyqfX9SVNM22zJMGMf5Ip66uO71EbeDotTs=";

	// 支付宝的公钥，无需修改该值
	public static String ali_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnLBcgn7J+645eRXp5oDG1GMGbF0cp8HQPE9FS/zjvUKEtnUlSt+aZAgs4egkbYfTwknFXpU7d8L4cGiV2mbV+keJpIb2vkf8SWA2tMlKwWS4W9yBhClpDfv2vai51zBHeT3g7beQgTJrkuEgthVtjeYQAMfiRFmz+Mf/1Thq8/o2N+yxQNazm7TrUO6kFK1Le8OB4kPBD3Pza4tgLI+1ZVem7jms3No8h0/OEX8hDBf2eY1/2HQT8m7r+xbeMDsbLVn23gLC1KxcPR11b+EcPiR8bNQ1UhRb9HJEIUvaNmjkVauuiTAONoAHX8Fj0nGRXCPw30uw3Qtcl/lHVgwZWQIDAQAB";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/return_url";

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

	// 支付类型 ，无需修改
	public static String payment_type = "1";

	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";

	public static String refund_service = "refund_fastpay_by_platform_pwd";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// ↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 防钓鱼时间戳 若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";

	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}
