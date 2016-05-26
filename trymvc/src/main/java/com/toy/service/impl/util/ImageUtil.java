package com.toy.service.impl.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.toy.service.ToyException;

public class ImageUtil {
	public static String getImageName(String oriName) {
		String source = oriName + "_" + System.currentTimeMillis();
		String[] names = oriName.split("\\.");
		String extName = names[1];
		return toMD5(source) + "." + extName;

	}

	public static String saveImage(String baseDir, MultipartFile file) {
		if (!(baseDir.endsWith("/") || baseDir.endsWith("/"))) {
			baseDir = baseDir + "/";
		}
		String thumnailDir = baseDir + "thumnail/";
		File thumnail = new File(thumnailDir);
		if (!thumnail.exists()) {
			thumnail.mkdirs();
		}

		String origName = file.getOriginalFilename();
		String newName = getImageName(origName);
		try {
			FileCopyUtils.copy(file.getBytes(), new File(baseDir + newName));
			generateThumnail(baseDir + newName, thumnailDir + newName);
			return newName;
		} catch (IOException e) {
			throw new ToyException(e);
		}
	}

	private static String toMD5(String source) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new ToyException(e);
		}
		md.update(source.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	private static void generateThumnail(String source, String target) {
		try {
			File fi = new File(source); // 大图文件
			File fo = new File(target); // 将要转换出的小图文件
			int nw = 500;

			AffineTransform transform = new AffineTransform();
			BufferedImage bis = ImageIO.read(fi); // 读取图片
			int w = bis.getWidth();
			int h = bis.getHeight();
			// double scale = (double)w/h;
			int nh = (nw * h) / w;
			double sx = (double) nw / w;
			double sy = (double) nh / h;
			transform.setToScale(sx, sy); // setToScale(double sx, double sy)
											// 将此变换设置为缩放变换。
			System.out.println(w + " " + h);
			AffineTransformOp ato = new AffineTransformOp(transform, null);
			BufferedImage bid = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
			ato.filter(bis, bid);
			ImageIO.write(bid, "jpeg", fo);
		} catch (Exception e) {
			throw new ToyException(e);
		}
	}

}
