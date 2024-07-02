package com.alinesno.infra.base.pay.channel.properties;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author Javen
 */
@Data
public class H5SceneInfo {
	private H5 h5_info;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	@Data
	public static class H5 {
		private String type;
		private String app_name;
		private String bundle_id;
		private String package_name;
		private String wap_url;
		private String wap_name;
	}
}
