package algorithm;
import org.apache.commons.math3.linear.LUDecomposition;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import model.Alphabet;

public class HillCipher
{
    String alphabet;
    String[] notAlphabets;
    String charLast;
    int[][] key;
    boolean isKeyValid;
    
    public HillCipher(final Alphabet alphabet) {
        this.charLast = "Z";
        this.key = new int[2][2];
        this.isKeyValid = true;
        this.alphabet = alphabet.getAlphabet();
    }
    
    public int[][] getKey() {
        return this.key;
    }
    
    public void setKey(final int[][] key) {
        this.key = key;
    }
    
    public boolean isKeyValid() {
        return this.isKeyValid;
    }
    
    public void setCharLast(final String a) {
        this.charLast = a;
    }
    
    public String getCharLast() {
        return this.charLast;
    }
    
    public String retrieveCipher(final int[][] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                result = String.valueOf(result) + this.alphabet.charAt(matrix[i][j] % this.alphabet.length());
            }
        }
        return result;
    }
    
    public RealMatrix matrixMod26(final RealMatrix matrix) {
        final double[][] m = new double[matrix.getRowDimension()][matrix.getColumnDimension()];
        for (int i = 0; i < matrix.getRowDimension(); ++i) {
            for (int j = 0; j < matrix.getColumnDimension(); ++j) {
                final double entry = (double)Math.round(matrix.getEntry(i, j));
                m[i][j] = ((entry > 0.0) ? (entry % this.alphabet.length()) : (this.alphabet.length() + entry % this.alphabet.length()));
            }
        }
        final RealMatrix resultMatrix = MatrixUtils.createRealMatrix(m);
        return resultMatrix;
    }
    
    public double[][] converMatrixIntToDouble(final int[][] matrixConvert) {
        final double[][] matrixResult = new double[matrixConvert.length][matrixConvert[0].length];
        for (int i = 0; i < matrixConvert.length; ++i) {
            for (int j = 0; j < matrixConvert[i].length; ++j) {
                matrixResult[i][j] = matrixConvert[i][j];
            }
        }
        return matrixResult;
    }
    
    public int[][] converRealMatrixToIn(final RealMatrix matrix) {
        final int[][] matrixResult = new int[matrix.getRowDimension()][matrix.getColumnDimension()];
        for (int i = 0; i < matrixResult.length; ++i) {
            for (int j = 0; j < matrixResult[i].length; ++j) {
                matrixResult[i][j] = (int)Math.round(matrix.getEntry(i, j));
            }
        }
        return matrixResult;
    }
    
    public String cleanText(final String input) {
        this.notAlphabets = new String[input.length()];
        String result = "";
        for (int i = 0; i < input.length(); ++i) {
            final int index = this.alphabet.indexOf(String.valueOf(input.charAt(i)).toUpperCase());
            if (index >= 0) {
                result = String.valueOf(result) + input.charAt(i);
            }
            else {
                this.notAlphabets[i] = String.valueOf(input.charAt(i));
            }
        }
        return result;
    }
    
    public String restoreText(final String input) {
        final StringBuffer buffer = new StringBuffer(input);
        for (int i = 0; i < this.notAlphabets.length; ++i) {
            if (this.notAlphabets[i] != null) {
                buffer.insert(i, this.notAlphabets[i]);
            }
        }
        return buffer.toString();
    }
    
    public String addCharater(String input, final int length) {
        int i = 0;
        while (true) {
            if (length == i) {
                i = 0;
            }
            if (input.length() == length) {
                break;
            }
            input = String.valueOf(input) + this.charLast;
            ++i;
        }
        return input;
    }
    
    public int[][] mulMatrix(final int[][] matrixA, final int[][] matrixB) {
        final int row = matrixA.length;
        final int column = matrixB[0].length;
        final int[][] result = new int[row][column];
        int temp = 0;
        if (matrixA[0].length == matrixB.length) {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < column; ++j) {
                    for (int j2 = 0; j2 < matrixB.length; ++j2) {
                        temp += matrixA[i][j2] * matrixB[j2][j];
                    }
                    result[i][j] = temp;
                    temp = 0;
                }
            }
        }
        return result;
    }
    
    public void createKey(final int length) {
        final Random random = new Random();
        for (int i = 0; i < this.key.length; ++i) {
            for (int j = 0; j < this.key.length; ++j) {
                this.key[i][j] = random.nextInt(this.alphabet.length());
            }
        }
    }
    
    public void loadKey(final String path) throws IOException {
    }
    
    public String encryptText(final String input) {
        final String inputClean = this.cleanText(input);
        final int numberOfGroup = (int)Math.ceil(inputClean.length() / (double)this.key.length);
        final int lengthNew = numberOfGroup * this.key.length;
        final String substituteInput = this.addCharater(inputClean, lengthNew);
        final String[][] groupValues = new String[numberOfGroup][this.key.length];
        final int[][] matrixM = new int[numberOfGroup][this.key.length];
        int k = 0;
        for (int i = 0; i < groupValues.length; ++i) {
            for (int j = 0; j < groupValues[i].length; ++j) {
                groupValues[i][j] = String.valueOf(substituteInput.charAt(k));
                matrixM[i][j] = this.alphabet.indexOf(String.valueOf(substituteInput.charAt(k)).toUpperCase());
                ++k;
            }
        }
        String cipher = "";
        for (int l = 0; l < matrixM.length; ++l) {
            final int[][] matrixP = new int[matrixM[l].length][1];
            for (int p = 0; p < matrixP.length; ++p) {
                matrixP[p][0] = matrixM[l][p];
            }
            final int[][] matrixC = this.mulMatrix(this.key, matrixP);
            cipher = String.valueOf(cipher) + this.retrieveCipher(matrixC);
        }
        this.charLast = cipher.substring(cipher.length() - 1);
        return this.restoreText(cipher.substring(0, inputClean.length()));
    }
    
    public String decryptText(final String input) {
        final double[][] matrixKey = this.converMatrixIntToDouble(this.key);
        final RealMatrix matrixKeyReal = MatrixUtils.createRealMatrix(matrixKey);
        final double det = (double)Math.round(new LUDecomposition(matrixKeyReal).getDeterminant());
        double detmod26;
        int factor;
        for (detmod26 = ((det >= 0.0) ? (det % this.alphabet.length()) : (this.alphabet.length() + det % this.alphabet.length())), factor = 1; factor < this.alphabet.length() && detmod26 * factor % this.alphabet.length() != 1.0; ++factor) {}
        if (factor >= 26) {
            this.isKeyValid = false;
        }
        final RealMatrix matrixInverse = MatrixUtils.inverse(matrixKeyReal);
        final RealMatrix matrixCofactor = matrixInverse.scalarMultiply(det);
        final RealMatrix matrixCofactorMod26 = this.matrixMod26(matrixCofactor).scalarMultiply((double)factor);
        final RealMatrix matrixKeyMod26 = this.matrixMod26(matrixCofactorMod26);
        final int[][] matrixKeyInt = this.converRealMatrixToIn(matrixKeyMod26);
        this.setKey(matrixKeyInt);
        final String decrypt = this.encryptText(input);
        return decrypt;
    }
    
    public boolean checkKey(final int[][] key) {
        boolean isValid = true;
        final double[][] matrixKey = this.converMatrixIntToDouble(key);
        final RealMatrix matrixKeyReal = MatrixUtils.createRealMatrix(matrixKey);
        final double det = (double)Math.round(new LUDecomposition(matrixKeyReal).getDeterminant());
        double detmod26;
        int factor;
        for (detmod26 = ((det >= 0.0) ? (det % this.alphabet.length()) : (this.alphabet.length() + det % this.alphabet.length())), factor = 1; factor < this.alphabet.length() && detmod26 * factor % this.alphabet.length() != 1.0; ++factor) {}
        if (factor >= 26) {
            isValid = false;
        }
        return isValid;
    }
    
    public static void main(final String[] args) {
        final Alphabet alphabet = new Alphabet();
        final HillCipher hillCipher = new HillCipher(alphabet);
        final int[][] arr = { { 9, 4 }, { 7, 3 } };
        hillCipher.setKey(arr);
        hillCipher.setCharLast("B");
        final String ssString = hillCipher.decryptText("WEJ XG MSU Q");
        System.out.println(ssString);
    }
}