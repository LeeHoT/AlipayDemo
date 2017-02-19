package com.qingcity.alipay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.qingcity.alipay.bean.AlipayNotification;
import com.qingcity.alipay.util.AlipayUtil;
import com.qingcity.alipay.util.RequestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/pay/alipay")
public class AlipayNotifyController {

	private static Logger logger = LoggerFactory.getLogger(AlipayNotifyController.class);

	/**
	 * 异步接受支付宝支付结果 支付宝服务器调用
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "notify", method = RequestMethod.POST)
	public void receiveNotify(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("跳转过来了。");
		Map<String, String> underScoreKeyMap = RequestUtils.getStringParams(request);
		Map<String, String> camelCaseKeyMap = RequestUtils.convertKeyToCamelCase(underScoreKeyMap);
		// 首先验证调用是否来自支付宝
		System.out.println(underScoreKeyMap.toString());
		System.out.println(camelCaseKeyMap.toString());
		PrintWriter printWriter = null;
		String resultResponse = "success";
		if ("TRADE_SUCCESS".equals(request.getParameter("trade_status"))) {
			Enumeration<?> pNames = request.getParameterNames();
			Map<String, String> param = new HashMap<String, String>();
			try {
				while (pNames.hasMoreElements()) {
					String pName = (String) pNames.nextElement();
					param.put(pName, request.getParameter(pName));
				}
				System.out.println("验证前商品总价和: " + param.get("totle_amount"));
				System.out.println(param.toString());
				boolean signVerified = AlipaySignature.rsaCheckV1(param, AlipayUtil.ALIPAY_PUBLIC_KEY,
						AlipayConstants.CHARSET_UTF8); // 校验签名是否正确
				if (signVerified) {
					// TODO 验签成功后
					String jsonStr = JSON.toJSONString(camelCaseKeyMap);
					AlipayNotification notice = JSON.parseObject(jsonStr, AlipayNotification.class);
					System.out.println("支付宝交易单号: " + notice.getTradeNo());
					System.out.println("订单号: " + notice.getOutTradeNo());
					System.out.println("订单描述: " + notice.getBody());
					System.out.println("商品名称: " + notice.getSubject());
					System.out.println("商品总价: " + notice.getTotalFee());
					// 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
					logger.info("订单支付成功：" + JSON.toJSONString(param));
					printWriter = response.getWriter();
				} else {
					resultResponse = "failure";
					System.out.println("验签失败");
					// TODO 验签失败则记录异常日志，并在response中返回failure.
				}
			} catch (Exception e) {
				resultResponse = "failure";
				e.printStackTrace();
			}
		}
		if (printWriter != null) {
			printWriter.print(resultResponse);
		}
		// boolean verifyResult = AlipayNotify.verify(underScoreKeyMap);
		// try {
		// String jsonString = JSON.toJSONString(camelCaseKeyMap);
		// AlipayNotification notice = JSON.parseObject(jsonString,
		// AlipayNotification.class);
		// notice.setVerifyResult(verifyResult);
		// String resultResponse = "success";
		// PrintWriter printWriter = null;
		// try {
		// printWriter = response.getWriter();
		// // do business
		// if (verifyResult) {
		// }
		// // fail due to verification error
		// else {
		// resultResponse = "fail";
		// }
		// } catch (Exception e) {
		// logger.error("alipay notify error :", e);
		// resultResponse = "fail";
		// printWriter.close();
		// }
		// if (printWriter != null) {
		// printWriter.print(resultResponse);
		// }
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }
	}
}