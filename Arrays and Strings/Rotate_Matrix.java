import java.util.Arrays;

public class Rotate_Matrix {
    public static void main(String[] args) {

        int[][] image1 = {{ 1, 2 },
                          { 3, 4 }};

        int[][] image2 = {{ 1, 2, 3 },
                          { 4, 5, 6 },
                          { 7, 8, 9 }};

        int[][] image3 = {{  1,  2,  3,  4 },
                          {  5,  6,  7,  8 },
                          {  9, 10, 11, 12 },
                          { 13, 14, 15, 16 }};

        int[][] image4 = {{  1,  2,  3,  4,  5 },
                          {  6,  7,  8,  9, 10 },
                          { 11, 12, 13, 14, 15 },
                          { 16, 17, 18, 19, 20 },
                          { 21, 22, 23, 24, 25 }};
        
        Sol1 solution1 = new Sol1();
        for(int[] matrx : image3) {
            System.out.println(Arrays.toString(matrx));
        }
        solution1.rotate(image3);
        System.out.println("-->");
        for(int[] matrx : image3) {
            System.out.println(Arrays.toString(matrx));
        }
        
    }
}

class Sol1 {

    public boolean rotate(int[][] image) {
        if(image.length==0 || image.length!=image[0].length) return false;

        int n = image.length;

        for(int layer=0; layer<n/2; layer++) {
            int first = layer;
            int last = n-1-layer;

            for(int i=first; i<last; i++) {
                int top = image[first][i];
                int offset = i - layer;

                /*left->top*/
                image[first][i] = image[last-offset][first];
                /*bottom->left*/
                image[last-offset][first] = image[last][last-offset];
                /*right->bottom*/
                image[last][last-offset] = image[i][last];
                /*top->right*/
                image[i][last] = top;
            }
        }

        return true;
    }
}

// Time Complexity: O(n^2). Impossible to do better since must touch all n^2 elements.
// Space Complexity: O(1)