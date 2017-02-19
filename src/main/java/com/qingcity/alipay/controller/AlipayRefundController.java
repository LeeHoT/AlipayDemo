package com.qingcity.alipay.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.qingcity.alipay.util.AlipayUtil;
import com.qingcity.alipay.util.OrderInfoUtil;

/**
 * 
 * @author Administrator
 * @Date 2017年2月19日 下午4:34:14
 * @Description TODO
 */
@Controller
@RequestMapping(value = "/pay/alipay")
public class AlipayRefundController {

	private static final Logger logger = LoggerFactory.getLogger(AlipayRefundController.class);

	/**
	 * 订单退款
	 * 
	 * @param request
	 * @param response
	 * @param tradeno
	 *            支付宝交易订单号
	 * @param orderno
	 *            商家交易订单号
	 * @param callback
	 */
	@RequestMapping(value = "/refund", method = RequestMethod.POST)
	public void orderPayRefund(HttpServletRequest request, HttpServletResponse response, String tradeno,
			String orderno) {
		logger.info("正在进行一笔退款");
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest(); // 统一收单交易退款接口
		alipayRequest.setBizContent(JSON.toJSONString(OrderInfoUtil.buildRefundParamMap(tradeno, orderno))); // 不需要对json字符串转义
		Map<String, Object> restmap = new HashMap<>();// 返回支付宝退款信息
		boolean flag = false; // 查询状态
		try {
			AlipayTradeRefundResponse alipayResponse = AlipayUtil.getAlipayClient().execute(alipayRequest);
			if (alipayResponse.isSuccess()) {
				// 调用成功，则处理业务逻辑
				if ("10000".equals(alipayResponse.getCode())) {
					// 订单创建成功
					flag = true;
					restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
					restmap.put("trade_no", alipayResponse.getTradeNo());
					restmap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());// 用户的登录id
					restmap.put("gmt_refund_pay", alipayResponse.getGmtRefundPay()); // 退看支付时间
					restmap.put("buyer_user_id", alipayResponse.getBuyerUserId());// 买家在支付宝的用户id
				} else {
				}
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

		if (flag) {
			// 订单查询成功

		} else { // 订单查询失败
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param orderno
	 *            商家订单号
	 * @param tradeno
	 *            支付宝订单号
	 * @param callback
	 */
	@RequestMapping(value = "/refund/query", method = RequestMethod.POST)
	public void orderPayRefundQuery(HttpServletRequest request, HttpServletResponse response, String orderno,
			String tradeno, String callback) {

		AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest(); // 统一收单交易退款查询
		// 只需要传入业务参数
		Map<String, Object> param = new HashMap<>();
		param.put("out_trade_no", orderno); // 商户订单号
		param.put("trade_no", tradeno);// 交易金额
		param.put("out_request_no", orderno);// 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
		alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义

		Map<String, Object> restmap = new HashMap<>();// 返回支付宝退款信息
		boolean flag = false; // 查询状态
		try {
			AlipayTradeFastpayRefundQueryResponse alipayResponse = AlipayUtil.getAlipayClient().execute(alipayRequest);
			if (alipayResponse.isSuccess()) {
				// 调用成功，则处理业务逻辑
				if ("10000".equals(alipayResponse.getCode())) {
					// 订单创建成功
					flag = true;
					restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
					restmap.put("trade_no", alipayResponse.getTradeNo());
					restmap.put("out_request_no", alipayResponse.getOutRequestNo());// 退款订单号
					restmap.put("refund_reason", alipayResponse.getRefundReason()); // 退款原因
					restmap.put("total_amount", alipayResponse.getTotalAmount());// 订单交易金额
					restmap.put("refund_amount", alipayResponse.getTotalAmount());// 订单退款金额
				} else {
				}
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

		if (flag) {
		} else { // 订单查询失败
		}
	}
}
