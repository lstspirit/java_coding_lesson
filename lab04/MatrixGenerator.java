package lab4;
import java.util.Random;

public class MatrixGenerator 
{
	private Matrix matrix;
	
	public MatrixGenerator()
	{
		Random temp = new Random();
		int row = temp.nextInt(100);
		int col = temp.nextInt(100);
		this.matrix = new Matrix(row, col);
		this.initMatrix();
	} 
	
	public MatrixGenerator(int row, int col)
	{
		this.matrix = new Matrix(row, col);
		this.initMatrix();
	}
	
	public void initMatrix()
	{
		Random temp = new Random();
		for (int i = 0; i < this.matrix.getRow(); i++)
		{
			for (int j = 0; j < this.matrix.getCol(); j++)
			{
				this.matrix.setMatrix(i, j, temp.nextInt(100));
			}
		}
	}
	
	public Matrix getMatrix()
	{
		return this.matrix;
	}
}
