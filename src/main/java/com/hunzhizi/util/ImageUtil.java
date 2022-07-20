package com.hunzhizi.util;

public class ImageUtil {
//	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
//		String realFileName = FileUtil.getRandomFileName();
//		String extension = getFileExtension(thumbnail);
//		makeDirPath(targetAddr);
//		String relativeAddr = targetAddr + realFileName + extension;
//		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
//		try {
//			Thumbnails.of(thumbnail.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(dest);
//		} catch (IOException e) {
//			throw new RuntimeException("创建缩略图失败：" + e.toString());
//		}
//		return relativeAddr;
//	}
//
//	public static String generateNormalImg(CommonsMultipartFile thumbnail, String targetAddr) {
//		String realFileName = FileUtil.getRandomFileName();
//		String extension = getFileExtension(thumbnail);
//		makeDirPath(targetAddr);
//		String relativeAddr = targetAddr + realFileName + extension;
//		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
//		try {
//			Thumbnails.of(thumbnail.getInputStream()).size(337, 640).outputQuality(0.5f).toFile(dest);
//		} catch (IOException e) {
//			throw new RuntimeException("创建缩略图失败：" + e.toString());
//		}
//		return relativeAddr;
//	}
//
//	public static List<String> generateNormalImgs(List<CommonsMultipartFile> imgs, String targetAddr) {
//		int count = 0;
//		List<String> relativeAddrList = new ArrayList<String>();
//		if (imgs != null && imgs.size() > 0) {
//			makeDirPath(targetAddr);
//			for (CommonsMultipartFile img : imgs) {
//				String realFileName = FileUtil.getRandomFileName();
//				String extension = getFileExtension(img);
//				String relativeAddr = targetAddr + realFileName + count + extension;
//				File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
//				count++;
//				try {
//					Thumbnails.of(img.getInputStream()).size(600, 300).outputQuality(0.5f).toFile(dest);
//				} catch (IOException e) {
//					throw new RuntimeException("创建图片失败：" + e.toString());
//				}
//				relativeAddrList.add(relativeAddr);
//			}
//		}
//		return relativeAddrList;
//	}


}
