
public class TwentyForthyEight {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int move;
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = io.getInt();
            }
        }
        move = io.getInt();
        //left
        if (move == 0) {
            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if(arr[i][j] != 0) {
                        for (int k = j+1; k < 4; k++) {
                            if (arr[i][k] == 0) {
                                continue;
                            }
                            else if (arr[i][j] == arr[i][k]) {
                                arr[i][j] *= 2;
                                arr[i][k] = 0;
                                break;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    if(arr[i][j] == 0) {
                        for (int k = j+1; k < 4; k++) {
                            if (arr[i][k] != 0) {
                                arr[i][j] = arr[i][k];
                                arr[i][k] = 0;
                                j--;
                                break;
                            }
                        }
                    }
                }
            }

        }
        //up
        if (move == 1) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 3; j++) {

                    if(arr[j][i] != 0) {
                        for(int k = j+1; k < 4; k++) {
                            if (arr[k][i] == 0) {
                                continue;
                            }
                            else if (arr[j][i] == arr[k][i]) {
                                arr[j][i] *= 2;
                                arr[k][i] = 0;
                                break;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    if (arr[j][i] == 0) {
                        for(int k = j+1; k < 4; k++) {
                            if (arr[k][i] != 0) {
                                arr[j][i] = arr[k][i];
                                arr[k][i] = 0;
                                j--;
                                break;
                            }
                        }
                    }
                }
            }
        }
        //right
        if (move == 2) {
           for(int i = 0; i < 4; i++) {
               for(int j = 3; j > 0; j--) {

                   if (arr[i][j] != 0) {
                       for (int k = j-1; k >= 0; k--) {
                           if (arr[i][k] == 0) {
                               continue;
                           }
                           else if (arr[i][j] == arr[i][k]) {
                               arr[i][j] *= 2;
                               arr[i][k] = 0;
                               break;
                           }
                           else {
                               break;
                           }
                       }
                   }
                   if (arr[i][j] == 0) {
                       for (int k = j-1; k >= 0; k--) {
                           if (arr[i][k] != 0) {
                               arr[i][j] = arr[i][k];
                               arr[i][k] = 0;
                               j++;
                               break;
                           }
                       }
                   }
               }
           }
        }
        //down
        if (move == 3) {
            for (int i = 0; i < 4; i++) {
                for(int j = 3; j > 0; j--) {

                    if (arr[j][i] != 0) {
                        for (int k = j-1; k >= 0; k--) {
                            if(arr[k][i] == 0) {
                                continue;
                            }
                            else if (arr[j][i] == arr[k][i]) {
                                arr[j][i] *= 2;
                                arr[k][i] = 0;
                                break;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    if (arr[j][i] == 0) {
                        for(int k = j-1; k >= 0; k--) {
                            if (arr[k][i] != 0) {
                                arr[j][i] = arr[k][i];
                                arr[k][i] = 0;
                                j++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        //print
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                io.print(arr[i][j] +" ");
            }
            io.println();
        }
        io.close();
    }

}
