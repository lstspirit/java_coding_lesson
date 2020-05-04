package lab4;

public class test 
{	
	public static void main(String[] args) throws InterruptedException 
	{
		int size = 2000;
		
		Matrix x = new MatrixGenerator(size, size).getMatrix(); 
		Matrix y = new MatrixGenerator(size, size).getMatrix();
		
		long time1 = System.nanoTime();
		Matrix resultSequentially = MatrixMultiplication.multiplyBySequentially(x, y);
		long time2 = System.nanoTime();
		Matrix resultParallelTwoThread = MatrixMultiplication.multiplyByTwoThread(x, y);
		long time3 = System.nanoTime();
		Matrix resultParallelFourThread = MatrixMultiplication.multiplyByFourThread(x, y);
		long time4 = System.nanoTime();

		assert resultSequentially.equals(resultParallelTwoThread);
		assert resultSequentially.equals(resultParallelFourThread);

		System.out.println("当矩阵大小: " + size + " * " + size);
		System.out.println("串行用时: " + (time2 - time1) + "ns");
		System.out.println("双线程用时: " + (time3 - time2) + "ns");
		System.out.println("四线程用时: " + (time4 - time3) + "ns");
	}	
}
