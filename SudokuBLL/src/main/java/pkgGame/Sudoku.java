/**
 * 
 */
package pkgGame;

import java.lang.Math;

import pkgHelper.LatinSquare;

/**
 * @author Yunpeng
 *
 */
public class Sudoku extends LatinSquare {

	public Sudoku() {
		super();
	}
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
		
	}
	protected int[] getRegion(int iRegionNbr) {
		//pass back two dimension array.
		int n = iRegionNbr;
		int[][] p = getPuzzle();
		int k = 0;
		
		int count=0; 
		int[] iRegion = new int[this.getPuzzle().length];
		for (int i = 0; i < (int)Math.sqrt(this.getPuzzle().length); i++ ) {
			for (int j = 0; j < (int)Math.sqrt(this.getPuzzle().length); i++ ) {
				iRegion[count] = p[n / 3 * 3 + i][n % 3 * 3 +j];
				count++;
			}
		}
		return iRegion;

	}
	protected int[] getRegion(int Col, int Row) {
		//figure what region i am in.
		
		return null;
		
	}
	protected boolean isSudoku() {
		//
		return false;
	}
	protected boolean isPartialSudoku() {
		//isPartialSudoku - return 'true' if... 
		//It's a LatinSquare If each region doesn't have duplicates 
		//If each element in the first row of the puzzle is in each region of the puzzle At least one of the elemnts is a zero
		for (int i = 0; i < getPuzzle().length; i++) {
			if (hasDuplicates(getRegion(i))) {
				return false;
	
			}
			for (int j = 0; j < getPuzzle().length; j++) {
				if (getRegion(i)[j] == 0 ) {
					return true;
				}
			}
		}
		return false;
		
	}
	protected boolean isValueValid(int iValue, int Col, int Row) {
		return false;
	}
	
}
