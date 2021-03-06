package test;

public class MatrixMultiplicatorVariantA extends MatrixMultiplicator {

	@Override
	public long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, final Matrix result ) {

		int[][] contentResult = result.getContent();
		int[][] contentMatrixA = matrixA.getContent();
		int[][] contentMatrixB = matrixB.getContent();
		
		long start,end;
		start = System.nanoTime();
		
		// omp parallel for schedule(static) threadNum(2)
		for (int i = 0; i < matrixA.getWidth(); i++) {
			for (int j = 0; j < matrixB.getHeight(); j++) {
				for (int k = 0; k < matrixA.getHeight(); k++) {
					contentResult[i][j] = contentResult[i][j] + contentMatrixA[i][k] * contentMatrixB[k][j];
				}
			}
		}
		
		end = System.nanoTime();
		return end-start;
	}

}
