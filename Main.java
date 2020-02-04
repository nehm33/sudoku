
public class Main {

	public static void main(String[] args) {
		InputOutputSudoku ios = new InputOutputSudoku("/home/yao/Documents/projets/sudoku/sudoku.txt");
		//InputOutputSudoku ios = new InputOutputSudoku("/user/7/yaoe/Documents/sudoku.txt");
		System.out.println(ios);
		ios.resoudreGrille();
		//System.out.println(ios);
	}

}
