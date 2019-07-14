package cn.hfut.ssh.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 * 
 * @author Yuqing
 * @version 1.0
 */
public class UploadUtils {
	/**
	 * 解决目录下文件名重复的问题
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getUuidFileName(String fileName) {
		int idx = fileName.lastIndexOf("."); // aa.txt
		String extions = fileName.substring(idx); // .txt
		return UUID.randomUUID().toString().replace("-", "") + extions;
	}

	/**
	 * 目录分离算法： 该算法最多可以得到8级目录，每个目录中最多又会有16级子目录（最多可得到约43亿个目录）
	 *
	 * @param uuidFileName使用UUID得到的文件名（不包含“.”和扩展名）
	 */
	public static String getPath(String uuidFileName) {
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf; // 作为一级目录
		int code2 = code1 >>> 4;
		int d2 = code2 & 0xf; // 作为二级目录
		return "/" + d1 + "/" + d2;
	}
}
