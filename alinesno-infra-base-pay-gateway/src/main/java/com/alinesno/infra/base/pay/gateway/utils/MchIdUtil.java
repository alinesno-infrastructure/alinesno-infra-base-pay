package com.alinesno.infra.base.pay.gateway.utils;

import java.util.Random;

/**
 * 提供生成商户号和特约商户号的工具类。
 *
 * <p>
 * 这个类包含用于生成固定格式商户号的方法。商户号由前缀加上随机生成的数字组成，确保了每次生成的唯一性。
 * </p>
 *
 * <h3>使用示例</h3>
 *
 * <pre>
 *   // 调用方法生成商户号和特约商户号
 *   String mchNo = MchIdUtil.getMchNo();
 *   String isvNo = MchIdUtil.getIsvNo();
 *
 *   System.out.println("Merchant Number: " + mchNo);
 *   System.out.println("ISV Number: " + isvNo);
 * </pre>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class MchIdUtil {

    private static final Random random = new Random();

    /**
     * 生成7位商户号，格式为 "Mch" 加上6位随机数。
     *
     * @return 生成的7位商户号字符串。
     */
    public static String getMchNo() {
        int randomNumber = 100000 + random.nextInt(900000);
        return "MCH" + randomNumber;
    }

    /**
     * 生成7位特约商户号，格式为 "ISV" 加上6位随机数。
     *
     * @return 生成的7位特约商户号字符串。
     */
    public static String getIsvNo() {
        int randomNumber = 100000 + random.nextInt(900000);
        return "ISV" + randomNumber;
    }
}