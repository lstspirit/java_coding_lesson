package lab4;

public class Matrix {
	private double [][] matrix;
	private int row, col;
	
	public Matrix(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.matrix = new double[row][col];
	}
	
	public double getMatrix(int row, int col) 
	{
		return matrix[row][col];
	}
	 
	public int getRow() 
	{
		return row;
	}
	
	public int getCol() 
	{
		return col;
	}
	
	public void setMatrix(int row, int col, double a) 
	{
		if (row <= this.row && col <= this.col)
		{
			this.matrix[row][col] = a;
		}
	}

}
