/*
 * Author: Samuel Bohl <bohls@student.ethz.ch>
 * 
 * Bonus Aufgabe 2 - Einführung in die Programmierung HS2020
 */

public class Matrix {
	
	public static boolean checkMatrix(int[][] m) {
		//Aus der Aufgabenbeschreibung sehen wir, dass die gegebene Matrix 4 Bedingungen erfüllen muss.
		//	1) Alle Dimensionen müssen gleich sein
		//	2) Alle Werte müssen zwischen 0 und n² sein. Also 0 < x <= n²
		//	3) Jeder Wert darf nur einmal vorkommen
		//	4) Die Zeilensummen sollen den gleichen Wert der Spaltensummen haben
		return isQuadratic(m) && isInRange(m) && isUnique(m) && rowSumEqualsColSum(m);
	}
	
	/*
	 * Mit dieser Funktion überprüfen wir, ob alle dimensionen gleich sind (also dass m quadratisch ist)
	 */
	public static boolean isQuadratic(int[][] m) {
		int n = m.length;
		for(int i = 0; i < n; ++i) {
			//Es genügt eine Zeile in m zu finden, die eine andere Dimension als n(= m.length) hat.
			if(m[i].length != n) {
				return false;
			}
		}
		
		//Wenn wir diesen Code Abschnitt erreichen, dann gab es keine Zeile, die eine andere Dimension als n hatte.
		return true;
	}
	
	/*
	 * Mit dieser Funktion überprüfen wir, dass jede Zelle im Bereich (0; n²] ist.
	 */
	public static boolean isInRange(int[][] m) {
		int n = m.length;
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				//Es genügt nur eine Zelle zu finden, die nicht passt. Wenn wir so eine Zelle finden, dann 
				//geben wir einfach false zurück.
				if(m[i][j] <= 0 || m[i][j] > n*n) {
					return false;
				}
			}
		}
		
		//Wenn wir diesen Code Abschnitt erreichen, dann waren alle Elemente im richtigen Intervall.
		return true;
	}
	
	/*
	 * Diese Funktion überprüft, ob jedes Element nur einmal vorkommt
	 */
	public static boolean isUnique(int[][] m) {
		int n = m.length;
		
		//Wir erstellen eine Tabelle um bereits benutze Werte zu markieren
		//Boolean Arrays werden standartmässig mit false initialisiert. Deswegen müssen wir hier nicht befüllen.
		boolean[] isUsed = new boolean[n*n+2];
		
		
		//Wir iterieren über alle Elemente
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				
				int currentCell = m[i][j];
				
				//Wir überprüfen, ob dieser Wert in unserer Tabelle bereits vorgekommen ist.
				//Falls ja, dann geben wir false zurück
				if(isUsed[currentCell]) {
					return false;
				}
				
				//Wir erreichen diesen Code Abschnitt, wenn der Wert noch nicht vorgekommen ist.
				//Also markieren wir den aktuellen Wert als benutzt
				isUsed[currentCell] = true;
			}
		}
		
		//Wir erreichen diesen Code Abschnitt wenn kein Wert doppelt vorkam. Also geben wir true zurück.
		return true;
	}
	
	/*
	 * Mit dieser Funktion überprüfen wir, ob alle Zeilen- und Spaltensummen gleich sind.
	 */
	public static boolean rowSumEqualsColSum(int[][] m) {
		int n = m.length;
		
		//Zuerst berechnen wir die erste Zeilen- und Spaltensumme, um später die restlichen damit zu vergleichen
		int firstRowSum = 0, firstColSum = 0;
		for(int i = 0; i < n; ++i) {
			
			firstRowSum += m[0][i];
			firstColSum += m[i][0];
		}
		
		//Wir iterieren über alle gefragten Zeilen/Spalten kombinationen: 
		for(int i = 0; i < n; ++i) {
			
			int currentRowSum = 0, currentColSum = 0;
			
			//Wir berechnen hiermit die Spalten- und Zeilensumme (j ist wie das k in der Summenformel)
			for(int j = 0; j < n; ++j) {
				
				currentRowSum += m[i][j];
				currentColSum += m[j][i];
			}
			
			//Es genügt eine Zeilen- oder Spaltensumme zu finden, die nicht der ersten Summe gleicht
			if(currentRowSum != firstRowSum || currentColSum != firstColSum) {
				return false;
			}
		}
		
		//Wenn wir diesen Code Abschnitt erreichen, dann waren alle Spalten- und Zeilensummen gleich
		return true;
	}

}
