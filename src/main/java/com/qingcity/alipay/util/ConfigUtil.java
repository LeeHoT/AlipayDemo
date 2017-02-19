package com.qingcity.alipay.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 创建时间：2016年6月14日 下午7:47:27
 * 
 * @author andy
 * @version 2.2
 */

public class ConfigUtil {

	private static final Logger LOG = LoggerFactory.getLogger(ConfigUtil.class);

	private static Properties config = null;

	/**
	 * 返回系统config.properties配置信息
	 * 
	 * @param key
	 *            key值
	 * @return value值
	 */
	public static String getProperty(String key) {
		if (config == null) {
			synchronized (ConfigUtil.class) {
				if (null == config) {
					try {
						Resource resource = new ClassPathResource("config.properties");
						config = PropertiesLoaderUtils.loadProperties(resource);
					} catch (IOException e) {
						LOG.error(e.getMessage(), e);
					}
				}
			}
		}
		return config.getProperty(key);
	}
}
