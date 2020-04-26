package java��̽���; 

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class copyFile {
	public File filename = new File("D:/�˲���ĸǴı�Ӣ��.txt");
	public File output = new File("D:/copy1.txt");
	public void copy(File resource, File target) throws Exception {
        // ������ --> ��һ��Ŀ���ȡ����
        // ����� --> ��һ��Ŀ��д������

        long start = System.currentTimeMillis();

        // �ļ������������л���
        FileInputStream inputStream = new FileInputStream(resource);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        // �ļ�����������л���
        FileOutputStream outputStream = new FileOutputStream(target);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        // ��������
        byte[] bytes = new byte[1024 * 2];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        // ˢ�����������
        bufferedOutputStream.flush();
        //�ر���
        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        outputStream.close();

        long end = System.currentTimeMillis();

        System.out.println("��ʱ��" + (end - start) / 1000 + " s");

    }
	
	public static void main(String[] args) throws Exception {
		copyFile c1 = new copyFile();
		c1.copy(c1.filename, c1.output);
	}

}
