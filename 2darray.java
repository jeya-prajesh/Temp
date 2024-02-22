public class Main {
    public static void main(String[] args) {
        String fs[][]={{"C","C","B","P"},
                       {"3","10","2", "4"},
                       {"","","","2"}};

        int numRows = fs.length;
        int numCols = fs[0].length;

        for (int j = 0; j < numCols; j++) {
            String format = fs[0][j];
            int length = Integer.parseInt(fs[1][j]);
            int decimal = fs[2][j].isEmpty() ? 0 : Integer.parseInt(fs[2][j]);

            System.out.println("Record: " + format + ", " + length + ", " + decimal);
        }
    }
}

