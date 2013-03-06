package Tuan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {

	public static void main(String[] args) {
		// copyFilev1("E:\\9_ISAD2_NopLan1.docx", "E:\\temp3.docx");
		copyFileBechMark();
	}

	public static void copyFileBechMark() {
		for (int i = 1; i <= 1024; i *= 2) {
			copyFilev2("E:\\9_ISAD2_NopLan1.docx", "E:\\temp3.docx", i);
		}
	}

	public static void copyFilev1(String srcFile, String dstFile) {
		try (FileInputStream fs = new FileInputStream(srcFile);
				FileOutputStream fs1 = new FileOutputStream(dstFile);) {
			int value;
			int cnt = 0;
			long start, span;
			start = System.nanoTime();
			while ((value = fs.read()) != -1 && cnt < 1024) {
				cnt++;
				fs1.write(value);
			}

			span = System.nanoTime() - start;
			System.out.printf("%d bytes copied in %f ms\n", cnt,
					span / 1000000000.0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e.toString());
		}
	}

	public static void copyFilev2(String srcFile, String dstFile, int sizeBuffer) {
		try (FileInputStream fs = new FileInputStream(srcFile);
				FileOutputStream fs1 = new FileOutputStream(dstFile);) {
			long start, span;
			int total = 0;
			byte[] buffer = new byte[sizeBuffer*1024];
			start = System.nanoTime();
			int cnt = 0;
			while (fs.available() != 0) {
				cnt = fs.read(buffer);
				// chep len file dich
				total += cnt;
				fs1.write(buffer, 0, cnt);
			}
			span = System.nanoTime() - start;
			System.out.printf("%d Kb : %f ms \n",
					sizeBuffer, span / 1000000000.0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
