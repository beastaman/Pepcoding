import java.util.Scanner;

public class l001Basic{
    private static Scanner scn = new Scanner(System.in);

    //The State Of Wakanda - 1
    public static void waveArrayUpDown(){
        int n = scn.nextInt(),m=scn.nextInt(); 
        int[][] arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j]=scn.nextInt();
            }
        }
        int flag=0;
        for(int j=0;j<m;++j){
            if(flag==0){
                for(int i=0;i<n;++i) System.out.println(arr[i][j]);
            }  
            else{
                for(int i=n-1;i>=0;--i) System.out.println(arr[i][j]);
            }
            flag=1-flag;
        }
    }

    // Wave array left right -> -> |
                         //  <- <- \/
    public static void waveArrayLeftRight(){
        int n = scn.nextInt(),m=scn.nextInt(); 
        int[][] arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j]=scn.nextInt();
            }
        }
        int flag=0;
        for(int j=0;j<n;++j){
            if(flag==0){
                for(int i=0;i<m;++i) System.out.println(arr[j][i]);
            }  
            else{
                for(int i=m-1;i>=0;--i) System.out.println(arr[j][i]);
            }
            flag=1-flag;
        }
    }

    // 2d array input and output
    public static void test1(){
        int n = scn.nextInt(),m=scn.nextInt(); 
        int[][] arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j]=scn.nextInt();
            }
        }
        System.out.println("Java");
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Exit point of a matrix
    public static void exitPointOfMatrix(){
        int n = scn.nextInt(),m=scn.nextInt(); 
        int[][] arr = new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j]=scn.nextInt();
            }
        }
        int dir=0; int curx=0,cury=0;
        while(true){
            if(arr[curx][cury]) dir=(dir+1)%4;
            if(dir==0){
                ++cury;
            }
            else if(dir==1){
                ++curx;
            }
            else if(dir==2){
                --cury;
            }
            else if(dir==3){
                --curx;
            }
            if(curx==-1 || curx==n || cury==-1 || cury==m){
                if(dir==0){
                    --cury;
                }
                else if(dir==1){
                    --curx;
                }
                else if(dir==2){
                    ++cury;
                }
                else if(dir==3){
                    ++curx;
                }
                System.out.println(curx);
                System.out.println(cury);
                break;
            } 
        }
    }

    //The State Of Wakanda - 2
    public static void diagonalTraversal(){
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                arr[i][j] = scn.nextInt();
            }
        }
        for(int gap=0;gap<n;++gap){
            int i=0,j=gap;
            while(j<n){
                System.out.println(arr[i][j]);
                ++i;++j;
            }
        }
    }

    //Saddle Point
    public static void saddlePoint(){
        int n = scn.nextInt();
        int m = n;
        int[][] arr = new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                arr[i][j] = scn.nextInt();
            }
        }
        for(int row=0;row<n;++row){
            int col=0;
            for(int j=0;j<m;++j){
                if(arr[row][j]<arr[row][col]){
                    col=j;
                }
            }
            int minEle = arr[row][col];
            boolean saddlePt = true;
            for(int i=0;i<n;++i){
                if(arr[i][col]>minEle){
                    saddlePt = false;
                    break;
                }
            }
            if(saddlePt){
                System.out.println(minEle);
                return;
            }

        }
        System.out.println("Invalid input");
    }

    //search-in-a-sorted-2d-array
    public static void searchInSortedMatrix(int[][] arr,int data){
        int i=0,j=arr[0].length-1;
        while(i<arr.length && j>=0){
            if(arr[i][j]==data){
                System.out.println(i+"\n"+j);
                return ;
            }
            else if(arr[i][j] < data){
                --j;
            }
            else{
                ++j;
            }
        }
        // use any one of the while loop
        i=arr.length-1,j=0;
        while(j<arr[0].length && i>=0){
            if(arr[i][j]==data){
                System.out.println(i+"\n"+j);
                return ;
            }
            else if(arr[i][j] < data){
                ++j;
            }
            else{
                --i;
            }
        }

        System.out.println("Not Found");
    }
    
    
    // Rotate Matrix by 90
    public static void rotateMatrix90(int[][] arr){
        // Transpose of a 2d matrix
        int n = arr.length;
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        // transpose done
        for(int i=0;i<n;++i){
            for(int j=0;j<n/2;++j){
                int temp=arr[i][j];
                arr[i][j]=arr[i][n-1-j];
                arr[i][n-1-j]=temp;
            }
        }
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    //Spiral Disaplay 
    public static void spiralDisplay(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int left=0,right=m-1;
        int top=0,btm=n-1;
        int dir=0;
        while(top<=btm && left<=right){
            if(dir==0){
                for(int x=top;x<=btm;++x){
                    System.out.println(arr[x][left]);
                }
                ++left;
            }
            else if(dir==1){
                for(int x=left;x<=right;++x){
                    System.out.println(arr[btm][x]);
                }
                --btm;
            }
            else if(dir==2){
                for(int x=btm;x>=top;--x){
                    System.out.println(arr[x][right]);
                }
                --right;
            }
            else if(dir==3){
                for(int x=right;x>=left;--x){
                    System.out.println(arr[top][x]);
                }
                ++top;
            }
            dir=(dir+1)%4;
        }
    }

    public static void main(String[] args){
        // test1();
        waveArrayLeftRight();
    }
}