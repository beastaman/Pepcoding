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

    public static void main(String[] args){
        // test1();
        waveArrayLeftRight();
    }
}