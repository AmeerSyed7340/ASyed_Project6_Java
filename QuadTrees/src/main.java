import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class QtNode{
    public int color;
    public int upperR;
    public int upperC;
    public int Size;
    QtNode NWkid = null;
    QtNode NEkid = null;
    QtNode SWkid = null;
    QtNode SEkid = null;

    public QtNode(int upperR, int upperC, int Size, QtNode NWkid, QtNode NEkid, QtNode SWkid, QtNode SEkid){
        this.upperR = upperR;
        this.upperC = upperC;
        this.Size = Size;
        this.NWkid = NWkid;
        this.NEkid = NEkid;
        this.SWkid = SWkid;
        this.SEkid = SEkid;
    }//constructor

    public void printQtNode(QtNode node, File outFile){

    }//printQtNode
} //End class QtNode

class QuadTree{
    int numRows;
    int numCols;
    int minVal;
    int maxVal;
    int power2;
    int [][] imgAry;
    QtNode QtRoot = null;

    public QuadTree(int numRows, int numCols, int minVal, int maxVal){
        this.numRows = numRows;
        this.numCols = numCols;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }//constructor

    public int computePower2(int numRows, int numCols){
        int max = 0;
        max = Math.max(numRows, numCols);
        int size = max;
        power2 = 2;
        while(size > power2){
            power2 *= 2;
        }
        return power2;
    }//computePower2

    public void loadImage(File inFile,int[][] imgAry){
        Scanner scFile = null;
        Scanner scL = null;
        int r;
        int c;
        int data = 0;
        String strData = null;

        try {
            scFile = new Scanner(inFile);
        }
        catch(IOException exp){
            exp.printStackTrace();
        }
        String firstLine = scFile.nextLine();
        //System.out.println("first: " + firstLine);
        scFile.useDelimiter(" ");
        String afterFirstLine = null;
        r = 0;
        while (scFile.hasNextLine()){
            afterFirstLine = scFile.nextLine();
            System.out.println("After: " + afterFirstLine);
           /* scL = new Scanner(afterFirstLine);
            scL.useDelimiter(" ");*/

            while(r < numRows){
                c = 0;
                while(c < numCols){
                    //while(scL.hasNextLine()){
                        strData = scFile.next();
                        data = Integer.parseInt(strData);
                        imgAry[r][c] = data;
                        c++;
                    //}
                }
                r++;
            }
        }
    }//loadImage

    public void zero2DAry(){

    }//zero2DAry

    public QtNode buildQuadTree(){
        return null;
    }//buildQuadTree

    public void sumKidsColor(QtNode node){

    }//sumKidsColor

    public void setLeaf(QtNode node){

    }//setLeaf

    public boolean isLeaf(QtNode node){
        return false;
    }//isLeaf

    public void preOrder(){

    }//preOrder

    public void postOrder(){

    }//postOrder
}

public class main {
    public static void main(String[] args) {
        System.out.println("Hello");
        File f1 = new File("G:\\SchoolDloads\\QC2021-2022\\Spring_2022\\DesignAndAnalysis\\Codes\\QuadTrees\\src\\inFile.txt");
        File outFile2 = new File("outFile2.txt");

        Scanner sc = null;
        Scanner sc1 = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        try{
            sc = new Scanner(f1);
            fw = new FileWriter(outFile2);
            pw = new PrintWriter(fw);
        }
        catch (IOException exp) {
// TODO Auto-generated catch block
            exp.printStackTrace();
        }//try-catch


       /* String st1 = null;
        while(sc.hasNextLine()) {
            st1 = sc.nextLine();
            System.out.println(st1);
            pw.print(st1);
            pw.println();
        }*/
        /*print(pw, "sdjkfhs");
        print(pw, "sajhdasjkdh" );
        sc.close();
        pw.close();*/

        String firstLine = sc.nextLine();
        String numRStr, numCStr, minVStr, maxVStr;
        int numRInt = 0;
        int numCInt = 0;
        int minVInt = 0;
        int maxVInt = 0;
        sc1 = new Scanner(firstLine);
        sc1.useDelimiter(" ");
        while(sc1.hasNextLine()){
            numRStr = sc1.next();
            numRInt = Integer.parseInt(numRStr);
            numCStr = sc1.next();
            numCInt = Integer.parseInt(numCStr);
            minVStr = sc1.next();
            minVInt = Integer.parseInt(minVStr);
            maxVStr = sc1.next();
            maxVInt = Integer.parseInt(maxVStr);
        } //while

        QuadTree qT = new QuadTree(numRInt, numCInt, minVInt, maxVInt);
        int power2 = qT.computePower2(qT.numRows, qT.numCols);
        pw.print("power2: " + power2);
        pw.println();
        qT.imgAry = new int[power2][power2];
        qT.loadImage(f1,qT.imgAry);

        pw.close();
        sc.close();
    }//inner main

    public static void print(PrintWriter p, String s){
        p.println(s);
    }//print

}//outer main
