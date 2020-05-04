package lab4;

class TwoThread implements Runnable
{
	Matrix x, y, result;
	
	public TwoThread(Matrix x, Matrix y, Matrix result)
	{
		this.x = x;
		this.y = y;
		this.result = result;
	}
	
	@Override 
	public void run() 
	{
		if (Thread.currentThread().getName().equals("线程1"))
		{
			firstThread();
		}
		else if (Thread.currentThread().getName().equals("线程2"))
		{
			secondThread();
		}
	}
	
	public void firstThread()
	{
		for (int i = 0; i < x.getRow(); i += 2)
		{
			for (int j = 0; j < y.getCol(); j++)
			{
				double sum = 0;
				for (int k = 0; k < x.getCol(); k++)
				{
					sum += x.getMatrix(i, k) * y.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}

	}
	
	public void secondThread()
	{
		for (int i = 1; i < x.getRow(); i += 2)
		{
			for (int j = 0; j < y.getCol(); j++)
			{
				double sum = 0;
				for (int k = 0; k < x.getCol(); k++)
				{
					sum += x.getMatrix(i, k) * y.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
}