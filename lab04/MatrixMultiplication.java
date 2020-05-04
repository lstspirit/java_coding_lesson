package lab4;

public class MatrixMultiplication{
    static Matrix x;
	static Matrix y;
	
	public MatrixMultiplication(Matrix x, Matrix y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Matrix multiplyBySequentially(Matrix x, Matrix y)
	{
		int xrow = x.getRow();//a
		int xcol = x.getCol();//b1
		int yrow = y.getRow();//b2 
		int ycol = y.getCol();//c
		if (xcol == yrow)
		{
			Matrix result = new Matrix(xrow, ycol);
			for (int i = 0; i < xrow; i++)
			{
				for (int j = 0; j < ycol; j++)
				{
					double sum = 0;
					for (int k = 0; k < xcol; k++)
					{
						sum += x.getMatrix(i, k) * y.getMatrix(k, j);
					}
					result.setMatrix(i, j, sum);
				}
			}
			return result;
		}
		else	
		{
			return null;
		}	
	}
	
	static Matrix multiplyByTwoThread(Matrix x, Matrix y) throws InterruptedException
	{
		int xrow = x.getRow();
		int xcol = x.getCol();
		int yrow = y.getRow();
		int ycol = y.getCol();
		if (xcol == yrow)
		{
			Matrix result = new Matrix(xrow, ycol);
			TwoThread tt = new TwoThread(x, y, result);
			Thread thread1 = new Thread(tt, "线程1");
			Thread thread2 = new Thread(tt, "线程2");
			thread1.start();
			thread2.start();
			while (thread1.isAlive() || thread2.isAlive()){}
			return result;
		}
		else	
		{
			return null;
		}
	}
	
	
	
	static Matrix multiplyByFourThread(Matrix x, Matrix y) throws InterruptedException
	{
		int xrow = x.getRow();
		int xcol = x.getCol();
		int yrow = y.getRow();
		int ycol = y.getCol();
		if (xcol == yrow)
		{
			Matrix result = new Matrix(xrow, ycol);
			FourThread tt = new FourThread(x, y, result);
			Thread thread1 = new Thread(tt, "线程1");
			Thread thread2 = new Thread(tt, "线程2");
			Thread thread3 = new Thread(tt, "线程3");
			Thread thread4 = new Thread(tt, "线程4");
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive()){}
			return result;
		}
		else	
		{
			return null;
		}
	}
}