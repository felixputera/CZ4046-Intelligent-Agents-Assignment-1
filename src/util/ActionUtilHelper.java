package util;

import java.text.DecimalFormat;

import classes.ActionUtilPair;
import classes.State;

public class ActionUtilHelper {
	
	public static void displayPolicy(final ActionUtilPair[][] utilArr) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("|");
        for(int col = 0 ; col < Const.NUM_COLS ; col++) {
        	sb.append("---|");
        }
        sb.append("\n");
        
		for (int row = 0; row < Const.NUM_ROWS; row++) {
			sb.append("|");
			for (int col = 0; col < Const.NUM_COLS; col++) {
				
				sb.append(String.format(" %s |", utilArr[col][row].getActionStr()));
			}
	        
	        sb.append("\n|");
	        for(int col = 0 ; col < Const.NUM_COLS ; col++) {
	        	sb.append("---|");
	        }
	        sb.append("\n");
	    }
		
		System.out.println(sb.toString());
	}
	
	/*
	 * Display the utilities of all the (non-wall) states
	 */
	public static void displayUtilities(final State[][] grid, final ActionUtilPair[][] utilArr) {
		
		for (int col = 0; col < Const.NUM_COLS; col++) {
			for (int row = 0; row < Const.NUM_ROWS; row++) {

				if (!grid[col][row].isWall()) {
					System.out.printf("(%1d, %1d): %-2.6f%n", col, row,
							utilArr[col][row].getUtil());
				}
			}
		}
	}
	
	/*
	 * Display the utilities of all the states, in a grid format
	 */
	public static void displayUtilitiesGrid(final ActionUtilPair[][] utilArr) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("|");
        for(int col = 0 ; col < Const.NUM_COLS ; col++) {
        	sb.append("--------|");
        }
        sb.append("\n");
        
        String pattern = "00.000";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
		for (int row = 0; row < Const.NUM_ROWS; row++) {
			
			sb.append("|");
	        for(int col = 0 ; col < Const.NUM_COLS ; col++) {
	        	sb.append("--------|".replace('-', ' '));
	        }
	        sb.append("\n");
			
			sb.append("|");
			for (int col = 0; col < Const.NUM_COLS; col++) {
				
				sb.append(String.format(" %s |",
						decimalFormat.format(utilArr[col][row].getUtil())));
			}
			
			sb.append("\n|");
	        for(int col = 0 ; col < Const.NUM_COLS ; col++) {
	        	sb.append("--------|".replace('-', ' '));
	        }
	        sb.append("\n");
	        
	        sb.append("|");
	        for(int col = 0 ; col < Const.NUM_COLS ; col++) {
	        	sb.append("--------|");
	        }
	        sb.append("\n");
	    }
		
		System.out.println(sb.toString());
	}

}
